import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import DeclarativeRenderingView from '@/views/DeclarativeRendering.vue'
import AttributeBindingsView from '@/views/AttributeBIndings.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue')
    },
    {
      path: '/DeclarativeRendering',
      name: 'DeclarativeRendering',
      component: DeclarativeRenderingView 
    },
    {
      path: '/AttributeBindings',
      name: 'AttributeBindings',
      component: AttributeBindingsView
    },
  ]
})

export default router
