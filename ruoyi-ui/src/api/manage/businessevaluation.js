import request from '@/utils/request'

// 查询系统商家评价列表
export function listBusinessevaluation(query) {
  return request({
    url: '/manage/businessevaluation/list',
    method: 'get',
    params: query
  })
}

// 查询系统商家评价详细
export function getBusinessevaluation(businessEvaluationId2) {
  return request({
    url: '/manage/businessevaluation/' + businessEvaluationId2,
    method: 'get'
  })
}

// 新增系统商家评价
export function addBusinessevaluation(data) {
  return request({
    url: '/manage/businessevaluation',
    method: 'post',
    data: data
  })
}

// 修改系统商家评价
export function updateBusinessevaluation(data) {
  return request({
    url: '/manage/businessevaluation',
    method: 'put',
    data: data
  })
}

// 删除系统商家评价
export function delBusinessevaluation(businessEvaluationId2) {
  return request({
    url: '/manage/businessevaluation/' + businessEvaluationId2,
    method: 'delete'
  })
}
