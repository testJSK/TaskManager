<template>
	<router-link :to="{ name: 'taskitem', params: {id: id} }">
		<td>{{ id }}</td>
	</router-link>
	<td>{{ title }}</td>
	<td>{{ initiator }}</td>
  <td>{{ manager }}</td>
  <td>{{ dateStart }}</td>
</template>

<script>
export default {
	name: 'AppTableRow',
	props: { task: Object },
	computed: {
		id(){ return this.task.id;	},
		title(){ return this.task.title; },
		initiator(){ return this.shortName(this.task.initiator); },
		manager(){ return this.shortName(this.task.manager); },
		dateStart(){ return this.shortDate(this.task.dateStart); },
	},
	methods: {
		shortName(person){			
			let lb = person.lastNameBase ? person.lastNameBase : '';			
			let ln = person.lastNameWho ? person.lastNameWho : '';
			let fb = person.firstNameBase ? (person.firstNameBase).substring(0,1) : '';
			let mb = person.firstNameBase ? (person.firstNameBase).substring(0,1) : '';						
			return `${lb}${ln} ${fb}${mb}`
		},
		shortDate(date){
			let d = new Date(date);
			let options = { year: 'numeric', month: 'numeric', day: 'numeric'};
			return  d.toLocaleDateString('ru-RU', options);
		}
	},
}
</script>