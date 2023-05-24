<template>
    <!-- <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" :ellipsis="false" @select="handleSelect"
        background-color="#39C5BB" router> -->
    <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect"
        background-color="#39C5BB" router>
        <el-sub-menu index="2" v-if="$store.state.user.is_login">
            <template #title>{{ $store.state.user.username }}</template>
            <el-button index="/login/">My Account</el-button>
            <el-button class="exit" @click="logout">Exit</el-button>
        </el-sub-menu>
        <el-menu-item v-else>
            <el-menu-item index="/login/">Login</el-menu-item>
            <el-menu-item index="/register/">Register</el-menu-item>
        </el-menu-item>
        <div class="flex-grow" />
        <el-menu-item index="/home/">编译器</el-menu-item>
        <el-menu-item index="/problem/">Problem</el-menu-item>
        <el-menu-item index="/training/">随机一题</el-menu-item>
        <el-menu-item index="/contest/">博客</el-menu-item>
        <el-menu-item index="/status/">待办</el-menu-item>
        <el-menu-item index="/discussion/">Discussion</el-menu-item>
        <el-menu-item index="/about/">About</el-menu-item>
    </el-menu>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
import { useStore } from 'vuex'
const activeIndex = ref('2')
const handleSelect = (key: string, keyPath: string[]) => {
    console.log(key, keyPath)
}


//login
const store = useStore();
const logout = () => {
    store.dispatch("logout");
}


</script>

<style scoped>
.el-menu-demo {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    align-items: center;
}

el-button {
    width: 100%;
}

.flex-grow {
    flex-grow: 1;
}

.el-button--text {
    margin-right: 15px;
}

.el-select {
    width: 300px;
}

.el-input {
    width: 300px;
}

.dialog-footer button:first-child {
    margin-right: 10px;
}
</style>