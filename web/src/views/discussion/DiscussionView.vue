<template>
    <!-- vue3 -->
    <v-md-editor :model-value="markdown" mode="preview"></v-md-editor>
</template>
  
<script>
export default {
    data() {
        return {
            markdown: '### 标题',
        };
    },
};
</script>