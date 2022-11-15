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
    editItem: state => state.editItem,
    detailed: (state, getters, rootState, rootGetters) => {
      return items.map( task => {
        let person = rootGetters['persons/items'].id(task.initiatorId)
        return person
      })

      }
        
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
      console.log('store')
      const tasks = await tasksApi.all();
      commit( 'getAll', tasks );
    },
    async getOne( { commit, getters }, id ) {
      console.log('get one task ')
      let task = await tasksApi.getOne(id)
      task.dateStart = formatHelper.shortDate(task.dateStart)
      console.log(task.dateStart)
      commit( 'getOne', task)
      console.log(getters.itemsDetail)
    }
  } 
})
