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
        placeholder="输入图书ID"
        :prefix-icon="Search"
    /></el-col>
    <el-col :span="1"></el-col>
    <el-col :span="3"><el-button type="primary">搜索</el-button></el-col>
  </el-row>

  <el-table :data="state.tableData" stripe style="width: 100%">
    <el-table-column prop="name" label="名称" width="150" />
    <el-table-column prop="writer" label="作者" width="220" />
    <el-table-column prop="createTime" sortable label="入馆时间" width="120" />
    <el-table-column prop="kind" label="种类" width="110" />
    <el-table-column prop="allow" label="权限" width="60" />
    <el-table-column prop="comment" label="简评" width="300" />
    <el-table-column prop="curNum" sortable label="现存" width="80" />
    <el-table-column prop="sumNum" sortable label="总数" width="100" />
    <el-table-column fixed="right" label="Operations" width="150">
      <template #default>
        <el-button
          type="text"
          size="small"
          @click="handleClick"
          style="color: rgb(103, 194, 58)"
          >查看</el-button
        >
        <el-button type="text" size="small">编辑</el-button>
        <el-button type="text" size="small" style="color: rgb(245, 108, 108)"
          >删除</el-button
        >
      </template>
    </el-table-column>
  </el-table>
  <el-pagination background layout="prev, pager, next" :total="1000">
  </el-pagination>
</template>

<script lang="ts" setup>
import { onMounted, reactive, ref, onBeforeMount } from "vue";
import { Calendar, Search } from "@element-plus/icons-vue";
import { listAllBook } from "@/network/network";
const input1 = ref("");
const input2 = ref("");
const input3 = ref("");
const input4 = ref("");
const state = reactive({
  tableData: [],
});
// const tableData=reactive([])

// console.log("hello")
listAllBook(1, 10).then((res) => {
  console.log(res.data);
  state.tableData = res.data;
  console.log("___________");
  console.log(state.tableData);
});

const handleClick = () => {
  console.log("click");
};
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