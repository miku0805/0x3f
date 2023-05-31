<template>
    <div class="row">
        <el-button type="button" class="float-end el-button--transparent" data-bs-toggle="modal"
            data-bs-target="#add-blog-btn">
            修改blog
        </el-button>

        <div class="modal fade" id="add-blog-btn" tabindex="-1">
            <div class="modal-dialog modal-xl">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">修改blog</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="mb-3">
                            <label for="add-blog-title" class="form-label">title</label>
                            <input v-model="blog.title" type="text" class="form-control" id="add-blog-title"
                                placeholder="title">
                        </div>
                        <div class="mb-3">
                            <label for="add-blog-brief" class="form-label">brief</label>
                            <textarea v-model="blog.brief" class="form-control" id="add-blog-brief" rows="3"
                                placeholder="brief"></textarea>
                        </div>
                        <div class="mb-3">
                            <label for="add-blog-image" class="form-label">image</label>
                            <textarea v-model="blog.image" class="form-control" id="add-blog-image" rows="3"
                                placeholder="image"></textarea>
                        </div>
                        <div class="mb-3">
                            <label for="add-blog-code" class="form-label">content</label>
                            <v-md-editor v-model="blog.content" width="400px" height="500px"></v-md-editor>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <div class="error-message">{{ blog.error_message }}</div>
                        <button type="button" class="btn btn-primary" @click="update_blog(blog)">创建</button>
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="blog-detail">
        <v-md-editor :model-value="blog.content" mode="preview" @copy-code-success="handleCopyCodeSuccess"></v-md-editor>
    </div>
</template>
  
<script>
import { ref, onMounted } from 'vue';
import { useRoute } from 'vue-router';
import { useStore } from 'vuex';
import $ from 'jquery';
import { Modal } from 'bootstrap/dist/js/bootstrap'
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

        const update_blog = (blog) => {
            console.log(blog.id);
            $.ajax({
                url: "http://101.33.207.160:3000/api/blog/update/",
                type: "POST",
                data: {
                    id: blog.id,
                    title: blog.title,
                    brief: blog.brief,
                    content: blog.content,
                    image: blog.image,
                },
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                success(resp) {
                    if (resp.error_message === "success") {
                        console.log(blog.id);
                        Modal.getInstance("#add-blog-btn").hide();

                    } else {
                        console.log(resp);
                        console.log(blog.id);
                    }
                }
            })
        }

        onMounted(() => {
            getBlogDetail();
        });
        return {
            blog,
            update_blog,
        };
    },
};
</script>

<style scoped>
.row {
    /* max-width: 1200px; */
    width: 100%;
    margin: 0 auto;
    overflow-x: hidden;
}



.blog-detail {
    width: auto;
    height: auto;
    margin: 30px;
    display: flex;
    background-image: linear-gradient(to top right, #f5f5f5, #ffe6e6);
    border-radius: 5px;
    padding: 50px 40px;
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

.el-button--transparent {
    background-color: transparent;
    border-color: transparent;
    color: #000;
}
</style>