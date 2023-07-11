import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listAward(query) {
  return request({
    url: '/object/award/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getAward(awardId) {
  return request({
    url: '/object/award/' + awardId,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addAward(data) {
  return request({
    url: '/object/award',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateAward(data) {
  return request({
    url: '/object/award',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delAward(awardId) {
  return request({
    url: '/object/award/' + awardId,
    method: 'delete'
  })
}
