<template>	
	<div class="row g-0 justify-content-between my-4">
		<div class="col-2">
			<img class="icon" src="/icons/bars.svg" alt="bars">
		</div>
		<div class="col-8">
		</div>		
		<div class="col-2">
			<img class="icon" src="/icons/right-from-bracket.svg" alt="log out">Log out
		</div>
	</div>

	<hr>
</template>

<script>
export default {
	name: 'AppHeader',
	props: { userStatus: String },
	computed: { },
	methods: { },
}
</script>