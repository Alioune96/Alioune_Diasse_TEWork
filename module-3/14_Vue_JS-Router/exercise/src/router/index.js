import { createRouter as _createRouter, createWebHistory } from 'vue-router';

import HomeView from '../views/HomeView.vue'
import MyBooksView from '../views/MyBooksView.vue'
import NewBookView from '../views/NewBookView.vue'
import JustOneView from '../views/JustOneView.vue'



const routes = [

  {
    path: '/',
    name: 'Home',
    component: HomeView
  },
  {
    path: '/myBooks',
    name: 'Mybook',
    component: MyBooksView
  }, 
  {
    path: '/addBook',
    name: 'NewBook',
    component: NewBookView
  },
  { path:'/book/:id',
    name: 'JustOne',
    component:JustOneView

  }
  
  
  
 


];

export function createRouter () {
  return _createRouter({
    history: createWebHistory(),
    routes: routes
  })
}
