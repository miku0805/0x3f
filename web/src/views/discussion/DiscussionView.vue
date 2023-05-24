<template>
    <!-- <MdEditor></MdEditor> -->
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <!-- <el-form-item label="标题" prop="title">
            <el-input v-model="ruleForm.title"></el-input> -->
        <!-- </el-form-item> -->

        <!-- <el-form-item label="摘要" prop="description">
            <el-input type="textarea" v-model="ruleForm.description"></el-input>
        </el-form-item>

        <el-form-item label="内容" prop="content">
            <mavon-editor v-model="ruleForm.content"></mavon-editor>
        </el-form-item> -->

        <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
    </el-form>
</template>

<script>
// import MdEditor from "@/components/MdEditor.vue"
export default {
    components: {
        // MdEditor,
    }
}
</script>

<style scoped></style>