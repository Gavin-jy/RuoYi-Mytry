<template>
<el-row class="index">
<el-col :span="18"  :key="o" :offset="index > 0 ? 2 : 0">
  <el-card :body-style="{ padding: '0px' }">
    <img src="../assets/images/1.jpg" class="image">
    <div style="padding: 14px;font-weight: bolder" class="text-center" >
      <span>张君逸&高诗杰 | 网上商城后台管理系统</span>
      <div class="bottom clearfix">
        <time class="time">{{ currentDate }}</time>
      </div>
    </div>
  </el-card>
</el-col>
</el-row>
</template>
<script>
export default {
  data() {
    return {
      currentDate: new Date()
    };
  }
}
</script>
<style>
.index{
  display: flex;
  justify-content: space-around;
  margin-top: 30px;
}
.time {
  font-size: 13px;
  color: #999;
}

.bottom {
  margin-top: 13px;
  line-height: 12px;
}


.image {
  width: 100%;
  height: 100%;
  display: block;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both
}
</style>



