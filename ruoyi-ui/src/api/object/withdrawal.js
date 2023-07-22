import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listWithdrawal(query) {
  return request({
    url: '/object/withdrawal/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getWithdrawal(withdrawalId) {
  return request({
    url: '/object/withdrawal/' + withdrawalId,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addWithdrawal(data) {
  return request({
    url: '/object/withdrawal',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateWithdrawal(data) {
  return request({
    url: '/object/withdrawal',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delWithdrawal(withdrawalId) {
  return request({
    url: '/object/withdrawal/' + withdrawalId,
    method: 'delete'
  })
}
