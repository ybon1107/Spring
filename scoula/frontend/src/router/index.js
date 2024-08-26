import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '../pages/HomPage.vue';
import authRoutes from './auth';
import boardRoutes from './board';
import travelRoutes from './travel';
import galleryRoutes from './gallery';
import friendsRoutes from './friends';
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [{ path: '/', name: 'home', component: HomePage }, ...authRoutes, ...boardRoutes, ...travelRoutes, ...galleryRoutes, ...friendsRoutes],
});

export default router;
