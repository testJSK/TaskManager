<template>
  <div class="home" v-show="!editmode">
    <button class="btn btn-success" @click.prevent="showFormTaskAdd">Add Task</button>
<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">#</th>
      <th scope="col">#</th>
      <th scope="col">#</th>
      <th scope="col">#</th>
      <th scope="col">#</th>
      <th scope="col">#</th>
    </tr>
  </thead>
  <tbody>
    <tr v-for="task in tasks" :key="task.id">
      <th scope="row">{{ task.id }}</th>
      <td>{{ task.title }}</td>
      <td>{{ task.dateStart }}</td>
      <td>{{ task.parentTaskId }}</td>
      <td>{{ task.initiatorId }}</td>
      <td>{{ task.manageId }}</td>
      <td>
        <router-link :to="{ name: 'tasks', params: { id: task.id } }">        
          <button class="btn btn-primary" >...</button>
        </router-link>
      </td>       
    </tr>
  </tbody>
</table>
  </div>
  <div class="new-task" v-show="editmode">
    <div class="container">
      <div class="row">
        <div class="col">
          <div class="row">

            <div class="col">
              <label for="" class="from-label">Заголовок</label>
              <input type="text" class="form-control" v-model="taskTitle">
            </div>
          </div>

          <div class="row">          
            <div class="col">
              <label for="" class="from-label">Инициатор</label>
              <select name="" id="" class="form-select" v-model="initiatorSelected">
                <option v-for="i in persons" :value="i.id" v-bind:key="i.id">{{ fio(i) }}</option>
              </select>              
            </div>
            <div class="col">
              <label for="" class="from-label">Исполнитель</label>
              <select name="" id="" class="form-select" v-model="managerSelected">
                <option v-for="i in persons" :value="i.id" v-bind:key="i.id">{{ fio( i ) }}</option>
              </select>
            </div>
          </div>

          <div class="row">          
            <div class="col">
              <label for="" class="from-label">Work App</label>
              <select name="" id="" class="form-select" v-model="workAppSelected">
                <option v-for="i in workapps" :value="i.id"  v-bind:key="i.id" >{{ i.title }}</option>
              </select>
            </div>
            <div class="col">
              <label for="" class="from-label">Task type</label>
              <select name="" id="" class="form-select" v-model="taskTypeSelected">
                <option v-for="i in tasktypes" :value="i.id" v-bind:key="i.id">{{ i.title }}</option>
              </select>
            </div>
          </div>
          
          <div class="row">          
            <div class="col">
              <label for="" class="from-label">Start</label>
              <input type="date" class="form-control" v-model="taskStart">
            </div>
            <div class="col">
              <label for="" class="from-label">End</label>
              <input type="date" class="form-control" v-model="taskEnd">
            </div>
          </div>
        </div>
       <div class="col">
          <label for="" class="from-label">Описание</label>
          <textarea type="text" class="form-control" v-model="taskDescription"></textarea>
        </div>
      </div>
      <div class="row">
         
        <div class="col">
          <hr>
        </div>
        
      </div>
    </div>
    
    <button class="btn btn-danger" @click.prevent="closeFormTaskAdd">Close</button> | 
    <button class="btn btn btn-success" @click.prevent="sendTask">Add task</button>
  </div>
</template>

<script>
// import HelloWorld from '@/components/HelloWorld.vue';
import { mapGetters, mapActions } from 'vuex';

export default {
  name: 'HomeView',
  components: {
    // HelloWorld
  },
  data: () => ({
    task:{},
    persons: {},
    workapps: {},
    tasktypes: {},
    editmode: false,
    
    taskStart: null,
    taskEnd: null,
    taskTitle: "",
    taskDescription: null,
    managerSelected: null,
    workAppSelected: null,
    taskTypeSelected: null,
    initiatorSelected: null,

  }),
  computed: {
    ...mapGetters( 'tasks', { tasks: 'items'} ),
  },
  methods: {
    ...mapActions( 'tasks', {getOne: 'getOne' }),
    async loadTasks(){
      let persons = await this.$api.persons.all();
      
      this.persons = persons;
    },
    async sendTask(){
      let task = {        
        "title": this.taskTitle,
        "description": this.taskDescription,
        "parentTaskId":null,
        "initiatorId":this.initiatorSelected,
        "managerId":this.managerSelected,
        "dateStart": this.taskStart,
        "dateEnd": this.taskEnd,
        "taskTypeId": this.taskTypeSelected,
        "workAppId": this.workAppSelected
      };
      let result = await this.$api.tasks.add(task);
      console.log(result)
      if(result.includes('added')){
        console.log(result.substring('added'))
        this.editmode = false;
      }
    },
    fio( person ){
      let lastname = person.lastNameBase;
      let lastnamewho = person.lastNameWho;
      let firstname = person.firstNameBase;
      let middlename = person.middleNameBase;
      let result = lastname + ( (lastnamewho !=null) ? lastnamewho : "" ) + ' ' + firstname.substring(0,1).toUpperCase() + middlename.substring(0,1).toUpperCase();
      return result;
    },
    showFormTaskAdd(){
      this.editmode = true
    },
    closeFormTaskAdd(){
      this.editmode = false
    },
  },
  async created(){
    this.loadTasks();

    this.workapps = await this.$api.workApps.all();

    this.tasktypes = await this.$api.taskTypes.all();

    let a = new Date()

    let n = a.getFullYear() + '-' +
     ((a.getMonth() > 9) ? a.getMonth() : ("0" + a.getMonth())) + '-' +
     ((a.getDate() > 9) ? a.getDate() : ("0" + a.getDate()))

console.log(n)
    this.taskStart = n
    // console.log(this.taskStart)
  }
  
}
</script>
<style scoped>
  textarea {
    height: 90%;
  }
</style>