<template>
    <v-ace-editor class="editor" v-model:value="content" @init="editorInit" lang="html" theme="chrome" />
</template>

<script >
import { VAceEditor } from 'vue3-ace-editor';
import ace from 'ace-builds';



export default {
    setup() {
        ace.config.set(
            "basePath",
            "https://cdn.jsdelivr.net/npm/ace-builds@" + require('ace-builds').version + "/src-noconflict/")
    },
    components: {
        VAceEditor,
    }
}
</script>

<style scoped>
.editor {
    width: 50%;
    height: 710px;
    margin-left: auto;
}
</style>