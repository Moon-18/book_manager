<template>
  <el-row :gutter="10">
    <el-col :span="6"></el-col>
  </el-row>
  <el-row>
    <el-col :span="1"></el-col>
    <el-col :span="3"
      ><el-input
        v-model="input2"
        class="w-50 m-2"
        placeholder="输入读者ID"
        :prefix-icon="Search"
    /></el-col>
    <el-col :span="1"></el-col>
    <el-col :span="3"><el-button type="primary">搜索</el-button></el-col>
  </el-row>

  <el-table :data="state.users" style="width: 100%">
    <el-table-column fixed prop="id" label="ID" width="180" />
    <el-table-column fixed prop="name" label="姓名" width="150" />
    <el-table-column prop="account" label="账号" width="240" />
    <el-table-column prop="type" label="类型" width="120" />
    <el-table-column prop="password" label="密码" width="120" />
    <!-- <el-table-column prop="history" label="已借阅(本)" width="120" />
    <el-table-column prop="current" label="正借阅(本)" width="120" /> -->
    <el-table-column fixed="right" label="Operations" width="300">
      <template #default>
        <el-button
          type="text"
          size="small"
          @click="handleClick"
          style="color: rgb(103, 194, 58)"
          >查看借阅信息</el-button
        >
        <el-button type="text" size="small">编辑</el-button>
        <el-button type="text" size="small" style="color: rgb(245, 108, 108)"
          >删除</el-button
        >
      </template>
    </el-table-column>
  </el-table>
</template>

<script lang="ts" setup>
import { reactive, ref } from "vue";
import { Calendar, Search } from "@element-plus/icons-vue";
import {listAllUser} from "@/network/network"
const state=reactive({
  users:[]
})
listAllUser(1, 10).then((res) => {
  console.log(res.data);
  state.users = res.data;
  console.log("___________");
  console.log(state.users);
});



</script>

<style>
.el-row {
  margin-bottom: 20px;
}
.el-row:last-child {
  margin-bottom: 0;
}
.el-col {
  border-radius: 4px;
}
.bg-purple-dark {
  background: #99a9bf;
}
.bg-purple {
  background: #d3dce6;
}
.bg-purple-light {
  background: #e5e9f2;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}
</style>