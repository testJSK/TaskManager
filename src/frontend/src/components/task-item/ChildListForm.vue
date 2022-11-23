<template>
	<div class="row g-0">		
	
<div>
   <h3> Задачи:</h3>
		<div class="row g-0 align-items-end my-3">
			<ol class="list-group list-group-numbered">
				<li class="list-group-item" v-for="i in taskList" :key="i.id">
					<router-link :to="{ name: 'taskitem', params:{ id: i.id } }">
						<button class="btn btn-primary"
							>...</button></router-link><br>					
				</li>
			</ol>
		</div>
	</div>
</div>

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
		// ...mapGetters( 'tasks', { childTaskList: 'tasksDetailedByParentId' })
		// id(){ return this.task.id;	},
		// title(){ return this.task.title; },
		// initiator(){ return this.shortName(this.task.initiator); },
		// manager(){ return this.shortName(this.task.manager); },
		// dateStart(){ return this.shortDate(this.task.dateStart); },
	},
	methods: {
		// shortName(person){			
		// 	let lb = person.lastNameBase ? person.lastNameBase : '';			
		// 	let ln = person.lastNameWho ? person.lastNameWho : '';
		// 	let fb = person.firstNameBase ? (person.firstNameBase).substring(0,1) : '';
		// 	let mb = person.firstNameBase ? (person.firstNameBase).substring(0,1) : '';						
		// 	return `${lb}${ln} ${fb}${mb}`
		// },
		// shortDate(date){
		// 	let d = new Date(date);
		// 	let options = { year: 'numeric', month: 'numeric', day: 'numeric'};
		// 	return  d.toLocaleDateString('ru-RU', options);
		// }
	},
	watch(){
		// childTaskList(this.id)
	},
	async created(){
		this.childTasks = this.taskList;
	},
}
</script>