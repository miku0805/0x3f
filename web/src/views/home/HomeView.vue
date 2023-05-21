<template>
    <v-ace-editor v-model:value="content" :min-lines="20" :max-lines="300" lang="c_cpp" style="" :options="{
            enableBasicAutocompletion: true, //启用基本自动完成
            enableSnippets: true, // 启用代码段
            enableLiveAutocompletion: true, // 启用实时自动完成
            fontSize: 22, //设置字号
            tabSize: 4, // tab大小
            showPrintMargin: false, //去除编辑器里的竖线
            highlightActiveLine: true,
        }" />
    <!-- <div class="btn-div" style="float:right"> -->
    <!-- <button @click="runCode" type="button" class="btn btn-success submit-btn">
            Submit</button> -->
    <el-button @click="runCode" type="button" style="float:right">submit</el-button>
    <!-- </div> -->
    <div class="operator-box mb-3"
        style=" 
                                                                                                                                        border-radius: 4px; 
                                                                                                                                        height: 200px; clear: both;">

        <div class="item" style="margin-left: 20px ; margin-right: 20px;">
            <label for="input" class="form-label" style="font-size: 15px; ">输入</label>
            <textarea ref="textarea" v-model="input" class="form-control" id="exampleFormControlTextarea1"
                rows="3"></textarea>
        </div>

        <div class="item" style="margin-left: 20px ; margin-right: 20px; border-radius: 4px;">
            <label for="input" class="form-label" style="font-size: 15px; ">输出</label>
            <div class="background-vm"
                style="background-color: white; border-radius: 4px; 
                                                                                                                                                color: black; height: auto; background-color: rgb(242,243,245);">
                <pre style="margin-left: 20px;">{{ output }}</pre>
                <!-- 用pre就可以换行渲染json -->
            </div>
        </div>
    </div>
</template>

<script>
import { VAceEditor } from 'vue3-ace-editor'
import ace from "ace-builds";
import 'ace-builds/src-noconflict/mode-json';
import 'ace-builds/src-noconflict/theme-chrome';
import 'ace-builds/src-noconflict/theme-monokai';
import 'ace-builds/src-noconflict/ext-language_tools';
import 'ace-builds/src-noconflict/mode-python';
import 'ace-builds/src-noconflict/mode-c_cpp';
import { ref } from 'vue';
import $ from 'jquery'
// import autosize from 'autosize'


ace.config.set(
    "basePath",
    "https://cdn.jsdelivr.net/npm/ace-builds@" +
    require("ace-builds").version +
    "/src-noconflict/")

export default {
    components: {
        // ContentField,
        VAceEditor,
    },
    // mounted() {
    //     autosize(this.$refs.textarea)
    // },
    setup() {
        let content = ref('');
        let backid = ref('');
        let output = ref('');
        let input = ref('');
        function runCode() {
            console.log(content.value);
            console.log(input.value);
            $.ajax({
                url: "http://101.33.207.160:3000/api/compile/",
                type: "POST",
                data: JSON.stringify({
                    code: content.value,
                    input: input.value,
                }),
                headers: {
                    "Content-Type": "application/json"
                },
                success(resp) {
                    backid = resp;
                    console.log(resp);
                    output.value = resp.output;
                    console.log(output.value);
                    if (output.value === undefined)  // 返回报错信息
                        output.value = resp.error
                },
            })
        }
        return {
            content,
            runCode,
            backid,
            output,
            input,
        }
    },
}
</script>

<style scoped>
.output-box {
    background-color: white;
    clear: both;
    height: 30px;
    border-radius: 5px;
}

.submit-btn {
    margin-top: 20px;
    width: 200px;
    margin-bottom: 20px;
}

.editor-bar-content {
    height: 60px;
    background-color: white;
}

.form-select {
    width: 140px;
    margin-left: auto;
    margin-right: 20px;
    margin-top: auto;
}

.col {
    border: solid;
}
</style>
