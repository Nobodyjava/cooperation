package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 核销表实体类
 * @Author:cy
 * @Date:2023/7/21
 */
public class Verification extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 核销表自增长id */
    private Long verificationId;

    /** 活动id */
    @Excel(name = "活动id")
    private Long activityId;

    /** openid */
    @Excel(name = "openid")
    private Long openid;

    /** 核销账号 */
    @Excel(name = "核销账号")
    private String validatedAccount;

    public void setVerificationId(Long verificationId)
    {
        this.verificationId = verificationId;
    }

    public Long getVerificationId()
    {
        return verificationId;
    }
    public void setActivityId(Long activityId)
    {
        this.activityId = activityId;
    }

    public Long getActivityId()
    {
        return activityId;
    }
    public void setOpenid(Long openid)
    {
        this.openid = openid;
    }

    public Long getOpenid()
    {
        return openid;
    }
    public void setValidatedAccount(String validatedAccount)
    {
        this.validatedAccount = validatedAccount;
    }

    public String getValidatedAccount()
    {
        return validatedAccount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("verificationId", getVerificationId())
                .append("activityId", getActivityId())
                .append("openid", getOpenid())
                .append("validatedAccount", getValidatedAccount())
                .toString();
    }
}

