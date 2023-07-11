package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 award
 *
 * @author ruoyi
 * @date 2023-06-05
 */
public class Award extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 奖励id */
    private String awardId;

    /** 奖励轮 */
    @Excel(name = "奖励轮")
    private Long awardTurn;

    /** 奖励现金 */
    @Excel(name = "奖励现金")
    private BigDecimal awardMoney;

    /** 奖励金豆 */
    @Excel(name = "奖励金豆")
    private Long awardBean;

    public void setAwardId(String awardId)
    {
        this.awardId = awardId;
    }

    public String getAwardId()
    {
        return awardId;
    }
    public void setAwardTurn(Long awardTurn)
    {
        this.awardTurn = awardTurn;
    }

    public Long getAwardTurn()
    {
        return awardTurn;
    }
    public void setAwardMoney(BigDecimal awardMoney)
    {
        this.awardMoney = awardMoney;
    }

    public BigDecimal getAwardMoney()
    {
        return awardMoney;
    }
    public void setAwardBean(Long awardBean)
    {
        this.awardBean = awardBean;
    }

    public Long getAwardBean()
    {
        return awardBean;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("awardId", getAwardId())
                .append("awardTurn", getAwardTurn())
                .append("awardMoney", getAwardMoney())
                .append("awardBean", getAwardBean())
                .toString();
    }
}

