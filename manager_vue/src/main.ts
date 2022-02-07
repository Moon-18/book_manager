import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import qs from 'qs'

import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

import axios from '@/network/login'
//全局挂载axios 注册与登录
const app=createApp(App)
app.config.globalProperties.$axios=axios

// import * as echarts from 'echarts';
// const AppBase = createApp(App);
// AppBase.config.globalProperties.echarts = echarts;

createApp(App).use(store).use(router).use(ElementPlus).mount('#app')
