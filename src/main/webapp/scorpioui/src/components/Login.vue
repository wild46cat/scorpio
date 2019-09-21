<template>
    <div>
        <el-row type="flex" justify="center">
            <h1>Scorpio Login</h1>
        </el-row>
        <el-row type="flex" justify="center">
            <el-col :span="8">
                <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px"
                         justify="center">
                    <el-form-item label="用户名" prop="loginName">
                        <el-input type="text" v-model="ruleForm.loginName" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="密码" prop="pass">
                        <el-input type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="login('ruleForm')">登录</el-button>
                    </el-form-item>
                </el-form>
            </el-col>
        </el-row>
    </div>
</template>

<script>
    export default {
        name: "Login",
        data() {
            let validateLoginName = (rule, value, callback) => {
                if (value == "") {
                    callback(new Error('请输入用户名'));
                } else {
                    callback();
                }
            };
            let validatePass = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请输入密码'));
                } else {
                    callback();
                }
            };
            return {
                ruleForm: {
                    loginName: '',
                    pass: '',
                },
                rules: {
                    loginName: [
                        {validator: validateLoginName, trigger: 'blur'}
                    ],
                    pass: [
                        {validator: validatePass, trigger: 'blur'}
                    ],
                }
            };
        },
        methods: {
            login(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        this.$ajax({
                            method: 'post',
                            url: '/login',
                            data: {
                                userName: this.ruleForm.loginName,
                                password: this.ruleForm.pass,
                            }
                        }).then((response) => {
                            window.console.log(response);
                            if (response.data == 0) {
                                this.$message.success("登录成功");
                                localStorage.setItem("loginUser", this.ruleForm.loginName);
                                this.$router.replace({name: 'main'})
                            } else {
                                localStorage.removeItem("loginUser");
                                this.$message.error("用户名密码错误");
                            }
                        }).catch((error) => {
                            this.$message.error("系统错误");
                            window.console.log(error);
                        });
                    }
                });
            },
            // resetForm(formName) {
            //     this.$refs[formName].resetFields();
            // }
        }
    }
</script>

<style scoped>
</style>