<template>
  <div class="error">
    <h1>ページが見つかりません</h1>
    <h2>ステータス４０４</h2>
    <div>
      <router-link to="/">Home</router-link>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Error400',
  data () {
    return {
      company_list: []
    }
  },
  methods: {
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
