import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listShopper(query) {
  return request({
    url: '/object/shopper/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getShopper(shopperId) {
  return request({
    url: '/object/shopper/getInfo?shopperId='+shopperId,
    method: 'get',
  })
}

// 新增【请填写功能名称】
export function addShopper(data) {
  return request({
    url: '/object/shopper',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateShopper(data) {
  return request({
    url: '/object/shopper',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delShopper(shopperId) {
  return request({
    url: '/object/shopper/' + shopperId,
    method: 'delete'
  })
}
