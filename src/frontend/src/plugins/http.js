import axios from 'axios';
import createTasksApi from '@/api/tasks';
import createPersonsApi from '@/api/persons';
import createWorkAppsApi from '@/api/work_apps'
import createTaskTypesApi from '@/api/task_types'
import createTaskStatusesApi from '@/api/task_statuses'

export default () =>  {
	
	// axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*';

	const http = axios.create({
		baseURL: 'http://localhost:8080/api/v1/',
		timeout: 10000,
		withCredentials: false
	});


	const api = {		
		tasks: createTasksApi(http),
		persons: createPersonsApi(http),
		workApps: createWorkAppsApi(http),
		taskTypes: createTaskTypesApi(http),		
		taskStatuses: createTaskStatusesApi(http),
	}

	return { http, api };
}

