<template>
  <div class="personedit">    
    <h2>{ { редактирование / добавление } } cотрудника</h2>
    <hr>
    <form action="" method="post" class="mb-4 mt-3 mb-3">
      <div class="row g-12 align-item-center">

        <div class="col-auto">
          <label class="label-form">Фамилия Кто</label>
          <input class="form-control" type="text" v-model="person.lastNameBase">                  
        </div>
        <div class="col-auto">
          <label class="label-form">Фамилия От</label>
          <input class="form-control" type="text" v-model="person.lastNameFrom">                
        </div>
        <div class="col-auto">
          <label class="label-form">Фамилия Кому</label>
          <input class="form-control" type="text" v-model="person.lastNameTo">
        </div>
      </div>

      <hr>
      <div class="row g-12 align-item-center">
        <div class="col-auto">
          <label class="label-form">Имя Кто</label>
          <input class="form-control" type="text" v-model="person.firstNameBase">
        </div>
        <div class="col-auto">
          <label class="label-form">От</label>
          <input class="form-control" type="text" v-model="person.firstNameFrom">
        </div>
        <div class="col-auto">
          <label class="label-form">Кому</label>
          <input class="form-control" type="text" v-model="person.firstNameTo">
        </div>
      </div>

      <hr>
      <div class="row g-12 align-item-center">
        <div class="col-auto">
          <label class="label-form">Отчество Кто</label>
          <input class="form-control" type="text" v-model="person.middleNameBase">
        </div>
        <div class="col-auto">
          <label class="label-form">От</label>
          <input class="form-control" type="text" v-bind="person.middleNameFrom">
        </div>
        <div class="col-auto">
          <label class="label-form">Кому</label>
          <input class="form-control" type="text" v-bind="person.middleNameTo">
        </div>
      </div>
      
      <hr>
      <div class="row g-12 align-item-center">
        <div class="col-auto">
          <label class="label-form">Email</label>
          <input class="form-control" type="text" v-model="person.email">
        </div>
      </div>
      
      <hr>
      <div class="row g-12 align-item-center">
        <div class="col-auto">
          <label class="label-form">Отдел</label>
          <input class="form-control" type="text" v-model="person.jobDepartment">
        </div>
      </div>
      
      <hr>
      <div class="row g-12 align-item-center">              
        <div class="col-auto">
          <label class="label-form">Должность</label>
          <input class="form-control" type="text" v-model="person.jobPosition">
        </div>
      </div>
      
      <hr>
      <div class="row g-12 align-item-center">              
        <div class="">
          <button class="btn btn-primary" type="button" @click.prevent="send()">Добавить</button>
          <button class="btn btn-danger" type="button" @click.prevent="closeedit()">Закрыть</button>
        </div>
        <div class="">
          
        </div>
      </div>          
    </form>
        </div>
</template>

<script>
// import { mapActions,  } from 'vuex'

export default {
  name: 'PersonEdit',
  props: {    
    personProp: Object,    
  },
  data:()=> ({
    person: {
      firstNameBase: "",
      firstNameFrom: "",
      firstNameTo: "",
      lastNameBase: "",
      lastNameFrom: "",
      lastNameTo: "",
      middleNameBase: "",
      middleNameFrom: "",
      middleNameTo: "",
      email: "",
      jobDepartment: "",
      jobPosition: ""
    },
  }),
  computed: {  },
  methods: {    
    // ...mapActions( 'persons', [ 'add', 'closeedit',  ] ),
    send() {      
     console.log(this.person)
     console.log( "^ from vue ")

     this.add( this.person )
    },
  },
}
</script>

<style scoped>
  .personedit {
    background-color:darkorange
  }
</style>
