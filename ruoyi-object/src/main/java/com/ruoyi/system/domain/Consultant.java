package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 consultant
 *
 * @author ruoyi
 * @date 2023-06-13
 */
public class Consultant extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 顾问id */
    private Long consultantId;

    /** 商家id */
    @Excel(name = "商家id")
    private Long shopperId;

    /** 活动id */
    @Excel(name = "活动id")
    private Long activityId;

    /** 顾问token */
    @Excel(name = "顾问token")
    private String consultantToken;

    /** 顾问姓名 */
    @Excel(name = "顾问姓名")
    private String consultantName;

    /** 顾问联系电话 */
    @Excel(name = "顾问联系电话")
    private String consultantPhone;

    /** 顾问归属项目 */
    @Excel(name = "顾问归属项目")
    private String project;

    /** 顾问密码 */
    @Excel(name = "顾问密码")
    private String consultantPassword;

    public void setConsultantId(Long consultantId)
    {
        this.consultantId = consultantId;
    }

    public Long getConsultantId()
    {
        return consultantId;
    }
    public void setShopperId(Long shopperId)
    {
        this.shopperId = shopperId;
    }

    public Long getShopperId()
    {
        return shopperId;
    }
    public void setActivityId(Long activityId)
    {
        this.activityId = activityId;
    }

    public Long getActivityId()
    {
        return activityId;
    }
    public void setConsultantToken(String consultantToken)
    {
        this.consultantToken = consultantToken;
    }

    public String getConsultantToken()
    {
        return consultantToken;
    }
    public void setConsultantName(String consultantName)
    {
        this.consultantName = consultantName;
    }

    public String getConsultantName()
    {
        return consultantName;
    }
    public void setConsultantPhone(String consultantPhone)
    {
        this.consultantPhone = consultantPhone;
    }

    public String getConsultantPhone()
    {
        return consultantPhone;
    }
    public void setProject(String project)
    {
        this.project = project;
    }

    public String getProject()
    {
        return project;
    }
    public void setConsultantPassword(String consultantPassword)
    {
        this.consultantPassword = consultantPassword;
    }

    public String getConsultantPassword()
    {
        return consultantPassword;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("consultantId", getConsultantId())
                .append("shopperId", getShopperId())
                .append("activityId", getActivityId())
                .append("consultantToken", getConsultantToken())
                .append("consultantName", getConsultantName())
                .append("consultantPhone", getConsultantPhone())
                .append("project", getProject())
                .append("consultantPassword", getConsultantPassword())
                .toString();
    }
}
