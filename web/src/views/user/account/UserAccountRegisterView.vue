<template>
    <div class="row justify-content-md-center">
        <div class="col-3">
            <form @submit.prevent="register">
                <div class="mb-3">
                    <label for="username" class="form-label">用户名</label>
                    <input v-model="username" type="text" class="form-control" id="username" placeholder="请输入用户名">
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">密码</label>
                    <input v-model="password" type="password" class="form-control" id="password" placeholder="请输入密码">
                </div>
                <div class="mb-3">
                    <label for="confirmedPassword" class="form-label">确认密码</label>
                    <input v-model="confirmedPassword" type="password" class="form-control" id="confirmedPassword"
                        placeholder="请再次输入密码">
                </div>
                <div class="error_message">{{ error_message }}</div>
                <button type="submit" class="btn btn-info">提交</button>
            </form>
        </div>
    </div>
</template>

<script>
import { ref } from 'vue'
import router from '../../../router/index'
import $ from 'jquery'

export default {
    components: {

    },
    setup() {
        let username = ref('');
        let password = ref('');
        let confirmedPassword = ref('');
        let error_message = ref('');

        const register = () => {
            $.ajax({
                url: "http://101.33.207.160:3000/api/user/account/register/",
                type: "post",
                data: {
                    username: username.value,
                    password: password.value,
                    confirmedPassword: confirmedPassword.value,
                },
                success(resp) {
                    if (resp.error_message === "success") {
                        router.push({ name: "login_index" });
                    } else {
                        error_message.value = resp.error_message;
                        console.log(error_message.value);
                    }
                },
            });
        }

        return {
            username,
            password,
            confirmedPassword,
            error_message,
            register,
        }
    }

}
</script>

<style scoped>
button {
    width: 100%;
}

div.error_messge {
    color: aquamarine;
}
</style>