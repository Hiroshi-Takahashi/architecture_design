<template>
  <div class="hello">
    <h1>TEST</h1>
    <h2>Essential Links</h2>
    <div>
      カテゴリ1:<input type="text" v-model="jobCategoryLevel1"/>
      カテゴリ2:<input type="text" v-model="jobCategoryLevel2"/>
    </div>
    <div>
      <input type="button" name="search" value="検索" @click="search"/>
    </div>
    <div>list!</div>
    <div v-for="value in company_list" :key="value">
      {{ value }}
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
      jobCategoryLevel1: '01',
      jobCategoryLevel2: '01',
      company_list: []
    }
  },
  methods: {
    search: function (event) {
      var req = {
        'jobCategoryLevel1': this.jobCategoryLevel1,
        'jobCategoryLevel2': this.jobCategoryLevel2
      }
      console.log('request=' + this.jobCategoryLevel1)
      console.log('request=' + this.jobCategoryLevel2)
      return axios.post(URL_BASE + '/search', req)
        .then(
          (res) => {
            console.log('response=' + res.data)
            res.data.fullFillCompanyList.forEach(element => {
              this.company_list.push(element.companyName)
            })
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
