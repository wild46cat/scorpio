<template>
    <div>
        <el-button type="primary" @click="logout()">登出</el-button>
    </div>
</template>

<script>
    export default {
        name: "Main.vue",
        data() {
            return {}
        },
        methods: {
            logout() {
                localStorage.removeItem("loginUser");
                this.$message.success("成功登出");
                this.$router.replace({name: '/login'});
                //下面有302 shior内部有服务器端跳转
                this.$ajax({
                    method: 'post',
                    url: '/logout'
                }).then((response) => {
                    if (response.data == 0) {
                        this.$message.success("成功登出");
                    }
                }).catch((response) => {
                    window.console.log(response);
                    this.$message.error("系统错误");
                });
            },
        }
    }
</script>

<style scoped>

</style>