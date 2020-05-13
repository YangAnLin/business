import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
/* 引入element 组件 */
import './plugins/element.js'
/* 引入element 样式 */
import 'element-ui/lib/theme-chalk/index.css'
import './assets/css/global.css'
/* 请求数据框架 */
import axios from 'axios'
// 配置请求的根路径
axios.defaults.baseURL = 'http://localhost:10001/'
/* 配置成全局的 */
Vue.prototype.$http = axios

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
