<template>
  <div class="department">
    department
    <!-- <h1>Панель управления -+</h1>
    <div class="row">
      <div class="col col-sm-3 mb-2 mt-2">        
        <div class="menu">
          <div class="person">Сотрудники</div>
        </div>
      </div>      

      <div class="col col-lg-9 mb-2 mt-2">        
        <div class="panel">
          <a href="persons/add">Добавить сотрудника</a>
          <table class="table">
            <thead>
              <tr>
                <th scope="col">#</th>
                <th scope="col">first</th>
                <th scope="col">last</th>
                <th scope="col">middle</th>
                <th scope="col">edit</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="person in persons" :key="person.id">
                <th scope="row">{{ person.id }}</th>
                <td>{{ person.firstNameBase + person.firstNameWho }}</td>
                <td>{{ person.lastNameBase + person.lastNameWho }}</td>
                <td>{{ person.middleNameBase + person.middleNameWho }}</td>
                <td><a href="/dashboard/person/{{ person.id }}" target="_blank" rel="noopener noreferrer">...</a></td>
              </tr>
            </tbody>
          </table>
          <hr>
         
        </div>
      </div> -->

  </div>
    
{{ persons[2] }} 

  
</template>

<script>
import { mapGetters, mapActions } from 'vuex';

export default {
  name: 'DepartmentsView',
  data: () => ({
    person: {
      firstNameBase: null,
      lastNameBase: null,
      email: null
    },
    
  }),
  computed: {
    ...mapGetters( 'persons', { persons: 'items' }),

  },
  methods: {
    ...mapActions( 'persons', [ 'addperson' ] ),
  }  
}
</script>
<style scoped>
  .menu {
    background-color: rgb(185, 245, 225);
  }
  .table {
    background-color: rgb(231, 228, 183);
  }
</style>