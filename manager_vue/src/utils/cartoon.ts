import { ElMessage } from "element-plus";
export const news = (msg,kind) => {
  ElMessage({
    showClose: true,
    message: msg,
    type: kind,
  });
};
