import { createApp } from 'vue';
import App from './App.vue';

import createStorageHelper from '@/utils/token-storage'
import createHttp from '@/plugins/http'
import createStore from '@/store';
import createRouter from '@/router';
import createDataFormater from '@/utils/data-formater';

export default () => {
                                            // eslint-disable-next-line
    const { http, api } = createHttp();
    const formatHelper = createDataFormater();
                                            // eslint-disable-next-line
    const storageHelper = createStorageHelper();
    const store = createStore(api, formatHelper);
    const router = createRouter(store);

    store.dispatch('persons/getAll');
    store.dispatch('tasks/getAll');    
    store.dispatch('tasks/getItemsDetailed');

    const app = createApp(App).use(store).use(router);
    app.config.globalProperties['$api'] = api;
    app.config.globalProperties['$store'] = store;

    
    return app;
};