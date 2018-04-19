import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home/Home'
import Error400 from '@/components/Error/400'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/error/400',
      name: 'Error400',
      component: Error400
    }
  ]
})
