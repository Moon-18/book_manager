<template>
  <el-container
    class="layout-container-demo"
    style="height: 700px; border: 1px solid #eee"
  >
    <el-aside width="180px" style="background-color: rgb(238, 241, 246)">
      <el-scrollbar>
        <el-menu :default-openeds="['3', '4']">
          <el-sub-menu index="1">
            <template #title>
              <el-icon><edit /></el-icon>书籍信息管理
            </template>
            <el-menu-item-group>
              <template #title>Group 1</template>
              <router-link :to="{ name: 'book-main' }"
                ><el-menu-item index="1-1">全部图书</el-menu-item></router-link
              >
              <router-link :to="{ name: 'book-add' }">
                <el-menu-item index="1-4">增加图书</el-menu-item></router-link
              >
            </el-menu-item-group>

            <!-- <el-menu-item-group title="Group 2">
            </el-menu-item-group>

            <el-sub-menu index="1-5">
              <template #title>按类别查看</template>
              <el-menu-item index="1-5-1">科技</el-menu-item>
              <el-menu-item index="1-5-2">教育</el-menu-item>
              <el-menu-item index="1-5-3">文化</el-menu-item>
              <el-menu-item index="1-5-4">卫生</el-menu-item>
              <el-menu-item index="1-5-5">体育</el-menu-item>
            </el-sub-menu> -->
          </el-sub-menu>

          <el-sub-menu index="2">
            <template #title>
              <el-icon><icon-menu /></el-icon>读者信息管理
            </template>
            <el-menu-item-group>
              <template #title>--</template>
              <router-link :to="{ name: 'reader-main' }"
                ><el-menu-item index="2-1">全部读者</el-menu-item></router-link
              >
              <router-link :to="{ name: 'reader-add' }"
                ><el-menu-item index="2-2">增加读者</el-menu-item></router-link
              >
            </el-menu-item-group>
          </el-sub-menu>

          <el-sub-menu index="3">
            <template #title>
              <el-icon><setting /></el-icon>借阅信息管理
            </template>
            <el-menu-item-group>
              <template #title>办理业务</template>
              <router-link :to="{ name: 'inf-current-in' }"
                ><el-menu-item index="3-1">还书</el-menu-item></router-link
              >
              <router-link :to="{ name: 'inf-current-out' }"
                ><el-menu-item index="3-2">借书</el-menu-item></router-link
              >
            </el-menu-item-group>

            <el-menu-item-group>
              <template #title>历史信息</template>
              <router-link :to="{ name: 'inf-history' }"
                ><el-menu-item index="3-3">档案</el-menu-item></router-link
              >
            </el-menu-item-group>
          </el-sub-menu>

          <el-sub-menu index="4">
            <template #title>
              <el-icon><histogram /></el-icon>可视化数据
            </template>
            <router-link :to="{ name: 'chart-reader' }"
              ><el-menu-item index="4-1">借阅读者数</el-menu-item></router-link
            >
            <router-link :to="{ name: 'chart-book' }"
              ><el-menu-item index="4-2" routerLinkto="chart2"
                >借阅图书数</el-menu-item
              >
            </router-link>
            <router-link :to="{ name: 'chart-classify' }"
              ><el-menu-item index="4-3"
                >当前馆藏图书</el-menu-item
              ></router-link
            >
          </el-sub-menu>
        </el-menu>
      </el-scrollbar>
    </el-aside>

    <el-container>
      <el-header>
        <!-- el-heaer的样式 -->
        <!-- style="text-align: right; font-size: 14px; background-color: #409eff" -->
        <div class="toolbar" style="height: 20px">
          <el-avatar
            :size="45"
            :src="imgUrl"
            @click="drawerControl = true"
            :fit="fit"
          ></el-avatar>
          <span><font color="#DCDFE6">用户中心</font></span>
        </div>
      </el-header>
      <!-- 右侧抽屉 -->
      <el-drawer
        v-model="drawerControl"
        title="个人信息"
        :direction="direction"
      >
        <drawer />
      </el-drawer>
      <!-- 主界面 height:1600;height:800 style="height:800;background-color:black" -->
      <el-main style="height: 800; overflow-x: hidden">
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script lang="ts" setup>
import { request } from "@/network/request";
import { ref, onMounted } from "vue";
import drawer from "@/components/drawer.vue";
import {
  Message,
  Menu as IconMenu,
  Setting,
  Avatar,
  Edit,
  Histogram,
} from "@element-plus/icons-vue";
import echarts from "@/views/chart/chart-reader.vue";
import echarts2 from "@/views/chart/chart-book.vue";

//控制右侧抽屉
const drawerControl = ref(false);
const direction = ref("rtl");
//头像请求的url
import { useStore } from "vuex";
const store = useStore();
const imgUrl=ref("http://localhost:8081/img/"+store.state.User.id+".jpg")
// console.log(imgUrl.value)
</script>

<style src="../assets/css/normalize.css"></style>

<style lang="scss">
.layout-container-demo {
  .el-header {
    position: relative;
    // background-color: #b3c0d1;
    background: -webkit-linear-gradient(right,#409EFF,rgb(217, 236, 255)) no-repeat;
    color: var(--el-text-color-primary);

  }
  .el-aside {
    width: 240px;
    color: var(--el-text-color-primary);
    background: #fff !important;
    border-right: solid 1px #e6e6e6;
    box-sizing: border-box;
  }
  .el-menu {
    border-right: none;
  }
  .el-main {
    padding: 0;
  }
  .toolbar {
    position: absolute;
    display: inline-flex;
    align-items: center;
    top: 50%;
    right: 20px;
    transform: translateY(-50%);
  }
}
.router-link-active {
  //点击时去掉下划线
  text-decoration: none;
}
a {
  text-decoration: none;
  color: black;
}
</style>
