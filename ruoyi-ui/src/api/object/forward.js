import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listForward(query) {
  return request({
    url: '/object/forward/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getForward(forwardId) {
  return request({
    url: '/object/forward/' + forwardId,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addForward(data) {
  return request({
    url: '/object/forward',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateForward(data) {
  return request({
    url: '/object/forward',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delForward(forwardId) {
  return request({
    url: '/object/forward/' + forwardId,
    method: 'delete'
  })
}
