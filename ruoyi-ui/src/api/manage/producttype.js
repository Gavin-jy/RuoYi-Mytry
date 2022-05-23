import request from '@/utils/request'

// 查询商品类型列表
export function listProducttype(query) {
  return request({
    url: '/manage/producttype/list',
    method: 'get',
    params: query
  })
}

// 查询商品类型详细
export function getProducttype(productTypeId) {
  return request({
    url: '/manage/producttype/' + productTypeId,
    method: 'get'
  })
}

// 新增商品类型
export function addProducttype(data) {
  return request({
    url: '/manage/producttype',
    method: 'post',
    data: data
  })
}

// 修改商品类型
export function updateProducttype(data) {
  return request({
    url: '/manage/producttype',
    method: 'put',
    data: data
  })
}

// 删除商品类型
export function delProducttype(productTypeId) {
  return request({
    url: '/manage/producttype/' + productTypeId,
    method: 'delete'
  })
}
