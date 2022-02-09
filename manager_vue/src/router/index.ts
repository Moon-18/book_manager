import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    redirect: "/login",
  },
  {
    path: "/login",
    name: "Login",
    component: () => import("../views/Login-Register.vue"),
  },
  {
    path: "/:catchAll(.*)",
    name: "/404",
    component: () => import("../views/404.vue"),
  },
  {
    path: "/index",
    name: "Index",
    component: () => import("../views/Index.vue"),
    children: [
      {
        path: "chart1",
        name: "chart-reader",
        component: () => import("../views/chart/chart-reader.vue"),
      },
      {
        path: "chart2",
        name: "chart-book",
        component: () => import("@/views/chart/chart-book.vue"),
      },
      {
        path: "chart3",
        name: "chart-classify",
        component: () => import("@/views/chart/chart-classify.vue"),
      },
      {
        path: "reader",
        name: "reader-main",
        component: () => import("@/views/reader/main.vue"),
      },
      {
        path: "reader2",
        name: "reader-add",
        component: () => import("@/views/reader/add.vue"),
      },
      {
        path: "information",
        name: "inf-current-in",
        component: () => import("@/views/information/current-in.vue"),
      },
      {
        path: "information2",
        name: "inf-current-out",
        component: () => import("@/views/information/current-out.vue"),
      },
      {
        path: "information3",
        name: "inf-history",
        component: () => import("@/views/information/history.vue"),
      },
      {
        path: "book",
        name: "book-main",
        component: () => import("@/views/book/main.vue"),
      },
      {
        path: "book2",
        name: "book-add",
        component: () => import("@/views/book/addBook.vue"),
      },
    ],
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL), //更换路由模式
  routes,
});

export default router;
