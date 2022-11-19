<template>
	<div class="row p-1">		
		<div class="col-3">
			<h3>{{ pageName }}</h3>	
		</div>
		<div class="col-6"></div>
		<div class="col-3">
			Home
			<img class="icon-m" src="/icons/angle-right.svg" alt="log out">
			Tasks
		</div>
	</div>
	<hr>
</template>

<script>
export default {
	name: 'AppBreadcrumb',
	props: { pageName: String },
	computed: { },
	methods: { },
}
</script>