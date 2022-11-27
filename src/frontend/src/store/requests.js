export default ( requestsApi ) => ({
	namespaced: true,
	state: {
		items: {},
		itemsDetailed: {},
		editItem: {},
		newItem: {},
	},

	getters: {
		items: state => state.items,
		editItem: state => state.editItem,		// eslint-disable-next-line
		// detailed: (state, getters, rootState, rootGetters) => {

		// 	let persons = rootGetters['persons/items']

		// 	return	state.items.map(	request => {
		// 		let initiator = persons.find( person => person.id == request.initiatorId)
		// 		let manager = persons.find( person => person.id == request.managerId)				
		// 		return	{ ...request, initiator: { ...initiator }, manager: { ...manager } }
		// 	})							 
		// },
		requestsDetailed: (state, getters, rootState, rootGetters) => {
			let persons = rootGetters['persons/items'];
			if(persons.length == 0){
				return {}
			}
			return state.items.map( request => {
				let initiator;
				let manager;
				if(request.initiatorId){
					initiator = persons.find( person => person.id == request.initiatorId);	
				}
				if(request.managerId){
					manager = persons.find( person => person.id == request.managerId)
				}

				return { initiator: { ...initiator }, manager: { ...manager }, ...request };
			});
		},		
		// requestsDetailedByParentId: getters => id => getters.requestsDetailed.some(request => request.parentId === id),
		// requestsDetailed: (state, getters, rootState, rootGetters) => {
		// 	getters.requestsDetailed.some( request => request.parentId !== null)
		// },
	},
	mutations: {
		getAll( state, requests ) {
			state.items = requests;
		},
		getOne( state, request ) {
			state.editItem = request
		},
		getItemsDetailed( state, itemsDetailed ) {
			state.itemsDetailed = itemsDetailed
		}
	},

	actions: {
		async getAll( { commit } ) {
			console.log('store')
			const requests = await requestsApi.all();
			commit( 'getAll', requests );
		},
		async getOne( { commit, getters }, id ) {
			console.log('get one request ')
			let request = await requestsApi.getOne(id)
			request.dateStart = formatHelper.shortDate(request.dateStart)
			// console.log(request.dateStart)
			commit( 'getOne', request)
			console.log(getters.itemsDetail)
		},
		async add( { dispatch }, request ) {
			const result = await requestsApi.add(request);
			console.log(result)
			return result;
		},
	} 
})
