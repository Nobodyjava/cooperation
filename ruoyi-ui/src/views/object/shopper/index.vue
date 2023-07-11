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
      <el-form-item label="商家名称" prop="shopperName">
        <el-input
          v-model="queryParams.shopperName"
          placeholder="请输入商家名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="收款账号" prop="account">
        <el-input
          v-model="queryParams.account"
          placeholder="请输入收款账号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="核销账户" prop="validatedAccount">
        <el-input
          v-model="queryParams.validatedAccount"
          placeholder="请输入核销账户"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商家收益" prop="shopperGain">
        <el-input
          v-model="queryParams.shopperGain"
          placeholder="请输入商家收益"
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
      <el-form-item label="商家联系电话" prop="shopperPhone">
        <el-input
          v-model="queryParams.shopperPhone"
          placeholder="请输入商家联系电话"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商家地址" prop="shopperAddress">
        <el-input
          v-model="queryParams.shopperAddress"
          placeholder="请输入商家地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商家门牌号" prop="shopperHousenumber">
        <el-input
          v-model="queryParams.shopperHousenumber"
          placeholder="请输入商家门牌号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="分店地址" prop="branchAddress">
        <el-input
          v-model="queryParams.branchAddress"
          placeholder="请输入分店地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="宣传图" prop="img">
        <el-input
          v-model="queryParams.img"
          placeholder="请输入宣传图"
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
          v-hasPermi="['object:shopper:add']"
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
          v-hasPermi="['object:shopper:edit']"
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
          v-hasPermi="['object:shopper:remove']"
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
          v-hasPermi="['object:shopper:export']"
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
      :data="shopperList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="商家id" align="center" prop="shopperId" />
      <el-table-column label="顾问id" align="center" prop="consultantId" />
      <el-table-column label="商家名称" align="center" prop="shopperName" />
      <el-table-column label="商家分类" align="center" prop="shopperType" />
      <el-table-column label="收款账号" align="center" prop="account" />
      <el-table-column
        label="核销账户"
        align="center"
        prop="validatedAccount"
      />
      <el-table-column label="商家收益" align="center" prop="shopperGain" />
      <el-table-column label="顾问归属项目" align="center" prop="project" />
      <el-table-column
        label="商家联系电话"
        align="center"
        prop="shopperPhone"
      />
      <el-table-column label="商家地址" align="center" prop="shopperAddress" />
      <el-table-column
        label="商家门牌号"
        align="center"
        prop="shopperHousenumber"
      />
      <el-table-column
        label="是否有分店 0没有1有"
        align="center"
        prop="status"
      />
      <el-table-column label="分店地址" align="center" prop="branchAddress" />
      <el-table-column label="宣传图" align="center" prop="img" />
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
            v-hasPermi="['object:shopper:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['object:shopper:remove']"
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
        <el-form-item label="商家名称" prop="shopperName">
          <el-input v-model="form.shopperName" placeholder="请输入商家名称" />
        </el-form-item>
        <el-form-item label="收款账号" prop="account">
          <el-input v-model="form.account" placeholder="请输入收款账号" />
        </el-form-item>
        <el-form-item label="核销账户" prop="validatedAccount">
          <el-input
            v-model="form.validatedAccount"
            placeholder="请输入核销账户"
          />
        </el-form-item>
        <el-form-item label="商家收益" prop="shopperGain">
          <el-input v-model="form.shopperGain" placeholder="请输入商家收益" />
        </el-form-item>
        <el-form-item label="顾问归属项目" prop="project">
          <el-input v-model="form.project" placeholder="请输入顾问归属项目" />
        </el-form-item>
        <el-form-item label="商家联系电话" prop="shopperPhone">
          <el-input
            v-model="form.shopperPhone"
            placeholder="请输入商家联系电话"
          />
        </el-form-item>
        <el-form-item label="商家地址" prop="shopperAddress">
          <el-input
            v-model="form.shopperAddress"
            placeholder="请输入商家地址"
          />
        </el-form-item>
        <el-form-item label="商家门牌号" prop="shopperHousenumber">
          <el-input
            v-model="form.shopperHousenumber"
            placeholder="请输入商家门牌号"
          />
        </el-form-item>
        <el-form-item label="分店地址" prop="branchAddress">
          <el-input v-model="form.branchAddress" placeholder="请输入分店地址" />
        </el-form-item>
        <el-form-item label="宣传图" prop="img">
          <el-input v-model="form.img" placeholder="请输入宣传图" />
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
  listShopper,
  getShopper,
  delShopper,
  addShopper,
  updateShopper,
} from "@/api/object/shopper";

export default {
  name: "Shopper",
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
      shopperList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        consultantId: null,
        shopperName: null,
        shopperType: null,
        account: null,
        validatedAccount: null,
        shopperGain: null,
        project: null,
        shopperPhone: null,
        shopperAddress: null,
        shopperHousenumber: null,
        status: null,
        branchAddress: null,
        img: null,
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
      listShopper(this.queryParams).then((response) => {
        this.shopperList = response.rows;
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
        shopperId: null,
        consultantId: null,
        shopperName: null,
        shopperType: null,
        account: null,
        validatedAccount: null,
        shopperGain: null,
        project: null,
        shopperPhone: null,
        shopperAddress: null,
        shopperHousenumber: null,
        status: null,
        branchAddress: null,
        img: null,
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
      this.ids = selection.map((item) => item.shopperId);
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
      const shopperId = row.shopperId || this.ids;
      getShopper(shopperId).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改【请填写功能名称】";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (this.form.shopperId != null) {
            updateShopper(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addShopper(this.form).then((response) => {
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
      const shopperIds = row.shopperId || this.ids;
      this.$modal
        .confirm(
          '是否确认删除【请填写功能名称】编号为"' + shopperIds + '"的数据项？'
        )
        .then(function () {
          return delShopper(shopperIds);
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
        "object/shopper/export",
        {
          ...this.queryParams,
        },
        `shopper_${new Date().getTime()}.xlsx`
      );
    },
  },
};
</script>
