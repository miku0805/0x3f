<template>
    <div class="blog-detail">
        <v-md-editor :model-value="blog.content" mode="preview" @copy-code-success="handleCopyCodeSuccess"></v-md-editor>
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
                url: `http://101.33.207.160:3000/api/blog/${route.params.id}/`,
                type: "get",
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
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
    background-color: #fff;
    border-radius: 5px;
    padding: 50px 40px;
    background: rgba(255, 255, 255, 0.84);

    /* 使用特性检测来判断是否支持backdrop-filter属性 */
    @supports (-webkit-backdrop-filter: blur(100px) or backdrop-filter: blur(10px)) {
        .element {
            -webkit-backdrop-filter: blur(10px);
            /* 设置模糊程度，可以根据需要进行调整 */
            backdrop-filter: blur(100px);
            /* 设置模糊程度，可以根据需要进行调整 */
        }
    }
}

#page-header #post-info {
    position: absolute;
    bottom: 100px;
    padding: 0 8%;
    width: 100%;
    text-align: center;
}

#post-info .post-title {
    margin-bottom: 8px;
    color: var(--white);
    font-weight: normal;
    font-size: 2.5em;
    line-height: 1.5;
    -webkit-line-clamp: 3;
}
</style>