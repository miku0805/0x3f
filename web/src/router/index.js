import { createRouter, createWebHistory } from 'vue-router'
import NotFound from '@/views/error/NotFound.vue'
import HomeView from '@/views/home/HomeView.vue'
import ProblemView from '@/views/problem/ProblemView.vue'
import StatusView from '@/views/status/StatusView.vue'
import TrainingView from '@/views/training/TrainingView.vue'
import BlogView from '@/views/blog/BlogView.vue'
import BlogDetailView from "@/views/blog/BlogDetailView.vue"
import DiscussionView from '@/views/discussion/DiscussionView.vue'
import AboutIntroductionView from '@/views/about/AboutIntroductionView.vue'
import AboutDeveloperView from '@/views/about/AboutDeveloperView.vue'
import UserAccountLoginView from '@/views/user/account/UserAccountLoginView.vue'
import UserAccountRegisterView from '@/views/user/account/UserAccountRegisterView.vue'
import AboutView from "@/views/about/AboutView.vue"
import store from '@/store/index'
const routes = [
  {
    path: "/404/",
    name: "404",
    component: NotFound,
    meta: {
      requestAuth: false,
    }
  },
  {
    path: "/home/",
    name: "home_index",
    component: HomeView,
    meta: {
      requestAuth: true,
    }
  },
  {
    path: "/problem/",
    name: "problem_index",
    component: ProblemView,
    meta: {
      requestAuth: true,
    }
  },
  {
    path: '/status/',
    name: "status_index",
    component: StatusView,
    meta: {
      requestAuth: true,
    }
  },
  {
    path: '/training/',
    name: "training_index",
    component: TrainingView,
    meta: {
      requestAuth: true,
    }
  },
  {
    path: '/blog/',
    name: "blog_index",
    component: BlogView,
    meta: {
      requestAuth: true,
    }
  },
  {
    path: '/blog/:id',
    name: "blogdetail",
    component: BlogDetailView,
    meta: {
      requestAuth: true,
    }
  },
  {
    path: "/discussion/",
    name: "discussion_index",
    component: DiscussionView,
    meta: {
      requestAuth: true,
    }
  },
  {
    path: "/about/",
    name: "about_index",
    component: AboutView,
    meta: {
      requestAuth: true,
    }
  },
  {
    path: "/aboutintroduction/",
    name: "aboutintroduction_index",
    component: AboutIntroductionView,
    meta: {
      requestAuth: true,
    }
  },
  {
    path: "/aboutdeveloper/",
    name: "aboutdeveloper_index",
    component: AboutDeveloperView,
    meta: {
      requestAuth: true,
    }
  },
  {
    path: "/login/",
    name: "login_index",
    component: UserAccountLoginView,
    meta: {
      requestAuth: false,
    }
  },
  {
    path: "/register/",
    name: "register_index",
    component: UserAccountRegisterView,
    meta: {
      requestAuth: false,
    }
  },
  {
    path: "/:catchAll(.*)",
    redirect: "/404/"
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

router.beforeEach((to, from, next) => {
  if (to.meta.requestAuth && !store.state.user.is_login) {
    next({ name: "login_index" })
  } else next();
})

export default router
