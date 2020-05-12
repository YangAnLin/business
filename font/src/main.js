import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
/* 引入element 组件 */
import './plugins/element.js'
/* 引入element 样式 */
import 'element-ui/lib/theme-chalk/index.css'
import './assets/css/global.css'

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
