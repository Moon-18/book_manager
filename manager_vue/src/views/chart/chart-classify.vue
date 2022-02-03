<template>
<p>不同类别图书数量</p>
  <div ref="myChart" :style="{ width: '1000px', height: '580px' }"></div>
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
      myCharts.value.setOption(//里面写option
        {
  legend: {
    top: 'bottom'
  },
  toolbox: {
    show: true,
    feature: {
      mark: { show: true },
      dataView: { show: true, readOnly: false },
      restore: { show: true },
      saveAsImage: { show: true }
    }
  },
  series: [
    {
      name: 'Nightingale Chart',
      type: 'pie',
      radius: [50, 250],
      center: ['50%', '50%'],
      roseType: 'area',
      itemStyle: {
        borderRadius: 8
      },
      data: [
        { value: 40, name: '科技' },
        { value: 38, name: '教育' },
        { value: 32, name: '文化' },
        { value: 30, name: '卫生' },
        { value: 28, name: '体育' }
      ]
    }
  ]
}
      );
    }, 10);

    return {
      myChart,
    };
  },
};
</script>
