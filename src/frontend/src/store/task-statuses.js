export default ( taskStatusesApi ) => ({
	namespaced: true,
	state: {
		items: [],
	},
	getters: {
		items: state => state.items,
	},
	mutations: {
		getAll( state, statuses ) {
			state.items = statuses;
		},
	}, 
	actions: {
	async getAll( { commit } ) {
		const statuses = await taskStatusesApi.all();
		commit( 'getAll', statuses );
		console.log('getAll statuses ')
		},
	},
})