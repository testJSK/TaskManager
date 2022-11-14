export default ( tasksApi, formatHelper ) => ({
  namespaced: true,  	  
  state: {
    items: {},
    editItem: {},
    newItem: {},
  },
  getters: {
    items: state => state.items,
    editItem: state => state.editItem,
  },
  mutations: {
    setItems( state, tasks ) {
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
      commit( 'setItems', tasks );
    },
    async getOne( { commit }, id ) {
      console.log('get one task ')
      let task = await tasksApi.getOne(id)
      task.dateStart = formatHelper.shortDate(task.dateStart)
      console.log(task.dateStart)
      commit( 'getOne', task)
    }
  } 
})
