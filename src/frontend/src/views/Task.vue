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
              <select name="" id="" class="form-select">
                <option v-for="i in taskTypes" :value="i.id" v-bind:key="i.id">{{ i.title }}</option>
              </select>
            </div>
            <div class="col">
              <label for="" class="form-label">Исполнитель</label>
              <select name="" id="" class="form-select">
                <option v-for="i in taskTypes" :value="i.id" v-bind:key="i.id">{{ i.title }}</option>
              </select>
            </div>
          </div>
          <div class="row">
            <div class="col">
              <label for="" class="form-label">Work App</label>
              <select name="" id="" class="form-select">
                <option v-for="i in taskTypes" :value="i.id" v-bind:key="i.id">{{ i.title }}</option>
              </select>
            </div>
            <div class="col">
              <label for="" class="form-label">Task type</label>
              <select name="" id="" class="form-select">
                <option v-for="i in taskTypes" :value="i.id" v-bind:key="i.id">{{ i.title }}</option>
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
          <label for="" class="form-label">Описание</label>          
          <textarea type="text" class="form-control" v-model="task.description"></textarea>
        </div>
      </div>

      <div class="row">       
        
        
      </div>
      <div class="row">


      </div>

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
      <div class="row">
        <div class="col">
          <button class="btn btn-success" @click.prevent="createZRS">Сформировать ЗРС</button>
        </div>
        <div class="col">
          <button class="btn btn-success">Добавить ТЗ</button>
        </div>
      </div>

    <hr>
<div class="row">
  <div class="col">
    <ol class="list-group list-group-numbered">
      <li class="list-group-item" v-for="i in childTasks" :key="i.id">
        {{ i.title }}
      </li>
    </ol>
  </div>
</div>


    </div>
  </div>    
</template>

<script>
import {  mapActions, mapGetters } from 'vuex';

export default {
  name: 'TaskView',
  components: { },
  data: () => ({    
    isShowForm: false,
    editmode: false,
    task: {},
    taskTypes: {},
    workApps: {},
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
    
    save(person){     
        console.log(' save = UPDATE ')
    },
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
    createdZRS(){
      this.ZRS = {
        
      }
    }
  },
  async created(){
    let getTask = await this.$api.tasks.getOne(this.id);
    this.task = getTask;  
console.log(this.task.id)
console.log(this.task)
console.log(this.task.parentId)

    let getTaskTypes = await this.$api.taskTypes.all();
    this.taskTypes = getTaskTypes;
    this.taskTypesSelected = this.task.taskTypeId;
    console.log(this.taskTypes)

    let getWorkApps = await this.$api.workApps.all();
    console.log(getWorkApps)
    this.workApps = getWorkApps;
    this.workAppsSelected = this.task.workAppId;

    if(this.task.parentId){
      let childTasks = await this.$api.tasks.allByParentId( await this.task.parentId)
      console.log(childTasks)
      this.childTasks = childTasks;
    }

    -let taskStatus = await this.$api++++-65451+-5

    
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

