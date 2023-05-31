<template>
  <NavBar />
  <router-view></router-view>
</template>

<script>
import NavBar from './components/NavBar.vue'
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap/dist/js/bootstrap"
export default {
  components: {
    NavBar
  },
  setup() {
  }
}
</script>

<style>
body {
  background-image: url("@/assets/background.jpeg");
  background-size: 100%;

}


::-webkit-scrollbar {
  width: 10px;
}

::-webkit-scrollbar-thumb {
  background-image: linear-gradient(-45deg, #f0c8c9, #a8c0d8);
  box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
}

::-webkit-scrollbar-track {
  background-color: #f5f5f5;
}

::-webkit-scrollbar-button {
  background-color: #ccc;
}

::-webkit-scrollbar-corner {
  background-color: #f5f5f5;
}
</style>
