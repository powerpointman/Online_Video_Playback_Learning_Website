<template>
    <div class="app-conrainer">
        讲师表单

        <!--查询表单-->
    <el-form :inline="true" class="demo-form-inline">
      <el-form-item>
        <el-input v-model="teacherQuery.name" placeholder="Name"/>
      </el-form-item>

      <el-form-item>
        <el-select v-model="teacherQuery.level" clearable placeholder="Title of Lecturer">
          <el-option :value="1" label="Senior Lecturer"/>
          <el-option :value="2" label="Principal Lecturer"/>
        </el-select>
      </el-form-item>

      <el-form-item label="Add time">
        <el-date-picker
          v-model="teacherQuery.begin"
          type="datetime"
          placeholder="StartTime"
          value-format="yyyy-MM-dd HH:mm:ss"
          default-time="00:00:00"
        />
      </el-form-item>
      <el-form-item>
        <el-date-picker
          v-model="teacherQuery.end"
          type="datetime"
          placeholder="EndTime"
          value-format="yyyy-MM-dd HH:mm:ss"
          default-time="00:00:00"
        />
      </el-form-item>

      <el-button type="primary" icon="el-icon-search" @click="getTeacherListPage()">Search</el-button>
      <el-button type="default" @click="resetData()">Emptying</el-button>
    </el-form>
         <!-- 表格 -->
    <el-table
      :data="list"
      border
      fit
      highlight-current-row>

      <el-table-column
        label="序号"
        width="70"
        align="center">
        <template slot-scope="scope">
          {{ (page - 1) * limit + scope.$index + 1 }}
        </template>
      </el-table-column>

      

      <el-table-column prop="name" label="Name" width="80" />

      <el-table-column label="Title" width="80">
        <template slot-scope="scope">
          {{ scope.row.level===1?'Senior Lecturer':'Principal Lecturer' }}
        </template>
      </el-table-column>

      <el-table-column prop="intro" label="Qualifications" />

      <el-table-column prop="gmtCreate" label="AddTime" width="160"/>

      <el-table-column prop="sort" label="Sort" width="60" />

      <el-table-column label="Opreation" width="200" align="center">
        <template slot-scope="scope">
          <router-link :to="'/teacher/edit/'+scope.row.id">
            <el-button type="primary" size="mini" icon="el-icon-edit">Modify</el-button>
          </router-link>
          <el-button type="danger" size="mini" icon="el-icon-delete" @click="removeDataById(scope.row.id)">Delete</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- 分页 -->
    <el-pagination
      :current-page="page"
      :page-size="limit"
      :total="total"
      style="padding: 30px 0; text-align: center;"
      layout="total, prev, pager, next, jumper"
      @current-change="getTeacherListPage"
    />

    
    </div>
</template>
<script>
import teacher from '@/api/edu/teacher.js'
export default {
    //核心代码位置
   
   data(){
    return{
        list:null,
        page:1,
        limit:3,
        total:0,
        teacherQuery:{}
    }
   },
    created(){
        this.getTeacherListPage()
    },
    methods:{
        getTeacherListPage(page=1){
          this.page = page
            teacher.getTeacherListPage(this.page,this.limit,this.teacherQuery)
            .then(response =>{
                //console.log(response)
                this.list = response.data.rows
                this.total = response.data.total
                console.log(this.list) 
                console.log(this.total)
            })
            .catch(error =>{console.log(error)
            })
        },

        resetData(){
          //表单输入项清空
          this.teacherQuery = {}
          //查询所有讲师数据
          this.getTeacherListPage()
        },

        removeDataById(id) {
            this.$confirm('此操作将永久删除讲师记录, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {  //点击确定，执行then方法
                //调用删除的方法
                teacher.deleteTeacher(id)
                    .then( response=>{//删除成功
                    //提示信息
                    this.$message({
                        type: 'success',
                        message: '删除成功!'
                    });
                    //回到列表页面
                    this.getTeacherListPage()
                })
            }) //点击取消，执行catch方法
        }

        
    }


}
</script>