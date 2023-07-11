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
      <el-form-item label="推广楼盘名称" prop="buildingName">
        <el-input
          v-model="queryParams.buildingName"
          placeholder="请输入推广楼盘名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="推广楼盘广告语" prop="buildingAd">
        <el-input
          v-model="queryParams.buildingAd"
          placeholder="请输入推广楼盘广告语"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="项目轮播图" prop="buildingPic">
        <el-input
          v-model="queryParams.buildingPic"
          placeholder="请输入项目轮播图"
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
        <el-button icon="el-icon-add" size="mini" @click="buildFormShow = true"
          >添加楼盘信息</el-button
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
          v-hasPermi="['object:building:add']"
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
          v-hasPermi="['object:building:edit']"
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
          v-hasPermi="['object:building:remove']"
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
          v-hasPermi="['object:building:export']"
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
      :data="buildingList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="楼盘id" align="center" prop="buildingId" />
      <el-table-column
        label="推广楼盘名称"
        align="center"
        prop="buildingName"
      />
      <el-table-column
        label="推广楼盘广告语"
        align="center"
        prop="buildingAd"
      />
      <el-table-column label="项目轮播图" align="center">
        <template slot-scope="scope">
          <el-button size="mini" @click="lookPic(scope.row)"
            >查看图片</el-button
          ></template
        >
      </el-table-column>
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
            v-hasPermi="['object:building:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['object:building:remove']"
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
        <el-form-item label="推广楼盘名称" prop="buildingName">
          <el-input
            v-model="form.buildingName"
            placeholder="请输入推广楼盘名称"
          />
        </el-form-item>
        <el-form-item label="推广楼盘广告语" prop="buildingAd">
          <el-input
            v-model="form.buildingAd"
            placeholder="请输入推广楼盘广告语"
          />
        </el-form-item>
        <el-form-item label="项目轮播图" prop="buildingPic">
          <el-input v-model="form.buildingPic" placeholder="请输入项目轮播图" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <el-dialog
      title="添加楼盘信息"
      :visible.sync="buildFormShow"
      @close="buildFormShow = false"
    >
      <build-form ref="buildForm"></build-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="buildFormShow = false">取 消</el-button>
        <el-button type="primary" @click="save">确 定</el-button>
      </span>
    </el-dialog>

    <el-dialog
      title="查看图片"
      :visible.sync="lookPicShow"
      @close="lookPicShow = false"
    >
      <look-pic ref="lookPic"></look-pic>
      <span slot="footer" class="dialog-footer">
        <el-button @click="lookPicShow = false">取 消</el-button>
        <el-button type="primary" @click="save2">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import {
  listBuilding,
  getBuilding,
  delBuilding,
  addBuilding,
  updateBuilding,
} from "@/api/object/building";

import BuildForm from "./building-form.vue";
import LookPic from "./look-pic.vue";

export default {
  name: "Building",
  components: {
    BuildForm,
    LookPic,
  },
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
      buildingList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        buildingName: null,
        buildingAd: null,
        buildingPic: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {},
      buildFormShow: false,
      lookPicShow: false,
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询【请填写功能名称】列表 */
    getList() {
      this.loading = true;
      listBuilding(this.queryParams).then((response) => {
        this.buildingList = response.rows;
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
        buildingId: null,
        buildingName: null,
        buildingAd: null,
        buildingPic: null,
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
      this.ids = selection.map((item) => item.buildingId);
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
      const buildingId = row.buildingId || this.ids;
      getBuilding(buildingId).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改【请填写功能名称】";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (this.form.buildingId != null) {
            updateBuilding(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addBuilding(this.form).then((response) => {
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
      const buildingIds = row.buildingId || this.ids;
      this.$modal
        .confirm(
          '是否确认删除【请填写功能名称】编号为"' + buildingIds + '"的数据项？'
        )
        .then(function () {
          return delBuilding(buildingIds);
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
        "object/building/export",
        {
          ...this.queryParams,
        },
        `building_${new Date().getTime()}.xlsx`
      );
    },
    /** 查看图片 */
    lookPic(e) {
      this.lookPicShow = true;
      this.$nextTick(() => {
        this.$refs.lookPic.address = "localhost/" + e.buildingPic;
      });
      console.log(e);
    },
    save() {
      this.$refs.buildForm.add();
      this.buildFormShow = false;
      this.getList();
    },
    save2() {
      this.lookPicShow = false;
    },
  },
};
</script>
