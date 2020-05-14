<template>
  <div class="login_container">
    <div class="login_box">

      <!--表单登录-->
      <el-form :model="loginForm" :rules="loginFormRules" ref="loginFromRef" label-width="60px" class="login_form">
        <!--用户名-->
        <el-form-item prop="username" label="账号">
          <el-input v-model="loginForm.username" ></el-input>
        </el-form-item>

        <!--密码-->
        <el-form-item prop="password" label="密码">
          <el-input v-model="loginForm.password" type="password"></el-input>
        </el-form-item>

        <!--按钮-->
        <el-form-item class="btns">
          <el-button type="success" @click="login">登录</el-button>
          <el-button type="info" @click="resetLoginForm">重置</el-button>
          <el-button type="warning" @click="register">去注册</el-button>
        </el-form-item>

      </el-form>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'Login',
    data () {
      return {
        loginForm: {
          username: '',
          password: ''
        },
        // 表单验证规则
        loginFormRules: {
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
          ]
        }
      }
    },
    methods: {
      // 重置表单
      resetLoginForm () {
        this.$refs.loginFromRef.resetFields()
      },
      // 登录
      login () {
        this.$refs.loginFromRef.validate(async valid => {
          console.log(valid)

          if (!valid) return

          const { data: res } = await this.$http.post('/user/login', this.loginForm)

          if (res.success === false) {
            return this.$message.error(res.msg)
          }else{
            this.$message.success("登录成功")
            // token 存入到session中
            window.sessionStorage.setItem("token",res.data)
            // 跳转页面
            this.$router.push("/home")
          }
        })
      },
      // 注册
      register(){
        this.$router.push("/register")
      }
    }

  }
</script>

<style lang="less" scoped>


  .login_container {
    background-color: #2b4b6b;
    height: 100%;
  }

  .login_box{
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

  .login_form {
    position: absolute;
    bottom: 60px;
    width: 100%;
    padding: 0 20px;
    box-sizing: border-box;
  }


</style>
