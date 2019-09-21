import Vue from 'vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import App from './App.vue'
import router from './router/main-router'
import axios from 'axios'

Vue.use(ElementUI)

Vue.config.productionTip = false

const BASE_URL = 'http://localhost:9889/api/';
axios.defaults.headers.post['Content-Type'] = 'application/json';
axios.defaults.headers.get['Content-Type'] = 'application/json';
axios.defaults.baseURL = BASE_URL;
Vue.prototype.$ajax = axios;



new Vue({
    router,
    render: h => h(App),
}).$mount('#app')


