package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 claim
 *
 * @author ruoyi
 * @date 2023-07-10
 */
public class Claim extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 领取表自增长id */
    private Long claimId;

    /** openid */
    @Excel(name = "openId")
    private String openId;

    /** 活动id */
    @Excel(name = "活动id")
    private Long activityId;

    /** 优惠券id */
    @Excel(name = "优惠券id")
    private Long discountId;

    public void setClaimId(Long claimId)
    {
        this.claimId = claimId;
    }

    public Long getClaimId()
    {
        return claimId;
    }
    public void setOpenId(String openId)
    {
        this.openId = openId;
    }

    public String getOpenId()
    {
        return openId;
    }
    public void setActivityId(Long activityId)
    {
        this.activityId = activityId;
    }

    public Long getActivityId()
    {
        return activityId;
    }
    public void setDiscountId(Long discountId)
    {
        this.discountId = discountId;
    }

    public Long getDiscountId()
    {
        return discountId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("claimId", getClaimId())
                .append("openId", getOpenId())
                .append("activityId", getActivityId())
                .append("discountId", getDiscountId())
                .toString();
    }
}

