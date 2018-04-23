import Vue from 'vue'
import { shallow } from '@vue/test-utils'
import axios from 'axios'
//import flushPromises from 'flush-promises'
import "babel-polyfill";
import sinon from 'sinon';

import Home from '@/components/Home/Home'

describe('Home.vue', () => {

  it('初期表示する', () => {
    const Constructor = Vue.extend(Home)
    const vm = new Constructor().$mount()
    expect(vm.$el.querySelector('.error')).to.be.null
    expect(vm.$el.querySelector('.div_table')).to.be.null
  })
  it('企業を検索し検索結果が０件返ってくる', () => {

    // APIをスタブ化
    const retJson = {
      fullFillCompanyList : [
        {companyId:'1',companyName:'企業A',jobCategoryLevel1:'01',jobCategoryLevel2:'01'}
      ]
    }
    
    const resolved = new Promise.resolve({data: retJson})


    const wrapper = shallow(Home)
    wrapper.find('#search').trigger('click')
    wrapper.vm.$nextTick(() => {
      expect(wrapper.vm.company_list).to.be.empty
      expect(wrapper.vm.error_list).to.be.empty
      done()
    })
/*
    await flushPromises()
    expect(wrapper.vm.company_list).to.be.empty
    expect(wrapper.vm.error_list).to.be.empty
*/
  })
/*
  it('企業を検索し検索結果が１件返ってくる', () => {
    const Constructor = Vue.extend(Home)
    const vm = new Constructor().$mount()
    
    expect(vm.$el.querySelector('.hello h1').textContent)
      .to.equal('Welcome to Your Vue.js App')
  })
  it('企業を検索し検索結果が複数件返ってくる', () => {
    const Constructor = Vue.extend(Home)
    const vm = new Constructor().$mount()
    expect(vm.$el.querySelector('.hello h1').textContent)
      .to.equal('Welcome to Your Vue.js App')
  })
  it('企業を検索するが入力エラーが発生する', () => {
    const Constructor = Vue.extend(Home)
    const vm = new Constructor().$mount()
    expect(vm.$el.querySelector('.hello h1').textContent)
      .to.equal('Welcome to Your Vue.js App')
  })
*/
})
