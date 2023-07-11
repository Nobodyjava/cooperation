package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 participant
 *
 * @author ruoyi
 * @date 2023-06-10
 */
public class Participant extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 参与人id */
    private Long participantId;

    /** 参与人姓名 */
    @Excel(name = "参与人姓名")
    private String participantName;

    /** 参与人联系电话 */
    @Excel(name = "参与人联系电话")
    private String participantPhone;

    /** 参与人密码 */
    @Excel(name = "参与人密码")
    private String participantPassword;

    /** 参与人ip地址 */
    @Excel(name = "参与人ip地址")
    private String participantIp;

    /** 参与人点赞数 */
    @Excel(name = "参与人点赞数")
    private Long participantLike;

    public void setParticipantId(Long participantId)
    {
        this.participantId = participantId;
    }

    public Long getParticipantId()
    {
        return participantId;
    }
    public void setParticipantName(String participantName)
    {
        this.participantName = participantName;
    }

    public String getParticipantName()
    {
        return participantName;
    }
    public void setParticipantPhone(String participantPhone)
    {
        this.participantPhone = participantPhone;
    }

    public String getParticipantPhone()
    {
        return participantPhone;
    }
    public void setParticipantPassword(String participantPassword)
    {
        this.participantPassword = participantPassword;
    }

    public String getParticipantPassword()
    {
        return participantPassword;
    }
    public void setParticipantIp(String participantIp)
    {
        this.participantIp = participantIp;
    }

    public String getParticipantIp()
    {
        return participantIp;
    }
    public void setParticipantLike(Long participantLike)
    {
        this.participantLike = participantLike;
    }

    public Long getParticipantLike()
    {
        return participantLike;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("participantId", getParticipantId())
                .append("participantName", getParticipantName())
                .append("participantPhone", getParticipantPhone())
                .append("participantPassword", getParticipantPassword())
                .append("participantIp", getParticipantIp())
                .append("participantLike", getParticipantLike())
                .toString();
    }
}
