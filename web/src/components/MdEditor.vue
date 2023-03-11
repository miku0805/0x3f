<template>
    <v-md-editor v-model="text" width="400px" height="500px"></v-md-editor>
</template>
  
<script>
export default {
    data() {
        return {
            text: '',
        };
    },
};
</script>