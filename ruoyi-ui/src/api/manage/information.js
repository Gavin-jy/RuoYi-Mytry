import request from '@/utils/request'

// 查询会员信息列表
export function listInformation(query) {
  return request({
    url: '/manage/information/list',
    method: 'get',
    params: query
  })
}

// 查询会员信息详细
export function getInformation(vipId) {
  return request({
    url: '/manage/information/' + vipId,
    method: 'get'
  })
}

// 新增会员信息
export function addInformation(data) {
  return request({
    url: '/manage/information',
    method: 'post',
    data: data
  })
}

// 修改会员信息
export function updateInformation(data) {
  return request({
    url: '/manage/information',
    method: 'put',
    data: data
  })
}

// 删除会员信息
export function delInformation(vipId) {
  return request({
    url: '/manage/information/' + vipId,
    method: 'delete'
  })
}
