import { createApp } from 'vue';
import App from './App.vue';

import createStorageHelper from '@/utils/token-storage'
import createHttp from '@/plugins/http'
import createStore from '@/store';
import createRouter from '@/router';

export default () => {
                                            // eslint-disable-next-line
    const { http, api } = createHttp();
                                            // eslint-disable-next-line
    const storageHelper = createStorageHelper();
    const store = createStore(api);
    const router = createRouter(store);

    store.dispatch('persons/load');
    store.dispatch('tasks/load');

    const app = createApp(App).use(store).use(router);
    app.config.globalProperties['$api'] = api;
    app.config.globalProperties['$store'] = store;

    
    return app;
};