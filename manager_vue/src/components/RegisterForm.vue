<template>
  <el-form
    ref="registerForm"
    :model="registerUser"
    :rules="registerRules"
    label-width="100px"
    class="registerForm sign-up-form"
  >
    <el-form-item label="用户名" prop="name">
      <el-input
        v-model="registerUser.name"
        placeholder="Enter UserName..."
      ></el-input>
    </el-form-item>
    <el-form-item label="账号" prop="account">
      <el-input
        v-model="registerUser.account"
        placeholder="Enter Email..."
      ></el-input>
    </el-form-item>
    <el-form-item label="密码" prop="password">
      <el-input
        v-model="registerUser.password"
        type="password"
        placeholder="Enter Password..."
      ></el-input>
    </el-form-item>
    <el-form-item label="确认密码" prop="password2">
      <el-input
        v-model="registerUser.password2"
        type="password"
        placeholder="Enter Password..."
      ></el-input>
    </el-form-item>

<el-form-item label="类型" prop="Type">
      <el-radio-group v-model="registerUser.Type">
        <el-radio label="user">用户</el-radio>
        <el-radio label="admin">管理员</el-radio>
        <!-- 1911834200@qq.com -->
      </el-radio-group>
    </el-form-item>

 <!-- <el-form-item label="验证码" prop="code">
      <el-row>
    <el-col :span="12">
      <el-input
        v-model="registerUser.code"
        type="code"
        placeholder="Enter code"
      ></el-input>
    </el-col>
    <el-col :span="12">
      <span style="background-color:white;width:100px;color:white">-----</span>
      <el-image :src="url"></el-image>
      </el-col>   
    </el-row>
    </el-form-item> -->

    <el-form-item>
      <el-button
        @click="handleRegister('registerForm')"
        type="primary"
        class="submit-btn"
        >注册</el-button
      >
    </el-form-item>
  </el-form>
</template>

<script lang="ts">
import { ref, getCurrentInstance } from "vue";
// import axios from 'axios' // 仅限在当前组件使用
export default {
  props: {
    registerUser: {
      type: Object,
      required: true,
    },
    registerRules: {
      type: Object,
      required: true,
    },
  },
  setup(props:any) {
    // @ts-ignore
    const { ctx } = getCurrentInstance();
    const status = ref(true)
    const handleRegister = (formName: string) => {
      ctx.$refs[formName].validate((valid: boolean) => {
        if (valid) {

          alert("submit!");
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    };

    return { handleRegister,status };
  },
};
</script>
<style scoped>
</style>