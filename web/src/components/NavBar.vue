<template>
    <!-- element -->
    <el-menu :default-active="activeIndex" class="menu" mode="horizontal" router background-color="#39C5BB"
        unique-opened="false" menu-trigger="clink" popper-effect="dark" @select="handleSelect">
        <el-menu-item index="/home/">OJ</el-menu-item>
        <el-menu-item index="/home/">Home</el-menu-item>
        <el-menu-item index="/problem/">Problem</el-menu-item>
        <el-menu-item index="/training/">Training</el-menu-item>
        <el-menu-item index="/contest/">Contest</el-menu-item>
        <el-menu-item index="/status/">Status</el-menu-item>
        <el-menu-item index="/discussion/">Discussion</el-menu-item>
        <el-sub-menu>
            <template #title>Rank</template>
            <el-menu-item index="/acmrank/">ACM</el-menu-item>
            <el-menu-item index="/oirank/">OI</el-menu-item>
            <el-sub-menu>
                <template #title>item four</template>
                <el-menu-item index="2-4-1">item one</el-menu-item>
                <el-menu-item index="2-4-2">item two</el-menu-item>
                <el-menu-item index="2-4-3">item three</el-menu-item>
            </el-sub-menu>
        </el-sub-menu>
        <el-menu-item index="/group/">Group</el-menu-item>
        <el-sub-menu>
            <template #title>About</template>
            <el-menu-item index="/aboutintroduction/">Introduction</el-menu-item>
            <el-menu-item index="/aboutdeveloper/">Developer</el-menu-item>
        </el-sub-menu>
        <el-sub-menu>
            <template #title>username</template>
            <el-menu-item index="/404/">account</el-menu-item>
            <el-menu-item index="/404/">exit</el-menu-item>
        </el-sub-menu>
    </el-menu>
</template>

<script lang="ts" setup>
import { ref } from 'vue'

const activeIndex = ref('1')
const handleSelect = (key: string, keyPath: string[]) => {
    console.log(key, keyPath)
}
// import { useRoute } from 'vue-router';
// import { computed } from 'vue';
// export default {
//     setup() {
//         const route = useRoute();
//         let route_name = computed(() => route.name)
//         return {
//             route_name
//         }
//     }
// }
</script>

<style></style>