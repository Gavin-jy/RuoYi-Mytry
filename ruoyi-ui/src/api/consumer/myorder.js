import request from '@/utils/request'

// 查询我的订单列表
export function listMyorder(query) {
  return request({
    url: '/consumer/myorder/list',
    method: 'get',
    params: query
  })
}

// 查询我的订单详细
export function getMyorder(myorderId) {
  return request({
    url: '/consumer/myorder/' + myorderId,
    method: 'get'
  })
}

// 新增我的订单
export function addMyorder(data) {
  return request({
    url: '/consumer/myorder',
    method: 'post',
    data: data
  })
}

// 修改我的订单
export function updateMyorder(data) {
  return request({
    url: '/consumer/myorder',
    method: 'put',
    data: data
  })
}

// 删除我的订单
export function delMyorder(myorderId) {
  return request({
    url: '/consumer/myorder/' + myorderId,
    method: 'delete'
  })
}
