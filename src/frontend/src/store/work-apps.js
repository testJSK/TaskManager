export default ( workAppsApi ) => ({
	namespaced: true,
	state: {
		items: [],
	},
	getters: {
		items: state => state.items,
	},
	mutations: {
		getAll( state, apps ) {
			state.items = apps;
		},
	}, 
	actions: {
	async getAll( { commit } ) {
		const apps = await workAppsApi.all();
		console.log(' 99999999  === getAll apps ')
		commit( 'getAll', apps );
		},
	},
})