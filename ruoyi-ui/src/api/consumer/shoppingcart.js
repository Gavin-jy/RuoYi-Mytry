import request from '@/utils/request'

// 查询购物车列表
export function listShoppingcart(query) {
  return request({
    url: '/consumer/shoppingcart/list',
    method: 'get',
    params: query
  })
}

// 查询购物车详细
export function getShoppingcart(shoppingItemId) {
  return request({
    url: '/consumer/shoppingcart/' + shoppingItemId,
    method: 'get'
  })
}

// 新增购物车
export function addShoppingcart(data) {
  return request({
    url: '/consumer/shoppingcart',
    method: 'post',
    data: data
  })
}

// 修改购物车
export function updateShoppingcart(data) {
  return request({
    url: '/consumer/shoppingcart',
    method: 'put',
    data: data
  })
}

// 删除购物车
export function delShoppingcart(shoppingItemId) {
  return request({
    url: '/consumer/shoppingcart/' + shoppingItemId,
    method: 'delete'
  })
}
