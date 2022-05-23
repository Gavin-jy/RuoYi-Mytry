<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="物流编号" prop="deliverId">
        <el-input
          v-model="queryParams.deliverId"
          placeholder="请输入评价的物流编号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="评价日期 " prop="logisticsEvaluationEvadite2">
        <el-date-picker clearable size="small"
          v-model="queryParams.logisticsEvaluationEvadite2"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择评价日期 ">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="评价内容" prop="logisticsEvaluationComment2">
        <el-input
          v-model="queryParams.logisticsEvaluationComment2"
          placeholder="请输入评价内容"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="分数" prop="logisticsEvaluationScore2">
        <el-input
          v-model="queryParams.logisticsEvaluationScore2"
          placeholder="请输入分数"
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
          v-hasPermi="['manage:deliverevaluation:add']"
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
          v-hasPermi="['manage:deliverevaluation:edit']"
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
          v-hasPermi="['manage:deliverevaluation:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['manage:deliverevaluation:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="deliverevaluationList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="评价编号" align="center" prop="logisticsEvaluationId2" />
      <el-table-column label="评价的物流编号" align="center" prop="deliverId" />
      <el-table-column label="评价日期 " align="center" prop="logisticsEvaluationEvadite2" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.logisticsEvaluationEvadite2, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="评价内容" align="center" prop="logisticsEvaluationComment2" />
      <el-table-column label="分数" align="center" prop="logisticsEvaluationScore2" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['manage:deliverevaluation:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['manage:deliverevaluation:remove']"
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

    <!-- 添加或修改系统物流评价对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="评价的物流编号" prop="deliverId">
          <el-input v-model="form.deliverId" placeholder="请输入评价的物流编号" />
        </el-form-item>
        <el-form-item label="评价日期 " prop="logisticsEvaluationEvadite2">
          <el-date-picker clearable size="small"
            v-model="form.logisticsEvaluationEvadite2"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择评价日期 ">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="评价内容" prop="logisticsEvaluationComment2">
          <el-input v-model="form.logisticsEvaluationComment2" placeholder="请输入评价内容" />
        </el-form-item>
        <el-form-item label="分数" prop="logisticsEvaluationScore2">
          <el-input v-model="form.logisticsEvaluationScore2" placeholder="请输入分数" />
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
import { listDeliverevaluation, getDeliverevaluation, delDeliverevaluation, addDeliverevaluation, updateDeliverevaluation } from "@/api/manage/deliverevaluation";

export default {
  name: "Deliverevaluation",
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
      // 系统物流评价表格数据
      deliverevaluationList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        deliverId: null,
        logisticsEvaluationEvadite2: null,
        logisticsEvaluationComment2: null,
        logisticsEvaluationScore2: null
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
    /** 查询系统物流评价列表 */
    getList() {
      this.loading = true;
      listDeliverevaluation(this.queryParams).then(response => {
        this.deliverevaluationList = response.rows;
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
        logisticsEvaluationId2: null,
        deliverId: null,
        logisticsEvaluationEvadite2: null,
        logisticsEvaluationComment2: null,
        logisticsEvaluationScore2: null
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
      this.ids = selection.map(item => item.logisticsEvaluationId2)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加系统物流评价";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const logisticsEvaluationId2 = row.logisticsEvaluationId2 || this.ids
      getDeliverevaluation(logisticsEvaluationId2).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改系统物流评价";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.logisticsEvaluationId2 != null) {
            updateDeliverevaluation(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addDeliverevaluation(this.form).then(response => {
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
      const logisticsEvaluationId2s = row.logisticsEvaluationId2 || this.ids;
      this.$modal.confirm('是否确认删除系统物流评价编号为"' + logisticsEvaluationId2s + '"的数据项？').then(function() {
        return delDeliverevaluation(logisticsEvaluationId2s);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('manage/deliverevaluation/export', {
        ...this.queryParams
      }, `deliverevaluation_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
