<template>
    <div class="app-container">
      <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
        <el-form-item label="商品id" prop="goodsId">
          <el-input
            v-model="queryParams.goodsId"
            placeholder="请输入商品id"
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
        <el-form-item label="已兑换" prop="redeemed">
          <el-input
            v-model="queryParams.redeemed"
            placeholder="请输入已兑换"
            clearable
            @keyup.enter.native="handleQuery"
          />
        </el-form-item>
        <el-form-item label="已核销" prop="writtenOff">
          <el-input
            v-model="queryParams.writtenOff"
            placeholder="请输入已核销"
            clearable
            @keyup.enter.native="handleQuery"
          />
        </el-form-item>
        <el-form-item label="待核销" prop="wait">
          <el-input
            v-model="queryParams.wait"
            placeholder="请输入待核销"
            clearable
            @keyup.enter.native="handleQuery"
          />
        </el-form-item>
        <el-form-item label="发放金额" prop="money">
          <el-input
            v-model="queryParams.money"
            placeholder="请输入发放金额"
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
            v-hasPermi="['object:analysis:add']"
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
            v-hasPermi="['object:analysis:edit']"
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
            v-hasPermi="['object:analysis:remove']"
          >删除</el-button>
        </el-col>
        <el-col :span="1.5">
          <el-button
            type="warning"
            plain
            icon="el-icon-download"
            size="mini"
            @click="handleExport"
            v-hasPermi="['object:analysis:export']"
          >导出</el-button>
        </el-col>
        <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
      </el-row>
  
      <el-table v-loading="loading" :data="analysisList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="商品分析id" align="center" prop="analyseId" />
        <el-table-column label="商品id" align="center" prop="goodsId" />
        <el-table-column label="商品名称" align="center" prop="goodsName" />
        <el-table-column label="已兑换" align="center" prop="redeemed" />
        <el-table-column label="已核销" align="center" prop="writtenOff" />
        <el-table-column label="待核销" align="center" prop="wait" />
        <el-table-column label="发放金额" align="center" prop="money" />
        <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
          <template slot-scope="scope">
            <el-button
              size="mini"
              type="text"
              icon="el-icon-edit"
              @click="handleUpdate(scope.row)"
              v-hasPermi="['object:analysis:edit']"
            >修改</el-button>
            <el-button
              size="mini"
              type="text"
              icon="el-icon-delete"
              @click="handleDelete(scope.row)"
              v-hasPermi="['object:analysis:remove']"
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
          <el-form-item label="商品id" prop="goodsId">
            <el-input v-model="form.goodsId" placeholder="请输入商品id" />
          </el-form-item>
          <el-form-item label="商品名称" prop="goodsName">
            <el-input v-model="form.goodsName" placeholder="请输入商品名称" />
          </el-form-item>
          <el-form-item label="已兑换" prop="redeemed">
            <el-input v-model="form.redeemed" placeholder="请输入已兑换" />
          </el-form-item>
          <el-form-item label="已核销" prop="writtenOff">
            <el-input v-model="form.writtenOff" placeholder="请输入已核销" />
          </el-form-item>
          <el-form-item label="待核销" prop="wait">
            <el-input v-model="form.wait" placeholder="请输入待核销" />
          </el-form-item>
          <el-form-item label="发放金额" prop="money">
            <el-input v-model="form.money" placeholder="请输入发放金额" />
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
  import { listAnalysis, getAnalysis, delAnalysis, addAnalysis, updateAnalysis } from "@/api/object/analysis";
  
  export default {
    name: "Analysis",
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
        analysisList: [],
        // 弹出层标题
        title: "",
        // 是否显示弹出层
        open: false,
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          goodsId: null,
          goodsName: null,
          redeemed: null,
          writtenOff: null,
          wait: null,
          money: null
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
        listAnalysis(this.queryParams).then(response => {
          this.analysisList = response.rows;
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
          analyseId: null,
          goodsId: null,
          goodsName: null,
          redeemed: null,
          writtenOff: null,
          wait: null,
          money: null
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
        this.ids = selection.map(item => item.analyseId)
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
        const analyseId = row.analyseId || this.ids
        getAnalysis(analyseId).then(response => {
          this.form = response.data;
          this.open = true;
          this.title = "修改【请填写功能名称】";
        });
      },
      /** 提交按钮 */
      submitForm() {
        this.$refs["form"].validate(valid => {
          if (valid) {
            if (this.form.analyseId != null) {
              updateAnalysis(this.form).then(response => {
                this.$modal.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              });
            } else {
              addAnalysis(this.form).then(response => {
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
        const analyseIds = row.analyseId || this.ids;
        this.$modal.confirm('是否确认删除【请填写功能名称】编号为"' + analyseIds + '"的数据项？').then(function() {
          return delAnalysis(analyseIds);
        }).then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        }).catch(() => {});
      },
      /** 导出按钮操作 */
      handleExport() {
        this.download('object/analysis/export', {
          ...this.queryParams
        }, `analysis_${new Date().getTime()}.xlsx`)
      }
    }
  };
  </script>
  