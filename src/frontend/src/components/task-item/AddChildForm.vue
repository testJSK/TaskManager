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
					<button class="btn btn-success" @click.prevent="addChildTask">Add</button>
				</div>
			</div>
	</div>
	</div>
<hr>

</template>

<script>
import { mapGetters } from 'vuex'

export default {
	name: 'AppAddChildForm',
	// props: { task: Object },
	data:()=>({
		task:{ },
		persons: { },
		workApps:{ },
		newChildTask:{},
		taskTypes: {},
		initiatorSelected: null,
  managerSelected: null,
  taskTypesSelected: null,
  workAppsSelected: null,
	}),
	computed: {
		...mapGetters('workApps', { getAll: 'items' })
		// id(){ return this.task.id;	},
		// title(){ return this.task.title; },
		// initiator(){ return this.shortName(this.task.initiator); },
		// manager(){ return this.shortName(this.task.manager); },
		// dateStart(){ return this.shortDate(this.task.dateStart); },
	},
	methods: {
		async addChildTask(){
			console.log(this.getAll)
			this.workApps =this.getAll
		}
		// shortName(person){			
		// 	let lb = person.lastNameBase ? person.lastNameBase : '';			
		// 	let ln = person.lastNameWho ? person.lastNameWho : '';
		// 	let fb = person.firstNameBase ? (person.firstNameBase).substring(0,1) : '';
		// 	let mb = person.firstNameBase ? (person.firstNameBase).substring(0,1) : '';						
		// 	return `${lb}${ln} ${fb}${mb}`
		// },
		// shortDate(date){
		// 	let d = new Date(date);
		// 	let options = { year: 'numeric', month: 'numeric', day: 'numeric'};
		// 	return  d.toLocaleDateString('ru-RU', options);
		// }

	// 	  async addChildTask(){
  //  this.newChildTask.dateStart = new Date();
  //  this.newChildTask.managerId = this.task.managerId;
  //  this.newChildTask.parentId = this.task.id
  //  console.log(this.newChildTask)

  //  // let result = await this.$api.tasks.add(this.newChildTask)
   
  //  this.childTasks = await this.$api.tasks.allByParentId(this.task.id);
   
  // },
	},
	beforeRouteUpdate( to, from, next){
		next( ()=>{
			this.workApps =this.getAll
			console.log('beforeRouteEnter(){')

		})

	}
	,
	async created(){
		console.log('created(){ {')

		},
	onActivated(){
		
		console.log(' activated(){ -6+++')
		this.workApps =this.getAll
		console.log(this.workApps)
	},
		renderTriggered(){
			
			this.$nextTick( () => {
			this.workApps =this.getAll
			console.log('this.$nextTick( () => {      this.workApps')	
			})

		console.log('renderTriggered')
		// this.workApps =this.getAll
		console.log(this.workApps)
	},

	async renderTracked(){
		console.log('actrenderTrackedivated')
		// this.task = await this.prop_task			
		this.workApps = this.getAll
  },  
	async onBeforeUpdated(){
		console.log('onBeforeUpdated()')
	},
	async onUpdated(){
		// console.log('onUpdated(){')
		// this.task = await this.prop_task
		console.log(this.task)
	},
  async activated(){
		console.log('activated')
  },
  async renderTriggered(){
		console.log('renderTriggered')
	},



}
</script>