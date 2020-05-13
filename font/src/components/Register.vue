<template>
    <div class="register_container">
        <div class="register_box">

            <!--表单登录-->
            <el-form :model="registerForm" :rules="registerFormRules" ref="registerFromRef" label-width="80px" class="register_form">
                <!--用户名-->
                <el-form-item prop="username" label="账号">
                    <el-input v-model="registerForm.username" ></el-input>
                </el-form-item>

                <!--密码-->
                <el-form-item prop="password" label="密码">
                    <el-input v-model="registerForm.password" type="password"></el-input>
                </el-form-item>

                <!--确认密码-->
                <el-form-item prop="confirmPassword" label="确认密码">
                    <el-input v-model="registerForm.confirmPassword" type="password"></el-input>
                </el-form-item>

                <!--按钮-->
                <el-form-item class="btns">
                    <el-button type="info" @click="resetregisterForm">重置</el-button>
                    <el-button type="success" @click="register">注册</el-button>
                    <el-button type="warning" @click="login">去登陆</el-button>
                </el-form-item>

            </el-form>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Register",
        data () {
            return {
                registerForm: {
                    username: '',
                    password: '',
                    confirmPassword:''
                },
                // 表单验证规则
                registerFormRules: {
                    username: [
                        {
                            required: true,
                            message: '请输入账号',
                            trigger: 'blur'
                        },
                        {
                            min: 3,
                            max: 10,
                            message: '长度在 3 到 10 个字符',
                            trigger: 'blur'
                        }
                    ],
                    password: [
                        {
                            required: true,
                            message: '请输入密码',
                            trigger: 'blur'
                        },
                        {
                            min: 3,
                            max: 10,
                            message: '长度在 3 到 10 个字符',
                            trigger: 'blur'
                        }
                    ],
                    confirmPassword:[
                        {
                            required: true,
                            message: '请输入密码',
                            trigger: 'blur'
                        },
                        {
                            min: 3,
                            max: 10,
                            message: '长度在 3 到 10 个字符',
                            trigger: 'blur'
                        }
                    ]
                }
            }
        },
        methods: {
            // 重置表单
            resetregisterForm () {
                this.$refs.registerFromRef.resetFields()
            },
            // 登录
            register () {
                this.$refs.registerFromRef.validate(async valid => {
                    console.log(valid)

                    if (!valid) return

                    const { data: res } = await this.$http.post('/user/register', this.registerForm)
                    console.log(res)
                    console.log(res.success === false)

                    if (res.success === false) {
                        return this.$message.error(res.msg)
                    }else{
                        this.$message.success("注册成功")
                        // token 存入到session中
                        window.sessionStorage.setItem("token",res.data)
                        // 清空数据
                        this.resetregisterForm()
                    }
                })
            },
            // 跳转登录页面
            login(){
                this.$router.push("/")
            }
        }
    }
</script>

<style scoped>


    .register_container {
        background-color: #2b4b6b;
        height: 100%;
    }

    .register_box{
        width: 450px;
        height: 360px;
        background-color: #fff;
        border-radius: 10px;
        position: absolute;
        left: 50%;
        top: 50%;
        -webkit-transform: translate(-50%, -50%);
        background-color: #fff;
    }

    .register_form {
        position: absolute;
        bottom: 60px;
        width: 100%;
        padding: 0 20px;
        box-sizing: border-box;
    }
</style>
