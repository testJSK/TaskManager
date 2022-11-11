import { createStore } from 'vuex';
import createPersonStore from './persons';
import createTaskStore from './tasks';

export default ( api, formatHelper ) => createStore({

  modules: {
    tasks: createTaskStore(api.tasks, formatHelper),
    persons: createPersonStore(api.persons),
  },

  strict: process.env.NODE_ENV !== 'production'
})
