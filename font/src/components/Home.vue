<template>
  <!--    Home组件-->
  <el-container class="home-container">
    <!-- 头部 -->
    <el-header>
      <div>
        <span>电商后台管理系统</span>
      </div>
      <el-button type="info" @click="logout">退出</el-button>
    </el-header>

    <!-- 页面主题 -->
    <el-container>
      <!-- 侧边栏-->
      <el-aside :width="isCollapse? '64px' : '200px'">

        <div class="toggle-button" @click="toggleCollapse">|||</div>

        <el-menu background-color="#333744" text-color="#fff" active-text-color="#409BFF"
                 :unique-opened="true" :collapse="isCollapse" :collapse-transition="false"
                 :router="true"
                 default-active="activePath">
          <!-- 高亮,貌似element已经弄好了-->
          <!-- default-active="activePath">-->
          <!-- 一级菜单-->
          <el-submenu :index="item.id +''" v-for="item in menuList" :key="item.id">

            <template slot="title">
              <i :class="iconsList[item.id]"></i>
              <span>{{item.menuName}}</span>
            </template>

            <!-- 二级菜单 -->
            <el-menu-item :index="'/'+subItem.menuUrl +''" v-for="subItem in item.children" :key="subItem.id" >
              <!--  @click="saveNavState('/'+subItem.path+'')">-->
              <template slot="title">
                <i class="el-icon-menu"></i>
                <span>{{subItem.menuName}}</span>
              </template>
            </el-menu-item>

          </el-submenu>
        </el-menu>
      </el-aside>
      <!-- 右侧内容主题-->
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>

</template>

<script>
  export default {
    data(){
      return{
        menuList:[],
        iconsList:{
          '125': 'iconfont icon-user',
          '103': 'iconfont icon-tijikongjian',
          '101': 'iconfont icon-shangpin',
          '102': 'iconfont icon-danju',
          '145': 'iconfont icon-baobiao'
        },
        isCollapse :false,
        // activePath:''
      }
    },
    name: 'Home',
    created () {
      this.getMenuList()
      // this.activePath =  window.sessionStorage.getItem("activePath")
    },
    methods: {
      logout () {
        window.sessionStorage.clear()
        this.$router.push('/')
        return this.$message.error("退出成功")
      },
      async getMenuList (){
        const { data: res } = await this.$http.get('/menu/list')
        console.log(res)
        if (res.success === false) {
          return this.$message.error(res.msg)
        }else{
          this.menuList = res.data
        }
      },
      // 点击按钮,切换菜单展开
      toggleCollapse(){
        this.isCollapse = !this.isCollapse
      },
      // 保存连接的激活状态
      // saveNavState(activePath){
      //   window.sessionStorage.setItem("activePath",activePath)
      // }
    }
  }
</script>

<style lang="less" scoped>

  .home-container {
    height: 100%;
  }

  .el-header {
    background-color: #373d41;
    display: flex;
    justify-content: space-between;
    padding-left: 0;
    align-items: center;
    color: #ffffff;
    font-size: 20px;

    > div {
      display: flex;
      align-items: center;

      span {
        margin-left: 15px;
      }
    }
  }

  .el-aside {
    background-color: #333744;
    .el-menu{
      border-right: none;
    }
  }

  .el-main {
    background-color: #eaedf1;
  }

  .iconfont {
    margin-right: 10px;
  }

  .toggle-button {
    background-color: #4A5064;
    font-size: 10px;
    line-height: 24px;
    color: #ffffff;
    text-align: center;
    letter-spacing: 0.2em;
    cursor: pointer;
  }

</style>
