<template>
	<div>
		<div class="kbox-title">        
			<router-link to="/task/new" class="btn btn-primary">Add Task</router-link>
		</div>
		<div class="kbox-content">
			<table class="table">
				<thead>
					<tr>
            <th>ID</th>
            <th>Title</th>
            <th>Initiator</th>
            <th>Manager</th>
            <th>Start</th>
          </tr>  
          </thead>
          <tbody v-if="inputDate">						
						<tr v-for="(item, ) in inputDate" :key="item.id">
							<app-table-row :task="item"></app-table-row>
						</tr>
          </tbody>
        </table>
      </div>          
					<!-- <tr v-for="(item, ) in tasks" :key="item.id"> -->
            <!-- <app-task-table-row :task="item"></app-task-table-row> -->
          <!-- </tr>   -->
</div>
</template>

<script>
import AppTableRow from '@/components/table/TableRow.vue'

export default {
	name: 'AppTable',
	components: { AppTableRow },
	props: { inputDate: Object },
	computed: {
	},
	methods: {
	},
}
</script>