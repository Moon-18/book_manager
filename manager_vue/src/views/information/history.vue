<template>
  <br />
  <el-button @click="resetDateFilter">清除时间条件</el-button>
  <el-button @click="clearFilter">清除全部条件</el-button>

  <el-table
    ref="tableRef"
    row-key="inDate"
    :data="state.tableData"
    style="width: 100%"
  >
    <el-table-column
      prop="outDate"
      label="借出时间"
      sortable
      width="180"
      column-key="outDate"
      :filters="state.timeSort"
      :filter-method="filterHandler"
    />
    <el-table-column prop="inDate" label="归还时间" width="180" />
    <el-table-column prop="bookName" label="图书名" width="180" />
    <el-table-column prop="readerName" label="读者名" width="180" />

    <el-table-column
      prop="state"
      label="状态"
      width="100"
      :filters="[
        { text: '借出', value: '借出' },
        { text: '归还', value: '归还' },
        { text: '异常', value: '异常' },
      ]"
      :filter-method="filterState"
      filter-placement="bottom-end"
    >
    <!-- :type="scope.row.state === '借出' ? 'info' : 'success'" -->
    <!-- :type=" color(scope.row.state)" -->
      <template #default="scope">
        <el-tag
          :type="scope.row.state === '借出' ? 'success' : ''"

          disable-transitions
          >{{ scope.row.state }}</el-tag
        >
      </template>
    </el-table-column>
    <el-table-column prop="message" label="备注信息" width="300" />
  </el-table>
</template>

<script lang="ts" setup>
import { ref, reactive, computed } from "vue";
import type { TableColumnCtx } from "element-plus/es/components/table/src/table-column/defaults";
import type { ElTable } from "element-plus";
import { listAllInf } from "@/network/network";

interface Inf {
  inDate: string;
  outDate: string;
  bookName: string;
  readerName: string;
  state: string;
  message: string;
}

const tableRef = ref<InstanceType<typeof ElTable>>();

//标签颜色处理
const color=(value)=>{
  if(value=='借出'){
    return 'success'
  }else if(value=='归还'){
    return 'info'
  }else{
    return 'err'
  }
}
const resetDateFilter = () => {
  tableRef.value!.clearFilter(["outDate"]);
};
// TODO: improvement typing when refactor table
const clearFilter = () => {
  // eslint-disable-next-line @typescript-eslint/ban-ts-comment
  // @ts-expect-error
  tableRef.value!.clearFilter();
};
const filterState = (value: string, row: Inf) => {
  return row.state === value;
};
const filterHandler = (
  value: string,
  row: Inf,
  column: TableColumnCtx<Inf>
) => {
  const property = column["property"];
  return row[property] === value;
};
const state = reactive({
  //响应式数据,表单信息
  tableData: [],
  timeSort: [],
});
//对象数组的去重方式
const unique=(arr)=> {
 const res = new Map();
 return arr.filter((arr) => !res.has(arr.inDate) && res.set(arr.inDate, 1))
}
//网络请求
listAllInf(1, 10).then((res) => {
  state.tableData = res.data;
  //时间列的筛选条件,建立一个新的数组,对数组赋值
  state.tableData.forEach((item) => {
    console.log(item.inDate);
    state.timeSort.push({ text: item.inDate, value: item.inDate });
  });
  //去重
  state.timeSort = unique(state.timeSort)
  console.log(state.timeSort);
});
</script>
