import request from '@/utils/request'

// 查询系统物流评价列表
export function listDeliverevaluation(query) {
  return request({
    url: '/manage/deliverevaluation/list',
    method: 'get',
    params: query
  })
}

// 查询系统物流评价详细
export function getDeliverevaluation(logisticsEvaluationId2) {
  return request({
    url: '/manage/deliverevaluation/' + logisticsEvaluationId2,
    method: 'get'
  })
}

// 新增系统物流评价
export function addDeliverevaluation(data) {
  return request({
    url: '/manage/deliverevaluation',
    method: 'post',
    data: data
  })
}

// 修改系统物流评价
export function updateDeliverevaluation(data) {
  return request({
    url: '/manage/deliverevaluation',
    method: 'put',
    data: data
  })
}

// 删除系统物流评价
export function delDeliverevaluation(logisticsEvaluationId2) {
  return request({
    url: '/manage/deliverevaluation/' + logisticsEvaluationId2,
    method: 'delete'
  })
}
