package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 analysis
 *
 * @author ruoyi
 * @date 2023-06-07
 */
public class Analysis extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商品分析id */
    private Long analyseId;

    /** 商品id */
    @Excel(name = "商品id")
    private String goodsId;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String goodsName;

    /** 已兑换 */
    @Excel(name = "已兑换")
    private Long redeemed;

    /** 已核销 */
    @Excel(name = "已核销")
    private Long writtenOff;

    /** 待核销 */
    @Excel(name = "待核销")
    private Long wait;

    /** 发放金额 */
    @Excel(name = "发放金额")
    private Long money;

    public void setAnalyseId(Long analyseId)
    {
        this.analyseId = analyseId;
    }

    public Long getAnalyseId()
    {
        return analyseId;
    }
    public void setGoodsId(String goodsId)
    {
        this.goodsId = goodsId;
    }

    public String getGoodsId()
    {
        return goodsId;
    }
    public void setGoodsName(String goodsName)
    {
        this.goodsName = goodsName;
    }

    public String getGoodsName()
    {
        return goodsName;
    }
    public void setRedeemed(Long redeemed)
    {
        this.redeemed = redeemed;
    }

    public Long getRedeemed()
    {
        return redeemed;
    }
    public void setWrittenOff(Long writtenOff)
    {
        this.writtenOff = writtenOff;
    }

    public Long getWrittenOff()
    {
        return writtenOff;
    }
    public void setWait(Long wait)
    {
        this.wait = wait;
    }

    public Long getWait()
    {
        return wait;
    }
    public void setMoney(Long money)
    {
        this.money = money;
    }

    public Long getMoney()
    {
        return money;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("analyseId", getAnalyseId())
                .append("goodsId", getGoodsId())
                .append("goodsName", getGoodsName())
                .append("redeemed", getRedeemed())
                .append("writtenOff", getWrittenOff())
                .append("wait", getWait())
                .append("money", getMoney())
                .toString();
    }
}

