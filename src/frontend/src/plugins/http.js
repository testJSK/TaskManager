import axios from 'axios';
import createPersonsApi from '@/api/persons';
import createTasksApi from '@/api/tasks';
import createTaskTypesApi from '@/api/task_types'
import createWorkAppsApi from '@/api/work_apps'

export default () =>  {
	
	// axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*';

	const http = axios.create({
		baseURL: 'http://localhost:8080/api/v1/',
		timeout: 10000,
		withCredentials: false
	});


	const api = {
		persons: createPersonsApi(http),
		tasks: createTasksApi(http),
		taskTypes: createTaskTypesApi(http),
		workApps: createWorkAppsApi(http),
	}

	return { http, api };
}

