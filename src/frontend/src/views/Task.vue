<template>
  <div class="row g-0 tasks">
    <div class="col">
			<!-- {{ requests }} -->
			<div v-if="requests">
				<app-table :inputDate="requests"></app-table>				
			</div>
    </div>
  </div>
</template>

<script>
import {  mapGetters, mapActions } from 'vuex';
import AppTable from '@/components/table/Table.vue'

export default {
  name: 'TaskView',
  components: {  AppTable },
  data: () => ({ }),
  computed: {     
    ...mapGetters( 'requests', { requests: 'requestsDetailed' } ),
    id(){
			return this.$route.params.id;
    },
  },
  methods: {
		...mapActions( 'persons', { addPerson: 'add' , updatePerson: 'update' } ),
  },
  async renderTracked(){
		console.log('actrenderTrackedivated')
  },  
  async activated(){
		console.log('activated')
  },
  async renderTriggered(){
		console.log('renderTriggered')
  },
  async created(){
		console.log('123')
    console.log("create() TASK ")    
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

