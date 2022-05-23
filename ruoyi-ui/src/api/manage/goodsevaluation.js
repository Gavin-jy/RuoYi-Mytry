import request from '@/utils/request'

// 查询系统商品评价列表
export function listGoodsevaluation(query) {
  return request({
    url: '/manage/goodsevaluation/list',
    method: 'get',
    params: query
  })
}

// 查询系统商品评价详细
export function getGoodsevaluation(goodsEvaluationId2) {
  return request({
    url: '/manage/goodsevaluation/' + goodsEvaluationId2,
    method: 'get'
  })
}

// 新增系统商品评价
export function addGoodsevaluation(data) {
  return request({
    url: '/manage/goodsevaluation',
    method: 'post',
    data: data
  })
}

// 修改系统商品评价
export function updateGoodsevaluation(data) {
  return request({
    url: '/manage/goodsevaluation',
    method: 'put',
    data: data
  })
}

// 删除系统商品评价
export function delGoodsevaluation(goodsEvaluationId2) {
  return request({
    url: '/manage/goodsevaluation/' + goodsEvaluationId2,
    method: 'delete'
  })
}
