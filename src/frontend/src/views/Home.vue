<template>
  <div class="home">
    <h1>Home Page</h1>
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





