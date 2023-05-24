<template>
    <table class="table table-striped table-hover" style="text-align: center;">
        <thead>
            <tr>
                <th> 任务 </th>
                <th>创建时间</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="record in records" :key="record.record.id">
                <td>{{ record.record.content }}</td>
                <td>{{ record.record.createtime }}</td>
                <td>
                    <!-- <button type="button" class="btn btn-secondary" @clink="finish_records(record)">Accept</button> -->
                    <el-button @click="finish_records(record)" type="button" class="btn btn-secondary">Accept</el-button>
                    <el-button @click="add_records" type="button" class="btn btn-secondary">Submit</el-button>
                </td>
            </tr>
        </tbody>
    </table>
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
export default {
    components: {
    },
    setup() {
        const store = useStore();
        let records = ref([]);
        let current_page = 1;
        let total_records = 0;
        console.log(total_records);

        const recordadd = reactive({
            content: "",
            error_message: "",
        });

        const pull_page = page => {
            current_page = page;
            $.ajax({
                url: "http://101.33.207.160:3000/api/record/getlist/",
                data: {
                    page,
                },
                type: "get",
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                success(resp) {
                    records.value = resp.records;
                    total_records = resp.records_count;
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
            let max_pages = parseInt(Math.ceil(total_records / 10));

            if (page >= 1 && page <= max_pages) {
                pull_page(page);
            }
        }

        const add_records = () => {
            recordadd.error_message = "";
            $.ajax({
                url: "http://101.33.207.160:3000/api/record/add/",
                type: "POST",
                data: {
                    content: recordadd.content,
                },
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                success(resp) {
                    if (resp.error_message === "success") {
                        recordadd.content = "",
                            pull_page(current_page);
                    }
                    else recordadd.error_message = resp.error_message;
                }
            })
        }


        const finish_records = (record) => {
            console.log(233);
            $.ajax({
                url: "http://101.33.207.160:3000/api/record/finish/",
                type: "post",
                data: {
                    record_id: record.record.id,
                },
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                success(resp) {
                    console.log(resp);
                    if (resp.error_message === "success") {
                        pull_page(current_page);
                    }
                }
            })
        }
        const open = () => {
            ElMessageBox.prompt('Please input your task', 'Task', {
                confirmButtonText: 'OK',
                cancelButtonText: 'Cancel',
                inputValidator: (value) => {
                    if (value && value.length <= 100) {
                        return true;
                    } else {
                        return 'The task should be less than 100 characters';
                    }
                },
            })
                .then(({ value }) => {
                    // 调用 add_records 函数
                    recordadd.content = value;
                    add_records();
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
        return {
            records,
            finish_records,
            add_records,
            open,
            click_page,
        }
    }
}
</script>

<style scoped></style>