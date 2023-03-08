import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
// createApp(App).use(store).use(router).mount('#app')

import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
createApp(App).use(store).use(router).use(ElementPlus).mount('#app')
// app.use(ElementPlus)
// app.mount('#app')