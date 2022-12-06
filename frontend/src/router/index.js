import Vue from "vue";
import VueRouter from "vue-router";
import store from "@/store";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    // component: HomeView,
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/HomeView.vue"),
  },
  {
    path: "/about",
    name: "about",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/AboutView.vue"),
  },
  {
    path: "/login",
    name: "Login",
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/Login.vue"),
  },
  {
    path: "/reviews",
    name: "Reviews",
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/ReviewPage.vue"),
  },
  {
    path: "/createReviewForm/:book_id/",
    name: "createReviewForm",
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/CreateReviewForm.vue"),
  },
  {
    path: "/addAuthor",
    name: "addAuthorForm",
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/addAuthorForm.vue"),
  },
  {
    path: "/addBook",
    name: "addBookForm",
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/addBookForm.vue"),
  },
];

const router = new VueRouter({
  routes,
});

//beforeEach hook to check the login in sync with the backend
router.beforeEach(async (to, from, next) => {
  //get login state from checkUser backend
  let response = await Vue.axios.get("/api/checkUser");
  await store.dispatch("setLoginUser", response.data);
  let loginState = response.data.loggedIn;
  console.log(response.data);
  if (to.name === "Login" && loginState) {
    next({ name: "home" });
  }
  if (to.name !== "Login" && !loginState) {
    next({ name: "Login" });
  } else {
    next();
  }
});

export default router;
