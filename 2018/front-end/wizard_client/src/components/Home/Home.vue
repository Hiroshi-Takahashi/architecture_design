<template>
  <div class="page">
    <h1>HOME画面</h1>
    <div>
      <div class="error" v-for="e in error_list" :key="e">
        {{ e }}
      </div>
    </div>
    <div>
      <div>カテゴリ1=01,02,03 or カテゴリ2＝01の場合データが存在する。</div>
      <div>カテゴリ1:<input type="text" v-model="jobCategoryLevel1"/></div>
      <div>カテゴリ2:<input type="text" v-model="jobCategoryLevel2"/></div>
    </div>
    <div>
      <input type="button" id="search" value="検索" @click="search"/>
    </div>
    <div class="div_table" v-if="company_list.length > 0">
      <div class="div_table_heading">
        <div class="div_table_row">
          <div class="div_table_cell">企業ID</div>
          <div class="div_table_cell">企業名</div>
          <div class="div_table_cell">ジョブカテゴリ１</div>
          <div class="div_table_cell">ジョブカテゴリ２</div>
        </div>
      </div>
      <div class="div_table_body">
        <div class="div_table_row" v-for="company in company_list" :key="company.companyId">
          <div class="div_table_cell">{{ company.companyId }}</div>
          <div class="div_table_cell">{{ company.companyName }}</div>
          <div class="div_table_cell">{{ company.jobCategoryLevel1 }}</div>
          <div class="div_table_cell">{{ company.jobCategoryLevel2 }}</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
import router from '../../router'

export default {
  name: 'Home',
  data () {
    return {
      jobCategoryLevel1: '',
      jobCategoryLevel2: '',
      company_list: [],
      error_list: []
    }
  },
  methods: {
    search: function (event) {
      // 条件満たす企業を取得する
      var req = {
        'jobCategoryLevel1': this.jobCategoryLevel1,
        'jobCategoryLevel2': this.jobCategoryLevel2
      }
      return axios.post(process.env.API_ENDPOINT + '/search', req)
        .then(
          // 正常終了
          (res) => {
            this.company_list = []
            res.data.fullFillCompanyList.forEach(company => {
              this.company_list.push(company)
            })
          }
        ).catch(error => {
          // 例外処理
          if (error.response) {
            if (error.response.status === 400) {
              // バリデーションエラーの設定
              this.error_list = []
              error.response.data.errors.forEach(element => {
                this.error_list.push(element.defaultMessage)
              })
            } else if (error.response.status === 404) {
              // 404用のページへ遷移
              router.push({ name: 'Error404' })
            }
          } else {
            console.log(error.message)
          }
        })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1 {
  font-weight: normal;
}

</style>
