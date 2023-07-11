import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listAnalysis(query) {
  return request({
    url: '/object/analysis/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getAnalysis(analyseId) {
  return request({
    url: '/object/analysis/' + analyseId,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addAnalysis(data) {
  return request({
    url: '/object/analysis',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateAnalysis(data) {
  return request({
    url: '/object/analysis',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delAnalysis(analyseId) {
  return request({
    url: '/object/analysis/' + analyseId,
    method: 'delete'
  })
}
