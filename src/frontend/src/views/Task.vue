<template>
  <div class="tasks">
    <h2>{{ ((task.parentId == null) ? "Запрос" : "Задача") + ' ' + task.id }}</h2>
    <div class="container">
      <div class="row">
          <label for="" class="form-label">Заголовок</label>
          <input type="text" class="form-control" v-model="task.title">
        <div class="col">
          <div class="row">
            <div class="col">
              <label for="" class="form-label">Инициатор</label>
              <select name="" id="" class="form-select" v-model="task.initiatorId">
                <option v-for="i in persons" :value="i.id" v-bind:key="i.id">{{ fio( i ) }}</option>
              </select>
            </div>
            <div class="col">
              <label for="" class="form-label">Исполнитель</label>
              <select name="" id="" class="form-select" v-model="task.managerId">
                <option v-for="i in persons" :value="i.id" v-bind:key="i.id">{{ fio( i ) }}</option>
              </select>
            </div>
          </div>
          <div class="row">
            <div class="col">
              <label for="" class="form-label">Work App</label>
              <select name="" id="" class="form-select" v-model="task.workAppId">
                <option v-for="i in workApps" :value="i.id" v-bind:key="i.id">{{ i.title }}</option>
              </select>
            </div>
            <div class="col">
              <label for="" class="form-label">Task type</label>
              <select name="" id="" class="form-select" v-model="task.taskTypeId">
                <option v-for="i in taskTypes" :value="i.id" v-bind:key="i.id">{{ i.title }}</option>
              </select>
            </div>
          </div>

          <div class="row">
            <div class="col">
              <label for="" class="from-label">Start</label>
              <input type="date" class="form-control" v-model="task.dateStart">
            </div>
            <div class="col">
              <label for="" class="from-label">End</label>
              <input type="date" class="form-control" v-model="task.dateEnd">
            </div>
          </div>

        </div>
        <div class="col">
          <label for="" class="form-label">Описание</label>          
          <textarea type="text" class="form-control" v-model="task.description"></textarea>
        </div>
      </div>

      <div class="row">       
        
        
      </div>
      <div class="row">


      </div>
<hr>
  <router-link :to="{ name: 'home'}">
    <button class="btn btn-danger" @click="closeFormTaskAdd">Close</button> | 
  </router-link>
    
    <button class="btn btn btn-success" @click.prevent="updateTask">Save</button>
      <hr>
      <div class="row">
      <h3> Задачи:</h3>
      <hr>
        <div class="col">
          <label for="" class="form-label">Заголовок</label>
          <input type="text" class="form-control">
        </div>
        <div class="col">
          <label for="" class="form-label">Тип</label>
          <select name="" id="" class="form-select">
            <option v-for="i in taskTypes" :value="i.id" v-bind:key="i.id">{{ i.title }}</option>
          </select>
        </div>
        <div class="col">
          <label for="" class="form-label">Программа</label>
          <select name="" id="" class="form-select">
            <option v-for="i in workApps" :value="i.id" v-bind:key="i.id">{{ i.title }}</option>
          </select>
        </div>        
        <div class="col">
          <label for="" class="form-label">-</label>
          <button class="btn btn-success">Add</button>
        </div>
      </div>
      

<hr>
      <!-- <div class="row">
        <div class="col">
          <button class="btn btn-success" @click.prevent="createZRS">Сформировать ЗРС</button>
        </div>
        <div class="col">
          <button class="btn btn-success">Добавить ТЗ</button>
        </div>
      </div> -->

    <hr>
<div class="row">
  <div class="col">
    <ol class="list-group list-group-numbered">
      <li class="list-group-item" v-for="i in childTasks" :key="i.id">
        {{ i.title }} {{ workApps.find( app => (app.id === i.workAppId).title) }}
        <router-link :to="{ name: 'tasks', params: { id: i.id } }">        
          <button class="btn btn-primary" @click="getTask(i.id)"> . . . </button>
        </router-link>
      </li>
    </ol>
  </div>
</div>


    </div>
  </div>    
</template>

<script>
import {  mapActions } from 'vuex';

export default {
  name: 'TaskView',
  components: { },
  data: () => ({    
    isShowForm: false,
    editmode: false,
    task: {},
    taskTypes: {},
    persons: {},
    
    workApps: {},
    initiatorSelected: null,
    managerSelected: null,
    taskTypesSelected: null,
    workAppsSelected: null,
    ZRS: {},
    childTasks: {},
  }),
  computed: {     
    // ...mapGetters( 'tasks',  { task: 'editItem' } ),
    id(){
      return this.$route.params.id;
    },

  },
  methods: {
    ...mapActions( 'persons', {addPerson: 'add' , updatePerson: 'update'} ),
    async updateTask(){
      let result = await this.$api.tasks.update(this.task)
      console.log(result)

    },
    closeFormTaskAdd(){
      this.task = {};
    },
    fio( person ){
      let lastname = person.lastNameBase;
      let lastnamewho = person.lastNameWho;
      let firstname = person.firstNameBase;
      let middlename = person.middleNameBase;
      let result = lastname + ( (lastnamewho !=null) ? lastnamewho : "" ) + ' ' + firstname.substring(0,1).toUpperCase() + middlename.substring(0,1).toUpperCase();
      return result;
    },
    // save(person){     
    //     console.log(' save = UPDATE ')
    // },
    abrev(str){
      if( str !== null) {        
        return ( 
          str.trim().split(' ').map( word => { 
              return ( word.length > 1 ) ? word[0].toUpperCase(): word[0].toLowerCase() 
            }).join('')
        ) 
      } else {
         return "";
      }            
    },
    async getTask(id){
      this.persons = await this.$api.persons.all();
      console.log(this.persons)
      this.childTasks = {};
      let getTask = await this.$api.tasks.getOne(id);      
      this.task = getTask;  
      
      let a = new Date(  this.task.dateStart);
      
      let n = a.getFullYear() + '-' +a.getMonth() + '-' +  (
        (a.getDate() > 9) ? a.getDate() : ("0" + a.getDate())
      )
console.log(n)
      this.task.dateStart = this.task.dateStart.substring(0, 10)
      if(this.task.dateEnd){
        this.task.dateEnd = this.task.dateEnd.substring(0, 10)
      }
      
      console.log(this.task.dateStart)


    },
  },
  async created(){
    this.getTask(this.id)
    // let getTask = await this.$api.tasks.getOne(this.id);
    // this.task = getTask;  

    let getTaskTypes = await this.$api.taskTypes.all();
    this.taskTypes = getTaskTypes;
    this.taskTypesSelected = this.task.taskTypeId;

    let getWorkApps = await this.$api.workApps.all();
    this.workApps = getWorkApps;
    this.workAppsSelected = this.task.workAppId;

console.log(this.task.id)

let childTasks = await this.$api.tasks.allByParentId(  this.task.id)      
      this.childTasks = childTasks;     

    if(this.task.parentId !== undefined){
      
    } 
    
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

