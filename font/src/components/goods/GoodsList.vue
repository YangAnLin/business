<template>
    <div>
        <!--面包屑导航区-->
        <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>商品管理</el-breadcrumb-item>
            <el-breadcrumb-item>商品列表</el-breadcrumb-item>
        </el-breadcrumb>

        <!-- 卡片视图 -->
        <el-card>
            <el-row :gutter="20">
                <el-col :span="8">
                    <el-input placeholder="请输入内容" v-model="queryInfo.search.goodsName" clearable @clear="getGoodsList">
                        <el-button slot="append" icon="el-icon-search" @click="getGoodsList"></el-button>
                    </el-input>
                </el-col>
                <el-col :span="4">
                    <el-button type="primary" @click="goAddpage">添加商品</el-button>
                </el-col>
            </el-row>

            <el-table :data="goodsList" border stripe>
                <el-table-column type="index"></el-table-column>
                <el-table-column label="商品名称" prop="goodsName"></el-table-column>
                <el-table-column label="商品价格(元)" prop="goodsPrice" width="100px"></el-table-column>
                <el-table-column label="商品重量" prop="goodsWeight" width="70px"></el-table-column>
                <el-table-column label="商品数量" prop="goodsNumber" width="70px"></el-table-column>
                <el-table-column label="创建时间" prop="addTime" width="170px">
                    <template slot-scope="scope">{{scope.row.addTime | dataFormat }}</template>
                </el-table-column>
                <el-table-column label="操作" width="130px">
                    <template slot-scope="scope">
                        <el-button type="primary" icon="el-icon-edit" size="mini"></el-button>
                        <el-button
                                type="danger"
                                icon="el-icon-delete"
                                size="mini"
                                @click="removeById(scope.row.id)"
                        ></el-button>
                    </template>
                </el-table-column>
            </el-table>

            <!-- 分页区域 -->
            <el-pagination
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="queryInfo.current"
                    :page-sizes="[5, 10, 15, 20]"
                    :page-size="queryInfo.size"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="total"
            ></el-pagination>
        </el-card>
    </div>
</template>

<script>
  export default {
    name: 'GoodsList',
      data () {
          return {
              queryInfo:{
                  query: '',
                  current: 1,
                  size: 10,
                  search:{
                      goodsName:""
                  }
              },
              goodsList:[],
              total:0
          }
      },
      created () {
          this.getGoodsList()
      },
      methods: {
          // 获取分页
          async getGoodsList(){
              const {data:res} = await this.$http.post("/goods/list",this.queryInfo)

              if (res.success === false) {
                  return this.$message.error(res.msg)
              }else{
                  this.goodsList = res.data.records
                  this.total = res.data.total
              }
          },
          handleSizeChange (newSize) {
              this.queryInfo.size = newSize
              this.getGoodsList()
          },
          handleCurrentChange (newSize) {
              this.queryInfo.current = newSize
              this.getGoodsList()
          },
          async removeById(id){
              const confirmResult = await this.$confirm(
                  '此操作将永久删除该商品, 是否继续?',
                  '提示',
                  {
                      confirmButtonText: '确定',
                      cancelButtonText: '取消',
                      type: 'warning'
                  }
              ).catch(err => err)
              if (confirmResult !== 'confirm') {
                  return this.$message.info('已取消删除！')
              }
              const { data: res } = await this.$http.delete('goods/' + id)
              if (res.meta.status !== 200) {
                  return this.$message.error('删除商品失败！')
              }
              this.$message.success('删除商品成功！')
              this.getGoodsList()
          },
          goAddpage(){
              this.$router.push('/goods/add')
          }
      },
      computed: {}
  }
</script>

<style scoped>

</style>
