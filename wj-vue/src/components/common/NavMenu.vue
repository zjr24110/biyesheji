<template>
  <div>
    <el-menu
      :default-active="path"
      router
      mode="horizontal"
      background-color="white"
      text-color="#222"
      active-text-color="red"
      style="min-width: 1300px">
      <el-menu-item v-for="(item,i) in navList" :key="i" :index="item.name">
        {{ item.navItem }}
      </el-menu-item>
      <span style="position: absolute;padding-top: 20px;right: 43%;font-size: 20px;font-weight: bold">小型图书馆</span>
      <!--<i class="el-icon-switch-button" v-on:click="logout" style="font-size: 40px;float: right"></i>-->
    </el-menu>
  </div>
</template>

<script>
  // import {createRouter} from '../../router'

  export default {
    name: 'NavMenu',
    data () {
      return {
        navList: [
          {name: '/index', navItem: '首页'},
          {name: '/library', navItem: '图书馆'},
          {name: '/recommand', navItem: '推荐中心'},
          {name: '/history', navItem: '阅读历史'},
          {name: '/admin/dashboard', navItem: '个人中心'}
        ],
        keywords: '',
        path: ''
      }
    },
    mounted: function () {
      // 获得第一级路由，以设置导航栏高亮
      var x = this.$route.path.indexOf('/', 1)
      if (x !== -1) {
        this.path = this.$route.path.substring(0, x)
      } else {
        this.path = this.$route.path
      }
    },
    computed: {
      hoverBackground () {
        return '#ffd04b'
      }
    },
    methods: {
      // logout () {
      //   var _this = this
      //   this.$axios.get('/logout').then(resp => {
      //     if (resp.data.code === 200) {
      //       _this.$store.commit('logout')
      //       _this.$router.replace('/index')
      //       // 清空路由，防止路由重复加载
      //       const newRouter = createRouter()
      //       _this.$router.matcher = newRouter.matcher
      //     }
      //   }).catch(failResponse => {})
      // }
    }
  }
</script>

<style scoped>
  a{
    text-decoration: none;
  }

  span {
    pointer-events: none;
  }

</style>
