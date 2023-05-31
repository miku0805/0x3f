<template>
    <div class="row">
        <el-button type="button" class="float-end el-button--transparent" data-bs-toggle="modal"
            data-bs-target="#add-blog-btn">
            创建blog
        </el-button>

        <div class="modal fade" id="add-blog-btn" tabindex="-1">
            <div class="modal-dialog modal-xl">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">创建blog</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="mb-3">
                            <label for="add-blog-title" class="form-label">title</label>
                            <input v-model="blogadd.title" type="text" class="form-control" id="add-blog-title"
                                placeholder="title">
                        </div>
                        <div class="mb-3">
                            <label for="add-blog-brief" class="form-label">brief</label>
                            <textarea v-model="blogadd.brief" class="form-control" id="add-blog-brief" rows="3"
                                placeholder="brief"></textarea>
                        </div>
                        <div class="mb-3">
                            <label for="add-blog-image" class="form-label">image</label>
                            <textarea v-model="blogadd.image" class="form-control" id="add-blog-image" rows="3"
                                placeholder="image"></textarea>
                        </div>
                        <div class="mb-3">
                            <label for="add-blog-code" class="form-label">content</label>
                            <v-md-editor v-model="blogadd.content" width="400px" height="500px"></v-md-editor>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <div class="error-message">{{ blogadd.error_message }}</div>
                        <button type="button" class="btn btn-primary" @click="add_blog">创建</button>
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <el-container class="blog-container" style="display: inline-block;">
        <el-card v-for="blog in blogs" :key="blog.id" class="blog-item" @click="handleClick(blog)">
            <div class="blog-content">
                <div class="blog-image" v-if="blog.image">
                    <img v-bind:src="blog.image.trim()" alt="BlogImage">
                </div>
                <div class="blog-info">
                    <h3>{{ blog.title }}</h3>
                    <p>{{ blog.brief }}</p>
                </div>
            </div>
        </el-card>
    </el-container>
    <nav aria-label="...">
        <ul class="pagination" style="float: right;">
            <li class="page-item" @click="click_page(-2)">
                <a class="page-link" href="#">前一页</a>
            </li>
            <li :class="'page-item ' + page.is_active" v-for="     page      in      pages     " :key="page.number"
                @click="click_page(page.number)">
                <a class="page-link" href="#">{{ page.number }}</a>
            </li>
            <li class="page-item" @click="click_page(-1)">
                <a class="page-link" href="#">后一页</a>
            </li>
        </ul>
    </nav>
</template>

<script>
import { useStore } from 'vuex';
import $ from "jquery";
import { reactive, ref } from 'vue';
import { useRouter } from 'vue-router'
import { Modal } from 'bootstrap/dist/js/bootstrap'
export default {
    components: {},
    setup() {
        const router = useRouter()
        const store = useStore();
        let blogs = ref([]);
        let current_page = 1;
        let total_blogs = 0;

        const blogadd = reactive({
            content: "",
            error_message: "",
            title: "",
            brief: "",
            image: "",
        });

        const pull_page = page => {
            current_page = page;
            $.ajax({
                url: "http://101.33.207.160:3000/api/blog/getlist/",
                data: {
                    page,
                },
                type: "get",
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                success(resp) {
                    blogs.value = resp.blogs;
                    total_blogs = resp.blogs_count;
                },
                error(resp) {
                    console.log(resp);
                }
            })
        }
        pull_page(current_page);

        const click_page = page => {
            if (page === -2) page = current_page - 1;
            else if (page === -1) page = current_page + 1;
            let max_pages = parseInt(Math.ceil(total_blogs / 10));

            if (page >= 1 && page <= max_pages) {
                pull_page(page);
            }
        }

        const add_blog = () => {
            blogadd.error_message = "";
            $.ajax({
                url: "http://101.33.207.160:3000/api/blog/add/",
                type: "POST",
                data: {
                    content: blogadd.content,
                    title: blogadd.title,
                    brief: blogadd.brief,
                    image: blogadd.image,
                },
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                success(resp) {
                    if (resp.error_message === "success") {
                        blogadd.content = "",
                            blogadd.brief = "",
                            blogadd.content = "",
                            Modal.getInstance("#add-blog-btn").hide(),
                            pull_page(current_page);
                    }
                    else blogadd.error_message = resp.error_message;
                }
            })
        }

        const handleClick = row => {
            router.push({ name: 'blogdetail', params: { id: row.blog.id } })
        }
        return {
            blogs,
            blogadd,
            add_blog,
            click_page,
            handleClick,
        }
    }
}
</script>

<style scoped>
.row {
    max-width: 1200px;
    margin: 0 auto;
    overflow-x: hidden;
}



.blog-image {
    flex: 0 0 200px;
    margin-right: 20px;
}

.blog-image img {
    width: 100%;
    height: auto;
    transition: transform 0.3s ease-out;
    /* 添加过渡效果 */
}

.blog-item:hover .blog-image img {
    transform: scale(1.1);
    /* 添加鼠标悬停时的动画效果 */
}

.blog-info {
    flex: 1;
}

.blog-info h3 {
    margin-top: 1;
}


.blog-content {
    display: flex;
    flex-direction: row;
    align-items: center;
}

.blog-item {
    background-color: transparent;
}

.blog-item:hover {
    background-image: linear-gradient(to top right, #f5f5f5, #ffe6e6);
    box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
}

.blog-image {
    margin-right: 10px;
}

.el-button--transparent {
    background-color: transparent;
    border-color: transparent;
    color: #000;
}
</style>