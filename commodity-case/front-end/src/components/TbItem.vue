<template>
  <div>
    <el-table
      :data="tableData"
      border
      style="width: 100%">
      <el-table-column
        prop="id"
        label="编号">
      </el-table-column>
      <el-table-column
        prop="title"
        label="标题">
      </el-table-column>
      <el-table-column
        prop="sellPoint"
        label="卖点">
      </el-table-column>
      <el-table-column
        prop="price"
        label="价格">
      </el-table-column>
      <el-table-column
        prop="num"
        label="库存">
      </el-table-column>
      <el-table-column
        prop="barcode"
        label="条形码">
      </el-table-column>
      <el-table-column
        prop="image"
        label="图片">
      </el-table-column>
      <el-table-column
        prop="cid"
        label="所属类目">
      </el-table-column>
      <el-table-column
        prop="status"
        label="状态"
        :formatter="statusFormat">
        <!--        <template slot-scope="scope">-->
        <!--          <p v-if="scope.row.status === 1">我还活着</p>-->
        <!--          <p v-else>我没了</p>-->
        <!--        </template>-->
      </el-table-column>
      <el-table-column
        prop="created"
        label="创建时间">
      </el-table-column>
      <el-table-column
        prop="updated"
        label="更新时间">
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button
            size="mini"
            @click="handleEdit(scope.$index, scope.row)">修改
          </el-button>
          <el-popconfirm
            confirmButtonText='好的'
            cancelButtonText='不用了'
            icon="el-icon-info"
            iconColor="red"
            title="确定要删除吗？"
            @onConfirm="handleDelete(scope.$index, scope.row)">
            <el-button slot="reference"
                       size="mini"
                       type="danger">删除
            </el-button>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="findSize"
      @current-change="findPage"
      :current-page.sync="current"
      :page-size="size"
      layout="prev, pager, next, jumper"
      :total="total">
    </el-pagination>
    <el-button style="margin-top: 10px" type="primary" @click="show">展示与隐藏</el-button>
    <el-input style="width: 300px"
              @blur="findIt"
              v-model="search"
              size="mini"
              placeholder="输入标题查询"/>
    <el-input style="width: 300px"
              @blur="findBySell"
              v-model="point"
              size="mini"
              placeholder="输入卖点查询"/>
    <div style="display: flex; margin-top: 20px; height: 100px;">
      <transition name="el-zoom-in-center">
        <div v-show="show2" class="transition-box">
          <el-form :label-position="labelPosition" label-width="80px" :model="formLabelAlign">
            <el-form-item label="标题">
              <el-input v-model="formLabelAlign.title"></el-input>
            </el-form-item>
            <el-form-item label="卖点">
              <el-input v-model="formLabelAlign.sellPoint"></el-input>
            </el-form-item>
            <el-form-item label="价格">
              <el-input v-model="formLabelAlign.price"></el-input>
            </el-form-item>
            <el-form-item label="库存">
              <el-input v-model="formLabelAlign.num"></el-input>
            </el-form-item>
            <el-form-item label="条形码">
              <el-input v-model="formLabelAlign.barcode"></el-input>
            </el-form-item>
            <el-form-item label="图片">
              <el-input v-model="formLabelAlign.image"></el-input>
            </el-form-item>
            <el-form-item label="所属类目">
              <el-input v-model="formLabelAlign.cid"></el-input>
            </el-form-item>
            <el-form-item label="商品状态">
              <el-input v-model="formLabelAlign.status"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="submitForm">立即创建</el-button>
              <el-button @click="resetForm('ruleForm')">重置</el-button>
            </el-form-item>
          </el-form>
        </div>
      </transition>
    </div>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        total: 0,
        point: '',
        size: 4,
        current: 1,
        search: '',
        show2: false,
        tableData: [],
        labelPosition: 'right',
        formLabelAlign: {
          title: '',
          sellPoint: '',
          price: '',
          num: '',
          barcode: '',
          image: '',
          cid: '',
          status: '',
        }
      }
    },
    //在组件创建之前发送axios请求
    created() {
      this.findAll()
    },
    methods: {
      statusFormat(row) {
        if (row.status == 1) {
          return '我还活着'
        } else {
          return '我没了'
        }
        // return row.status==1?'我还活着':'我没了'
      },
      findSize(size) {
        this.size = size
        this.findAll()
      },
      findPage(current) {
        this.current = current
        this.findAll()
      },
      //查询所有
      findAll() {
        this.$axios.get(`http://localhost:10110/service-consumer/TbItem/findAll/${this.current}/${this.size}?token=123`).then(res => {
          console.log(res.data)
          this.tableData = res.data.tbItems
          // alert(this.status)
          if (this.tableData.status == '1') {
            this.tableData.status = '我还活着'
          } else {
            this.tableData.status = '我没了'
          }
          this.total = res.data.total
        })
      },
      //根据卖点查询
      findBySell() {
        if (this.point == null || this.point == []) {
          this.findAll()
        } else {
          console.log(this.point)
          this.tableData = []
          this.$axios.get(`http://localhost:10110/service-consumer/TbItem/findByPoint/${this.point}?token=xxx`).then(res => {
            this.tableData = res.data
          })
        }
      },
      findIt() {
        if (this.search == null || this.search == []) {
          this.findAll()
        } else {
          this.tableData = []
          this.$axios.get(`http://localhost:10110/service-consumer/TbItem/findOne/${this.search}?token=xxx`).then(res => {
            this.tableData = res.data
          })
        }
      },
      show() {
        this.formLabelAlign = {}
        this.show2 = !this.show2
      },
      handleEdit(index, row) {
        console.log(index, row);
        this.show2 = true
        this.formLabelAlign = row
      },
      handleDelete(index, row) {
        console.log(index, row);
        this.$axios.get(`http://localhost:10110/service-consumer/TbItem/delete/${row.id}?token=123`).then(value => {
          if (value) {
            alert('submit!');
          } else {
            console.log('error submit!!');
            return false;
          }
        })
      },
      submitForm(row) {
        console.log(row)
        console.log(this.formLabelAlign)
        this.$axios.post(`http://localhost:10110/service-consumer/TbItem/insertOrUpdate?token=123`, this.formLabelAlign).then((valid) => {
          if (valid) {
            alert('submit!');
          } else {
            console.log('error submit!!');
            return false;
          }
        });

      },
      resetForm() {
        this.formLabelAlign = {};
      },
    },
    name: "TbItem"
  }
</script>

<style scoped>
  .transition-box {
    margin-bottom: 10px;
    width: 100%;
    height: 400px;
    border-radius: 4px;
    /*background-color: #409EFF;*/
    text-align: center;
    /*color: #fff;*/
    padding: 40px 20px;
    box-sizing: border-box;
    margin-right: 20px;
  }
</style>
