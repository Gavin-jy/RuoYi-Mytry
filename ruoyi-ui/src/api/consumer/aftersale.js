import request from '@/utils/request'

// 查询我的售后列表
export function listAftersale(query) {
  return request({
    url: '/consumer/aftersale/list',
    method: 'get',
    params: query
  })
}

// 查询我的售后详细
export function getAftersale(aftersaleId) {
  return request({
    url: '/consumer/aftersale/' + aftersaleId,
    method: 'get'
  })
}

// 新增我的售后
export function addAftersale(data) {
  return request({
    url: '/consumer/aftersale',
    method: 'post',
    data: data
  })
}

// 修改我的售后
export function updateAftersale(data) {
  return request({
    url: '/consumer/aftersale',
    method: 'put',
    data: data
  })
}

// 删除我的售后
export function delAftersale(aftersaleId) {
  return request({
    url: '/consumer/aftersale/' + aftersaleId,
    method: 'delete'
  })
}
