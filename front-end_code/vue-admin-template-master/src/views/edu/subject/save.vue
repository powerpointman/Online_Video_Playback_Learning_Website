<template>
  <div class="app-container">
    <el-form label-width="120px">
      <el-form-item label="Information">
        <el-tag type="info">excel model explain</el-tag>
        <el-tag>
          <i class="el-icon-download"/>
          <a :href="'/static/Subject.xlsx'">upload module</a>
        </el-tag>

      </el-form-item>

      <el-form-item label="Choose Excel">
        <el-upload
          ref="upload"
          :auto-upload="false"
          :on-success="fileUploadSuccess"
          :on-error="fileUploadError"
          :disabled="importBtnDisabled"
          :limit="1"
          :action="BASE_API+'/eduservice/edu-subject/addSubject'"
          name="file"
          accept="application/vnd.ms-excel">
          <el-button slot="trigger" size="small" type="primary">Select doucument</el-button>
          <el-button
            :loading="loading"
            style="margin-left: 10px;"
            size="small"
            type="success"
            @click="submitUpload">Upload Server</el-button>
        </el-upload>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
export default {
    data() {
        return {
            BASE_API: process.env.BASE_API, // 接口API地址
            importBtnDisabled: false, // 按钮是否禁用,
            loading: false
        }
    },
    created() {

    },
    methods:{
        //点击按钮上传文件到接口里面
        submitUpload() {
            this.importBtnDisabled = true
            this.loading = true
            // js: document.getElementById("upload").submit()
            this.$refs.upload.submit()
        },
        //上传成功
        fileUploadSuccess(response) {
            //提示信息
            this.loading = false
            this.$message({
                type: 'success',
                message: '添加课程分类成功'
            })
            //跳转课程分类列表
            //路由跳转
           this.$router.push({path:'/subject/list'})
        },
        //上传失败
        fileUploadError() {
            this.loading = false
            this.$message({
                type: 'error',
                message: '添加课程分类失败'
            })
        }
    }
}
</script>