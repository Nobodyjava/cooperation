<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="顾问id" prop="consultantId">
        <el-input
          v-model="queryParams.consultantId"
          placeholder="请输入顾问id"
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
      <el-form-item label="活动id" prop="activityId">
        <el-input
          v-model="queryParams.activityId"
          placeholder="请输入活动id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="openid" prop="openId">
        <el-input
          v-model="queryParams.openId"
          placeholder="请输入openid"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="当前参与人的手机号" prop="phone">
        <el-input
          v-model="queryParams.phone"
          placeholder="请输入当前参与人的手机号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="被邀请人手机号" prop="bPhone">
        <el-input
          v-model="queryParams.bPhone"
          placeholder="请输入被邀请人手机号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="当前助力人数" prop="helpCount">
        <el-input
          v-model="queryParams.helpCount"
          placeholder="请输入当前助力人数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
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
          v-hasPermi="['object:forward:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['object:forward:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['object:forward:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['object:forward:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="forwardList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="转发表id" align="center" prop="forwardId" />
      <el-table-column label="顾问id" align="center" prop="consultantId" />
      <el-table-column label="商品id" align="center" prop="goodsId" />
      <el-table-column label="活动id" align="center" prop="activityId" />
      <el-table-column label="openid" align="center" prop="openId" />
      <el-table-column label="当前参与人的手机号" align="center" prop="phone" />
      <el-table-column label="被邀请人手机号" align="center" prop="bPhone" />
      <el-table-column label="当前助力人数" align="center" prop="helpCount" />
      <el-table-column label="核销码状态 0未核销1已核销" align="center" prop="status" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['object:forward:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['object:forward:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
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
        <el-form-item label="商品id" prop="goodsId">
          <el-input v-model="form.goodsId" placeholder="请输入商品id" />
        </el-form-item>
        <el-form-item label="活动id" prop="activityId">
          <el-input v-model="form.activityId" placeholder="请输入活动id" />
        </el-form-item>
        <el-form-item label="openid" prop="openId">
          <el-input v-model="form.openId" placeholder="请输入openid" />
        </el-form-item>
        <el-form-item label="当前参与人的手机号" prop="phone">
          <el-input v-model="form.phone" placeholder="请输入当前参与人的手机号" />
        </el-form-item>
        <el-form-item label="被邀请人手机号" prop="bPhone">
          <el-input v-model="form.bPhone" placeholder="请输入被邀请人手机号" />
        </el-form-item>
<!--        <el-form-item label="当前助力人数" prop="helpCount">-->
<!--          <el-input v-model="form.helpCount" placeholder="请输入当前助力人数" />-->
<!--        </el-form-item>-->
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listForward, getForward, delForward, addForward, updateForward } from "@/api/object/forward";

export default {
  name: "Forward",
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
      forwardList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        consultantId: null,
        goodsId: null,
        activityId: null,
        openId: null,
        phone: null,
        bPhone: null,
        helpCount: null,
        status: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询【请填写功能名称】列表 */
    getList() {
      this.loading = true;
      listForward(this.queryParams).then(response => {
        this.forwardList = response.rows;
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
        forwardId: null,
        consultantId: null,
        goodsId: null,
        activityId: null,
        openId: null,
        phone: null,
        bPhone: null,
        helpCount: null,
        status: null
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
      this.ids = selection.map(item => item.forwardId)
      this.single = selection.length!==1
      this.multiple = !selection.length
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
      const forwardId = row.forwardId || this.ids
      getForward(forwardId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改【请填写功能名称】";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.forwardId != null) {
            updateForward(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addForward(this.form).then(response => {
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
      const forwardIds = row.forwardId || this.ids;
      this.$modal.confirm('是否确认删除【请填写功能名称】编号为"' + forwardIds + '"的数据项？').then(function() {
        return delForward(forwardIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('object/forward/export', {
        ...this.queryParams
      }, `forward_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
