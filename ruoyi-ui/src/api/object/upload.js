// 引入axios
import axios from 'axios'

const upload = axios.create({
  // axios中请求配置有baseURL选项，表示请求URL公共部分
  baseURL: process.env.VUE_APP_BASE_API,
})

// 引入ElementUI Loading层
import {Loading} from 'element-ui';
// 引入ElementUI Message层
import {Message} from 'element-ui'
let loading;

// 开始加载
function startLoading() {
  loading = Loading.service({
    lock: true,
    text: '上传中...',
    background: 'rgba(255,255,255,0)',
  })
}

// 结束加载
function endLoading() {
  loading.close()
}

// axios.defaults.transformRequest

upload.interceptors.request.use(
  config => {
      // 定义formData
      let formData = new FormData()
      formData.append('file', config.data.file, time_str + '.png')
      // 获取除文件外其他参数
      let {
        file,
        ...params
      } = config.data
      // 补全formData
      for (let key in params) {
        // console.log(key, config.data[key]);
        formData.append(`${key}`, params[key])
      }
      formData.append('sign', sign)

      config.method = config.method || 'GET'
      config.data = formData
      config.headers.post['Content-Type'] = 'multipart/form-data'
      config.params = ''
      config.method.toUpperCase()
      startLoading()

      return config
  },
  err => {
    // alert(err)
    return Promise.reject(err)
  })
// 配置axios响应拦截器
upload.interceptors.response.use(
  response => {
        endLoading();
        return response
  },
  error => {
    return error.response;
  }
)

export default upload