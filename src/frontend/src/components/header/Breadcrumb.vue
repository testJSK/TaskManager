<template>
	<div class="row g-0 justify-content-between">		
		<div class="col-2">
			<h3>{{ pageName }}</h3>	
		</div>
		<div class="col-8"></div>
		<div class="col-2">
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