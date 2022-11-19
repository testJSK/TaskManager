<template>
  <div class="row tasks">
    <div class="col">
      <div class="kbox-title">
        <button class="btn btn-primary" @click.prevent="test">TEST</button>
        <router-link to="/task/new" class="btn btn-primary">Add Task</router-link>
      </div>
      <div class="kbox-content">
        <table class="table">
          <thead>
          <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Initiator</th>
            <th>Manager</th>
            <th>Start</th>
          </tr>  
          </thead>
          <tbody v-if="tasks">            
          <tr v-for="(item, ) in tasks" :key="item.id">
            <task-table-row :task="item"></task-table-row>
            <!-- <td>{{ item.id }}</td>
            <td>{{ item.title }}</td>
            <td>{{ item?.initiator.lastNameBase }}</td>
            <td>{{ shortName(item?.manager) }}</td>
            <td>{{ item.dateStart }}</td> -->
          </tr>  
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>


<script>
import {  mapGetters, mapActions } from 'vuex';
import TaskTableRow from '@/components/tasks/TableRow.vue'

export default {
  name: 'TaskView',
  components: { TaskTableRow },
  data: () => ({    
  }),
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

// this.hasTask = this.tasks
  },
  async created(){
  //  this.hasTask = this.tasks
    console.log("create() TASK ")    
       
    },
}
   // this.persons = await this.$api.persons.all();
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
      
    // },
    // closeFormTaskAdd(){
    //   this.task = {};
    // },
    // fio( person ){
    //   let lastname = person.lastNameBase;
    //   let lastnamewho = person.lastNameWho;
    //   let firstname = person.firstNameBase;
    //   let middlename = person.middleNameBase;
    //   let result = lastname + ( (lastnamewho !=null) ? lastnamewho : "" ) + ' ' + firstname.substring(0,1).toUpperCase() + middlename.substring(0,1).toUpperCase();
    //   return result;
    // },
    // save(person){     
    //     console.log(' save = UPDATE ')
    // },
    // abrev(str){
    //   if( str !== null) {        
    //     return ( 
    //       str.trim().split(' ').map( word => { 
    //           return ( word.length > 1 ) ? word[0].toUpperCase(): word[0].toLowerCase() 
    //         }).join('')
    //     ) 
    //   } else {
    //      return "";
    //   }            
    // },
    // async getTask(id){
    //   this.persons = await this.$api.persons.all();
      
    //   this.childTasks = {};
    //   // let getTask = await this.$api.tasks.getOne(id);      
    //   // this.task = getTask;  
      
    //   // let a = new Date(  this.task.dateStart);
      
    //   // let n = a.getFullYear() + '-' +a.getMonth() + '-' +  (
    //   //   (a.getDate() > 9) ? a.getDate() : ("0" + a.getDate())
    //   // )

    //   this.task.dateStart = this.task.dateStart.substring(0, 10)
    //   if(this.task.dateEnd){
    //     this.task.dateEnd = this.task.dateEnd.substring(0, 10)
    //   }      
    // },
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

