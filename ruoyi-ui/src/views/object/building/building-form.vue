<template>
  <!-- 楼盘信息 -->
  <el-card class="outer-border-fifth-first">
    <div class="inner-border-fifth-first">
      <div class="main-title">
        <p>楼盘信息</p>
      </div>
    </div>
    <div class="inner-border-fifth-second">
      <div class="main-title">
        <p>推广楼盘名称</p>
      </div>
      <el-input
        v-model="buildingInfo.buildingName"
        placeholder="请输入楼盘名称"
        size="small"
      ></el-input>
    </div>
    <div class="inner-border-fifth-third">
      <div class="main-title">
        <p>推广楼盘广告语</p>
      </div>
      <el-input
        v-model="buildingInfo.buildingAd"
        placeholder="请输入推广楼盘广告语"
        size="small"
      ></el-input>
    </div>
    <div class="inner-border-fifth-fourth">
      <div class="main-title">
        <p>项目图片</p>
      </div>
      <el-upload
        class="tip"
        accept=".png,.jpg,.jpeg,.PNG,.JPG,.JPEG"
        action=""
        :file-list="fileList"
        :on-success="onSuccess"
        :http-request="uploadImg"
        list-type="picture-card"
      >
        <i class="el-icon-plus"></i>
      </el-upload>
    </div>
  </el-card>
</template>

<script>
// import axios from "axios";
import { uploads } from "@/api/object/uploads.js";
import { addBuilding } from "@/api/object/building.js";
import axios from "axios";
export default {
  data() {
    return {
      buildingInfo: {
        // 推广楼盘名称输入框
        buildingName: "",
        // 推广楼盘广告语输入框
        buildingAd: "",
      },
      // 图片数组
      fileList: [],
      buildingPic: [],
    };
  },
  methods: {
    add() {},
    // 上传文件之前
    beforeUpload(file) {
      // console.log(file)
    },
    // 上传文件方法
    uploadImg(param) {
      // console.log(data);
      let self = this;
      let formData = new FormData();
      formData.append("file", param.file);
      uploads(formData).then((res) => {
        console.log(res);
        self.buildingPic.push("/profile/upload/" + res);
      });
    },
    // 图片上传成功后
    onSuccess(response, file, fileList) {
      file.file_id = response.file_id;
      this.fileList.push(file);
    },
    add() {
      let e = this.buildingPic.join(",");
      let param = JSON.parse(JSON.stringify(this.buildingInfo));
      param.buildingPic = e;
      console.log(param);
      addBuilding(param).then((res) => {
        console.log(res);
      });
    },
  },
};
</script>
