<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <h2>Essential Links</h2>
    <div>
      <input type="button" name="search" value="検索" @click="search"/>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

var URL_BASE = 'http://localhost:8080'

export default {
  name: 'Home',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  },
  methods: {
    search: function (event) {
      var condition = {
        'jobCategoryLevel1': '01',
        'jobCategoryLevel2': '02'
      }
      return axios.post(URL_BASE + '/search', condition)
        .then(
          (res) => {
            console.log(res)
          }
        )
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
