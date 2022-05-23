<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="客户id" prop="userId">
        <el-input
          v-model="queryParams.cust_evaluation_id2"
          placeholder="请输入客户的id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="订单编号" prop="custEvaluationOrderkey2">
        <el-input
          v-model="queryParams.custEvaluationOrderkey2"
          placeholder="请输入订单编号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="评价日期" prop="custEvaluationEvadate2">
        <el-date-picker clearable size="small"
          v-model="queryParams.custEvaluationEvadate2"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择评价日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="评价内容" prop="custEvaluationComment2">
        <el-input
          v-model="queryParams.custEvaluationComment2"
          placeholder="请输入评价内容"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商家分数" prop="custEvaluationSuppscore2">
        <el-input
          v-model="queryParams.custEvaluationSuppscore2"
          placeholder="请输入商家分数，0-100"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商品分数" prop="custEvaluationGoodsscore2">
        <el-input
          v-model="queryParams.custEvaluationGoodsscore2"
          placeholder="请输入商品分数，0-100"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="物流分数" prop="custEvaluationDelievryscore2">
        <el-input
          v-model="queryParams.custEvaluationDelievryscore2"
          placeholder="请输入物流分数，0-100"
          clearable
          size="small"
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
          v-hasPermi="['consumer:custevaluation:add']"
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
          v-hasPermi="['consumer:custevaluation:edit']"
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
          v-hasPermi="['consumer:custevaluation:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['consumer:custevaluation:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="custevaluationList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="评价编号" align="center" prop="custEvaluationId2" />
      <el-table-column label="客户id" align="center" prop="userId" />
      <el-table-column label="订单编号" align="center" prop="custEvaluationOrderkey2" />
      <el-table-column label="评价日期" align="center" prop="custEvaluationEvadate2" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.custEvaluationEvadate2, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="评价内容" align="center" prop="custEvaluationComment2" />
      <el-table-column label="商家分数，0-100" align="center" prop="custEvaluationSuppscore2" />
      <el-table-column label="商品分数，0-100" align="center" prop="custEvaluationGoodsscore2" />
      <el-table-column label="物流分数，0-100" align="center" prop="custEvaluationDelievryscore2" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['consumer:custevaluation:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['consumer:custevaluation:remove']"
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

    <!-- 添加或修改我的评价对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="评价编号" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入客户id" />
        </el-form-item>
        <el-form-item label="订单编号" prop="custEvaluationOrderkey2">
          <el-input v-model="form.custEvaluationOrderkey2" placeholder="请输入订单编号" />
        </el-form-item>
        <el-form-item label="评价日期" prop="custEvaluationEvadate2">
          <el-date-picker clearable size="small"
            v-model="form.custEvaluationEvadate2"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择评价日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="评价内容" prop="custEvaluationComment2">
          <el-input v-model="form.custEvaluationComment2" placeholder="请输入评价内容" />
        </el-form-item>
        <el-form-item label="商家分数，0-100" prop="custEvaluationSuppscore2">
          <el-input v-model="form.custEvaluationSuppscore2" placeholder="请输入商家分数，0-100" />
        </el-form-item>
        <el-form-item label="商品分数，0-100" prop="custEvaluationGoodsscore2">
          <el-input v-model="form.custEvaluationGoodsscore2" placeholder="请输入商品分数，0-100" />
        </el-form-item>
        <el-form-item label="物流分数，0-100" prop="custEvaluationDelievryscore2">
          <el-input v-model="form.custEvaluationDelievryscore2" placeholder="请输入物流分数，0-100" />
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
import { listCustevaluation, getCustevaluation, delCustevaluation, addCustevaluation, updateCustevaluation } from "@/api/consumer/custevaluation";

export default {
  name: "Custevaluation",
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
      // 我的评价表格数据
      custevaluationList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userId: null,
        custEvaluationOrderkey2: null,
        custEvaluationEvadate2: null,
        custEvaluationComment2: null,
        custEvaluationSuppscore2: null,
        custEvaluationGoodsscore2: null,
        custEvaluationDelievryscore2: null
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
    /** 查询我的评价列表 */
    getList() {
      this.loading = true;
      listCustevaluation(this.queryParams).then(response => {
        this.custevaluationList = response.rows;
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
        custEvaluationId2: null,
        userId: null,
        custEvaluationOrderkey2: null,
        custEvaluationEvadate2: null,
        custEvaluationComment2: null,
        custEvaluationSuppscore2: null,
        custEvaluationGoodsscore2: null,
        custEvaluationDelievryscore2: null
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
      this.ids = selection.map(item => item.custEvaluationId2)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加我的评价";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const custEvaluationId2 = row.custEvaluationId2 || this.ids
      getCustevaluation(custEvaluationId2).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改我的评价";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.custEvaluationId2 != null) {
            updateCustevaluation(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCustevaluation(this.form).then(response => {
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
      const custEvaluationId2s = row.custEvaluationId2 || this.ids;
      this.$modal.confirm('是否确认删除我的评价编号为"' + custEvaluationId2s + '"的数据项？').then(function() {
        return delCustevaluation(custEvaluationId2s);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('consumer/custevaluation/export', {
        ...this.queryParams
      }, `custevaluation_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
