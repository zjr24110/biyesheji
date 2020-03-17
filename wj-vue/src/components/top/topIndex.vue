<template>
  <div>
    <!--//////-->
    <nav-menu class="nav-menu"></nav-menu>
    <router-view/>
    <!--//////-->
    <el-row style="height: 840px;">
      <view-switch class="switch"></view-switch>
      <el-tooltip effect="dark" placement="right"
                  v-for="item in books.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                  :key="item.id">
        <p slot="content" style="font-size: 14px;margin-bottom: 6px;">{{item.title}}</p>
        <p slot="content" style="font-size: 13px;margin-bottom: 6px">
          <span>{{item.author}}</span> /
          <span>{{item.date}}</span> /
          <span>{{item.press}}</span>
        </p>
        <p slot="content" style="width: 300px" class="abstract">{{item.abs}}</p>
        <el-card style="width: 135px;margin-bottom: 20px;height: 233px;float: left;margin-right: 15px" class="book"
                 bodyStyle="padding:10px" shadow="hover">
          <div class="cover">
            <img :src="item.cover" alt="封面">
          </div>
          <div class="info">
            <div class="title">
              <a href="">{{item.title}}</a>
            </div>
          </div>
          <!--<div class="author">-->
          <!--<a href="">{{item.author}}</a>-->
          <!--</div>-->
          <div class="button">
            <el-button size="mini" type="primary" icon="el-icon-plus" circle v-on:click="DoSth(item.id)"></el-button>
          </div>
        </el-card>
      </el-tooltip>
    </el-row>
    <el-row>
      <el-pagination
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-size="pagesize"
        :total="books.length">
      </el-pagination>
    </el-row>
  </div>
</template>

<script>
  // dafafdsfasf
  import NavMenu from '@/components/common/NavMenu'
  // dfafafasdsaff
  export default {
    // dsfsadfasdfas
    components: {NavMenu},
    // ddfsadfsdfa
    name: 'top',
    data () {
      return {
        books: [],
        currentPage: 1,
        pagesize: 8,
        sortType: 'read_times'
      }
    },
    mounted: function () {
      this.loadBooks()
    },
    methods: {
      loadBooks () {
        var user = JSON.parse(localStorage.getItem('user'))
        var _this = this
        this.$axios.post('/topbook', {
          userName: user.username,
          bookID: 1
        }).then(resp => {
          if (resp && resp.status === 200) {
            _this.books = resp.data
          }
        })
      },
      handleCurrentChange: function (currentPage) {
        this.currentPage = currentPage
      },
      DoSth (bid) {
        var user = JSON.parse(localStorage.getItem('user'))
        alert(bid + user.username)
        this.$axios
          .post('/userBook/add', {
            userName: user.username,
            bookID: bid
          }).then(resp => {
          if (resp && resp.status === 200) {
            alert('阅览成功')
          }
        })
      }
    }
  }
</script>
<style scoped>

  .cover {
    width: 115px;
    height: 172px;
    margin-bottom: 7px;
    overflow: hidden;
    cursor: pointer;
  }

  img {
    width: 115px;
    height: 172px;
    /*margin: 0 auto;*/
  }

  .title {
    font-size: 12px;
    text-align: left;
    text-align:center;
  }
  /*.author {*/
  /*!*float: left;*!*/
  /*!*color: #333;*!*/
  /*!*width: 66px;*!*/
  /*font-size: 13px;*/
  /*!*margin-bottom: 6px;*!*/
  /*!*text-align: left;*!*/
  /*float: left;*/
  /*width: 30%;*/
  /*height:auto;*/
  /*}*/
  .button {
    /*float: right;*/
    /*color: #333;*/
    /*width: 50px;*/
    /*font-size: 13px;*/
    float: left;
    width: 20%;
    height: 20%;
    text-align:center;
  }
  .abstract {
    display: block;
    line-height: 17px;
  }
  .el-icon-delete {
    cursor: pointer;
    float: right;
  }
  .switch {
    display: flex;
    position: absolute;
    left: 780px;
    top: 25px;
  }
  a {
    text-decoration: none;
  }
  a:link, a:visited, a:focus {
    color: #3377aa;
  }
  .nav-menu {
    /*margin-bottom: 40px;*/
    box-shadow: 0 2px 4px 0 rgba(0,0,0,.05);
  }
</style>
