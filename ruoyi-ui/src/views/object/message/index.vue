<!-- <template>
  <!-- 最大框 -->
  <el-card class="outer-border">
    <el-tabs v-model="activeName" @tab-click="handleClick">
      <el-tab-pane
        v-for="(item, index) in tabsConfig"
        :key="item.index"
        :label="item.label"
        :name="item.name"
      ></el-tab-pane>
    </el-tabs>
    <!-- 基础信息开始 -->
    <el-card v-show="activeName == 'first'">
      <el-card>
        <div class="inner-border">
          <div class="main-title">
            <p>基本信息</p>
          </div>
        </div>
        <div class="outer-border-first">
          <div class="title">
            <p>推广城市范围</p>
          </div>
          <div class="choose">
            <el-cascader
              ref="citySelect"
              v-model="selectedCity"
              :options="cityData"
              @change="handleChange"
            ></el-cascader>
          </div>
          <div class="result">
            <p>您选择的地点是:{{ selectedCityName }}</p>
          </div>
        </div>
        <div class="outer-border-second">
          <div class="title">
            <p>项目营销负责人</p>
          </div>
          <div class="selectOption">
            <el-select v-model="selectedOption" placeholder="请选择">
              <el-option
                v-for="item in leader"
                :key="item.messageId"
                :value="item.messageLeader"
              >
              </el-option>
            </el-select>
          </div>
          <div class="result">
            <p>您选择的项目营销人是:{{ selectedOption }}</p>
          </div>
        </div>
      </el-card>

      <!-- 阶梯奖励设置 -->
      <el-card class="outer-border-second-first">
        <div class="inner-border-second-first">
          <div class="main-title">
            <p>阶梯奖励设置</p>
          </div>
        </div>
        <el-card class="inner-border-second-second">
          <el-table :data="award" border>
            <el-table-column
              prop="awardTurn"
              label="轮"
              width="180"
              align="center"
            >
            </el-table-column>
            <el-table-column
              prop="awardMoney"
              label="现金"
              width="180"
              align="center"
            >
            </el-table-column>
            <el-table-column
              prop="awardBean"
              label="金豆"
              width="180"
              align="center"
            >
            </el-table-column>
          </el-table>
        </el-card>

        <div class="inner-border-second-third">
          <table>
            <tr>
              <th>
                注:为了让集赞类活动符合微信生态要求,需调整为梯度裂变形式(对客户集赞体验无影响),梯度轮数由顾问创建商家任务时,根据所需集赞数进行自动拆分,并给予对应的奖励
              </th>
            </tr>
          </table>
        </div>
      </el-card>

      <!-- 优惠券推送 -->
      <el-card class="outer-border-third-first">
        <div class="inner-border-third-first">
          <div class="main-title">
            <p>优惠券推送</p>
          </div>
        </div>

        <div class="inner-border-third-second">
          <div class="main-title">
            <p>配置优惠券</p>
          </div>
          <!-- <el-button type="primary" size="small" class="chooseBtn"
            >选择</el-button
          > -->
        </div>

        <div class="inner-border-third-second">
          <el-table :data="discount" border style="width: 100%">
            <el-table-column
              prop="discountType"
              label="优惠券类型"
              width="180"
              align="center"
            >
            </el-table-column>
            <el-table-column
              prop="discountName"
              label="优惠券名称"
              width="180"
              align="center"
            >
            </el-table-column>
          </el-table>
        </div>

        <div class="inner-border-third-third">
          <table>
            <tr>
              <th>注:建议选择到访领礼券,诱导领券者到访案场,达到引流目的</th>
            </tr>
          </table>
        </div>
      </el-card>

      <!-- 成交奖励 -->
      <el-card class="outer-border-fourth-first">
        <div class="inner-border-fourth-first">
          <div class="main-title">
            <p>成交奖励</p>
          </div>
        </div>
        <div class="inner-border-fourth-second">
          <div class="title">
            <p>是否进行凤凰通成交金额奖励</p>
          </div>
          <div class="choose">
            <el-radio v-model="selectedAward" label="是">是</el-radio>
            <el-radio v-model="selectedAward" label="否">否</el-radio>
          </div>
          <div class="result">
            <p>您选择的结果是:{{ selectedAward }}</p>
          </div>
        </div>
      </el-card>

      <!-- 楼盘信息 -->
      <!-- <el-card class="outer-border-fifth-first">
        <div class="inner-border-fifth-first">
          <div class="main-title">
            <p>楼盘信息</p>
          </div>
        </div>
        <div class="inner-border-fifth-second">
          <div class="main-title">
            <p>推广楼盘名称</p>
          </div>
          <el-input
            v-model="inputBuildingName"
            placeholder="请输入楼盘名称"
            size="small"
          ></el-input>
        </div>
        <div class="inner-border-fifth-third">
          <div class="main-title">
            <p>推广楼盘广告语</p>
          </div>
          <el-input
            v-model="inputAd"
            placeholder="请输入推广楼盘广告语"
            size="small"
          ></el-input>
        </div>
        <div class="inner-border-fifth-fourth">
          <div class="main-title">
            <p>项目图片</p>
          </div>
          <el-upload
            class="upload-demo"
            action="https://jsonplaceholder.typicode.com/posts/"
            :on-preview="handlePreview"
            :on-remove="handleRemove"
            :file-list="fileList"
            list-type="picture"
          >
            <el-button size="small" type="primary">点击上传</el-button>
            <div slot="tip" class="el-upload__tip">
              只能上传jpg/png文件,且不超过500kb
            </div>
          </el-upload>
        </div> -->
      <!-- <div class="inner-border-fifth-fifth">
          <div class="block">
            <el-carousel height="360px">
              <el-carousel-item v-for="item in 5" :key="item">
                <h3 class="small">{{ item }}</h3>
              </el-carousel-item>
            </el-carousel>
          </div>
        </div> -->
      <!-- </el-card> -->
    </el-card>
    <!-- 基本信息结束 -->

    <!-- 数据分析开始 -->
    <el-card class="third" v-show="activeName == 'third'">
      <div class="analyButton">
        <el-row>
          <el-button>转任务</el-button>
          <el-button type="primary">永久下线</el-button>
        </el-row>
      </div>
      <!-- 左侧漏斗图 -->
      <el-card class="left">
        <el-card>
          <div class="title">
            <p>推广数据浏览</p>
          </div>
        </el-card>
        <el-card>
          <div ref="chartRef" style="width: 400px; height: 400px"></div>
        </el-card>
      </el-card>
      <!-- 右侧表格数据 -->
      <el-card class="right">
        <el-card>
          <div class="title">
            <p>商品发放分析</p>
          </div>
        </el-card>
        <el-table :data="analysis" border style="width: 100%">
          <el-table-column
            prop="goodsName"
            label="商品名称"
            width="150"
            align="center"
          >
          </el-table-column>
          <el-table-column
            prop="writtenOff"
            label="已兑换"
            width="150"
            align="center"
          >
          </el-table-column>
          <el-table-column
            prop="redeemed"
            label="已核销"
            width="150"
            align="center"
          >
          </el-table-column>
          <el-table-column
            prop="wait"
            label="待核销"
            width="150"
            align="center"
          >
          </el-table-column>
          <el-table-column
            prop="money"
            label="发放金额"
            width="150"
            align="center"
          >
          </el-table-column>
        </el-table>
      </el-card>
    </el-card>
    <!-- 数据分析结束 -->
  </el-card>
</template>

<script>
// 导入axios
import axios from "axios";
import * as echarts from "echarts";
import cityJson from "@/utils/dict/city.json";

export default {
  name: "Message",
  data() {
    return {
      selectedCityName: "",
      cityData: cityJson,
      // tabs标签
      activeName: "first",
      // 头部单选框
      selected: [],
      // 单选项目营销负责人
      selectedOption: "",
      // 是否进行凤凰通成交奖励
      selectedAward: "",
      // 阶梯奖励数组
      award: [],
      // 项目营销负责人
      leader: [],
      // 优惠券
      discount: [],
      // 推广楼盘名称输入框
      inputBuildingName: "",
      // 推广楼盘广告语输入框
      inputAd: "",
      // 图片数组
      fileList: [],
      // tabs标签
      tabsConfig: [
        {
          label: "基础信息",
          name: "first",
        },
        {
          label: "审批进度",
          name: "second",
        },
        {
          label: "数据分析",
          name: "third",
        },
      ],
      // 级联选择城市
      selectedCity: "1",
      // 商品发放分析
      analysis: [],
      options: {
        title: {
          text: "商品发放数据分析",
        },
        tooltip: {
          trigger: "item",
          formatter: "{a} <br/>{b} : {c}%",
        },
        toolbox: {
          feature: {
            dataView: { readOnly: false },
            restore: {},
            saveAsImage: {},
          },
        },
        legend: {
          data: ["Show", "Click", "Visit", "Inquiry"],
        },
        series: [
          {
            name: "Funnel",
            type: "funnel",
            left: "10%",
            top: 60,
            bottom: 60,
            width: "80%",
            min: 0,
            max: 100,
            minSize: "0%",
            maxSize: "100%",
            sort: "descending",
            gap: 2,
            label: {
              show: true,
              position: "inside",
            },
            labelLine: {
              length: 10,
              lineStyle: {
                width: 1,
                type: "solid",
              },
            },
            itemStyle: {
              borderColor: "#fff",
              borderWidth: 1,
            },
            emphasis: {
              label: {
                fontSize: 20,
              },
            },
            data: [
              { value: 40, name: "报名量" },
              { value: 60, name: "UV(访客量)" },
              { value: 80, name: "集赞量" },
              { value: 100, name: "PV(访问量)" },
            ],
          },
        ],
      },
      provinceConfig: [],
      cityConfig: [],
    };
  },

  mounted() {
    // 漏斗图
    this.initChart();
    // 得到阶梯奖励
    this.getData();
    // 得到负责人信息
    this.getOptions();
    // 得到优惠券信息
    this.getDiscount();
    // 得到商品发放分析
    this.getAnalysis();
  },
  methods: {
    // 图片上传
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePreview(file) {
      console.log(file);
    },
    handleChange(value) {
      console.log(value);
      let province = "";
      this.cityData.map((t) => {
        if (t.value == value[0]) province = t.label;
        return false;
      });
      let city = "";
      this.cityData.map((t) =>
        t.children.map((v) => {
          if (v.value == value[1]) city = v.label;
          return false;
        })
      );
      console.log(province, city);
      this.selectedCityName = `${province}/${city}`;
    },
    handleSelectCity(value) {
      console.log(value);
    },
    // 漏斗图
    initChart() {
      let charts = echarts.init(this.$refs.chartRef);
      this.options && charts.setOption(this.options);
    },
    // tabs标签
    handleClick(tab, event) {
      console.log(tab, event);
      console.log(tab.paneName);
    },
    // 得到阶梯奖励
    getData() {
      axios
        .get("http://192.168.1.6:8080/object/award/list")
        .then((response) => {
          this.award = response.data.rows;
        })
        .catch((error) => {
          console.log(error);
        });
    },
    // 得到负责人信息
    getOptions() {
      axios
        .get("http://192.168.1.6:8080/object/message/list")
        .then((response) => {
          console.log(response);
          this.leader = response.data.rows;
        })
        .catch((error) => {
          console.log(error);
        });
    },
    // 得到优惠券信息
    getDiscount() {
      axios
        .get("http://192.168.1.6:8080/object/discount/list")
        .then((response) => {
          console.log(response.data.rows);
          this.discount = response.data.rows;
        })
        .catch((error) => {
          console.log(error);
        });
    },
    // 得到商品发放分析
    getAnalysis() {
      axios
        .get("http://192.168.1.6:8080/object/analysis/list")
        .then((response) => {
          console.log(response);
          this.analysis = response.data.rows;
        })
        .catch((error) => {
          console.log(error);
        });
      console.log(this.analysis);
    },
  },
};
</script>

<style scoped>
/* 基础信息开始 */
/* 基本信息 */
.main-title {
  margin-left: 30px;
  font-weight: 700;
}

.title {
  margin-left: 30px;
}

.outer-border-first {
  display: flex;
  flex-direction: row;
}

.choose {
  margin: 18px;
}

.outer-border-second {
  display: flex;
  flex-direction: row;
}

.selectOption {
  margin: 18px;
  margin-left: 30px;
  display: flex;
  flex-direction: row;
}

/* 阶梯奖励设置 */
.outer-border-second-first {
  margin-top: 6px;
}

.inner-border-second-first {
  width: 100%;
  height: 50px;
}

.inner-border-second-second table {
  border-collapse: collapse;
}

.inner-border-second-second table tr {
  border: 1px solid black;
}

.inner-border-second-second table th {
  border: 1px solid black;
}

.inner-border-second-third table {
  margin: 10px;
  border: 1px solid yellow;
  background-color: antiquewhite;
}

/* 优惠券推送 */
/* 选择按钮 */
/* .chooseBtn {
  margin: 10px;
} */
.outer-border-third-first {
  margin-top: 6px;
}

.inner-border-third-first {
  width: 100%;
  height: 50px;
}

.inner-border-third-second {
  display: flex;
}

#choose-discount {
  margin: 13px;
  margin-left: 20px;
  width: 60px;
  height: 25px;
  background-color: aquamarine;
}

.inner-border-third-second table {
  margin: 5px;
  border-collapse: collapse;
  width: 50%;
  border: 1px solid black;
}

.inner-border-third-second table tr {
  border: 1px solid black;
}

.inner-border-third-second table th {
  border: 1px solid black;
}

.inner-border-third-third table {
  margin: 10px;
  border: 1px solid yellow;
  background-color: antiquewhite;
}

/* 成交奖励 */
.outer-border-fourth-first {
  margin-top: 6px;
}

.inner-border-fourth-first {
  width: 100%;
  height: 50px;
}

.inner-border-fourth-second {
  display: flex;
}

/* 楼盘信息
.el-input {
  margin: 12px;
  width: 500px;
}
.outer-border-fifth-first {
  margin-top: 6px;
}

.inner-border-fifth-first {
  width: 100%;
  height: 50px;
}

.inner-border-fifth-second {
  display: flex;
}

#inputBuilding {
  margin: 13px;
  margin-left: 30px;
  width: 300px;
  height: 30px;
}

.inner-border-fifth-third {
  display: flex;
}

#inputAd {
  margin: 13px;
  margin-left: 30px;
  width: 300px;
  height: 30px;
}

.inner-border-fifth-fourth {
  display: flex;
}

#upload {
  margin: 13px;
  margin-left: 20px;
  width: 80px;
  height: 25px;
  background-color: aquamarine;
} */

/* 轮播图 */
/* .el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 150px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}

.block {
  margin-left: 300px;
  width: 600px;
} */

/* 基础信息结束 */

/* 数据分析开始 */
/* 总体布局 */
.analyButton {
  display: flex;
}
.left,
.right {
  width: 50%;
  height: 100%;
  padding: 20px;
  box-sizing: border-box;
  float: left;
  background-color: #f0f0f0;
}
/* 数据分析结束 */
</style> -->
