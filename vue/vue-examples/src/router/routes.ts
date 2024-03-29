import HomeView from '../views/HomeView.vue'
import DeclarativeRenderingView from '@/views/DeclarativeRendering.vue'
import AttributeBindingsView from '@/views/AttributeBIndings.vue'
import EventListenersView from '@/views/EventListeners.vue'
import FormBindingsView from '@/views/FormBindings.vue'
import ConditionalRenderingView from '@/views/ConditionalRendering.vue'
import ListRenderingView from '@/views/ListRendering.vue'
import ComputedPropertyView from '@/views/ComputedProperty.vue'
import LifecycleAndTemplateRefsView from '@/views/LifecycleAndTemplateRefs.vue'
import WatchersView from '@/views/Watchers.vue'
import ComponentsView from '@/views/Components.vue'
import PropsView from '@/views/Props.vue'
import EmitsView from '@/views/Emits.vue'
import SlotsView from '@/views/Slots.vue'

export const routes = [
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
  {
    path: '/FromBindings',
    name: 'Form Bindings',
    component: FormBindingsView
  },
  {
    path: '/ConditionalRendering',
    name: 'Conditional Rendering',
    component: ConditionalRenderingView 
  },
  {
    path: '/ListRendering',
    name: 'List Rendering',
    component: ListRenderingView 
  },
  {
    path: '/ComputedProperty',
    name: 'Computed Property',
    component: ComputedPropertyView 
  },
  {
    path: '/LifecycleAndTemplateRefs',
    name: 'Lifecycle And Template Refs',
    component: LifecycleAndTemplateRefsView
  },
  {
    path: '/Watchers',
    name: 'Watchers',
    component: WatchersView 
  },
  {
    path: '/Components',
    name: 'Components',
    component: ComponentsView 
  },
  {
    path: '/Props',
    name: 'Props',
    component: PropsView 
  },
  {
    path: '/Emits',
    name: 'Emits',
    component: EmitsView 
  },
  {
    path: '/Slots',
    name: 'Slots',
    component: SlotsView 
  },
]