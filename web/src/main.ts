import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

import VueMarkdownEditor from '@kangc/v-md-editor';
import '@kangc/v-md-editor/lib/style/base-editor.css';
import vuepressTheme from '@kangc/v-md-editor/lib/theme/vuepress.js';
import '@kangc/v-md-editor/lib/theme/style/vuepress.css';
import Prism from 'prismjs';
import githubTheme from '@kangc/v-md-editor/lib/theme/github.js';
import '@kangc/v-md-editor/lib/theme/style/github.css';
import cpp from 'highlight.js/lib/languages/cpp';
// highlightjs
import hljs from 'highlight.js';


hljs.registerLanguage('cpp', cpp);
VueMarkdownEditor.use(vuepressTheme, {
    Prism,
    Hljs: hljs,
    extend() {
        // md为 markdown-it 实例，可以在此处进行修改配置,并使用 plugin 进行语法扩展
        // md.set(option).use(plugin);
    },
});
VueMarkdownEditor.use(githubTheme, {
    Hljs: hljs,
});
createApp(App).use(store).use(router).use(ElementPlus).use(VueMarkdownEditor).mount('#app')