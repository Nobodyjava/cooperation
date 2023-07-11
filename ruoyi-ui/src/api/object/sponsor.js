import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listSponsor(query) {
  return request({
    url: '/object/sponsor/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getSponsor(sponsorId) {
  return request({
    url: '/object/sponsor/getInfo?sponsorId=' + sponsorId,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addSponsor(data) {
  return request({
    url: '/object/sponsor',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateSponsor(data) {
  return request({
    url: '/object/sponsor',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delSponsor(sponsorId) {
  return request({
    url: '/object/sponsor/' + sponsorId,
    method: 'delete'
  })
}
