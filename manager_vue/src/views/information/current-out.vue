<template>

  <div class="center">
   <el-card class="box-card">
    <template #header>
      <div class="card-header">
        <span>借阅图书</span>
        <el-button class="button" type="text">确认</el-button>
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
    <el-form-item label="读者姓名" prop="name">
      <el-row>
    <el-col :span="12"><el-input v-model="ruleForm.name"></el-input></el-col>
  </el-row>
    </el-form-item>

  <el-form-item label="图书名称" prop="name">
      <el-row>
    <el-col :span="12"><el-input v-model="ruleForm.name"></el-input></el-col>
  </el-row>
    </el-form-item>
    
    
    <el-form-item label="借阅时间" required>
      <el-col :span="4">
        <el-form-item prop="date1">
          <el-date-picker
            v-model="ruleForm.date1"
            type="date"
            placeholder="Pick a date"
            style="width: 100%"
          ></el-date-picker>
        </el-form-item>
      </el-col>
      <el-col class="text-center" :span="1">
        <!-- <span class="text-gray-500">-</span> -->
      </el-col>
      <el-col :span="4">
        <el-form-item prop="date2">
          <el-time-picker
            v-model="ruleForm.date2"
            placeholder="Pick a time"
            style="width: 100%"
          ></el-time-picker>
        </el-form-item>
      </el-col>
    </el-form-item>
    
    <el-form-item label="注意"> <span style="color:#67C23A">借阅最长时间为两个月</span></el-form-item>

    <el-form-item label="网上借阅服务" prop="delivery">
      <el-switch v-model="ruleForm.delivery"></el-switch>
    </el-form-item>
    <el-form-item label="图书种类" prop="type">
      <el-checkbox-group v-model="ruleForm.type">
        <el-checkbox label="科技" name="type"></el-checkbox>
        <el-checkbox label="教育" name="type"></el-checkbox>
        <el-checkbox label="文化" name="type"></el-checkbox>
        <el-checkbox label="卫生" name="type"></el-checkbox>
        <el-checkbox label="体育" name="type"></el-checkbox>
      </el-checkbox-group>
    </el-form-item>
    <el-form-item label="类别" prop="resource">
      <el-radio-group v-model="ruleForm.resource">
        <el-radio label="普通书籍"></el-radio>
        <el-radio label="珍贵古籍"></el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item label="备注" >
      <el-input v-model="ruleForm.desc" type="textarea"></el-input>
    </el-form-item>
  </el-form>

  </el-card>

</div>

 
</template>

<script lang="ts" setup>
import { reactive, ref } from 'vue'
// More info see https://github.com/element-plus/element-plus/blob/dev/docs/examples/form/utils.ts
// import { resetForm, submitForm } from './utils'//自定义规则
import type { ElForm } from 'element-plus'

const formSize = ref('')

const ruleFormRef = ref<InstanceType<typeof ElForm>>()
const ruleForm = reactive({
  name: '',
  region: '',
  date1: '',
  date2: '',
  delivery: false,
  type: [],
  resource: '',
  desc: '',
})

const rules = reactive({
  name: [
    {
      required: true,
      message: 'Please input Activity name',
      trigger: 'blur',
    },
    {
      min: 3,
      max: 5,
      message: 'Length should be 3 to 5',
      trigger: 'blur',
    },
  ],
  region: [
    {
      required: true,
      message: 'Please select Activity zone',
      trigger: 'change',
    },
  ],
  date1: [
    {
      type: 'date',
      required: true,
      message: 'Please pick a date',
      trigger: 'change',
    },
  ],
  date2: [
    {
      type: 'date',
      required: true,
      message: 'Please pick a time',
      trigger: 'change',
    },
  ],
  type: [
    {
      type: 'array',
      required: true,
      message: 'Please select at least one activity type',
      trigger: 'change',
    },
  ],
  resource: [
    {
      required: true,
      message: 'Please select activity resource',
      trigger: 'change',
    },
  ],
  desc: [
    {
      required: true,
      message: 'Please input activity form',
      trigger: 'blur',
    },
  ],
})
</script>


<style>
.center{
  
  margin:25px 160px;
  
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
