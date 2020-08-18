import Vue from 'vue'
import Router from 'vue-router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import TbItem from "../components/TbItem";

Vue.use(ElementUI);
Vue.use(Router)

export default new Router({
  routes: [
    //重定向
    {path: '/' , redirect:"/tbItem"},
    {path:'/tbItem', component:TbItem}
  ]
})
