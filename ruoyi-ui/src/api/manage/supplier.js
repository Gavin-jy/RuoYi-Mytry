import request from '@/utils/request'

// 查询商家管理列表
export function listSupplier(query) {
  return request({
    url: '/manage/supplier/list',
    method: 'get',
    params: query
  })
}

// 查询商家管理详细
export function getSupplier(supplierId) {
  return request({
    url: '/manage/supplier/' + supplierId,
    method: 'get'
  })
}

// 新增商家管理
export function addSupplier(data) {
  return request({
    url: '/manage/supplier',
    method: 'post',
    data: data
  })
}

// 修改商家管理
export function updateSupplier(data) {
  return request({
    url: '/manage/supplier',
    method: 'put',
    data: data
  })
}

// 删除商家管理
export function delSupplier(supplierId) {
  return request({
    url: '/manage/supplier/' + supplierId,
    method: 'delete'
  })
}
