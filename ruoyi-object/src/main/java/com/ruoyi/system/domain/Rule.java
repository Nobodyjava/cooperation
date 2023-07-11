package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 【请填写功能名称】对象 rule
 *
 * @author ruoyi
 * @date 2023-07-08
 */
public class Rule extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 活动规则id */
    private Long ruleId;

    /** 活动规则内容 */
    @Excel(name = "活动规则内容")
    private String content;

    public void setRuleId(Long ruleId)
    {
        this.ruleId = ruleId;
    }

    public Long getRuleId()
    {
        return ruleId;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("ruleId", getRuleId())
                .append("content", getContent())
                .append("createTime", getCreateTime())
                .toString();
    }
}

