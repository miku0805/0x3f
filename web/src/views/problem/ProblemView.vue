<template>
    <!-- <AceEditor v-model:value="code" lang="c_cpp"></AceEditor> -->
    <!-- <v-ace-editor v-model:value="content" lang="html" theme="github" style="height: 300px" /> -->
    <!-- <codemirror v-model="currentValue" :options="options" ref="editor"></codemirror> -->
    <div>
        <button @click="compile">commit</button>
    </div>
</template>

<script >
// import AceEditor from "@/components/AceEditor.vue"
import $ from 'jquery'
// import { ref } from "vue";
// import { VAceEditor } from "vue3-ace-editor"
// import ace from 'ace-builds';
// import { codemirror, CodeMirror } from 'vue-codemirror-lite';
// import 'codemirror/mode/javascript/javascript';
// import 'codemirror/mode/clike/clike.js';
// import 'codemirror/mode/python/python.js';
// import 'codemirror/theme/solarized.css';
// ace.config.set(
//     "basePath",
//     "https://cdn.jsdelivr.net/npm/ace-builds@" + require('ace-builds').version + "/src-noconflict/")
export default {
    components: {
        // AceEditor,
        // VAceEditor
        // CodeMirror,
    },
    methods: {
        compile() {
            // let code = ref('')
            $.ajax({
                url: "http://127.0.0.1:3000/compile/",
                type: "post",
                data: JSON.stringify({
                    code: "#include <iostream>\nint main() {\n    std::cout << \"李嘉又要进国赛喽\" << std::endl;\n    return 0;\n}"
                    // code: code.value,
                }),
                headers: {
                    "Content-Type": "application/json"
                },
                success(resp) {
                    console.log(resp);
                },
                error(resp) {
                    console.log(resp);
                }
            });
        }
    },
}
</script>
<style>
.editor {
    width: 50%;
    height: 500px;
    margin-left: auto;
    margin-left: auto;
}
</style>