import { reactive } from "vue";
export const bookRule = reactive({
  id: [
    {
      required: true,
      message: "Please input writer name",
      trigger: "blur",
    },
  ],
  name: [
    {
      required: true,
      message: "Please input book name!!!!!!!!!!!!!!!!",
      trigger: "blur",
    },
    {
      min: 1,
      max: 10,
      message: "Length should be 1 to 10",
      trigger: "blur",
    },
  ],
  writer: [
    {
      required: true,
      message: "Please input writer name",
      trigger: "blur",
    },
  ],
  kind: [
    {
      type: [],
      required: true,
      message: "Please select at least one kind",
      trigger: "blur",
    },
  ],
  allow: [
    {
      required: true,
      message: "Please input allow",
      trigger: "blur",
    },
  ],
  curNum: [
    {
      required: true,
      message: "Please input current number",
      trigger: "blur",
    },
    {
      min: 1,
      max: 10,
      message: "Length should be 1 to 10",
      trigger: "blur",
    },
  ],
  sumNum: [
    {
      required: true,
      message: "Please input current number",
      trigger: "blur",
    },
    {
      min: 1,
      max: 10,
      message: "Length should be 1 to 10",
      trigger: "blur",
    },
  ],
});
