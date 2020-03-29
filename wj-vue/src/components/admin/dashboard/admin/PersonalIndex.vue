<!--suppress ALL -->
<template>
  <div>
    <bulk-registration @onSubmit="listUsers()"></bulk-registration>
    <el-card style="margin: 18px 2%;width: 95%">
      <el-table
        :data="users"
        stripe
        :default-sort = "{prop: 'id', order: 'ascending'}"
        style="width: 100%"
        :max-height="tableHeight">
        <el-table-column
          prop="id"
          label="用户编号"
          width="100">
        </el-table-column>
        <el-table-column
          prop="username"
          label="用户名"
          fit>
        </el-table-column>
        <el-table-column
          prop="name"
          label="真实姓名"
          fit>
        </el-table-column>
        <el-table-column
          prop="phone"
          label="手机号"
          fit>
        </el-table-column>
        <el-table-column
          prop="profession"
          label="专业"
          show-overflow-tooltip
          fit>
        </el-table-column>
      </el-table>
    </el-card>
  </div>
</template>

<script>
  export default {
    name: 'PersonalIndex',
    data () {
      return {
        users: []
      }
    },
    mounted () {
      this.listUsers()
      // this.listRoles()
    },
    computed: {
      tableHeight () {
        return window.innerHeight - 320
      }
    },
    methods: {
      listUsers () {
        var user = JSON.parse(localStorage.getItem('user'))
        var _this = this
        this.$axios
          .post('/users', {
            userName: user.username
        }).then(resp => {
          if (resp && resp.status === 200) {
            _this.users = resp.data
          }
        })
      }
      // resetPassword (username) {
      //   this.$axios.put('/admin/user/password', {
      //     username: username
      //   }).then(resp => {
      //     if (resp && resp.status === 200) {
      //       this.$alert('密码已重置为 123')
      //     }
      //   })
      // }
    }
  }
</script>

<style scoped>

</style>
