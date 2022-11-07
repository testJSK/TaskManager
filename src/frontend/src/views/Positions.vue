<template>
  <div class="positions">
    positions
  </div>
    
<!-- {{ persons[4] }}  -->

  
</template>

<script>
import { mapGetters, mapActions } from 'vuex';

export default {
  name: 'PositionsView',
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
