<template>
  <div>
    <h1>随机一题</h1>
    <button @click="getRandomProblem">获取题目</button>
    <div v-if="problem">
      <h2>{{ problem.name }}</h2>
      <p>{{ problem.index }}</p>
      <p>{{ problem.rating }}</p>
      <p>{{ problem.type }}</p>
      <a :href="`https://codeforces.com/problemset/problem/${problem.contestId}/${problem.index}`">查看题目</a>
    </div>
  </div>
</template>
  
<script>
export default {
  data() {
    return {
      problem: null
    }
  },
  methods: {
    async getRandomProblem() {
      try {
        const response = await fetch('https://codeforces.com/api/problemset.problems')
        const data = await response.json()
        const problems = data.result.problems
        const randomIndex = Math.floor(Math.random() * problems.length)
        this.problem = problems[randomIndex]
      } catch (error) {
        console.error(error)
      }
    }
  }
}
</script>