// 导入封装好的Axios
import { request } from "./request"; //注意request.js的相对路径问题

// import { loginUser} from "@/utils/loginValidators";
import { registerUser } from "@/utils/registerValidators";
import Qs from "qs";

//1.用户相关网络请求
//1.1登录post
export function loginIn(account, password, type) {
  console.log("post方法已经接收到数据");

  return request({
    url: "/user/loginIn",
    headers: {
      "Content-Type": "application/json",
    },
    method: "post",
    data: {
      account: account,
      password: password,
      type: type,
    },
  });
}
//1.2注册post
export function register(account, password, type, name) {
  return request({
    url: "/user/register",
    headers: {
      "Content-Type": "application/json",
    },
    method: "post",
    data: {
      account: account,
      password: password,
      type: type,
      name: name,
    },
  });
}
//2.书籍相关网络请求
export function listAll(cur,size){
  return request({
    url: `/book/listAll/${cur}/${size}`,//es6语法,用反单引号拼接路径
    method: "get",
  });
}
//3.借阅相关网络请求

//1. get请求---获取首页的多个数据
export function getHomeMultidata() {
  return request({
    url: "/api/home",
    method: "get",
    // 可以带参数也可以不带参数
    // params: {
    //     userName: 'Lan',
    //     password: '123'
    // }
  });
}
// 2.1 post请求---传输json数据时，获取电视剧多个数据
export function getTvshowMultidata() {
  return request({
    url: "/api/Tvshow",
    headers: {
      "Content-Type": "application/json",
    },
    method: "post",
    data: {
      userName: "Lan",
      password: "123",
    },
  });
}

//2.2 post请求---传输文件流,表单Form Data 数据时
export function getMovieMultidata() {
  return request({
    url: "/api/Movie",
    headers: {
      "Content-Type": "multipart/form-data",
    },
    method: "post",
    data: {
      userName: "Lan",
      password: "123",
    },
  });
}
