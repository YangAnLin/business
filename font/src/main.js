import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

//==========================全局样式====================================================
import './assets/css/global.css'

//==========================element====================================================
/* 引入element 组件 */
import './plugins/element.js'
/* 引入element 样式 */
import 'element-ui/lib/theme-chalk/index.css'

//==========================axios====================================================
/* 请求数据框架 */
import axios from 'axios'
// 配置请求的根路径
axios.defaults.baseURL = process.env.VUE_APP_PATH
/* 配置成全局的 */
Vue.prototype.$http = axios

//==========================进度条====================================================
// 导入进度条
import NProgress from 'nprogress'
import 'nprogress/nprogress.css'


//==========================拦截器和进度条====================================================
axios.interceptors.request.use(config => {
    NProgress.start();  // 配置进度条
    config.headers.Authorization = window.sessionStorage.getItem("token")
    return config
})
axios.interceptors.response.use(config => {
        NProgress.done(); // 配置进度条

        console.log("token这里",config.data.code);
        if (config.data.code === "030") {
          router.push('/')
        }

        return config
})


Vue.config.productionTip = false

new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')


Vue.filter('dataFormat', function (originVal) {
    const dt = new Date(originVal)

    const y = dt.getFullYear()
    const m = (dt.getMonth() + 1 + '').padStart(2, '0')
    const d = (dt.getDate() + '').padStart(2, '0')

    const hh = (dt.getHours() + '').padStart(2, '0')
    const mm = (dt.getMinutes() + '').padStart(2, '0')
    const ss = (dt.getSeconds() + '').padStart(2, '0')
    // yyyy-mm-dd hh:mm:ss
    return `${y}-${m}-${d} ${hh}:${mm}:${ss}`
})
