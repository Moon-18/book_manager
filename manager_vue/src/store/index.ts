import { createStore } from "vuex";

export default createStore({
  state: {
    User: {
      id: "",
      name: "",
      account: "",
      password: "",
      type: "",
    },
  },
  mutations: {
    setUser(state,user){
      // state.User.id=user.id;
      // state.User.name=user.name;
      // state.User.account=user.account;
      // state.User.password=user.password;
      state.User=user
    }

  },
  actions: {},
  getters:{
    formatInfo(state){
      return "账号是"+ state.User.account
    }
  },
  modules: {},
});
