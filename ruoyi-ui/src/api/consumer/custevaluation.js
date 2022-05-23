import request from '@/utils/request'

// 查询我的评价列表
export function listCustevaluation(query) {
  return request({
    url: '/consumer/custevaluation/list',
    method: 'get',
    params: query
  })
}

// 查询我的评价详细
export function getCustevaluation(custEvaluationId2) {
  return request({
    url: '/consumer/custevaluation/' + custEvaluationId2,
    method: 'get'
  })
}

// 新增我的评价
export function addCustevaluation(data) {
  return request({
    url: '/consumer/custevaluation',
    method: 'post',
    data: data
  })
}

// 修改我的评价
export function updateCustevaluation(data) {
  return request({
    url: '/consumer/custevaluation',
    method: 'put',
    data: data
  })
}

// 删除我的评价
export function delCustevaluation(custEvaluationId2) {
  return request({
    url: '/consumer/custevaluation/' + custEvaluationId2,
    method: 'delete'
  })
}
