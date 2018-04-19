<template>
  <div>
    <div class="header">
      header
    </div>
    <div id="app">
      <router-view/>
    </div>
    <div class="footer">
      footer
    </div>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
.header {
  background-color: cornflowerblue;
  height: 50px;
}
.footer {
  background-color: cyan;
  height: 50px;
}
.error {
  color: red;
}
</style>
