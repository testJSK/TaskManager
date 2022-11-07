<template>
  <div class="personlist">    
    <h2>Сотрудники</h2>
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
                <td><button class="btn btn-primary" @click.prevent="aditshow(person)">...</button></td>
              </tr>
            </tbody>
          </table>          
        </div>
</template>

<script>
// import { mapActions } from 'vuex';

export default {
  name: 'PersonList',
  props: {    
    persons: Array
  },
  computed: {

  },
  methods: {
    // ...mapActions( 'persons', [ 'aditshow' ] ),
  },
}
</script>

<style scoped>
  .personlist {
    background-color:coral
  }
</style>
