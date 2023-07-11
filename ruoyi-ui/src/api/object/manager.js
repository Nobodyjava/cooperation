import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listManager(query) {
  return request({
    url: '/object/manager/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getManager(managerId) {
  return request({
    url: '/object/manager/' + managerId,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addManager(data) {
  return request({
    url: '/object/manager',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateManager(data) {
  return request({
    url: '/object/manager',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delManager(managerId) {
  return request({
    url: '/object/manager/' + managerId,
    method: 'delete'
  })
}
