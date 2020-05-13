import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from "../components/Login";
import Home from "../views/Home";
import Register from "../components/Register";

Vue.use(VueRouter)

const routes = [
    // 登录页
    {path: '/', name: 'Login', component: Login},
    // 注册页
    {path: '/register', name: 'Register',component: Register},
    // 系统首页
    {
        path: '/home',
        name: 'Home',
        component: Home
    },
    {
        path: '/about',
        name: 'About',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
    }
]

const router = new VueRouter({
    routes
})

export default router
