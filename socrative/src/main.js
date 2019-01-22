// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
// import { userInfo } from 'os';

Vue.use(router)
Vue.use(BootstrapVue)
Vue.config.productionTip = false

/* eslint-disable no-new*/
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>',
  methods: {
    clear: function () {
      this.pregunta = ''
      this.resp1 = ''
      this.resp2 = ''
      this.resp3 = ''
      this.rValida = ''
    },
    editarTarea: function (index) {
      this.index = index
      switch (this.cuest[index].tipo) {
        case '1':
          this.MO = true
          this.p = this.cuest[index].pregunta
          this.r1 = this.cuest[index].op.op1
          this.r2 = this.cuest[index].op.op2
          this.r3 = this.cuest[index].op.op3
          this.rc = this.cuest[index].opc
          break
      }
    },
    created: function () {
      this.connect()
      let base = JSON.parse(localStorage.getItem('datos'))
      if (base === null) {
        this.cuest = []
      } else {
        this.cuest = base
      }
    }
  }
})
