<template>
    <el-carousel :interval="4000" type="card" height="200px">
        <el-carousel-item v-for="item in 6" :key="item">
            <h3 text="2xl" justify="center">{{ item }}</h3>
        </el-carousel-item>
    </el-carousel>
    <!-- <ul v-infinite-scroll="load" class="infinite-list" style="overflow: auto">
        <li v-for="i in count" :key="i" class="infinite-list-item">{{ i }}</li>
    </ul>
    <div class="demo-fit">
        <div v-for="fit in fits" :key="fit" class="block">
            <span class="title">{{ fit }}</span>
            <el-avatar shape="square" :size="100" :fit="fit" :src="url" />
        </div>
    </div> -->
    <div>
        <el-button @click="show = !show">Click Me</el-button>

        <div style="display: flex; margin-top: 20px; height: 100px">
            <transition name="el-zoom-in-center">
                <div v-show="show" class="transition-box">.el-zoom-in-center</div>
            </transition>

            <transition name="el-zoom-in-top">
                <div v-show="show" class="transition-box">.el-zoom-in-top</div>
            </transition>

            <transition name="el-zoom-in-bottom">
                <div v-show="show" class="transition-box">.el-zoom-in-bottom</div>
            </transition>
        </div>
    </div>
    <!-- 折叠面板 -->
    <!-- <div>
        <el-button @click="show = !show">Click Me</el-button>

        <div style="margin-top: 20px; height: 200px">
            <el-collapse-transition>
                <div v-show="show">
                    <div class="transition-box">el-collapse-transition</div>
                    <div class="transition-box">el-collapse-transition</div>
                </div>
            </el-collapse-transition>
        </div>
    </div> -->
</template>
  
<script lang="ts" setup>
// import { ref } from 'vue'
// import { reactive, toRefs } from 'vue'
// const show = ref(true)
// const count = ref(0)
// const load = () => {
//     count.value += 2
// }
// const state = reactive({
//     fits: ['fill', 'contain', 'cover', 'none', 'scale-down'],
//     url: "https://avatars.githubusercontent.com/u/105724177?s=400&u=15976605823fa42ea1a5bc43847b44ae7858eaec&v=4",
// })

// const { fits, url } = toRefs(state)
</script>

<style scoped>
.el-carousel__item h3 {
    color: #475669;
    opacity: 0.75;
    line-height: 200px;
    margin: 0;
    text-align: center;
}

.el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
    background-color: #d3dce6;
}

.infinite-list {
    height: 300px;
    padding: 0;
    margin: 0;
    list-style: none;
}

.infinite-list .infinite-list-item {
    display: flex;
    align-items: center;
    justify-content: center;
    height: 50px;
    background: var(--el-color-primary-light-9);
    margin: 10px;
    color: var(--el-color-primary);
}

.infinite-list .infinite-list-item+.list-item {
    margin-top: 10px;
}

.demo-fit {
    display: flex;
    text-align: center;
    justify-content: space-between;
}

.demo-fit .block {
    flex: 1;
    display: flex;
    flex-direction: column;
    flex-grow: 0;
}

.demo-fit .title {
    margin-bottom: 10px;
    font-size: 14px;
    color: var(--el-text-color-secondary);
}

.transition-box {
    margin-bottom: 10px;
    width: 200px;
    height: 100px;
    border-radius: 4px;
    background-color: #409eff;
    text-align: center;
    color: #fff;
    padding: 40px 20px;
    box-sizing: border-box;
    margin-right: 20px;
}

/* 折叠面板 */
.transition-box {
    margin-bottom: 10px;
    width: 200px;
    height: 100px;
    border-radius: 4px;
    background-color: #409eff;
    text-align: center;
    color: #fff;
    padding: 40px 20px;
    box-sizing: border-box;
    margin-right: 20px;
}
</style>
  