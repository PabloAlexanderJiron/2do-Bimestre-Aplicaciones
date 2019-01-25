// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
// import VueWebsocket from "vue-websocket"

Vue.use(router)
Vue.use(BootstrapVue)
// Vue.use(VueWebsocket)
Vue.config.productionTip = false

export default new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
