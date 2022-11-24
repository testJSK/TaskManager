<template>
   <h3> Задачи:</h3>
				<ol class="list-group list-group-numbered">
					<li class="list-group-item" v-for="i in taskList" :key="i.id">
								{{ i.id }}
								{{ i.title }}
						<router-link :to="{ name: 'taskitem', params:{ id: i.id } }">
							<button class="btn btn-primary"
								>...</button></router-link><br>					
					</li>
				</ol>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
	name: 'AppChildListForm',
	props: { taskList: Object },
	data:()=>({
		task:{ },
		persons:{ },
		i: {id: 1},
		workApps: { },
		childTasks: {id: 1, title: "title",  },
	}),
	computed: {

	},
	methods: {

	},
	watch(){
	},
	async created(){
		this.childTasks = this.taskList;
	},
}
</script>

<style scoped>
li {
	text-align: left;
}
</style>