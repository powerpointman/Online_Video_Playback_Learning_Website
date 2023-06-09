import request from '@/utils/request'

export default{
    //讲师列表（条件查询分页）
    getTeacherListPage(current,limit,teacherQuery) {
        return request({
            //url: '/eduservice/edu-teacher/pageTeacherCondition/'+current+"/"+limit,
            url: `/eduservice/edu-teacher/pageTeacherCondition/${current}/${limit}`,
            method: 'post',
            //teacherQuery条件对象，后端使用RequestBody获取数据
            //data表示把对象转换json进行传递到接口里面
            data: teacherQuery
          })
    },

    //删除讲师
    deleteTeacher(id){
        return request({
            url: `/eduservice/edu-teacher/${id}`,
            method: 'delete'
          })
    },

    //添加讲师
    addTeacher(teacher){
        return request({
            url: `/eduservice/edu-teacher/addTeacher`,
            method: 'post',
            data: teacher
          })
    },
    //根据id查询讲师
    getTeacherInfo(id) {
        return request({
            url: `/eduservice/edu-teacher/getTeacher/${id}`,
            method: 'get'
          })
    },
    //修改讲师
    updateTeacherInfo(teacher) {
        return request({
            url: `/eduservice/edu-teacher/updateTeacher`,
            method: 'post',
            data: teacher
          })
    }
}
