<template>
	<div class="row g-0">		
	
<div>
   <h3> Задачи:</h3>
		<div class="row g-0 align-items-end my-3">
			<ol class="list-group list-group-numbered">
				<li class="list-group-item" v-for="i in childTasks" :key="i.id">
					<!-- {{ i.title }} {{ workApps.find( app => (app.id === i.workAppId).title) }} -->
					<!-- <router-link :to="{ name: 'taskitem', params: { id: i.id } }">    
						<button class="btn btn-primary" @click="console.log(e.target)" >...</button>
					</router-link> -->

					<button 
						class="btn btn-primary" 
						@click="this.$router.push('/task/'+ i.id )"
					>...</button>
						<!-- @click="$router.push({name: 'taskitem', params: { id: i.id }})" -->
				</li>
			</ol>
		</div>
	</div>
</div>

</template>

<script>
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
	async created(){
		this.childTasks = this.taskList;
	},
}
</script>