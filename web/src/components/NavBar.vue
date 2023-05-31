<template>
    <!-- <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" :ellipsis="false" @select="handleSelect"
        background-color="#39C5BB" router> -->

    <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect"
        background-color="transparent" router>
        <el-sub-menu index="2" v-if="$store.state.user.is_login">
            <template #title>{{ $store.state.user.username }}</template>
            <el-button class="menu-element" index="/login/">My Account</el-button>
            <el-button class="menu-element" @click="logout">Exit</el-button>
        </el-sub-menu>
        <el-menu-item v-else>
            <el-menu-item class="menu-element" index="/login/">Login</el-menu-item>
            <el-menu-item class="menu-element" index="/register/">Register</el-menu-item>
        </el-menu-item>
        <div class="flex-grow" />
        <el-menu-item class="menu-element" index="/home/">Home</el-menu-item>
        <el-menu-item class="menu-element" index="/problem/">Problem</el-menu-item>
        <el-menu-item class="menu-element" index="/training/">随机一题</el-menu-item>
        <el-menu-item class="menu-element" index="/blog/">博客</el-menu-item>
        <el-menu-item class="menu-element" index="/status/">待办</el-menu-item>
        <el-menu-item class="menu-element" index="/discussion/">编译器</el-menu-item>
        <el-menu-item class="menu-element" index="/about/">About</el-menu-item>
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

.menu-element:hover {
    background-image: linear-gradient(to top right, #f5f5f5, #ffe6e6);
    box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
}
</style>