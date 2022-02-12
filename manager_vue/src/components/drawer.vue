<template>
  <el-form
    ref="ruleFormRef"
    :model="store.state.User"
    :rules="userRule"
    label-width="120px"
    class="demo-ruleForm"
    :size="formSize"
  >
    <el-form-item label="头像">
      <!-- 头像上传 -->
      <el-upload
        class="avatar-uploader"
        :action="photoUrl"
        :show-file-list="false"
        :on-success="handleAvatarSuccess"
        :before-upload="beforeAvatarUpload"
        name="photo"
      >
        <img v-if="imageUrl" :src="imageUrl" class="avatar" />
        <el-icon v-else class="avatar-uploader-icon"><plus /></el-icon>
      </el-upload>
    </el-form-item>
    <el-form-item label="名称" prop="name">
      <el-row
        ><el-col :span="24">{{ store.state.User.name }}</el-col></el-row
      >
    </el-form-item>
    <el-form-item label="账号" prop="account">
      <el-row
        ><el-col :span="24"
          ><el-input v-model="store.state.User.account"></el-input></el-col
      ></el-row>
    </el-form-item>

    <el-form-item label="类型" prop="type" required>
      <span>普通读者</span>
    </el-form-item>

    <el-form-item label="密码" prop="password">
      <el-row
        ><el-col :span="24"
          ><el-input v-model="store.state.User.password"></el-input></el-col
      ></el-row>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submitForm()">修改信息</el-button>
      <el-button type="danger" @click="resetForm(ruleFormRef)">退出登录</el-button>
    </el-form-item>
  </el-form>
</template>
<script lang='ts' setup>
import { userRule } from "@/utils/userRule";
import { reactive, computed, ref } from "vue";
import { useStore } from "vuex";
//表单
const store = useStore();
const User = reactive({
  name: "",
  account: "",
  type: "user",
  password: "",
});
// 图片上传部分
import { ElMessage } from "element-plus";
import { Plus } from "@element-plus/icons-vue";
import type {
  UploadFile,
  ElUploadProgressEvent,
  ElFile,
} from "element-plus/es/components/upload/src/upload.type";
const photoUrl=ref("http://localhost:8081/user/photo/"+store.state.User.id)
const imageUrl = ref("");
const handleAvatarSuccess = (res: ElUploadProgressEvent, file: UploadFile) => {
  imageUrl.value = URL.createObjectURL(file.raw);
  window.alert("上传成功")
};
const beforeAvatarUpload = (file: ElFile) => {
  const isJPG = file.type === "image/jpeg";
  const isLt2M = file.size / 1024 / 1024 < 2;

  if (!isJPG) {
    ElMessage.error("Avatar picture must be JPG format!");
  }
  if (!isLt2M) {
    ElMessage.error("Avatar picture size can not exceed 2MB!");
  }
  return isJPG && isLt2M;
};
</script>

<style>
/* 照片上传的相关样式 */
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}
.avatar-uploader .el-upload:hover {
  border-color: #409eff;
}
.el-icon.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  text-align: center;
}
.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
</style>