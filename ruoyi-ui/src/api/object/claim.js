import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listClaim(query) {
  return request({
    url: '/object/claim/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getClaim(claimId) {
  return request({
    url: '/object/claim/' + claimId,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addClaim(data) {
  return request({
    url: '/object/claim',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateClaim(data) {
  return request({
    url: '/object/claim',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delClaim(claimId) {
  return request({
    url: '/object/claim/' + claimId,
    method: 'delete'
  })
}
