import request from '@/utils/request'

export function uploads(data){
    return request({
        url:'/object/shopper/upload',
        method:'post',
        data:data
    })
}