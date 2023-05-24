<template>
    <div class="blog-detail">
        <div class="title">{{ blog.title }}</div>
        <div class="create-time">{{ blog.createtime }}</div>
        <div class="mblog">
            <h2> {{ blog.title }}</h2>
            <el-link icon="el-icon-edit" v-if="ownBlog">
                <router-link :to="{ name: 'BlogEdit', params: { blogId: blog.id } }">
                    编辑
                </router-link>
            </el-link>
            <el-divider></el-divider>
            <div class="markdown-body" v-html="blog.content"></div>
        </div>

    </div>
</template>
  
<script>
import { ref, onMounted } from 'vue';
import { useRoute } from 'vue-router';
import { useStore } from 'vuex';
import $ from 'jquery';

export default {
    setup() {
        const route = useRoute();
        const store = useStore();
        let blog = ref("");

        const getBlogDetail = () => {
            $.ajax({
                url: `http://127.0.0.1:3000/api/blog/${route.params.id}/`,
                type: 'get',
                headers: {
                    Authorization: 'Bearer ' + store.state.user.token,
                },
                success(resp) {
                    blog.value = resp.blog;
                    console.log(blog.value);
                },
                error(resp) {
                    console.log(resp);
                },
            });
        };

        onMounted(() => {
            getBlogDetail();
        });

        return {
            blog,
        };
    },
};
</script>
  
<style scoped>
.blog-detail {
    margin: 20px;
    display: flex;
    flex-direction: column;
}

.title {
    font-size: 24px;
    font-weight: bold;
}

.content {
    margin-top: 20px;
    font-size: 16px;
}

.create-time {
    margin-top: 20px;
    font-size: 14px;
    color: gray;
}

.mblog {
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
    width: 100%;
    min-height: 700px;
    padding: 20px 15px;
}
</style>