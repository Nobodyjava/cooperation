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
      <el-form-item label="商家id" prop="shopperId">
        <el-input
          v-model="queryParams.shopperId"
          placeholder="请输入商家id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="活动id" prop="activityId">
        <el-input
          v-model="queryParams.activityId"
          placeholder="请输入活动id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="顾问token" prop="consultantToken">
        <el-input
          v-model="queryParams.consultantToken"
          placeholder="请输入顾问token"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="顾问姓名" prop="consultantName">
        <el-input
          v-model="queryParams.consultantName"
          placeholder="请输入顾问姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="顾问联系电话" prop="consultantPhone">
        <el-input
          v-model="queryParams.consultantPhone"
          placeholder="请输入顾问联系电话"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="顾问归属项目" prop="project">
        <el-input
          v-model="queryParams.project"
          placeholder="请输入顾问归属项目"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="顾问密码" prop="consultantPassword">
        <el-input
          v-model="queryParams.consultantPassword"
          placeholder="请输入顾问密码"
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
          v-hasPermi="['object:consultant:add']"
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
          v-hasPermi="['object:consultant:edit']"
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
          v-hasPermi="['object:consultant:remove']"
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
          v-hasPermi="['object:consultant:export']"
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
      :data="consultantList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="顾问id" align="center" prop="consultantId" />
      <el-table-column label="商家id" align="center" prop="shopperId" />
      <el-table-column label="活动id" align="center" prop="activityId" />
      <el-table-column
        label="顾问token"
        align="center"
        prop="consultantToken"
      />
      <el-table-column label="顾问姓名" align="center" prop="consultantName" />
      <el-table-column
        label="顾问联系电话"
        align="center"
        prop="consultantPhone"
      />
      <el-table-column label="顾问归属项目" align="center" prop="project" />
      <el-table-column
        label="顾问密码"
        align="center"
        prop="consultantPassword"
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
            v-hasPermi="['object:consultant:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['object:consultant:remove']"
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
        <el-form-item label="商家id" prop="shopperId">
          <el-input v-model="form.shopperId" placeholder="请输入商家id" />
        </el-form-item>
        <el-form-item label="活动id" prop="activityId">
          <el-input v-model="form.activityId" placeholder="请输入活动id" />
        </el-form-item>
        <el-form-item label="顾问token" prop="consultantToken">
          <el-input
            v-model="form.consultantToken"
            placeholder="请输入顾问token"
          />
        </el-form-item>
        <el-form-item label="顾问姓名" prop="consultantName">
          <el-input
            v-model="form.consultantName"
            placeholder="请输入顾问姓名"
          />
        </el-form-item>
        <el-form-item label="顾问联系电话" prop="consultantPhone">
          <el-input
            v-model="form.consultantPhone"
            placeholder="请输入顾问联系电话"
          />
        </el-form-item>
        <el-form-item label="顾问归属项目" prop="project">
          <el-input v-model="form.project" placeholder="请输入顾问归属项目" />
        </el-form-item>
        <el-form-item label="顾问密码" prop="consultantPassword">
          <el-input
            v-model="form.consultantPassword"
            placeholder="请输入顾问密码"
          />
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
  listConsultant,
  getConsultant,
  delConsultant,
  addConsultant,
  updateConsultant,
} from "@/api/object/consultant";

export default {
  name: "Consultant",
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
      consultantList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        shopperId: null,
        activityId: null,
        consultantToken: null,
        consultantName: null,
        consultantPhone: null,
        project: null,
        consultantPassword: null,
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
      listConsultant(this.queryParams).then((response) => {
        this.consultantList = response.rows;
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
        consultantId: null,
        shopperId: null,
        activityId: null,
        consultantToken: null,
        consultantName: null,
        consultantPhone: null,
        project: null,
        consultantPassword: null,
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
      this.ids = selection.map((item) => item.consultantId);
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
      const consultantId = row.consultantId || this.ids;
      getConsultant(consultantId).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改【请填写功能名称】";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (this.form.consultantId != null) {
            updateConsultant(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addConsultant(this.form).then((response) => {
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
      const consultantIds = row.consultantId || this.ids;
      this.$modal
        .confirm(
          '是否确认删除【请填写功能名称】编号为"' +
            consultantIds +
            '"的数据项？'
        )
        .then(function () {
          return delConsultant(consultantIds);
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
        "object/consultant/export",
        {
          ...this.queryParams,
        },
        `consultant_${new Date().getTime()}.xlsx`
      );
    },
  },
};
</script>
