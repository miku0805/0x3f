<template>
    <el-carousel :interval="4000" type="card" height="500px" width="500px">
        <el-carousel-item class='item' v-for="item in carouseData" :key="item">
            <img :src="item.url" alt="" />
        </el-carousel-item>
    </el-carousel>
</template>
<script setup>
const carouseData = [
    { url: require("@/assets/background.jpeg") },
    { url: require("@/assets/carousel0.png") },
    { url: require("@/assets/carousel1.jpeg") },
    { url: require("@/assets/carousel0.png") },
    { url: require("@/assets/carousel1.jpeg") },
    { url: require("@/assets/carousel0.png") },
]
</script>

<style scoped>
img {
    /*设置图片宽度和浏览器宽度一致*/
    width: 100%;
    /* height: 100%; */
    height: inherit;
}
</style>