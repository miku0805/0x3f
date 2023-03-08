import { createRouter, createWebHistory } from 'vue-router'
import NotFound from '@/views/error/NotFound'
import GroupView from '@/views/group/GroupView'
import HomeView from '@/views/home/HomeView'
import ProblemView from '@/views/problem/ProblemView'
import StatusView from '@/views/status/StatusView'
import TrainingView from '@/views/training/TrainingView'
import ContestView from '@/views/contest/ContestView'
import DiscussionView from '@/views/discussion/DiscussionView'
import AboutIntroductionView from '@/views/about/AboutIntroductionView'
import AboutDeveloperView from '@/views/about/AboutDeveloperView'
import ACMView from '@/views/rank/ACMView'
import OIView from '@/views/rank/OIView'

const routes = [
  {
    path: "/404/",
    name: "404",
    component: NotFound,
  },
  {
    path: "/group/",
    name: "group_index",
    component: GroupView,
  },
  {
    path: "/home/",
    name: "home_index",
    component: HomeView,
  },
  {
    path: "/problem/",
    name: "problem_index",
    component: ProblemView,
  },
  {
    path: "/acmrank/",
    name: "acm_rank_index",
    component: ACMView,
  },
  {
    path: "/oirank/",
    name: "oi_rank_index",
    component: OIView,
  },
  {
    path: "/status/",
    name: "status_index",
    component: StatusView,
  },
  {
    path: "/training/",
    name: "training_index",
    component: TrainingView,
  },
  {
    path: "/contest/",
    name: "contest_index",
    component: ContestView,
  },
  {
    path: "/discussion/",
    name: "discussion_index",
    component: DiscussionView,
  },
  {
    path: "/aboutintroduction/",
    name: "aboutintroduction_index",
    component: AboutIntroductionView,
  },
  {
    path: "/aboutdeveloper/",
    name: "aboutdeveloper_index",
    component: AboutDeveloperView,
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

export default router
