package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 forward
 *
 * @author ruoyi
 * @date 2023-06-14
 */
public class Forward extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 转发表id */
    private Long forwardId;

    /** 顾问id */
    @Excel(name = "顾问id")
    private Long consultantId;

    /** 商品id */
    @Excel(name = "商品id")
    private Long goodsId;

    /** 活动id */
    @Excel(name = "活动id")
    private Long activityId;

    /** 当前参与人id */
    @Excel(name = "当前参与人id")
    private String openId;

    /** 当前助力人数 */
    @Excel(name = "当前助力人数")
    private Long helpCount;

    /** 核销码状态 */
    @Excel(name = "核销码状态")
    private Long status;

    public void setForwardId(Long forwardId)
    {
        this.forwardId = forwardId;
    }

    public Long getForwardId()
    {
        return forwardId;
    }
    public void setConsultantId(Long consultantId)
    {
        this.consultantId = consultantId;
    }

    public Long getConsultantId()
    {
        return consultantId;
    }
    public void setGoodsId(Long goodsId)
    {
        this.goodsId = goodsId;
    }

    public Long getGoodsId()
    {
        return goodsId;
    }
    public void setActivityId(Long activityId)
    {
        this.activityId = activityId;
    }

    public Long getActivityId()
    {
        return activityId;
    }
    public void setOpenId(String openId)
    {
        this.openId = openId;
    }

    public String getOpenId()
    {
        return openId;
    }
    public void setHelpCount(Long helpCount)
    {
        this.helpCount = helpCount;
    }

    public Long getHelpCount()
    {
        return helpCount;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Forward{" +
                "forwardId=" + forwardId +
                ", consultantId=" + consultantId +
                ", goodsId=" + goodsId +
                ", activityId=" + activityId +
                ", openId='" + openId + '\'' +
                ", helpCount=" + helpCount +
                ", status=" + status +
                '}';
    }
}
