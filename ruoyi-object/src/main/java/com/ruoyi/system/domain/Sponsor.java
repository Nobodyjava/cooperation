package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 sponsor
 *
 * @author ruoyi
 * @date 2023-06-12
 */
public class Sponsor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 活动赞助方id */
    private Long sponsorId;

    /** 主题 */
    @Excel(name = "主题")
    private String topic;

    /** 图片 */
    @Excel(name = "图片")
    private String pic;

    public void setSponsorId(Long sponsorId)
    {
        this.sponsorId = sponsorId;
    }

    public Long getSponsorId()
    {
        return sponsorId;
    }
    public void setTopic(String topic)
    {
        this.topic = topic;
    }

    public String getTopic()
    {
        return topic;
    }
    public void setPic(String pic)
    {
        this.pic = pic;
    }

    public String getPic()
    {
        return pic;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("sponsorId", getSponsorId())
                .append("topic", getTopic())
                .append("pic", getPic())
                .toString();
    }
}

