import { createStore } from 'vuex';
import createPersonStore from './persons';
import createTaskStore from './tasks';
import createWorkAppsStore from '@/store/work-apps'
import createTaskTypesStore from '@/store/task-types'
import createTaskStatusesStore from '@/store/task-statuses'

export default ( api, formatHelper ) => createStore({

  modules: {
    tasks: createTaskStore(api.tasks, formatHelper),
    persons: createPersonStore(api.persons),
    workApps: createWorkAppsStore(api.workApps),
    taskTypes: createTaskTypesStore(api.taksTypes),
    taskStatuses: createTaskStatusesStore(api.taskStatuses),
  },

  strict: process.env.NODE_ENV !== 'production'
})
