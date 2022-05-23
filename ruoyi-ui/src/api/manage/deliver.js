import request from '@/utils/request'

// 查询物流公司列表
export function listDeliver(query) {
  return request({
    url: '/manage/deliver/list',
    method: 'get',
    params: query
  })
}

// 查询物流公司详细
export function getDeliver(deliverId) {
  return request({
    url: '/manage/deliver/' + deliverId,
    method: 'get'
  })
}

// 新增物流公司
export function addDeliver(data) {
  return request({
    url: '/manage/deliver',
    method: 'post',
    data: data
  })
}

// 修改物流公司
export function updateDeliver(data) {
  return request({
    url: '/manage/deliver',
    method: 'put',
    data: data
  })
}

// 删除物流公司
export function delDeliver(deliverId) {
  return request({
    url: '/manage/deliver/' + deliverId,
    method: 'delete'
  })
}
