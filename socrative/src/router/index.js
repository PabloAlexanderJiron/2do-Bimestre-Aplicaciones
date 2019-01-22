import Vue from 'vue'
import Router from 'vue-router'
import Crear from '@/components/Crear'
import Lanzar from '@/components/Lanzar'
import Cuestionarios from '@/components/Cuestionarios'
import Reportes from '@/components/Reportes'

Vue.use(Router)

/* eslint-disable eol-last */
export default new Router({
  routes: [
    {
      path: '/crear',
      name: 'Crear',
      component: Crear
    },
    {
      path: '/lanzar',
      name: 'Lanzar',
      component: Lanzar
    },
    {
      path: '/cuestionarios',
      name: 'Cuestionarios',
      component: Cuestionarios
    },
    {
      path: '/reportes',
      name: 'Reportes',
      component: Reportes
    }
  ]
})
