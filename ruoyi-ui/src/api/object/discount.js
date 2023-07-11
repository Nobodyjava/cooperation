import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listDiscount(query) {
  return request({
    url: '/object/discount/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getDiscount(discountId) {
  return request({
    url: '/object/discount/' + discountId,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addDiscount(data) {
  return request({
    url: '/object/discount',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateDiscount(data) {
  return request({
    url: '/object/discount',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delDiscount(discountId) {
  return request({
    url: '/object/discount/' + discountId,
    method: 'delete'
  })
}
