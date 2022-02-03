import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import qs from 'qs'

import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

// import * as echarts from 'echarts';
// const AppBase = createApp(App);
// AppBase.config.globalProperties.echarts = echarts;

createApp(App).use(store).use(router).use(ElementPlus).mount('#app')
