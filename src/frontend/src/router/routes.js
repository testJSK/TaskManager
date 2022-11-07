import HomeView from '@/views/Home.vue'
import PanelView from '@/views/Panel.vue'
import PersonsView from '@/views/Persons.vue'
import PositionsView from '@/views/Positions.vue'
import DepartmentsView from '@/views/Departments.vue'
import TaskView from '@/views/Task.vue'
import ZRSView from '@/views/ZRS.vue'

export default function() {
  
  const routes = [ 
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/tasks/:id',
      name: 'tasks',
      component: TaskView
    },
    {
      path: '/zrs',
      name: 'zrs',
      component: ZRSView
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
    },
    {
      path: '/panel/',      
      component: PanelView,
      children: [
        {
          path: 'persons',
          name: 'panel.persons',
          component: PersonsView
        },
        {
          path: 'departments',
          name: 'panel.departments',
          component: DepartmentsView
        },
        {
          path: 'positions',
          name: 'panel.positions',
          component: PositionsView
        },
      ]
    },    
  ];
  
  return routes;
}