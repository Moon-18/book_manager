<template>
  <el-form
    ref="loginForm"
    :model="loginUser"
    :rules="rules"
    label-width="100px"
    class="loginForm sign-in-form"
  >
    <el-form-item label="账号" prop="account">
      <el-input
        v-model="loginUser.account"
        placeholder="Enter Email..."
      ></el-input>
      
    </el-form-item>
    <el-form-item label="密码" prop="password">
      <el-input
        v-model="loginUser.password"
        type="password"
        placeholder="Enter Password..."
      ></el-input>
    </el-form-item>

    <el-form-item label="类型" prop="Type">
      <el-radio-group v-model="loginUser.Type">
        <el-radio label="user">用户</el-radio>
        <el-radio label="admin">管理员</el-radio>
        <!-- 1911834200@qq.com -->
      </el-radio-group>
    </el-form-item>

    <el-form-item>
      <el-button
        @click="handleLogin('loginForm')"
        type="primary"
        class="submit-btn"
        >提交</el-button
      >
    </el-form-item>

    <!-- 找回密码 -->
    <div class="tiparea">
      <p>忘记密码? <a>立即找回</a></p>
    </div>
  </el-form>
</template>

<script lang="ts">
import { ref, getCurrentInstance } from "vue";
import { useRouter } from 'vue-router';//路由
import {loginIn} from '@/network/network'
import { loginUser } from '@/utils/loginValidators';
export default {
  props: {
    loginUser: {
      type: Object,
      required: true
    },
    rules: {
      type: Object,
      required: true,
    },
  },
  setup(props:any) {
    // @ts-ignore
    const { ctx } = getCurrentInstance();
    const status = ref(true)
     const router = useRouter()
    // 触发登录方法
    const handleLogin = (formName: string) => {
      ctx.$refs[formName].validate((valid: boolean) => {
        if (valid) {
          //输入有效，进行账号密码验证
          //进行网络请求
      loginIn(loginUser.value.account,loginUser.value.password,loginUser.value.Type).then(
          res => {
            console.log(res)
          // 此处res 为返回的数据，将返回的数据进行处理显示
          let code=res.code
          console.log(code+"读取到的状态码")
          if(code==200){
            console.log("登录成功 ");
            //结果正确
            router.push({ name: 'Index'})
          }else{
            console.log("登录失败")
          }
            
          }).catch(
          err => {
            let code=err.data.code
          console.log(code+"读取到的状态码")
            console.log("登录错误")
          }
        );
         
          
        } else {
          console.log("error submit!!");
          return false;
        }
      })
    };

    return { handleLogin,status };
  },
};
</script>

<style scoped>
/* form */
.loginForm {
  margin-top: 20px;
  background-color: #fff;
  padding: 20px 40px 20px 20px;
  border-radius: 5px;
  box-shadow: 0px 5px 10px #cccc;
}

.submit-btn {
  width: 100%;
}
.tiparea {
  text-align: right;
  font-size: 12px;
  color: #333;
}
.tiparea p a {
  color: #409eff;
}
</style>