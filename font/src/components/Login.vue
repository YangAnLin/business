<template>
  <div class="login_container">
    <div class="login_box">

      <!--表单登录-->
      <!-- TODO label-width  这个是什么意思-->
      <el-form :model="loginForm" :rules="loginFormRules" ref="loginFromRef" label-width="80px" class="login_form">
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
          <el-button type="primary" @click="login">登录</el-button>
          <el-button type="info" @click="resetLoginForm">重置</el-button>
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
          username: 'admin',
          password: '123456'
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
      // 重置
      resetLoginForm () {
        this.$refs.loginFromRef.resetFields()
      },
      login () {
        // this.$refs.loginFromRef.validate(async valid => {
        //   console.log(valid)
        //
        //   if (!valid) return
        //
        //   const { data: res } = await this.$http.post('login', this.loginForm)
        //   console.log(res)
        //
        //   if (res.meta.status != 200) {
        //     return this.$message.error(res.meta.msg)
        //   }
        //   this.$message.success(res.meta.msg)
        //
        //   // token 存入到session中
        //   window.sessionStorage.setItem("token",res.data.token)
        //
        //   // 跳转页面
        //   this.$router.push("/home")
        //
        // })
          // 跳转页面
          this.$router.push("/home")
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
    border-radius: 3px;
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
