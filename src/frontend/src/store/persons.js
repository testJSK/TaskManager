export default ( personApi ) => ({
  namespaced: true,
  state: {
    items: [],
    editPerson: {},
    resultAddPerson: null,
  },
  getters: {
    items: state => state.items,
    editPerson: state => state.editPerson,
  },
  mutations: {
    getAll( state, persons ) {
      state.items = persons;
    },
    getOne( state, person ) {
      state.editPerson = person
    },
  }, 
  actions: {
    async getAll( { commit } ) {
      const persons = await personApi.all();
      commit( 'getAll', persons );
    },
    async getOne( { commit }, id ) {
      const person = await personApi.getOne(id);
      commit( 'getOne', person );      
    },
    async add({ dispatch }, person ) {
      const result = await personApi.add(person)
      if(result.includes('added')) {
        dispatch( 'load' );
      }
    },
    async update( { dispatch }, person) {
      const result = await personApi.update(person.id, person);
      dispatch( 'load' );
    }
  }
})