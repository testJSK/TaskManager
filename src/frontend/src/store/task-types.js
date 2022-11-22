export default ( taskTypesApi ) => ({
	namespaced: true,
	state: {
		items: [],
	},
	getters: {
		items: state => state.items,
	},
	mutations: {
		getAll( state, types ) {
			state.items = types;
		},
	}, 
	actions: {
	async getAll( { commit } ) {
		const types = await taskTypesApi.all()
		console.log('getAll types ++++++ +++++++++++++++++')
		// commit( 'getAll', types );
		},
	}
})