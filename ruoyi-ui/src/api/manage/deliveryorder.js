import request from '@/utils/request'

// 查询物流订单列表
export function listDeliveryorder(query) {
  return request({
    url: '/manage/deliveryorder/list',
    method: 'get',
    params: query
  })
}

// 查询物流订单详细
export function getDeliveryorder(deliveryOrderId3) {
  return request({
    url: '/manage/deliveryorder/' + deliveryOrderId3,
    method: 'get'
  })
}

// 新增物流订单
export function addDeliveryorder(data) {
  return request({
    url: '/manage/deliveryorder',
    method: 'post',
    data: data
  })
}

// 修改物流订单
export function updateDeliveryorder(data) {
  return request({
    url: '/manage/deliveryorder',
    method: 'put',
    data: data
  })
}

// 删除物流订单
export function delDeliveryorder(deliveryOrderId3) {
  return request({
    url: '/manage/deliveryorder/' + deliveryOrderId3,
    method: 'delete'
  })
}
