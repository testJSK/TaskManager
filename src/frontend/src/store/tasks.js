export default ( tasksApi, formatHelper ) => ({
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
		detailed: (state, getters, rootState, rootGetters) => {

			let persons = rootGetters['persons/items']

			return	state.items.map(	task => {
				let initiator = persons.find( person => person.id == task.initiatorId)
				let manager = persons.find( person => person.id == task.managerId)				
				return	{ ...task, initiator: { ...initiator }, manager: { ...manager } }
			})							 
		},
		tasksDetailed: (state, getters, rootState, rootGetters) => {
			let persons = rootGetters['persons/items'];
			if(persons.length == 0){
				return {}
			}
			return state.items.map( task => {
				let initiator;
				let manager;
				if(task.initiatorId){
					initiator = persons.find( person => person.id == task.initiatorId);	
				}
				if(task.managerId){
					manager = persons.find( person => person.id == task.managerId)
				}

				return { initiator: { ...initiator }, manager: { ...manager }, ...task };
			});
		},
		tasksDetailedByParentId: getters => id => getters.tasksDetailed.some(task => task.parentId === id),
		// requestsDetailed: (state, getters, rootState, rootGetters) => {
		// 	getters.tasksDetailed.some( task => task.parentId !== null)
		// },
	},
	mutations: {
		getAll( state, tasks ) {
			state.items = tasks;
		},
		getOne( state, task ) {
			state.editItem = task
		},
		getItemsDetailed( state, itemsDetailed ) {
			state.itemsDetailed = itemsDetailed
		}
	},

	actions: {
		async getAll( { commit } ) {
			// console.log('store')
			const tasks = await tasksApi.all();
			commit( 'getAll', tasks );
		},
		async getOne( { commit, getters }, id ) {
			console.log('get one task ')
			let task = await tasksApi.getOne(id)
			task.dateStart = formatHelper.shortDate(task.dateStart)
			// console.log(task.dateStart)
			commit( 'getOne', task)
			console.log(getters.itemsDetail)
		},
		async add( { dispatch }, task ) {
			const result = await tasksApi.add(task);
			console.log(result)
			return result;
		},
	} 
})
