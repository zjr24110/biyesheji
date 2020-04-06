<template>
  <div>
    <div class="change-zhanghao">
      <p class="zhanghao">你的账号是 {{zhanghao}}</p>
      <p>修改密码以后，可以使用账号和密码登录</p>
    </div>
    <!--引入element插件HTML样式-->
    <template>
      <el-form class="user-account-key" ref="form" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="原密码" prop="lastpassword">
          <el-input type="password" placeholder="请输入原密码" v-model="form.lastpassword"></el-input>
        </el-form-item>
        <el-form-item label="新密码" prop="password">
          <el-input type="password" placeholder="请设置新密码" v-model="form.password"></el-input>
        </el-form-item>
        <el-form-item label="确认密码" prop="qrpassword">
          <el-input type="password" placeholder="请确认新密码" v-model="form.qrpassword"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit('form')">修改</el-button>
          <el-button @click="$refs['form'].resetFields()">重置</el-button>
        </el-form-item>
      </el-form>
    </template>
  </div>
</template>

<script>
  import { Toast, MessageBox } from 'mint-ui'
  export default {
    name: 'UpdatePassword',
    data () {
      return {
        zhanghao: '',
        form: {
          lastpassword: '',
          password: '',
          qrpassword: ''
        },
        rules: {
          // 验证规则
          lastpassword: [{
            required: true,
            message: '请输入原密码',
            trigger: 'blur'
          }],
          password: [{
            required: true,
            message: '请设置新密码',
            trigger: 'blur'
          } ],
          qrpassword: [{
            required: true,
            message: '请确认新密码',
            trigger: 'blur'
          } ]
        }
      }
    },
    created () {
      // 若无身份信息，则跳转登录页
      if (!(localStorage.getItem('user'))) {
        this.$router.push('/login')
      }
      // 初始化
      this.getZhang()
    },
    methods: {
      getZhang () {
        this.user = JSON.parse(localStorage.getItem('user'))
        this.zhanghao = this.user.username
      },
      change_back () {
        this.$router.push('/login')
      },
      // 提交事件
      onSubmit (formName) {
        this.user = JSON.parse(localStorage.getItem('user'))
        this.form.id = this.user.id
        this.$refs[formName].validate(valid => {
          // valid 全为 true即执行以下操作
          if (valid) {
            if (this.form.lastpassword === this.form.password) {
              Toast({
                message: '原密码不能与新密码相同',
                duration: 1000
              })
              return
            }
            if (this.form.password !== this.form.qrpassword) {
              Toast({
                message: '确认密码与新密码不一致',
                duration: 1000
              })
              return
            }
            this.$axios
              .post('/updatePassword', {
                id: this.form.id,
                lastpassword: this.form.lastpassword,
                password: this.form.password,
                qrpassword: this.form.qrpassword
              })
              .then(function (result) {
                if (result.body.status === 200) {
                  MessageBox.alert('操作成功').then(action => {
                    this.$router.push('/login')
                  })
                } else if (result.body.status === 201) {
                  Toast({
                    message: result.body.message,
                    duration: 2000
                  })
                }
              }, function (result) {
                Toast({
                  message: '服务器异常',
                  duration: 2000
                })
              })
          } else {
            this.$message.error('请正确填写表单')
            return false
          }
        })
      }
    }
  }
</script>

<style scoped>
  .change-back {
    position: absolute;
    top: 24%;
    left: 0%;
  }

  .change-content {
    position: absolute;
    top: 40%;
    left: 40%;
  }

  .change-zhanghao {
    position: relative;
    margin-top: 51px;
    margin-left: 15px;
  }

  .zhanghao {
    margin-bottom: 0;
  }

  .user-account-key {
    width: 88%;
  }
</style>
