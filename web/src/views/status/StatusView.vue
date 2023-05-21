<template>
    <table class="table table-striped table-hover" style="text-align: center;">
        <thead>
            <tr>
                <th> 任务 </th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="record in records" :key="record.record.id">
                <td>
                    <img :src="record.a_photo" alt="" class="record-user-photo">
                    &nbsp;
                    <span class="record-user-username">{{ record.a_username }}</span>
                </td>
                <td>
                    <img :src="record.b_photo" alt="" class="record-user-photo">
                    &nbsp;
                    <span class="record-user-username">{{ record.b_username }}</span>
                </td>
                <td>{{ record.result }}</td>
                <td>{{ record.record.createtime }}</td>
                <td>
                    <button @click="open_record_content(record.record.id)" type="button"
                        class="btn btn-secondary">查看录像</button>
                </td>
            </tr>
        </tbody>
    </table>
    <!-- <nav aria-label="...">
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
    </nav> -->
</template>

<script>
// import ContentField from '@/components/ContentField.vue'

export default {
    components: {
        // ContentField,
    }
}
</script>

<style scoped></style>