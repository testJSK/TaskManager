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
    load( state, persons ) {
      state.items = persons;
    },
    getOne( state, person ) {
      state.editPerson = person
    },
  }, 
  actions: {
    async load( { commit } ) {
      const persons = await personApi.all();
      commit( 'load', persons );
    },
    async getOne( { commit }, id ) {
      const person = await personApi.getOne(id);
      commit( 'getOne', person );      
    },
    async add({ dispatch }, person ) {
      const result = await personApi.add(person)
      console.log(result)
      if(result.includes('added')) {
        dispatch( 'load' );
      }
    },
    async update( { dispatch }, person) {
      console.log(person.id)
      const result = await personApi.update(person.id, person);
      console.log(result)
      // if(result.includes('update'))
      dispatch( 'load' );
    }
  }
})






// export default ( personsApi ) => ({
//   namespaced: true,
//   state: {
//     items: [],
//     edit_visible: false,
//     // edit_person: null,
//     personforedit: null,
//   },
//   getters: {
//     edit_visible: state => state.edit_visible,
//     // edit_person: state => state.edit_person,
//     personforedit: state => state.personforedit,
    
//     items: state => state.items,
//     // inCart: state => id => state.products.some(product => product.id === id)
//   },
//   mutations: {
//     async loadpersonforedit( state, person){
//        state.personforedit = person;
//     },
//     // seteditperson( state, person ){
//     //   state.edit_person = person;
//     //   console.log(person)
//     // },
//     edit_visible( state, visible ){
//       state.edit_visible = visible;
//     },    
//     // set( state, persons ){
//     //   state.items = persons;
//     // },
//     load( state, persons ){
//       state.items = persons;
//     },
//     add( state, person ){
//       state.items.push(person);
//     },
//   },
//   actions: {
//     async loadOnePerson( { commit }, id ){
//       const person = await personsApi.getOne(id);

//       console.log(person)
//       commit( 'loadpersonforedit', person )
//     },
//     closeedit( { commit } ){
//       commit( 'edit_visible', false );
//     },
//     async aditshow( { commit, dispatch }, person ){
//       console.log(person)
//       commit( 'edit_visible', true );
//       // commit( 'seteditperson',  person );
//       await dispatch( 'loadOnePerson', person.id );

//       if( person.id !== null ){
//         console.log(person.id);
//       }
//     },
//     async load({ commit }){
//       const persons = await personsApi.all();      
//       commit( 'load', persons );
//     },

//     async add( { commit, state }, newperson  ){

//       console.log(state.items[1])
//       let result = await personsApi.add(newperson);

//       console.log(result)
//       console.log("^ result add from store")

      
//       if(result){
//         commit('add', newperson);
//       }

//       console.log(newperson)
//       console.log("^ from store ")
//       // const res = await personsApi.add(newperson);
//       // console.log(res);
//     }
//   } 
// })

// commonStr(arr1, arr2, arr3){
//   // let arr1 = a.split('');
//   // let arr2 = b.split('');
//   // let arr3 = c.split('');

//   let common = arr1.filter( x => arr2.indexOf(x) !== -1);
//   let res = common.filter( x => arr3.indexOf(x) !== -1);
//   console.log(res);
//   return res;
// },
// display(){
//   return this.commonStr(this.lastNameBase.split(''), this.lastNameFrom.split(''), this.lastNameTo.split(''));
// },