<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="客户id" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入客户id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="收藏店铺的id" prop="mycollectStoreId">
        <el-input
          v-model="queryParams.mycollectStoreId"
          placeholder="请输入收藏店铺的id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="收藏书籍的id" prop="mycollectBookId">
        <el-input
          v-model="queryParams.mycollectBookId"
          placeholder="请输入收藏书籍的id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建时间" prop="creatime">
        <el-date-picker clearable size="small"
          v-model="queryParams.creatime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择创建时间">
        </el-date-picker>
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
          v-hasPermi="['consumer:mycollect:add']"
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
          v-hasPermi="['consumer:mycollect:edit']"
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
          v-hasPermi="['consumer:mycollect:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['consumer:mycollect:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="mycollectList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="收藏列表编号id" align="center" prop="mycollectId" />
      <el-table-column label="客户id" align="center" prop="userId" />
      <el-table-column label="收藏的类型" align="center" prop="mycollectType" />
      <el-table-column label="收藏店铺的id" align="center" prop="mycollectStoreId" />
      <el-table-column label="收藏书籍的id" align="center" prop="mycollectBookId" />
      <el-table-column label="创建时间" align="center" prop="creatime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.creatime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['consumer:mycollect:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['consumer:mycollect:remove']"
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

    <!-- 添加或修改我的收藏对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="客户id" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入客户id" />
        </el-form-item>
        <el-form-item label="收藏店铺的id" prop="mycollectStoreId">
          <el-input v-model="form.mycollectStoreId" placeholder="请输入收藏店铺的id" />
        </el-form-item>
        <el-form-item label="收藏书籍的id" prop="mycollectBookId">
          <el-input v-model="form.mycollectBookId" placeholder="请输入收藏书籍的id" />
        </el-form-item>
        <el-form-item label="创建时间" prop="creatime">
          <el-date-picker clearable size="small"
            v-model="form.creatime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择创建时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="删除标记" prop="delFlag">
          <el-input v-model="form.delFlag" placeholder="请输入删除标记" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注" />
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
import { listMycollect, getMycollect, delMycollect, addMycollect, updateMycollect } from "@/api/consumer/mycollect";

export default {
  name: "Mycollect",
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
      // 我的收藏表格数据
      mycollectList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userId: null,
        mycollectType: null,
        mycollectStoreId: null,
        mycollectBookId: null,
        creatime: null,
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
    /** 查询我的收藏列表 */
    getList() {
      this.loading = true;
      listMycollect(this.queryParams).then(response => {
        this.mycollectList = response.rows;
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
        mycollectId: null,
        userId: null,
        mycollectType: null,
        mycollectStoreId: null,
        mycollectBookId: null,
        creatime: null,
        createBy: null,
        updateTime: null,
        updateBy: null,
        delFlag: null,
        remark: null
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
      this.ids = selection.map(item => item.mycollectId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加我的收藏";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const mycollectId = row.mycollectId || this.ids
      getMycollect(mycollectId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改我的收藏";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.mycollectId != null) {
            updateMycollect(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addMycollect(this.form).then(response => {
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
      const mycollectIds = row.mycollectId || this.ids;
      this.$modal.confirm('是否确认删除我的收藏编号为"' + mycollectIds + '"的数据项？').then(function() {
        return delMycollect(mycollectIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('consumer/mycollect/export', {
        ...this.queryParams
      }, `mycollect_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
