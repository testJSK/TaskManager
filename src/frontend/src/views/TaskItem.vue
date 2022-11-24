<template>
		<app-main-form
			:prop_task="task"
			:persons="persons"
			:workApps="workApps"
			:taskTypes="taskTypes"
		></app-main-form>
		<app-add-child-form 
			:parentTask="task"
		></app-add-child-form>
	<div class="row g-0">
		<div class="col-1"></div>
		<div class="col-10">
		<app-child-list-form :taskList="childTasks"></app-child-list-form>

		</div>
	</div>
		<!-- <app-child-list-form :taskList="[{id: 57},{id: 58}]"></app-child-list-form> -->
</template>

<script>
import { mapActions } from 'vuex';
import AppMainForm from '@/components/task-item/MainForm.vue'
import AppAddChildForm from '@/components/task-item/AddChildForm.vue'
import AppChildListForm from '@/components/task-item/ChildListForm.vue'

export default {
 name: 'TaskItemView',
 components: { AppMainForm, AppAddChildForm, AppChildListForm },
 data: () => ({  
  mode: {add: false, edit: false, read: false},
	isShowForm: false,
  editmode: false,
  // id: null,
	task: {},
  persons: {},
  workApps: {},
  taskTypes: {},
  childTasks: {},
  newChildTask: {},
 }),
 computed: {   
  // ...mapGetters( 'tasks', { task: 'editItem' } ),
	id(){
		return this.$route.params.id;
  },
 },
 methods: {
  ...mapActions( 'persons', { 
		addPerson: 'add', 
		updatePerson: 'update',
		workAppsGetAll: 'getAll'
		} ),
  async updateTask(){
   let result = await this.$api.tasks.update(this.task)
  },
  async getTask(id){
   this.persons = await this.$api.persons.all();
   
   this.childTasks = {};
   let getTask = await this.$api.tasks.getOne(id);   
   this.task = getTask; 
   
   // let a = new Date( this.task.dateStart);
   
   // let n = a.getFullYear() + '-' +a.getMonth() + '-' + (
   //  (a.getDate() > 9) ? a.getDate() : ("0" + a.getDate())
   // )

   this.task.dateStart = this.task.dateStart.substring(0, 10)
   if(this.task.dateEnd){
    this.task.dateEnd = this.task.dateEnd.substring(0, 10)
   }   
  },
 },
 watch: {
	async id(){
		this.task = await this.$api.tasks.getOne(this.id)

	},
 },
async created(){
		this.persons = await this.$api.persons.all();
		this.workApps = await this.$api.workApps.all();
		this.taskTypes = await this.$api.taskTypes.all();
		this.task = await this.$api.tasks.getOne(this.id)
		this.childTasks = await this.$api.tasks.allByParentId(this.task.id) 
 },
}
</script>
<style scoped>
 .persons {
  background-color: rgb(111, 150, 137)
 }

 .menu {
  background-color: rgb(185, 245, 225);
 }
 .table {
  background-color: rgb(231, 228, 183);
 }
 .end-string {
  width: 12%;
 }
 .long-string {
  width: 37%;
 }
 textarea {
  height: 90%;
 }
</style>

