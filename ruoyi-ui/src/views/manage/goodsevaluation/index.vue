<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="商品编号" prop="productId">
        <el-input
          v-model="queryParams.productId"
          placeholder="请输入商品编号id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商家编号" prop="goodsEvaluationGoodskey2">
        <el-input
          v-model="queryParams.goodsEvaluationGoodskey2"
          placeholder="请输入商家编号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="评价日期" prop="goodsEvaluationEvedate2">
        <el-date-picker clearable size="small"
          v-model="queryParams.goodsEvaluationEvedate2"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择评价日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="评价内容" prop="goodsEvaluationComment2">
        <el-input
          v-model="queryParams.goodsEvaluationComment2"
          placeholder="请输入评价内容"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="总分数" prop="goodsEvaluationScore2">
        <el-input
          v-model="queryParams.goodsEvaluationScore2"
          placeholder="请输入总分数"
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
          v-hasPermi="['manage:goodsevaluation:add']"
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
          v-hasPermi="['manage:goodsevaluation:edit']"
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
          v-hasPermi="['manage:goodsevaluation:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['manage:goodsevaluation:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="goodsevaluationList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="评价编号" align="center" prop="goodsEvaluationId2" />
      <el-table-column label="商品编号id" align="center" prop="productId" />
      <el-table-column label="商家编号" align="center" prop="goodsEvaluationGoodskey2" />
      <el-table-column label="评价日期" align="center" prop="goodsEvaluationEvedate2" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.goodsEvaluationEvedate2, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="评价内容" align="center" prop="goodsEvaluationComment2" />
      <el-table-column label="总分数" align="center" prop="goodsEvaluationScore2" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['manage:goodsevaluation:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['manage:goodsevaluation:remove']"
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

    <!-- 添加或修改系统商品评价对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="商品编号id" prop="productId">
          <el-input v-model="form.productId" placeholder="请输入商品编号id" />
        </el-form-item>
        <el-form-item label="商品编号" prop="goodsEvaluationGoodskey2">
          <el-input v-model="form.goodsEvaluationGoodskey2" placeholder="请输入商品编号" />
        </el-form-item>
        <el-form-item label="评价日期" prop="goodsEvaluationEvedate2">
          <el-date-picker clearable size="small"
            v-model="form.goodsEvaluationEvedate2"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择评价日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="评价内容" prop="goodsEvaluationComment2">
          <el-input v-model="form.goodsEvaluationComment2" placeholder="请输入评价内容" />
        </el-form-item>
        <el-form-item label="总分数" prop="goodsEvaluationScore2">
          <el-input v-model="form.goodsEvaluationScore2" placeholder="请输入总分数" />
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
import { listGoodsevaluation, getGoodsevaluation, delGoodsevaluation, addGoodsevaluation, updateGoodsevaluation } from "@/api/manage/goodsevaluation";

export default {
  name: "Goodsevaluation",
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
      // 系统商品评价表格数据
      goodsevaluationList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        productId: null,
        goodsEvaluationGoodskey2: null,
        goodsEvaluationEvedate2: null,
        goodsEvaluationComment2: null,
        goodsEvaluationScore2: null
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
    /** 查询系统商品评价列表 */
    getList() {
      this.loading = true;
      listGoodsevaluation(this.queryParams).then(response => {
        this.goodsevaluationList = response.rows;
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
        goodsEvaluationId2: null,
        productId: null,
        goodsEvaluationGoodskey2: null,
        goodsEvaluationEvedate2: null,
        goodsEvaluationComment2: null,
        goodsEvaluationScore2: null
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
      this.ids = selection.map(item => item.goodsEvaluationId2)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加系统商品评价";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const goodsEvaluationId2 = row.goodsEvaluationId2 || this.ids
      getGoodsevaluation(goodsEvaluationId2).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改系统商品评价";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.goodsEvaluationId2 != null) {
            updateGoodsevaluation(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addGoodsevaluation(this.form).then(response => {
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
      const goodsEvaluationId2s = row.goodsEvaluationId2 || this.ids;
      this.$modal.confirm('是否确认删除系统商品评价编号为"' + goodsEvaluationId2s + '"的数据项？').then(function() {
        return delGoodsevaluation(goodsEvaluationId2s);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('manage/goodsevaluation/export', {
        ...this.queryParams
      }, `goodsevaluation_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
