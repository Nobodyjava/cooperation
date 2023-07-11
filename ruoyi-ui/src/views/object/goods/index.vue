<template>
  <div class="app-container">
    <el-form
      :model="queryParams"
      ref="queryForm"
      size="small"
      :inline="true"
      v-show="showSearch"
      label-width="68px"
    >
      <el-form-item label="顾问id" prop="consultantId">
        <el-input
          v-model="queryParams.consultantId"
          placeholder="请输入顾问id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商品名称" prop="goodsName">
        <el-input
          v-model="queryParams.goodsName"
          placeholder="请输入商品名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="兑换的赞数" prop="goodsLike">
        <el-input
          v-model="queryParams.goodsLike"
          placeholder="请输入兑换的赞数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="添加兑换图片" prop="img">
        <el-input
          v-model="queryParams.img"
          placeholder="请输入添加兑换图片"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商品原价" prop="goodsOriginalprice">
        <el-input
          v-model="queryParams.goodsOriginalprice"
          placeholder="请输入商品原价"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="补贴商家费用" prop="goodsPrice">
        <el-input
          v-model="queryParams.goodsPrice"
          placeholder="请输入补贴商家费用"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商品投放总量" prop="goodsTotalnum">
        <el-input
          v-model="queryParams.goodsTotalnum"
          placeholder="请输入商品投放总量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商品已领取数量" prop="goodsClaimnum">
        <el-input
          v-model="queryParams.goodsClaimnum"
          placeholder="请输入商品已领取数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商品剩余数量" prop="goodsRemainnum">
        <el-input
          v-model="queryParams.goodsRemainnum"
          placeholder="请输入商品剩余数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商品领取限制" prop="goodsLimit">
        <el-input
          v-model="queryParams.goodsLimit"
          placeholder="请输入商品领取限制"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="使用时间" prop="usetime">
        <el-date-picker
          clearable
          v-model="queryParams.usetime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择使用时间"
        >
        </el-date-picker>
      </el-form-item>
      <el-form-item label="有效天数" prop="fundays">
        <el-input
          v-model="queryParams.fundays"
          placeholder="请输入有效天数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="截止核销时间" prop="endtime">
        <el-date-picker
          clearable
          v-model="queryParams.endtime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择截止核销时间"
        >
        </el-date-picker>
      </el-form-item>
      <el-form-item label="打折数" prop="discount">
        <el-input
          v-model="queryParams.discount"
          placeholder="请输入打折数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="满减标准" prop="priceStandard">
        <el-input
          v-model="queryParams.priceStandard"
          placeholder="请输入满减标准"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="满减数" prop="priceReduction">
        <el-input
          v-model="queryParams.priceReduction"
          placeholder="请输入满减数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="可减数" prop="priceOff">
        <el-input
          v-model="queryParams.priceOff"
          placeholder="请输入可减数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button
          type="primary"
          icon="el-icon-search"
          size="mini"
          @click="handleQuery"
          >搜索</el-button
        >
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery"
          >重置</el-button
        >
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['object:goods:add']"
          >新增</el-button
        >
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['object:goods:edit']"
          >修改</el-button
        >
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['object:goods:remove']"
          >删除</el-button
        >
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['object:goods:export']"
          >导出</el-button
        >
      </el-col>
      <right-toolbar
        :showSearch.sync="showSearch"
        @queryTable="getList"
      ></right-toolbar>
    </el-row>

    <el-table
      v-loading="loading"
      :data="goodsList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="商品id" align="center" prop="goodsId" />
      <el-table-column label="顾问id" align="center" prop="consultantId" />
      <el-table-column label="商品类型" align="center" prop="goodsType" />
      <el-table-column label="商品名称" align="center" prop="goodsName" />
      <el-table-column label="兑换的赞数" align="center" prop="goodsLike" />
      <el-table-column label="添加兑换图片" align="center" prop="img" />
      <el-table-column
        label="商品原价"
        align="center"
        prop="goodsOriginalprice"
      />
      <el-table-column label="补贴商家费用" align="center" prop="goodsPrice" />
      <el-table-column
        label="商品投放总量"
        align="center"
        prop="goodsTotalnum"
      />
      <el-table-column
        label="商品已领取数量"
        align="center"
        prop="goodsClaimnum"
      />
      <el-table-column
        label="商品剩余数量"
        align="center"
        prop="goodsRemainnum"
      />
      <el-table-column label="商品领取限制" align="center" prop="goodsLimit" />
      <el-table-column
        label="使用时间"
        align="center"
        prop="usetime"
        width="180"
      >
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.usetime, "{y}-{m}-{d}") }}</span>
        </template>
      </el-table-column>
      <el-table-column label="有效天数" align="center" prop="fundays" />
      <el-table-column
        label="截止核销时间"
        align="center"
        prop="endtime"
        width="180"
      >
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.endtime, "{y}-{m}-{d}") }}</span>
        </template>
      </el-table-column>
      <el-table-column label="打折数" align="center" prop="discount" />
      <el-table-column label="满减标准" align="center" prop="priceStandard" />
      <el-table-column label="满减数" align="center" prop="priceReduction" />
      <el-table-column label="可减数" align="center" prop="priceOff" />
      <el-table-column
        label="商品领取状态 0未领取完1已领取完"
        align="center"
        prop="goodsClaimstatus"
      />
      <el-table-column
        label="操作"
        align="center"
        class-name="small-padding fixed-width"
      >
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['object:goods:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['object:goods:remove']"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total > 0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改【请填写功能名称】对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="顾问id" prop="consultantId">
          <el-input v-model="form.consultantId" placeholder="请输入顾问id" />
        </el-form-item>
        <el-form-item label="商品名称" prop="goodsName">
          <el-input v-model="form.goodsName" placeholder="请输入商品名称" />
        </el-form-item>
        <el-form-item label="兑换的赞数" prop="goodsLike">
          <el-input v-model="form.goodsLike" placeholder="请输入兑换的赞数" />
        </el-form-item>
        <el-form-item label="添加兑换图片" prop="img">
          <el-input v-model="form.img" placeholder="请输入添加兑换图片" />
        </el-form-item>
        <el-form-item label="商品原价" prop="goodsOriginalprice">
          <el-input
            v-model="form.goodsOriginalprice"
            placeholder="请输入商品原价"
          />
        </el-form-item>
        <el-form-item label="补贴商家费用" prop="goodsPrice">
          <el-input
            v-model="form.goodsPrice"
            placeholder="请输入补贴商家费用"
          />
        </el-form-item>
        <el-form-item label="商品投放总量" prop="goodsTotalnum">
          <el-input
            v-model="form.goodsTotalnum"
            placeholder="请输入商品投放总量"
          />
        </el-form-item>
        <el-form-item label="商品已领取数量" prop="goodsClaimnum">
          <el-input
            v-model="form.goodsClaimnum"
            placeholder="请输入商品已领取数量"
          />
        </el-form-item>
        <el-form-item label="商品剩余数量" prop="goodsRemainnum">
          <el-input
            v-model="form.goodsRemainnum"
            placeholder="请输入商品剩余数量"
          />
        </el-form-item>
        <el-form-item label="商品领取限制" prop="goodsLimit">
          <el-input
            v-model="form.goodsLimit"
            placeholder="请输入商品领取限制"
          />
        </el-form-item>
        <el-form-item label="使用时间" prop="usetime">
          <el-date-picker
            clearable
            v-model="form.usetime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择使用时间"
          >
          </el-date-picker>
        </el-form-item>
        <el-form-item label="有效天数" prop="fundays">
          <el-input v-model="form.fundays" placeholder="请输入有效天数" />
        </el-form-item>
        <el-form-item label="截止核销时间" prop="endtime">
          <el-date-picker
            clearable
            v-model="form.endtime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择截止核销时间"
          >
          </el-date-picker>
        </el-form-item>
        <el-form-item label="打折数" prop="discount">
          <el-input v-model="form.discount" placeholder="请输入打折数" />
        </el-form-item>
        <el-form-item label="满减标准" prop="priceStandard">
          <el-input v-model="form.priceStandard" placeholder="请输入满减标准" />
        </el-form-item>
        <el-form-item label="满减数" prop="priceReduction">
          <el-input v-model="form.priceReduction" placeholder="请输入满减数" />
        </el-form-item>
        <el-form-item label="可减数" prop="priceOff">
          <el-input v-model="form.priceOff" placeholder="请输入可减数" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {
  listGoods,
  getGoods,
  delGoods,
  addGoods,
  updateGoods,
} from "@/api/object/goods";

export default {
  name: "Goods",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 【请填写功能名称】表格数据
      goodsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        consultantId: null,
        goodsType: null,
        goodsName: null,
        goodsLike: null,
        img: null,
        goodsOriginalprice: null,
        goodsPrice: null,
        goodsTotalnum: null,
        goodsClaimnum: null,
        goodsRemainnum: null,
        goodsLimit: null,
        usetime: null,
        fundays: null,
        endtime: null,
        discount: null,
        priceStandard: null,
        priceReduction: null,
        priceOff: null,
        goodsClaimstatus: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {},
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询【请填写功能名称】列表 */
    getList() {
      this.loading = true;
      listGoods(this.queryParams).then((response) => {
        this.goodsList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        goodsId: null,
        consultantId: null,
        goodsType: null,
        goodsName: null,
        goodsLike: null,
        img: null,
        goodsOriginalprice: null,
        goodsPrice: null,
        goodsTotalnum: null,
        goodsClaimnum: null,
        goodsRemainnum: null,
        goodsLimit: null,
        usetime: null,
        fundays: null,
        endtime: null,
        discount: null,
        priceStandard: null,
        priceReduction: null,
        priceOff: null,
        goodsClaimstatus: null,
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map((item) => item.goodsId);
      this.single = selection.length !== 1;
      this.multiple = !selection.length;
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加【请填写功能名称】";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const goodsId = row.goodsId || this.ids;
      getGoods(goodsId).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改【请填写功能名称】";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (this.form.goodsId != null) {
            updateGoods(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addGoods(this.form).then((response) => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const goodsIds = row.goodsId || this.ids;
      this.$modal
        .confirm(
          '是否确认删除【请填写功能名称】编号为"' + goodsIds + '"的数据项？'
        )
        .then(function () {
          return delGoods(goodsIds);
        })
        .then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        })
        .catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download(
        "object/goods/export",
        {
          ...this.queryParams,
        },
        `goods_${new Date().getTime()}.xlsx`
      );
    },
  },
};
</script>
