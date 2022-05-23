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
      <el-form-item label="订单时间" prop="myorderTime">
        <el-date-picker clearable size="small"
          v-model="queryParams.myorderTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择订单发生时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="商品id" prop="myorderBookid">
        <el-input
          v-model="queryParams.myorderBookid"
          placeholder="请输入订单订购的书的id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="订单状态" prop="myorderSituation">
        <el-input
          v-model="queryParams.myorderSituation"
          placeholder="待付款为0，待收货为1，待评价为2"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="订购数目" prop="myorderNumber">
        <el-input
          v-model="queryParams.myorderNumber"
          placeholder="请输入订购的数目"
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
          v-hasPermi="['consumer:myorder:add']"
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
          v-hasPermi="['consumer:myorder:edit']"
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
          v-hasPermi="['consumer:myorder:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['consumer:myorder:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="myorderList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="订单编号" align="center" prop="myorderId" />
      <el-table-column label="客户id" align="center" prop="userId" />
      <el-table-column label="订单时间" align="center" prop="myorderTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.myorderTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="商品id" align="center" prop="myorderBookid" />
      <el-table-column label="订单状态" align="center" prop="myorderSituation" />
      <el-table-column label="订购数目" align="center" prop="myorderNumber" />
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
            v-hasPermi="['consumer:myorder:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['consumer:myorder:remove']"
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

    <!-- 添加或修改我的订单对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="客户id" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入客户id" />
        </el-form-item>
        <el-form-item label="订单发生时间" prop="myorderTime">
          <el-date-picker clearable size="small"
            v-model="form.myorderTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择订单发生时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="订单订购的书的id" prop="myorderBookid">
          <el-input v-model="form.myorderBookid" placeholder="请输入订单订购的书的id" />
        </el-form-item>
        <el-form-item label="订单的状态，待付款为0，待收货为1，待评价为2" prop="myorderSituation">
          <el-input v-model="form.myorderSituation" placeholder="请输入订单的状态，待付款为0，待收货为1，待评价为2" />
        </el-form-item>
        <el-form-item label="订购的数目" prop="myorderNumber">
          <el-input v-model="form.myorderNumber" placeholder="请输入订购的数目" />
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
import { listMyorder, getMyorder, delMyorder, addMyorder, updateMyorder } from "@/api/consumer/myorder";

export default {
  name: "Myorder",
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
      // 我的订单表格数据
      myorderList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userId: null,
        myorderTime: null,
        myorderBookid: null,
        myorderSituation: null,
        myorderNumber: null,
        creatime: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        myorderTime: [
          { required: true, message: "订单发生时间不能为空", trigger: "blur" }
        ],
        myorderBookid: [
          { required: true, message: "订单订购的书的id不能为空", trigger: "blur" }
        ],
        myorderSituation: [
          { required: true, message: "订单的状态，待付款为0，待收货为1，待评价为2不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询我的订单列表 */
    getList() {
      this.loading = true;
      listMyorder(this.queryParams).then(response => {
        this.myorderList = response.rows;
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
        myorderId: null,
        userId: null,
        myorderTime: null,
        myorderBookid: null,
        myorderSituation: null,
        myorderNumber: null,
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
      this.ids = selection.map(item => item.myorderId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加我的订单";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const myorderId = row.myorderId || this.ids
      getMyorder(myorderId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改我的订单";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.myorderId != null) {
            updateMyorder(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addMyorder(this.form).then(response => {
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
      const myorderIds = row.myorderId || this.ids;
      this.$modal.confirm('是否确认删除我的订单编号为"' + myorderIds + '"的数据项？').then(function() {
        return delMyorder(myorderIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('consumer/myorder/export', {
        ...this.queryParams
      }, `myorder_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
