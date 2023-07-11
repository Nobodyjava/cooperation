import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listRule(query) {
  return request({
    url: '/object/rule/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getRule(ruleId) {
  return request({
    url: '/object/rule/' + ruleId,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addRule(data) {
  return request({
    url: '/object/rule',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateRule(data) {
  return request({
    url: '/object/rule',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delRule(ruleId) {
  return request({
    url: '/object/rule/' + ruleId,
    method: 'delete'
  })
}
