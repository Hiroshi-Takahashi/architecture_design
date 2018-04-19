import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home/Home'
import Error404 from '@/components/Error/404'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/error/404',
      name: 'Error404',
      component: Error404
    }
  ]
})
