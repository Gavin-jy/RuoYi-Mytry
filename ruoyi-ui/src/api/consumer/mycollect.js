import request from '@/utils/request'

// 查询我的收藏列表
export function listMycollect(query) {
  return request({
    url: '/consumer/mycollect/list',
    method: 'get',
    params: query
  })
}

// 查询我的收藏详细
export function getMycollect(mycollectId) {
  return request({
    url: '/consumer/mycollect/' + mycollectId,
    method: 'get'
  })
}

// 新增我的收藏
export function addMycollect(data) {
  return request({
    url: '/consumer/mycollect',
    method: 'post',
    data: data
  })
}

// 修改我的收藏
export function updateMycollect(data) {
  return request({
    url: '/consumer/mycollect',
    method: 'put',
    data: data
  })
}

// 删除我的收藏
export function delMycollect(mycollectId) {
  return request({
    url: '/consumer/mycollect/' + mycollectId,
    method: 'delete'
  })
}
