import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listMessage(query) {
  return request({
    url: '/object/message/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getMessage(messageId) {
  return request({
    url: '/object/message/' + messageId,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addMessage(data) {
  return request({
    url: '/object/message',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateMessage(data) {
  return request({
    url: '/object/message',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delMessage(messageId) {
  return request({
    url: '/object/message/' + messageId,
    method: 'delete'
  })
}
