import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listParticipant(query) {
  return request({
    url: '/object/participant/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getParticipant(participantId) {
  return request({
    url: '/object/participant/' + participantId,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addParticipant(data) {
  return request({
    url: '/object/participant',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateParticipant(data) {
  return request({
    url: '/object/participant',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delParticipant(participantId) {
  return request({
    url: '/object/participant/' + participantId,
    method: 'delete'
  })
}
