import HomeView from '@/views/Home.vue'
import PanelView from '@/views/Panel.vue'
import PersonsView from '@/views/Persons.vue'
import PositionsView from '@/views/Positions.vue'
import DepartmentsView from '@/views/Departments.vue'
import TaskView from '@/views/Task.vue'
import TaskItemView from '@/views/TaskItem.vue'
import E404View from '@/components/E404.vue'

export default function() {
  
  const routes = [ 
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/task',
      name: 'task',
      component: TaskView
    },
    {
      path: '/task/:id',
      name: 'taskitem',
      component: TaskItemView
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
    {
      path: '/:any(.*)',
      component: E404View,
      
    }, 
  ];
  
  return routes;
}