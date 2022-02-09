<template>
  <div class="center">
    <el-card class="box-card">
      <template #header>
        <div class="card-header">
          <span>借阅图书</span>
          <el-button class="button" type="text" @click="submit()"
            >确认</el-button
          >
        </div>
      </template>

      <el-form
        ref="ruleFormRef"
        :model="ruleForm"
        :rules="rules"
        label-width="120px"
        class="demo-ruleForm"
        :size="formSize"
      >
        <el-form-item label="读者姓名" prop="readerName">
          <el-row>
            <el-col :span="18"
              ><el-input v-model="ruleForm.readerName"></el-input
            ></el-col>
          </el-row>
        </el-form-item>

        <el-form-item label="图书名称" prop="bookName">
          <el-row>
            <el-col :span="18"
              ><el-input v-model="ruleForm.bookName"></el-input
            ></el-col>
          </el-row>
        </el-form-item>

        <el-form-item label="借阅时间">
          <el-row>
            <el-col :span="24"
              ><span>{{ time }}</span></el-col
            >
          </el-row>
        </el-form-item>

        <el-form-item label="借阅状态">
          <el-row>
            <el-col :span="24"><span>正在办理外借手续</span></el-col>
          </el-row>
        </el-form-item>

        <el-form-item label="备注">
          <el-input v-model="ruleForm.comment" type="textarea"></el-input>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script lang="ts" setup>
import { reactive, ref } from "vue";
// More info see https://github.com/element-plus/element-plus/blob/dev/docs/examples/form/utils.ts
// import { resetForm, submitForm } from './utils'//自定义规则
import type { ElForm } from "element-plus";
import { createInf } from "@/network/network";
import { news } from "@/utils/cartoon";
const formSize = ref("");

const timeFormat = () => {
  var date = new Date();
  var year = date.getFullYear();
  /* 在日期格式中，月份是从0开始的，因此要加0
   * 使用三元表达式在小于10的前面加0，以达到格式统一  如 09:11:05
   * */
  var month =
    date.getMonth() + 1 < 10
      ? "0" + (date.getMonth() + 1)
      : date.getMonth() + 1;
  var day = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
  var hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
  var minutes =
    date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
  var seconds =
    date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
  // 拼接
  return (
    year + "-" + month + "-" + day + " " + hours + ":" + minutes + ":" + seconds
  );
};
const time = ref(timeFormat());
const ruleFormRef = ref<InstanceType<typeof ElForm>>();
const ruleForm = reactive({
  bookName: "",
  readerName: "",
  comment: "",
});

const rules = reactive({
  readerName: [
    {
      required: true,
      message: "Please input reader name",
      trigger: "blur",
    },
    {
      min: 1,
      max: 10,
      message: "Length should be 1 to 10",
      trigger: "blur",
    },
  ],
  bookName: [
    {
      required: true,
      message: "Please input book name",
      trigger: "blur",
    },
    {
      min: 1,
      max: 10,
      message: "Length should be 1 to 10",
      trigger: "blur",
    },
  ],
  comment: [
    {
      required: false,
      message: "Please input comment",
      trigger: "blur",
    },
  ],
});
const submit = () => {
  createInf(ruleForm.readerName, ruleForm.bookName, ruleForm.comment).then(
    (res) => {
      console.log(res)
      if (res.code == 200) {
        news(res.msg, "success");
      } else {
        news(res.msg, "error");
      }
    }
  );
};
</script>


<style>
.center {
  margin: 25px 160px;
}
.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.text {
  font-size: 14px;
}

.item {
  margin-bottom: 18px;
}

.box-card {
  width: 960px;
}
</style>
