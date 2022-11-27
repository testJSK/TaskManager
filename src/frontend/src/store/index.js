import { createStore } from 'vuex';
import createPersonStore from '@/store/persons';
import createTaskStore from '@/store/tasks';
import createRequestStore from '@/store/requests'
import createWorkAppsStore from '@/store/work-apps'
import createTaskTypesStore from '@/store/task-types'
import createTaskStatusesStore from '@/store/task-statuses'


export default ( api, formatHelper ) => createStore({

  modules: {
		requests: createRequestStore(api.requests),
    tasks: createTaskStore(api.tasks, formatHelper),
    persons: createPersonStore(api.persons),
    workApps: createWorkAppsStore(api.workApps),
    taskTypes: createTaskTypesStore(api.taskTypes),
    taskStatuses: createTaskStatusesStore(api.taskStatuses),
  },

  strict: process.env.NODE_ENV !== 'production'
})
