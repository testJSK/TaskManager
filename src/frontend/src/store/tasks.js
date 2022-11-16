export default ( tasksApi, formatHelper ) => ({
  namespaced: true,  	  
  state: {
    items: {},
    itemsDetail: {},
    editItem: {},
    newItem: {},
  },

  getters: {
    items: state => state.items,
    editItem: state => state.editItem,    // eslint-disable-next-line
    detailed: (state, getters, rootState, rootGetters) => {       
      return  state.items.map(  task => {
        let initiators = rootGetters['persons/items']
        let initiator = initiators.find( i => i.id == 44)
        console.log(initiator.firstNameBase)
        return  {...task, ...initiator}
      })       
        
    }
      // return rootGetters['persons/items'].map(i => i.id)       
  },

  mutations: {
    getAll( state, tasks ) {
      state.items = tasks;
    },
    getOne( state, task ) {
      state.editItem = task
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
    }
  } 
})
