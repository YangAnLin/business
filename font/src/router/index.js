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
        component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
    }
]


const router = new VueRouter({
    routes
})

//==========================路由守卫====================================================
// to将要访问的路径
// from 从哪个路径跳转而来
// next 是一个函数,表示方形 ,比如 netxt()   和 next("/login)强制跳转
// router.beforeEach((to,from,next)=>{
//
//     // 访问首页不用验证
//     if (to.path === '/') {
//         return next()
//     }
//
//     const tokenStr = window.sessionStorage.getItem('token')
//     if (!tokenStr) {
//         return next('/login')
//     }else{
//         next()
//     }
// })

export default router
