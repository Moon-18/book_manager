import { reactive } from "vue";
export const userRule = reactive({
  name: [
    {
      required: true,
      message: "Please input reader name!!!",
      trigger: "blur",
    },
    {
      min: 1,
      max: 10,
      message: "Length should be 1 to 10",
      trigger: "blur",
    },
  ],
  account: [
    {
      type: "email",
      required: true,
      message: "Please input account!!!!~~~",
      trigger: "blur",
    },
  ],
  password: [
    {
      type: "",
      required: true,
      message: "Please select at least one kind",
      trigger: "change",
    },
    {
      min: 6,
      max: 30,
    },
  ]
});
