import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listConsultant(query) {
  return request({
    url: '/object/consultant/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getConsultant(consultantId) {
  return request({
    url: '/object/consultant/' + consultantId,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addConsultant(data) {
  return request({
    url: '/object/consultant',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateConsultant(data) {
  return request({
    url: '/object/consultant',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delConsultant(consultantId) {
  return request({
    url: '/object/consultant/' + consultantId,
    method: 'delete'
  })
}
