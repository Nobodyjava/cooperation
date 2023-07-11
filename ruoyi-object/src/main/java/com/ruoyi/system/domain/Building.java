package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 building
 *
 * @author ruoyi
 * @date 2023-06-16
 */
public class Building extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 楼盘id */
    private Long buildingId;

    /** 推广楼盘名称 */
    @Excel(name = "推广楼盘名称")
    private String buildingName;

    /** 推广楼盘广告语 */
    @Excel(name = "推广楼盘广告语")
    private String buildingAd;

    /** 项目轮播图 */
    @Excel(name = "项目轮播图")
    private String buildingPic;

    public void setBuildingId(Long buildingId)
    {
        this.buildingId = buildingId;
    }

    public Long getBuildingId()
    {
        return buildingId;
    }
    public void setBuildingName(String buildingName)
    {
        this.buildingName = buildingName;
    }

    public String getBuildingName()
    {
        return buildingName;
    }
    public void setBuildingAd(String buildingAd)
    {
        this.buildingAd = buildingAd;
    }

    public String getBuildingAd()
    {
        return buildingAd;
    }
    public void setBuildingPic(String buildingPic)
    {
        this.buildingPic = buildingPic;
    }

    public String getBuildingPic()
    {
        return buildingPic;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("buildingId", getBuildingId())
                .append("buildingName", getBuildingName())
                .append("buildingAd", getBuildingAd())
                .append("buildingPic", getBuildingPic())
                .toString();
    }
}

