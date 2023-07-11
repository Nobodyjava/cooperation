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
      <el-form-item label="商家id" prop="shopperId">
        <el-input
          v-model="queryParams.shopperId"
          placeholder="请输入商家id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商品id" prop="goodsId">
        <el-input
          v-model="queryParams.goodsId"
          placeholder="请输入商品id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="活动主题" prop="activityTopic">
        <el-input
          v-model="queryParams.activityTopic"
          placeholder="请输入活动主题"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="活动开始时间" prop="begintime">
        <el-date-picker
          clearable
          v-model="queryParams.begintime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择活动开始时间"
        >
        </el-date-picker>
      </el-form-item>
      <el-form-item label="活动结束时间" prop="endtime">
        <el-date-picker
          clearable
          v-model="queryParams.endtime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择活动结束时间"
        >
        </el-date-picker>
      </el-form-item>
      <el-form-item label="活动推广城市" prop="activityCity">
        <el-input
          v-model="queryParams.activityCity"
          placeholder="请输入活动推广城市"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="项目管理人" prop="leader">
        <el-input
          v-model="queryParams.leader"
          placeholder="请输入项目管理人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商品核销截止日期" prop="goodsEndtime">
        <el-date-picker
          clearable
          v-model="queryParams.goodsEndtime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择商品核销截止日期"
        >
        </el-date-picker>
      </el-form-item>
      <el-form-item label="微信分享语" prop="sharing">
        <el-input
          v-model="queryParams.sharing"
          placeholder="请输入微信分享语"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="分享卡片" prop="cards">
        <el-input
          v-model="queryParams.cards"
          placeholder="请输入分享卡片"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="活动列表封面图" prop="pic">
        <el-input
          v-model="queryParams.pic"
          placeholder="请输入活动列表封面图"
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
          v-hasPermi="['object:activity:add']"
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
          v-hasPermi="['object:activity:edit']"
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
          v-hasPermi="['object:activity:remove']"
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
          v-hasPermi="['object:activity:export']"
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
      :data="activityList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="活动id" align="center" prop="activityId" />
      <el-table-column label="顾问id" align="center" prop="consultantId" />
      <el-table-column label="商家id" align="center" prop="shopperId" />
      <el-table-column label="商品id" align="center" prop="goodsId" />
      <el-table-column label="活动主题" align="center" prop="activityTopic" />
      <el-table-column
        label="活动开始时间"
        align="center"
        prop="begintime"
        width="180"
      >
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.begintime, "{y}-{m}-{d}") }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="活动结束时间"
        align="center"
        prop="endtime"
        width="180"
      >
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.endtime, "{y}-{m}-{d}") }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="活动推广城市"
        align="center"
        prop="activityCity"
      />
      <el-table-column label="项目管理人" align="center" prop="leader" />
      <el-table-column
        label="商品核销截止日期"
        align="center"
        prop="goodsEndtime"
        width="180"
      >
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.goodsEndtime, "{y}-{m}-{d}") }}</span>
        </template>
      </el-table-column>
      <el-table-column label="微信分享语" align="center" prop="sharing" />
      <el-table-column label="分享卡片" align="center" prop="cards" />
      <el-table-column label="活动列表封面图" align="center" prop="pic" />
      <el-table-column
        label="是否通过凤凰通成交金额奖励"
        align="center"
        prop="status"
      />
      <el-table-column
        label="审核码 0通过1不通过"
        align="center"
        prop="checkStatus"
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
            v-hasPermi="['object:activity:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['object:activity:remove']"
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
        <el-form-item label="商家id" prop="shopperId">
          <el-input v-model="form.shopperId" placeholder="请输入商家id" />
        </el-form-item>
        <el-form-item label="商品id" prop="goodsId">
          <el-input v-model="form.goodsId" placeholder="请输入商品id" />
        </el-form-item>
        <el-form-item label="活动主题" prop="activityTopic">
          <el-input v-model="form.activityTopic" placeholder="请输入活动主题" />
        </el-form-item>
        <el-form-item label="活动开始时间" prop="begintime">
          <el-date-picker
            clearable
            v-model="form.begintime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择活动开始时间"
          >
          </el-date-picker>
        </el-form-item>
        <el-form-item label="活动结束时间" prop="endtime">
          <el-date-picker
            clearable
            v-model="form.endtime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择活动结束时间"
          >
          </el-date-picker>
        </el-form-item>
        <el-form-item label="活动推广城市" prop="activityCity">
          <el-input
            v-model="form.activityCity"
            placeholder="请输入活动推广城市"
          />
        </el-form-item>
        <el-form-item label="项目管理人" prop="leader">
          <el-input v-model="form.leader" placeholder="请输入项目管理人" />
        </el-form-item>
        <el-form-item label="商品核销截止日期" prop="goodsEndtime">
          <el-date-picker
            clearable
            v-model="form.goodsEndtime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择商品核销截止日期"
          >
          </el-date-picker>
        </el-form-item>
        <el-form-item label="微信分享语" prop="sharing">
          <el-input v-model="form.sharing" placeholder="请输入微信分享语" />
        </el-form-item>
        <el-form-item label="分享卡片" prop="cards">
          <el-input v-model="form.cards" placeholder="请输入分享卡片" />
        </el-form-item>
        <el-form-item label="活动列表封面图" prop="pic">
          <el-input v-model="form.pic" placeholder="请输入活动列表封面图" />
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
  listActivity,
  getActivity,
  delActivity,
  addActivity,
  updateActivity,
} from "@/api/object/activity";

export default {
  name: "Activity",
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
      activityList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        consultantId: null,
        shopperId: null,
        goodsId: null,
        activityTopic: null,
        begintime: null,
        endtime: null,
        activityCity: null,
        goodsEndtime: null,
        sharing: null,
        cards: null,
        pic: null,
        checkStatus: null,
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
      listActivity(this.queryParams).then((response) => {
        this.activityList = response.rows;
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
        activityId: null,
        consultantId: null,
        shopperId: null,
        goodsId: null,
        activityTopic: null,
        begintime: null,
        endtime: null,
        activityCity: null,
        goodsEndtime: null,
        sharing: null,
        cards: null,
        pic: null,
        checkStatus: null,
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
      this.ids = selection.map((item) => item.activityId);
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
      const activityId = row.activityId || this.ids;
      getActivity(activityId).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改【请填写功能名称】";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (this.form.activityId != null) {
            updateActivity(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addActivity(this.form).then((response) => {
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
      const activityIds = row.activityId || this.ids;
      this.$modal
        .confirm(
          '是否确认删除【请填写功能名称】编号为"' + activityIds + '"的数据项？'
        )
        .then(function () {
          return delActivity(activityIds);
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
        "object/activity/export",
        {
          ...this.queryParams,
        },
        `activity_${new Date().getTime()}.xlsx`
      );
    },
  },
};
</script>
