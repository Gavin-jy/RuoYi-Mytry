import request from '@/utils/request'

// 查询用户 列表
export function listUser(query) {
  return request({
    url: '/manage/user/list',
    method: 'get',
    params: query
  })
}

// 查询用户 详细
export function getUser(userId) {
  return request({
    url: '/manage/user/' + userId,
    method: 'get'
  })
}

// 新增用户 
export function addUser(data) {
  return request({
    url: '/manage/user',
    method: 'post',
    data: data
  })
}

// 修改用户 
export function updateUser(data) {
  return request({
    url: '/manage/user',
    method: 'put',
    data: data
  })
}

// 删除用户 
export function delUser(userId) {
  return request({
    url: '/manage/user/' + userId,
    method: 'delete'
  })
}
