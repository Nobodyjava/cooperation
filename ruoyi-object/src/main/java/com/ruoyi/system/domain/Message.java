package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 message
 *
 * @author ruoyi
 * @date 2023-06-03
 */
public class Message extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 信息id */
    private String messageId;

    /** 推广城市范围 */
    @Excel(name = "推广城市范围")
    private String messageCity;

    /** 项目营销负责人 */
    @Excel(name = "项目营销负责人")
    private String messageLeader;

    public void setMessageId(String messageId)
    {
        this.messageId = messageId;
    }

    public String getMessageId()
    {
        return messageId;
    }
    public void setMessageCity(String messageCity)
    {
        this.messageCity = messageCity;
    }

    public String getMessageCity()
    {
        return messageCity;
    }
    public void setMessageLeader(String messageLeader)
    {
        this.messageLeader = messageLeader;
    }

    public String getMessageLeader()
    {
        return messageLeader;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("messageId", getMessageId())
                .append("messageCity", getMessageCity())
                .append("messageLeader", getMessageLeader())
                .toString();
    }
}
