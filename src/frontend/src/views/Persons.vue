<template>
  <div class="persons">
    <h2>Сотрудники</h2>

    <div v-show="isShowForm" class="personEdit">
      <h2>{{ editmode ? "Редактирование сотрудника" : "Добавление сотрудника" }}</h2>
      <div class="row g-12 align-item-center">
        <hr>
        <div class="col-auto">
          <label for="" label-form>Имя корень</label>
          <input type="text" class="form-control" v-model="editPerson.lastNameBase">
        </div>
        <div class="col-auto end-string">
          <label for="" label-form>Имя кто</label>
          <input type="text" class="form-control" v-model="editPerson.lastNameWho">
        </div>
        <div class="col-auto end-string">
          <label for="" label-form>Имя от</label>
          <input type="text" class="form-control" v-model="editPerson.lastNameFrom">
        </div>
        <div class="col-auto end-string">
          <label for="" label-form>Имя кому</label>
          <input type="text" class="form-control" v-model="editPerson.lastNameTo">
        </div>                
      </div>
      <div class="row g-12 align-item-center">
        <hr>
        <div class="col-auto">
          <label for="" label-form>Фамилия корень</label>
          <input type="text" class="form-control" v-model="editPerson.firstNameBase">
        </div>
        <div class="col-auto end-string">
          <label for="" label-form>Фамилия кто</label>
          <input type="text" class="form-control" v-model="editPerson.firstNameWho">
        </div>
        <div class="col-auto end-string">
          <label for="" label-form>Фамилия от</label>
          <input type="text" class="form-control" v-model="editPerson.firstNameFrom">
        </div>
        <div class="col-auto end-string">
          <label for="" label-form>Фамилия кому</label>
          <input type="text" class="form-control" v-model="editPerson.firstNameTo">
        </div>
      </div>

      <div class="row g-12 align-item-center">
        <hr>
        <div class="col-auto">
          <label for="" label-form>Отчество корень</label>
          <input type="text" class="form-control" v-model="editPerson.middleNameBase">
        </div>
        <div class="col-auto end-string">
          <label for="" label-form>Отчество кто</label>
          <input type="text" class="form-control" v-model="editPerson.middleNameWho">
        </div>
        <div class="col-auto end-string">
          <label for="" label-form>Отчество от</label>
          <input type="text" class="form-control" v-model="editPerson.middleNameFrom">
        </div>
        <div class="col-auto end-string">
          <label for="" label-form>Отчество кому</label>
          <input type="text" class="form-control" v-model="editPerson.middleNameTo">
        </div>
      </div>

      <div class="row g-12 align-item-center">
        <hr>
        <div class="col-auto">
          <label for="" label-form>email</label>
          <input type="text" class="form-control" v-model="editPerson.email">
        </div>
      </div>

      <div class="row g-12 align-item-center">
        <hr>
        <div class="col-auto long-string">
          <label for="" label-form>Отдел</label>
          <input type="text" class="form-control" v-model="editPerson.jobDepartment">
        </div>
      </div>
      <div class="row g-12 align-item-center">
        <hr>
        <div class="col-auto long-string">
          <label for="" label-form>Должность</label>
          <input type="text" class="form-control" v-model="editPerson.jobPosition">
        </div>
      </div>

      <button class="btn btn-danger" @click.prevent="closeForm">Close</button>
      <button class="btn btn-success" @click.prevent="save(editPerson)">Save</button>
    </div>
{{ editPerson }}
    <div v-show="!isShowForm" class="personlist">
      <table class="table">        
        <thead>          
          <button class="btn btn-success" @click.prevent="showForm('add')"> + Add </button>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Фамилия</th>
            <th scope="col">Имя</th>
            <th scope="col">Отчество</th>
            <th scope="col">email</th>
            <th scope="col">Должность</th>
            <th scope="col">Отдел</th>
            <th scope="col">edit</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="person in persons" :key="person.id">
            <th scope="row">{{ person.id }}</th>
            <td>{{ person.lastNameBase + ( person.lastNameWho ? person.lastNameWho : '' ) }}</td>
            <td>{{ person.firstNameBase + ( person.firstNameWho ? person.firstNameWho : '' ) }}</td>
            <td>{{ person.middleNameBase + ( person.middleNameWho ? person.middleNameWho : '' ) }}</td>
            <td>{{ person.email }}</td>
            <td>{{ abrev( person.jobPosition )  }}</td>
            <td>{{ abrev( person.jobDepartment ) }}</td>
            <td><button class="btn btn-primary" @click.prevent="showForm('edit', person.id )"> . . . </button></td>
          </tr>
        </tbody>
      </table>
    </div>

<!-- 
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
 -->



<!-- 
   <div class="personlist" >    
    <h2>Сотрудники</h2>
    <table class="table">
            <thead>
              <button @click="showForm(person)" class="btn btn-success">Add person</button>
              <tr>
                <th scope="col">#</th>
                <th scope="col">first</th>
                <th scope="col">last</th>
                <th scope="col">middle</th>
                <th scope="col">edit</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="persona in persons" :key="persona.id">
                <th scope="row">{{ persona.id }}</th>
                <td>{{ persona.firstNameBase + persona.firstNameWho }}</td>
                <td>{{ persona.lastNameBase + persona.lastNameWho }}</td>
                <td>{{ persona.middleNameBase + persona.middleNameWho }}</td>
                <td><button class="btn btn-primary" @click.prevent="showForm(persona)">...</button></td>
              </tr>
            </tbody>
          </table>     
 -->
    

  </div>    
</template>

<script>
import {  mapActions, mapGetters } from 'vuex';

export default {
  name: 'PersonsView',
  components: {
    // PersonList,    
    // PersonEdit,    

  },
  data: () => ({
    isShowForm: false,
    editmode: false,
    editPerson: {},
    personsList: {}

  }),
  computed: {     
    ...mapGetters( 'persons',  { persons: 'items' } ),


  },
  methods: {
    ...mapActions( 'persons', {addPerson: 'add' , updatePerson: 'update'} ),
    save(person){
      if( this.editmode ){

        console.log(' save = UPDATE person')
        this.updatePerson(person)
      } else {

        console.log(' save = ADD person')
        this.addPerson(person)
      }
      this.isShowForm = false;
      this.editPerson = {};
      console.log(person)

    },
    abrev(str){
      if( str !== null) {        
        // console.log(' >>>> ... ' + str)
        // console.log('yfxf b bnf'.length > 1 ? 'lowercase'.toUpperCase() : 'UPPERCASE'.toLowerCase())
        // console.log
        return ( 
          str.trim().split(' ').map( word => { 

              return ( word.length > 1 ) ? word[0].toUpperCase(): word[0].toLowerCase() 

            }).join('')
        )
        // return str.split(' ').map( word => { (word.length > 1) ? word[0].toUpperCase(): word[0].toLowerCase() }).join('');
        // return str.toUpperCase().split(' ').map( word => word[0]).join('');
      } else {
         return "";
      }            
    },
    closeForm(){
      this.isShowForm = false;
      this.editPerson = {};
      console.log(this.isShowForm)
   },
   showForm(mode , id = null ){

    this.isShowForm = true;

    if( mode === 'edit') {
      
      this.editmode = true;
       this.persons.forEach(element => { 
        if (element.id == id) {
          Object.assign(this.editPerson, element)
        }
       });

    } else {
      console.log('==== NEW ')
      this.editmode = false;
    }
   }
  }  
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
</style>


<!-- 


  <div class="personedit" v-if="showformsss">    
    <h2 v-show="editmode">Update person info's</h2>
    <h2 v-show="!editmode">Edit person</h2>
    <hr>
    <form @submit.prevent="editmode ? updatePerson() : createPerson()" class="mb-4 mt-3 mb-3">
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
          <button type="button" class="btn btn-danger" @click="showForm({}, false)">Close</button>
          <button v-if="editmode" type="submit" class="btn btn-primary" >Update</button>
          <button v-else type="submit" class="btn btn-primary" >Create</button>

        </div>
      </div>          
    </form>
  </div>



  <div class="personlist" >    
    <h2>Сотрудники</h2>
    <table class="table">
            <thead>
              <button @click="showForm(person)" class="btn btn-success">Add person</button>
              <tr>
                <th scope="col">#</th>
                <th scope="col">first</th>
                <th scope="col">last</th>
                <th scope="col">middle</th>
                <th scope="col">edit</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="persona in persons" :key="persona.id">
                <th scope="row">{{ persona.id }}</th>
                <td>{{ persona.firstNameBase + persona.firstNameWho }}</td>
                <td>{{ persona.lastNameBase + persona.lastNameWho }}</td>
                <td>{{ persona.middleNameBase + persona.middleNameWho }}</td>
                <td><button class="btn btn-primary" @click.prevent="showForm(persona)">...</button></td>
              </tr>
            </tbody>
          </table>          
        </div> -->