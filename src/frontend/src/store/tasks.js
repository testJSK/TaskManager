export default ( tasksApi, formatHelper ) => ({
  namespaced: true,  	  
  state: {
    items: null,
    editItem: {},
  },
  getters: {
    items: state => state.items,
    editItem: state => state.editItem,
  },
  mutations: {
    set( state, tasks ) {
      state.items = tasks;
    },
    getOne( state, task ) {
      state.editItem = task
    }
  },
  actions: {
    async load( { commit } ) {
      console.log('store')
      const tasks = await tasksApi.all();
      commit( 'set', tasks );
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
