import { createRouter as _createRouter, createWebHistory } from 'vue-router';
import ProductsView from '../views/ProductsView.vue';
import ProductDetailView from '../views/ProductDetailView.vue';
import AddReviewView from '../views/AddReviewView.vue';

const routes = [
  {
    path: "/",
    name: "home",
    component: ProductsView
  },
  {
    path: "/home",
    redirect: "/",
    name: "home2",
    component: ProductsView
  },
  {
    path: "/products/:bookId",
    name: "details",
    component: ProductDetailView
  },
  {
    path: "/products/:bookId/addReview",
    name: "addReview",
    component: AddReviewView
  }

];

export function createRouter () {
  return _createRouter({
    history: createWebHistory(),
    routes: routes
  })
}
