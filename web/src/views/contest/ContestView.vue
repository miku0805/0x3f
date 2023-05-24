<template>
    <div>
        <el-table :data="blogs" style="width: 100%" router>
            <el-table-column prop="blog.content" label="文章"></el-table-column>
            <el-table-column prop="blog.createtime" label="创建时间"></el-table-column>
            <el-table-column label="操作">
                <template #default="{ row }">
                    <el-button type="primary" @click="handleClick(row)">查看详情</el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>
    <nav aria-label="...">
        <ul class="pagination" style="float: right;">
            <li class="page-item" @click="click_page(-2)">
                <a class="page-link" href="#">前一页</a>
            </li>
            <li :class="'page-item ' + page.is_active" v-for="page in pages" :key="page.number"
                @click="click_page(page.number)">
                <a class="page-link" href="#">{{ page.number }}</a>
            </li>
            <li class="page-item" @click="click_page(-1)">
                <a class="page-link" href="#">后一页</a>
            </li>
        </ul>
    </nav>

    <el-button text @click="open" type="success">Add</el-button>
</template>

<script >
import { useStore } from 'vuex';
import $ from "jquery";
import { reactive, ref } from 'vue';
import { ElMessage, ElMessageBox } from 'element-plus'
import { useRouter } from 'vue-router'
export default {
    components: {
    },
    setup() {
        const router = useRouter()
        const store = useStore();
        let blogs = ref([]);
        let current_page = 1;
        let total_blogs = 0;
        console.log(total_blogs);

        const blogadd = reactive({
            content: "",
            error_message: "",
            brief: "",
        });

        const pull_page = page => {
            current_page = page;
            $.ajax({
                url: "http://127.0.0.1:3000/api/blog/getlist/",
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
                url: "http://127.0.0.1:3000/api/blog/add/",
                type: "POST",
                data: {
                    content: blogadd.content,
                    brief: blogadd.brief,
                },
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                success(resp) {
                    if (resp.error_message === "success") {
                        blogadd.content = "",
                            pull_page(current_page);
                    }
                    else blogadd.error_message = resp.error_message;
                }
            })
        }


        const open = () => {
            ElMessageBox.prompt('Please input your task', 'Task', {
                confirmButtonText: 'OK',
                cancelButtonText: 'Cancel',
                inputValidator: (value) => {
                    // if (value && value.length <= 100) {
                    if (value) {
                        return true;
                    } else {
                        return 'The task should be less than 100 characters';
                    }
                },
            })
                .then(({ value }) => {
                    // 调用 add_records 函数
                    blogadd.content = value;
                    add_blog();
                    ElMessage({
                        type: 'success',
                        message: `Your task is: ${value}`,
                    });
                })
                .catch(() => {
                    ElMessage({
                        type: 'info',
                        message: 'Input canceled',
                    });
                });
        };

        const handleClick = row => {
            router.push({ name: 'blogdetail', params: { id: row.blog.id } })
        }

        return {
            blogs,
            add_blog,
            open,
            click_page,
            handleClick,
        }
    }
}
</script>

<style scoped></style>