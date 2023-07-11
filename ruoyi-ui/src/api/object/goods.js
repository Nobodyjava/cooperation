import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listGoods(query) {
  return request({
    url: '/object/goods/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getGoods(goodsId) {
  return request({
    url: '/object/goods/getInfo?goodsId=' + goodsId,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addGoods(data) {
  return request({
    url: '/object/goods',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateGoods(data) {
  return request({
    url: '/object/goods',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delGoods(goodsId) {
  return request({
    url: '/object/goods/' + goodsId,
    method: 'delete'
  })
}
