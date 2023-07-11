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
      <el-form-item label="主题" prop="topic">
        <el-input
          v-model="queryParams.topic"
          placeholder="请输入主题"
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
          v-hasPermi="['object:sponsor:add']"
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
          v-hasPermi="['object:sponsor:edit']"
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
          v-hasPermi="['object:sponsor:remove']"
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
          v-hasPermi="['object:sponsor:export']"
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
      :data="sponsorList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="活动赞助方id" align="center" prop="sponsorId" />
      <el-table-column label="主题" align="center" prop="topic" />
      <el-table-column label="图片" align="center" prop="pic" />
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
            v-hasPermi="['object:sponsor:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['object:sponsor:remove']"
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
        <el-form-item label="主题" prop="topic">
          <el-input v-model="form.topic" placeholder="请输入主题" />
        </el-form-item>

        <el-form-item label="赞助图片" prop="picture"> </el-form-item>
      </el-form>
      <el-upload
        class="tip"
        accept=".png,.jpg,.jpeg,.PNG,.JPG,.JPEG"
        action=""
        :file-list="fileList"
        :on-success="onSuccess"
        :http-request="uploadImg"
        list-type="picture-card"
      >
        <i class="el-icon-plus"></i>
      </el-upload>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { uploads } from "@/api/object/uploads.js";
import {
  listSponsor,
  getSponsor,
  delSponsor,
  addSponsor,
  updateSponsor,
} from "@/api/object/sponsor";

export default {
  name: "Sponsor",
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
      // 表格数据
      sponsorList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 图片数组
      fileList: [],
      sponsorPic: [],
      sponsorInfo: {
        topic: "",
        pic: "",
      },
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        topic: null,
        pic: null,
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
    add() {},
    /** 查询【请填写功能名称】列表 */
    getList() {
      this.loading = true;
      listSponsor(this.queryParams).then((response) => {
        this.sponsorList = response.rows;
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
        sponsorId: null,
        topic: null,
        pic: null,
      };
      this.sponsorPic.length = 0;
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
      this.ids = selection.map((item) => item.sponsorId);
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
      const sponsorId = row.sponsorId || this.ids;
      getSponsor(sponsorId).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改【请填写功能名称】";
      });
    },
    /** 提交按钮 */
    submitForm() {
      let self = this;
      this.$refs["form"].validate((valid) => {
        if (valid) {
          let e = this.sponsorPic.join(",");
          console.log(e);
          this.form.pic = e;
          console.log(this.form);
          if (this.form.sponsorId != null) {
            updateSponsor(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addSponsor(this.form).then((response) => {
              this.open = false;
              this.$modal.msgSuccess("新增成功");

              this.fileList = [];
              this.sponsorPic = [];
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const sponsorIds = row.sponsorId || this.ids;
      this.$modal
        .confirm(
          '是否确认删除【请填写功能名称】编号为"' + sponsorIds + '"的数据项？'
        )
        .then(function () {
          return delSponsor(sponsorIds);
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
        "object/sponsor/export",
        {
          ...this.queryParams,
        },
        `sponsor_${new Date().getTime()}.xlsx`
      );
    },
    // 上传文件方法
    uploadImg(param) {
      let self = this;
      let formData = new FormData();
      formData.append("file", param.file);
      uploads(formData).then((res) => {
        console.log(res);
        self.sponsorPic.push("/profile/upload/" + res);
      });
    },
    // 图片上传成功后
    onSuccess(response, file, fileList) {
      file.sponsor_id = response.sponsor_id;
      this.fileList.push(file);
    },
    add() {
      let e = this.sponsorPic.join(",");
      let param = JSON.parse(JSON.stringify(this.sponsorInfo));
      param.sponsorPic = e;
      console.log(param);
      addBuilding(param).then((res) => {
        console.log(res);
      });
    },
  },
};
</script>
