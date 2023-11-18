import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import {ClientTable, Event} from 'vue-tables-2';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';




Vue.config.productionTip = false
Vue.use(ClientTable);
Vue.use(Event);

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
