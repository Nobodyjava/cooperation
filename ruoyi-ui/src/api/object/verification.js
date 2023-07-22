import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listVerification(query) {
  return request({
    url: '/object/verification/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getVerification(verificationId) {
  return request({
    url: '/object/verification/' + verificationId,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addVerification(data) {
  return request({
    url: '/object/verification',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateVerification(data) {
  return request({
    url: '/object/verification',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delVerification(verificationId) {
  return request({
    url: '/object/verification/' + verificationId,
    method: 'delete'
  })
}
