<template>
<!-- <span>全部书籍信息</span> -->
<el-row :gutter="10">
  <el-col :span="6"></el-col>
</el-row>
  <el-row>
     <el-col :span="1"></el-col>
    <el-col :span="3"><el-input
        v-model="input2"
        class="w-50 m-2"
        placeholder="输入图书ID"
        :prefix-icon="Search"
      /></el-col>
      <el-col :span="1"></el-col>
    <el-col :span="3"><el-button type="primary">搜索</el-button></el-col>
  </el-row>

  <el-table :data="tableData" style="width: 100%">
    <el-table-column fixed prop="bookName" label="bookName" width="150" />
    <el-table-column prop="bookWriter" label="bookWriter" width="120" />
    <el-table-column prop="bookKind" label="bookKind" width="120" />
    <el-table-column prop="bookDate" label="bookDate" width="120" />
    <el-table-column prop="allowOut" label="allowOut" width="120" />
    <el-table-column prop="bookComment" label="bookComment" width="600" />
    <el-table-column fixed="right" label="Operations" width="150">
      <template #default>
        <el-button type="text" size="small" @click="handleClick"
        style="color:rgb(103, 194, 58)"
          >查看</el-button
        >
        <el-button type="text" size="small">编辑</el-button>
        <el-button type="text" size="small" style="color:rgb(245, 108, 108)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
import { Calendar, Search } from '@element-plus/icons-vue'
const input1 = ref('')
const input2 = ref('')
const input3 = ref('')
const input4 = ref('')

const handleClick = () => {
  console.log('click')
}

const tableData = [
  {
    bookName: '平凡的世界',
    bookWriter: '路遥',
    bookKind: '文化',
    bookDate: '2000',
    allowOut:'right',
    bookComment: '《平凡的世界》是中国作家路遥创作的一部全景式地表现中国当代城乡社会生活的百万字长篇小说。全书共三部。1986年12月首次出版。该书以中国70年代中期到80年代中期十年间为背景，通过复杂的矛盾纠葛，以孙少安和孙少平两兄弟为中心，刻画了当时社会各阶层众多普通人的形象；劳动与爱情、挫折与追求、痛苦与欢乐、日常生活与巨大社会冲突纷繁地交织在一起，深刻地展示了普通人在大时代历史进程中所走过的艰难曲折的道路。',
    tag: 'Home',
  }
]
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