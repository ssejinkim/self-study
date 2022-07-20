import HomeView from '../views/HomeView.vue'
import DeclarativeRenderingView from '@/views/DeclarativeRendering.vue'
import AttributeBindingsView from '@/views/AttributeBIndings.vue'
import EventListenersView from '@/views/EventListeners.vue'

export const routes =  [
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
      name: 'Declarative Rendering',
      component: DeclarativeRenderingView 
    },
    {
      path: '/AttributeBindings',
      name: 'Attribute Bindings',
      component: AttributeBindingsView
    },
    {
      path: '/EventListeners',
      name: 'Event Listeners',
      component: EventListenersView 
    },
  ]