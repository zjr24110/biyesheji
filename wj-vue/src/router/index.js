import Vue from 'vue'
import Router from 'vue-router'
import AppIndex from '../components/home/AppIndex'
// import Articles from '../components/jotter/Articles'
import Editor from '../components/admin/content/ArticleEditor'
import LibraryIndex from '../components/library/LibraryIndex'
import Login from '../components/Login'
import Home from '../components/Home'
import AdminIndex from '../components/admin/AdminIndex'
import Register from '../components/Register'
import DashBoard from '../components/admin/dashboard/admin/index'
import Recommand from '../components/recommand/recommandIndex'
import History from '../components/history/historyIndex'
import TopBook from '../components/top/topIndex'
import MajorRecommand from '../components/recommand/majorRecommandIndex'
// import Personal from '../components/admin/PersonalIndex'
// import ArticleDetails from '../components/jotter/ArticleDetails'

Vue.use(Router)
export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Default',
      redirect: '/library',
      component: LibraryIndex
    },
    {
      // home页面并不需要被访问，只是作为其它组件的父组件
      path: '/home',
      name: 'Home',
      component: Home,
      redirect: '/index',
      children: [
        {
          path: '/index',
          name: 'AppIndex',
          component: AppIndex
        },
        // {
        //   path: '/admin/dashboard',
        //   name: 'dashboard',
        //   component: DashBoard
        // },
        // {
        //   path: '/jotter',
        //   name: 'Jotter',
        //   component: Articles
        // },
        // {
        //   path: '/jotter/article',
        //   name: 'Article',
        //   component: ArticleDetails
        // },
        {
          path: '/admin/content/editor',
          name: 'Editor',
          component: Editor,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/library',
          name: 'Library',
          component: LibraryIndex
        }
      ]
    },
    {
      path: '/recommand',
      name: 'recommand',
      component: Recommand
    },
    {
      path: '/history',
      name: 'history',
      component: History
    },
    {
      path: '/top',
      name: 'top',
      component: TopBook
    },
    {
      path: '/majorRecommand',
      name: 'majorRecommand',
      component: MajorRecommand
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/register',
      name: 'Register',
      component: Register
    },
    {
      path: '/admin',
      name: 'Admin',
      component: AdminIndex,
      meta: {
        requireAuth: true
      },
      children: [
        {
          // path: '/admin/dashboard',
          path: '/library',
          // name: 'dashboard',
          name: 'Library',
          component: LibraryIndex,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/admin/dashboard',
          // name: 'dashboard',
          name: 'dashboard',
          component: DashBoard,
          meta: {
            requireAuth: true
          }
        }
      ]
    }
  ]
})

export const createRouter = routes => new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Default',
      redirect: '/library',
      component: LibraryIndex
    },
    {
      // home页面并不需要被访问，只是作为其它组件的父组件
      path: '/home',
      name: 'Home',
      component: Home,
      redirect: '/index',
      children: [
        {
          path: '/index',
          name: 'AppIndex',
          component: AppIndex
        },
        // {
        //   path: '/admin/dashboard',
        //   name: 'dashboard',
        //   component: DashBoard
        // },
        {
          path: '/recommand',
          name: 'recommand',
          component: Recommand
        },
        {
          path: '/history',
          name: 'history',
          component: History
        },
        {
          path: '/top',
          name: 'top',
          component: TopBook
        },
        {
          path: '/majorRecommand',
          name: 'majorRecommand',
          component: MajorRecommand
        },
        // {
        //   path: '/jotter',
        //   name: 'Jotter',
        //   component: Articles
        // },
        // {
        //   path: '/jotter/article',
        //   name: 'Article',
        //   component: ArticleDetails
        // },
        {
          path: '/admin/content/editor',
          name: 'Editor',
          component: Editor,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/library',
          name: 'Library',
          component: LibraryIndex
        }
      ]
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/register',
      name: 'Register',
      component: Register
    },
    {
      path: '/admin',
      name: 'Admin',
      component: AdminIndex,
      meta: {
        requireAuth: true
      },
      children: [
        {
          path: '/library',
          // name: 'dashboard',
          name: 'Library',
          component: LibraryIndex,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/admin/dashboard',
          // name: 'dashboard',
          name: 'dashboard',
          component: DashBoard,
          meta: {
            requireAuth: true
          }
        }
      ]
    }
  ]
})
