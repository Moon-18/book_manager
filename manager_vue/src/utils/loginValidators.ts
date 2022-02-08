import { ref } from "vue";

interface User {
  //定义了一个接口
  account: string;
  password: string;
  Type: string;
  // code:string
}

export const loginUser = ref<User>({
  //对应上面的类型
  account: "",
  password: "",
  Type: "",
  // code:""
});

interface Rules {
  //定义规则的类型
  account: {
    type: string;
    message: string;
    required: boolean;
    trigger: string;
  }[];
  // code: {
  //   message: string;
  //   required: boolean;
  //   trigger: string;
  // }[];
  Type: {
    message: string;
    required: boolean;
    trigger: string;
  }[];
  password: (
    | {
        required: boolean;
        message: string;
        trigger: string;
        min?: undefined;
        max?: undefined;
      }
    | {
        min: number;
        max: number;
        message: string;
        trigger: string;
        required?: undefined;
      }
  )[];
}

// 校验规则
export const rules = ref<Rules>({
  //对应上面的类型
  account: [
    {
      type: "email",
      message: "Email is incorrect...",
      required: true,
      trigger: "blur",
    },
  ],
  // code: [
  //   {

  //     message: "验证码为空",
  //     required: true,
  //     trigger: "blur",
  //   },
  // ],
  Type: [
    {
      required: true,
      message: "Type could not be empty...",
      trigger: "blur",
    },
  ],
  password: [
    {
      required: true,
      message: "Password could not be empty...",
      trigger: "blur",
    },
    {
      min: 6,
      max: 30,
      message: "Password's length has to be 6 to 30 characters...",
      trigger: "blur",
    },
  ],
});
