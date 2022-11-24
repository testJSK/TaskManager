<template>
	<div class="row g-0">		
		<h2>{{ mainFormTitle }}</h2>
		<div class="col-1"></div>

		<div class="col-10">
			<div class="row g-0">
				<label for="" class="form-label">Заголовок</label>
				<input type="text" class="form-control" v-model="task.title">
			</div>
<!--  -->
			<div class="row g-0 justify-content-between">
				<div class="col-5 my-2">
					<label for="" class="form-label">Инициатор</label>
					<select name="" id="" class="form-select" v-model="task.initiatorId">
						<option v-for="i in persons" :value="i.id" v-bind:key="i.id">{{ shortName( i ) }}</option>
					</select>
				</div>
				<div class="col-5 my-2 mx-2">
					<label for="" class="form-label">Исполнитель</label>
					<select name="" id="" class="form-select" v-model="task.managerId">
						<option v-for="i in persons" :value="i.id" v-bind:key="i.id">{{ shortName( i ) }}</option>
					</select>
				</div>
			</div>
<!--  -->
			<div class="row g-0 justify-content-between">
				<div class="col-5 my-2">
					<label for="" class="form-label">Work App</label>
						<select name="" id="" class="form-select" v-model="task.workAppId">
							<option v-for="i in workApps" :value="i.id" v-bind:key="i.id">{{ i.title }}</option>
						</select>
				</div>
				<div class="col-5 my-2 mx-2">
				<label for="" class="form-label">Task type</label>
				<select name="" id="" class="form-select" v-model="task.taskTypeId">
					<option v-for="i in taskTypes" :value="i.id" v-bind:key="i.id">{{ i.title }}</option>
				</select>
				</div>
			</div>
<!--  -->
			<div class="row g-0 justify-content-between">
				<div class="col-5 my-2">
					<label for="" class="from-label">Start</label>
					<input type="date" class="form-control" v-model="task.dateStart">
				</div>
				<div class="col-5 my-2 mx-2">
					<label for="" class="from-label">End</label>
					<input type="date" class="form-control" v-model="task.dateEnd">
				</div>
			</div>
<!--  -->
			<div class="row g-0">
				<label for="" class="form-label">Описание</label>     
				<textarea type="text" class="form-control" v-model="task.description"></textarea>
			</div>
<!--  -->
			<!-- <hr> -->
			<div class="row g-0 my-4">
				<div class="col">
				<router-link :to="{ name: 'home'}">
					<button class="btn btn-danger" @click="closeFormTaskAdd">Close</button>
				</router-link>
				<router-link :to="{ name: 'task'}">
					<button type="button" class="btn btn-success mx-2" @click.prevent="updateTask">Save</button>
				</router-link>
				</div>
			</div>
			</div>
			</div>	
<hr>
</template>

<script>
export default {
	name: 'AppMainForm',
	props: { prop_task: Object, persons: Object, workApps: Object, taskTypes: Object},
	data:()=>({
		task:{ },
		isShowForm: false,
	  editmode: false,
  
  initiatorSelected: null,
  managerSelected: null,
  taskTypesSelected: null,
  workAppsSelected: null,
  childTasks: {},
  newChildTask: {},
	}),
	computed: {
		mainFormTitle(){
			this.task = this.prop_task
			return (this.task.parentId) ? "Задача" : "Запрос"
		},
		test_task(){
			return this.task
		}
	},
	methods: {
		async updateTask(){
			let res;
			let id = this.task.id
			if(isNaN(id)){
				res = await this.$api.tasks.add(this.task);
			} else {
				res = await this.$api.tasks.update(this.task);
			}
			console.log(res)

			if(res.includes('add')){
				// this.$router.push('/task/' + parseInt(res.split(' ')[3]))
				let taskId = parseInt(res.split(' ')[3])
				this.$router.push({name: 'taskitem', params: { id:taskId } })
					
			}
		},
		shortName(person){			
			let lb = person.lastNameBase ? person.lastNameBase : '';			
			let ln = person.lastNameWho ? person.lastNameWho : '';
			let fb = person.firstNameBase ? (person.firstNameBase).substring(0,1) : '';
			let mb = person.firstNameBase ? (person.firstNameBase).substring(0,1) : '';						
			return `${lb}${ln} ${fb}${mb}`
		},
			taskType(){
		return  (this.task.parentId == null) ? "Запрос" : "Задачу";
	},
	taskNum(){
		return (this.id == null) ? "" : this.id;
	},
	itemTitle(){
		let res;
		res = isNaN(this.taskNum) ? "Добавить" : 'Редактировать '
		res = res + ' ' + this.taskType
		return res ;
	},

	},
	async created(){
	},

	async renderTracked(){
  },  
	async onBeforeUpdated(){
	},
	async onUpdated(){

	},
  async activated(){
		console.log('activated')
  },
  async renderTriggered(){


  },

}
</script>