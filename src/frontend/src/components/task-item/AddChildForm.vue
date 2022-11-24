<template>
	<div class="row g-0">		
	<!-- <div v-if="mode.edit"> -->
			<h3 v-if="!workApps">Добавить Задачу</h3>
		<div class="col-1"></div>

		<div class="col-10">
			<div class="row g-0 align-items-end my-3">
				<div class="col">
					<label for="" class="form-label">Заголовок</label>
					<input type="text" class="form-control" v-model="newChildTask.title">
				</div>
				<div class="col-2 mx-1">
					<label for="" class="form-label">Тип</label>
					<select name="" id="" class="form-select" v-model="newChildTask.taskTypeId">
						<option v-for="i in taskTypes" :value="i.id" v-bind:key="i.id">{{ i.title }}</option>
					</select>
				</div>
				<div class="col-2 ">
					<label for="" class="form-label">Программа</label>
					<select name="" id="" class="form-select" v-model="newChildTask.workAppId">
						<option v-for="i in workApps" :value="i.id" v-bind:key="i.id">{{ i.title }}</option>
					</select>
				</div>    
				<div class="col-1 mx-1">					
					<button class="btn btn-success" @click.prevent="tryAddChildTask">Add</button>
				</div>
			</div>
	</div>
	</div>
	<hr>
</template>

<script>
import { mapGetters, mapActions } from 'vuex'

export default {
	name: 'AppAddChildForm',
	props: { parentTask: Object },
	data:()=>({
		task:{ },
		persons: { },
		workApps:{ },
		newChildTask:{},
		taskTypes: {},
	}),
	computed: {
		...mapGetters('workApps', { getAllWorkApps: 'items' }),
		...mapGetters('taskTypes', { getAllTaskTypes: 'items' }),
	},
	watch: {
		getAllWorkApps(){
			this.workApps = this.getAllWorkApps
			this.newChildTask.workAppId = this.workApps[0].id
		},
		getAllTaskTypes(){
			this.taskTypes = this.getAllTaskTypes;
			this.newChildTask.taskTypeId = this.taskTypes[0].id
		},
	},
	methods: {
		...mapActions( 'tasks', { addChildTask: 'add' }),
		async tryAddChildTask(){
			this.newChildTask.dateStart = new Date();
			this.newChildTask.parentId = this.parentTask.id;
			this.newChildTask.managerId = this.parentTask.managerId;

			console.log('this.newChildTask.parentId = this.task.id;')
			console.log(this.newChildTask)

			let res = await this.addChildTask(this.newChildTask)
			if(res.includes('add')){
				this.newChildTask.title = ''
			}
		},
	},
	async created(){
	},
}
</script>