<template>
  <div ref="myChart" :style="{ width: '1000px', height: '500px' }"></div>
</template>

<script lang="ts">
import { ref } from "vue";
import * as echarts from "echarts";

export default {
  name: "Home",
  setup() {
    const myChart = ref<HTMLElement>();  //也可以用const myChart = ref<any>(); 

    console.log(myChart);
    const myCharts = ref<any>();
    setTimeout(() => {
      // 绘制图表
      myCharts.value = echarts.init(myChart.value!);
      myCharts.value.setOption({
  title: {
    text: '不同种类书籍借阅量'
  },
  tooltip: {
    trigger: 'axis'
  },
  legend: {
    data: ['科技', '教育', '文化', '卫生', '体育']
  },
  grid: {
    left: '3%',
    right: '4%',
    bottom: '3%',
    containLabel: true
  },
  toolbox: {
    feature: {
      saveAsImage: {}
    }
  },
  xAxis: {
    type: 'category',
    boundaryGap: false,
    data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
  },
  yAxis: {
    type: 'value'
  },
  series: [
    {
      name: '科技',
      type: 'line',
      stack: 'Total',
      data: [120, 132, 101, 134, 90, 230, 210]
    },
    {
      name: '教育',
      type: 'line',
      stack: 'Total',
      data: [220, 182, 191, 234, 290, 330, 310]
    },
    {
      name: '文化',
      type: 'line',
      stack: 'Total',
      data: [150, 232, 201, 154, 190, 330, 410]
    },
    {
      name: '卫生',
      type: 'line',
      stack: 'Total',
      data: [320, 332, 301, 334, 390, 330, 320]
    },
    {
      name: '体育',
      type: 'line',
      stack: 'Total',
      data: [820, 932, 901, 934, 1290, 1330, 1320]
    }
  ]
});
    }, 10);

    return {
      myChart,
    };
  },
};
</script>
