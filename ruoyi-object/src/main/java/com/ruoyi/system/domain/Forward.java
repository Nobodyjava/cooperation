package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 转发集赞表对象 forward
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

    /** openid */
    @Excel(name = "openid")
    private String openId;

    /** 当前参与人的手机号 */
    @Excel(name = "当前参与人的手机号")
    private String phone;

    /** 被邀请人手机号 */
    @Excel(name = "被邀请人手机号")
    private String bPhone;

    /** 当前助力人数 */
    @Excel(name = "当前助力人数")
    private Integer helpCount;

    /** 核销码状态 0未核销1已核销 */
    @Excel(name = "核销码状态 0未核销1已核销")
    private Integer status;

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
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhone()
    {
        return phone;
    }
    public void setbPhone(String bPhone)
    {
        this.bPhone = bPhone;
    }

    public String getbPhone()
    {
        return bPhone;
    }
    public void setHelpCount(Integer helpCount)
    {
        this.helpCount = helpCount;
    }

    public Integer getHelpCount()
    {
        return helpCount;
    }
    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("forwardId", getForwardId())
                .append("consultantId", getConsultantId())
                .append("goodsId", getGoodsId())
                .append("activityId", getActivityId())
                .append("openId", getOpenId())
                .append("phone", getPhone())
                .append("bPhone", getbPhone())
                .append("helpCount", getHelpCount())
                .append("status", getStatus())
                .toString();
    }
}

