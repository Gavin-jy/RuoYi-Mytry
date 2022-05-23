<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="物流编号" prop="deliverId">
        <el-input
          v-model="queryParams.deliverId"
          placeholder="请输入物流编号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="退货标记" prop="deliveryOrderReturnflag2">
        <el-input
          v-model="queryParams.deliveryOrderReturnflag2"
          placeholder="请输入退货标记，0表示未退货，1表示退货"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="发货地址" prop="deliveryOrderDeliveryadd2">
        <el-input
          v-model="queryParams.deliveryOrderDeliveryadd2"
          placeholder="请输入发货地址"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="发货状态" prop="deliveryOrderDeliverystatus2">
        <el-input
          v-model="queryParams.deliveryOrderDeliverystatus2"
          placeholder="请输入发货状态，0表示未发货，1表示已发货"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="发货日期" prop="deliveryOrderDeliverydate2">
        <el-date-picker clearable size="small"
          v-model="queryParams.deliveryOrderDeliverydate2"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择发货日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="运输方式" prop="deliveryOrderShiptype2">
        <el-input
          v-model="queryParams.deliveryOrderShiptype2"
          placeholder="请输入运输方式"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="签收地址" prop="deliveryOrderReceiptadd2">
        <el-input
          v-model="queryParams.deliveryOrderReceiptadd2"
          placeholder="请输入签收地址"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="签收状态" prop="deliveryOrderReceiptstatus2">
        <el-input
          v-model="queryParams.deliveryOrderReceiptstatus2"
          placeholder="请输入签收状态"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="签收日期" prop="deliveryOrderReceiptdate2">
        <el-date-picker clearable size="small"
          v-model="queryParams.deliveryOrderReceiptdate2"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择签收日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="总运费" prop="deliveryOrderShipprice2">
        <el-input
          v-model="queryParams.deliveryOrderShipprice2"
          placeholder="请输入总运费"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="总运输时间" prop="deliveryOrderShiptime2">
        <el-date-picker clearable size="small"
          v-model="queryParams.deliveryOrderShiptime2"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择总运输时间">
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
          v-hasPermi="['manage:deliveryorder:add']"
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
          v-hasPermi="['manage:deliveryorder:edit']"
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
          v-hasPermi="['manage:deliveryorder:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['manage:deliveryorder:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="deliveryorderList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="物流订单编号" align="center" prop="deliverId" />
      <el-table-column label="退货标记，0表示未退货，1表示退货" align="center" prop="deliveryOrderReturnflag2" />
      <el-table-column label="发货地址" align="center" prop="deliveryOrderDeliveryadd2" />
      <el-table-column label="发货状态，0表示未发货，1表示已发货" align="center" prop="deliveryOrderDeliverystatus2" />
      <el-table-column label="发货日期" align="center" prop="deliveryOrderDeliverydate2" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.deliveryOrderDeliverydate2, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="运输方式" align="center" prop="deliveryOrderShiptype2" />
      <el-table-column label="签收地址" align="center" prop="deliveryOrderReceiptadd2" />
      <el-table-column label="签收状态，0表示未签收，1表示已签收" align="center" prop="deliveryOrderReceiptstatus2" />
      <el-table-column label="签收日期" align="center" prop="deliveryOrderReceiptdate2" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.deliveryOrderReceiptdate2, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="总运费" align="center" prop="deliveryOrderShipprice2" />
      <el-table-column label="总运输时间" align="center" prop="deliveryOrderShiptime2" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.deliveryOrderShiptime2, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['manage:deliveryorder:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['manage:deliveryorder:remove']"
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

    <!-- 添加或修改物流订单对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="${comment}" prop="deliverId">
          <el-input v-model="form.deliverId" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="退货标记，0表示未退货，1表示退货" prop="deliveryOrderReturnflag2">
          <el-input v-model="form.deliveryOrderReturnflag2" placeholder="请输入退货标记，0表示未退货，1表示退货" />
        </el-form-item>
        <el-form-item label="发货地址" prop="deliveryOrderDeliveryadd2">
          <el-input v-model="form.deliveryOrderDeliveryadd2" placeholder="请输入发货地址" />
        </el-form-item>
        <el-form-item label="发货状态，0表示未发货，1表示已发货" prop="deliveryOrderDeliverystatus2">
          <el-input v-model="form.deliveryOrderDeliverystatus2" placeholder="请输入发货状态，0表示未发货，1表示已发货" />
        </el-form-item>
        <el-form-item label="发货日期" prop="deliveryOrderDeliverydate2">
          <el-date-picker clearable size="small"
            v-model="form.deliveryOrderDeliverydate2"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择发货日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="运输方式" prop="deliveryOrderShiptype2">
          <el-input v-model="form.deliveryOrderShiptype2" placeholder="请输入运输方式" />
        </el-form-item>
        <el-form-item label="签收地址" prop="deliveryOrderReceiptadd2">
          <el-input v-model="form.deliveryOrderReceiptadd2" placeholder="请输入签收地址" />
        </el-form-item>
        <el-form-item label="签收状态，0表示未签收，1表示已签收" prop="deliveryOrderReceiptstatus2">
          <el-input v-model="form.deliveryOrderReceiptstatus2" placeholder="请输入签收状态，0表示未签收，1表示已签收" />
        </el-form-item>
        <el-form-item label="签收日期" prop="deliveryOrderReceiptdate2">
          <el-date-picker clearable size="small"
            v-model="form.deliveryOrderReceiptdate2"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择签收日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="总运费" prop="deliveryOrderShipprice2">
          <el-input v-model="form.deliveryOrderShipprice2" placeholder="请输入总运费" />
        </el-form-item>
        <el-form-item label="总运输时间" prop="deliveryOrderShiptime2">
          <el-date-picker clearable size="small"
            v-model="form.deliveryOrderShiptime2"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择总运输时间">
          </el-date-picker>
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
import { listDeliveryorder, getDeliveryorder, delDeliveryorder, addDeliveryorder, updateDeliveryorder } from "@/api/manage/deliveryorder";

export default {
  name: "Deliveryorder",
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
      // 物流订单表格数据
      deliveryorderList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        deliverId: null,
        deliveryOrderReturnflag2: null,
        deliveryOrderDeliveryadd2: null,
        deliveryOrderDeliverystatus2: null,
        deliveryOrderDeliverydate2: null,
        deliveryOrderShiptype2: null,
        deliveryOrderReceiptadd2: null,
        deliveryOrderReceiptstatus2: null,
        deliveryOrderReceiptdate2: null,
        deliveryOrderShipprice2: null,
        deliveryOrderShiptime2: null
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
    /** 查询物流订单列表 */
    getList() {
      this.loading = true;
      listDeliveryorder(this.queryParams).then(response => {
        this.deliveryorderList = response.rows;
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
        deliveryOrderId3: null,
        deliverId: null,
        deliveryOrderReturnflag2: null,
        deliveryOrderDeliveryadd2: null,
        deliveryOrderDeliverystatus2: null,
        deliveryOrderDeliverydate2: null,
        deliveryOrderShiptype2: null,
        deliveryOrderReceiptadd2: null,
        deliveryOrderReceiptstatus2: null,
        deliveryOrderReceiptdate2: null,
        deliveryOrderShipprice2: null,
        deliveryOrderShiptime2: null
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
      this.ids = selection.map(item => item.deliveryOrderId3)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加物流订单";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const deliveryOrderId3 = row.deliveryOrderId3 || this.ids
      getDeliveryorder(deliveryOrderId3).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改物流订单";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.deliveryOrderId3 != null) {
            updateDeliveryorder(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addDeliveryorder(this.form).then(response => {
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
      const deliveryOrderId3s = row.deliveryOrderId3 || this.ids;
      this.$modal.confirm('是否确认删除物流订单编号为"' + deliveryOrderId3s + '"的数据项？').then(function() {
        return delDeliveryorder(deliveryOrderId3s);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('manage/deliveryorder/export', {
        ...this.queryParams
      }, `deliveryorder_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
