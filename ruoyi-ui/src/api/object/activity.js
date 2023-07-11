import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listActivity(query) {
  return request({
    url: '/object/activity/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getActivity(activityId) {
  return request({
    url: '/object/activity/getInfo?activityId=' + activityId,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addActivity(data) {
  return request({
    url: '/object/activity',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateActivity(data) {
  return request({
    url: '/object/activity',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delActivity(activityId) {
  return request({
    url: '/object/activity/' + activityId,
    method: 'delete'
  })
}
