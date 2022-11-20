<template>
  <div class="row g-0 tasks">
    <div class="col">
			<div v-if="tasks">
				<app-table :inputDate="tasks"></app-table>				
			</div>
    </div>
  </div>
</template>

<script>
import {  mapGetters, mapActions } from 'vuex';
import AppTable from '@/components/table/Table.vue'

export default {
  name: 'TaskView',
  components: {  AppTable },
  data: () => ({ }),
  computed: {     
    ...mapGetters( 'tasks', { tasks: 'tasksDetailed' } ),
    id(){
      return this.$route.params.id;
    },
  },
  methods: {
    ...mapActions( 'persons', {addPerson: 'add' , updatePerson: 'update'} ),
  },
  async renderTracked(){
		console.log('actrenderTrackedivated')
  },  
  async activated(){
		console.log('activated')
  },
  async renderTriggered(){
		console.log('renderTriggered')
  },
  async created(){
    console.log("create() TASK ")    
	},
}
   
    // this.task = await this.$api.tasks.getOne(this.id)
    // // this.childTasks = await this.$api.tasks.allByParentId(this.task.id) 

    // let getTaskTypes = await this.$api.taskTypes.all();
    // this.taskTypes = getTaskTypes;
    // this.taskTypesSelected = this.task.taskTypeId;

    // let getWorkApps = await this.$api.workApps.all();
    // this.workApps = getWorkApps;
    // this.workAppsSelected = this.task.workAppId;
 // async addChildTask(){
    //   this.newChildTask.dateStart = new Date();
    //   this.newChildTask.managerId = this.task.managerId;
    //   this.newChildTask.parentId = this.task.id
    //   console.log(this.newChildTask)

    //   // let result = await this.$api.tasks.add(this.newChildTask)
      
    //   // this.childTasks = await this.$api.tasks.allByParentId(this.task.id);

    
    //   this.task = await this.$api.tasks.getOne(id);      
          
    //   // let a = new Date(  this.task.dateStart);
      
    //   // let n = a.getFullYear() + '-' +a.getMonth() + '-' +  (
    //   //   (a.getDate() > 9) ? a.getDate() : ("0" + a.getDate())
    //   // )

    //   this.task.dateStart = this.task.dateStart.substring(0, 10)
    //   if(this.task.dateEnd){
    //     this.task.dateEnd = this.task.dateEnd.substring(0, 10)

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

