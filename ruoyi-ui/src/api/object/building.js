import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listBuilding(query) {
  return request({
    url: '/object/building/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getBuilding(buildingId) {
  return request({
    url: '/object/building/' + buildingId,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addBuilding(data) {
  return request({
    url: '/object/building',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateBuilding(data) {
  return request({
    url: '/object/building',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delBuilding(buildingId) {
  return request({
    url: '/object/building/' + buildingId,
    method: 'delete'
  })
}
