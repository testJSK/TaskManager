<template>
	<td>{{ id }}</td>
  <td>{{ title }}</td>
  <td>{{ initiator }}</td>
  <!-- <td>{{ manager }}</td>
  <td>{{ dateStart }}</td> -->
</template>

<script>
export default {
	name: 'RowTable',
	props: { task: Object },
	computed: {
		id(){ return this.task.id;	},
		title(){ return this.task.title; },
		initiator(){ 
			if(!!this.task.initiator.firstNameBase){
				let lb = this.task.initiator.lastNameBase;
				let ln = (!!!this.task.initiator.lastNameWho ) ? '' : this.task.initiator.lastNameWho;
				let fb = this.task.initiator.firstNameBase;
				let fn = (!!!this.task.initiator.firstNameWho ) ? '' : this.task.initiator.firstNameWho;
				return `${lb}${ln} ${fb}${fn}`; 
			}
			return ''
		},
		// manager(){ return this.task.manager; },
		// dateStart(){ return this.task.dateStart; },
	},
	methods: {},
}
</script>