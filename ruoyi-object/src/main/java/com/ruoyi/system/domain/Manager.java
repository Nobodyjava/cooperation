package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 manager
 *
 * @author ruoyi
 * @date 2023-06-10
 */
public class Manager extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 审批流程审批人id */
    private Long managerId;

    /** 审批流程审批人姓名 */
    @Excel(name = "审批流程审批人姓名")
    private String managerName;

    /** 审批流程审核人联系电话 */
    @Excel(name = "审批流程审核人联系电话")
    private String managerPhone;

    /** 审批流程审核人密码 */
    @Excel(name = "审批流程审核人密码")
    private String managerPassword;

    /** 活动id */
    @Excel(name = "活动id")
    private Long activityId;

    /** 错误信息 */
    @Excel(name = "错误信息")
    private String errorMsg;

    public void setManagerId(Long managerId)
    {
        this.managerId = managerId;
    }

    public Long getManagerId()
    {
        return managerId;
    }
    public void setManagerName(String managerName)
    {
        this.managerName = managerName;
    }

    public String getManagerName()
    {
        return managerName;
    }
    public void setManagerPhone(String managerPhone)
    {
        this.managerPhone = managerPhone;
    }

    public String getManagerPhone()
    {
        return managerPhone;
    }
    public void setManagerPassword(String managerPassword)
    {
        this.managerPassword = managerPassword;
    }

    public String getManagerPassword()
    {
        return managerPassword;
    }
    public void setActivityId(Long activityId)
    {
        this.activityId = activityId;
    }

    public Long getActivityId()
    {
        return activityId;
    }
    public void setErrorMsg(String errorMsg)
    {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg()
    {
        return errorMsg;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("managerId", getManagerId())
                .append("managerName", getManagerName())
                .append("managerPhone", getManagerPhone())
                .append("managerPassword", getManagerPassword())
                .append("activityId", getActivityId())
                .append("errorMsg", getErrorMsg())
                .toString();
    }
}
