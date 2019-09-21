import Vue from 'vue'
import VueRouter from 'vue-router'
import HelloWorld from '../components/HelloWorld'
import HelloWorld2 from '../components/HelloWorld2'
import Login from '../components/Login'
import Main from '../components/main/Main'
import UnAuthorized from '../components/main/UnAuthorized'

Vue.use(VueRouter)

const router = new VueRouter({
    routes: [
        // dynamic segments start with a colon
        {path: '/', redirect: '/login'},
        {name: 'login', path: '/login', component: Login},
        {name: 'main', path: '/main', component: Main},
        {name: 'home', path: '/home', component: HelloWorld},
        {name: 'home2', path: '/home2', component: HelloWorld2},
        {name: 'unAuthorized', path: '/unAuthorized', component: UnAuthorized},
    ]
});

router.beforeEach((to, from, next) => {
    //这里能够跟踪路径的变化
    // window.console.log(from.fullPath);
    // window.console.log(to.fullPath);
    let item = localStorage.getItem("loginUser");
    if (item == null) {
        if (to.fullPath == "/login") {
            next();
        } else {
            next({name: 'login'})
        }
    } else {
        if (to.fullPath == "/login") {
            next({name: "main"})
        } else {
            next();
        }
    }
});

export default router