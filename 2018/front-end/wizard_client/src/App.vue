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

.div_table{
  display: table;
  width: 100%;
}
.div_table_row {
  display: table-row;
}
.div_table_heading {
  background-color: #EEE;
  display: table-header-group;
}
.div_table_cell, .div_table_head {
  border: 1px solid #522c2c;
  display: table-cell;
  padding: 3px 10px;
}
.div_table_body {
  display: table-row-group;
}

.error {
  color: red;
}
</style>
