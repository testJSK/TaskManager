<template>
  <div class="panel">
    <h1>Панель управления</h1>
    <div class="row">

      <!-- MENU -->
      <div class="col col-12-col md-3 menu">

        
        <ul class="list-group">
          <li class="list-group-item " aria-current="true">
            <router-link :to="{ name: 'panel.persons' }">Сотрудники</router-link>
          </li>
          <li class="list-group-item">
            <router-link :to="{ name: 'panel.departments' }">Отделы</router-link>
          </li>
          <li class="list-group-item">
            <router-link :to="{ name: 'panel.positions' }">Должности</router-link>
          </li>
        </ul>
      </div>

      <!-- VIEW ROUTER -->
      <div class="col col-lg-10 mb-2 mt-2 viewrouter">
        <router-view></router-view>
      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';

export default {
  components: {

    },
  name: 'PanelView',
  data: () => ({
    person: {
      firstNameBase: null,
      lastNameBase: null,
      email: null
    },
    
  }),
  computed: {
    ...mapGetters( 'persons', { persons: 'items' } ),

  },
  // methods: {
  //   ...mapActions( 'persons', [ 'addperson' ] ),
  // }  
}
</script>
<style scoped>
  .panel {
    background-color: rgb(83, 97, 224);
  }
  .menu {
    background-color: rgb(185, 245, 225);
  }
  .viewrouter {
    background-color:rgb(208, 211, 16)
  }
  .table {
    background-color: darkkhaki;
  }
</style>

