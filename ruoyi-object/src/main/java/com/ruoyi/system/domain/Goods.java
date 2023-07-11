package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 goods
 *
 * @author ruoyi
 * @date 2023-06-12
 */
public class Goods extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商品id */
    private Long goodsId;

    /** 顾问id */
    @Excel(name = "顾问id")
    private Long consultantId;

    /** 商品类型 */
    @Excel(name = "商品类型")
    private String goodsType;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String goodsName;

    /** 兑换的赞数 */
    @Excel(name = "兑换的赞数")
    private String goodsLike;

    /** 添加兑换图片 */
    @Excel(name = "添加兑换图片")
    private String img;

    /** 商品原价 */
    @Excel(name = "商品原价")
    private BigDecimal goodsOriginalprice;

    /** 补贴商家费用 */
    @Excel(name = "补贴商家费用")
    private BigDecimal goodsPrice;

    /** 商品投放总量 */
    @Excel(name = "商品投放总量")
    private Long goodsTotalnum;

    /** 商品已领取数量 */
    @Excel(name = "商品已领取数量")
    private Long goodsClaimnum;

    /** 商品剩余数量 */
    @Excel(name = "商品剩余数量")
    private Long goodsRemainnum;

    /** 商品领取限制 */
    @Excel(name = "商品领取限制")
    private String goodsLimit;

    /** 使用时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "使用时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date usetime;

    /** 有效天数 */
    @Excel(name = "有效天数")
    private String fundays;

    /** 截止核销时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "截止核销时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endtime;

    /** 打折数 */
    @Excel(name = "打折数")
    private Long discount;

    /** 满减标准 */
    @Excel(name = "满减标准")
    private Long priceStandard;

    /** 满减数 */
    @Excel(name = "满减数")
    private Long priceReduction;

    /** 可减数 */
    @Excel(name = "可减数")
    private Long priceOff;

    /** 商品领取状态 0未领取完1已领取完 */
    @Excel(name = "商品领取状态 0未领取完1已领取完")
    private Integer goodsClaimstatus;

    public void setGoodsId(Long goodsId)
    {
        this.goodsId = goodsId;
    }

    public Long getGoodsId()
    {
        return goodsId;
    }
    public void setConsultantId(Long consultantId)
    {
        this.consultantId = consultantId;
    }

    public Long getConsultantId()
    {
        return consultantId;
    }
    public void setGoodsType(String goodsType)
    {
        this.goodsType = goodsType;
    }

    public String getGoodsType()
    {
        return goodsType;
    }
    public void setGoodsName(String goodsName)
    {
        this.goodsName = goodsName;
    }

    public String getGoodsName()
    {
        return goodsName;
    }
    public void setGoodsLike(String goodsLike)
    {
        this.goodsLike = goodsLike;
    }

    public String getGoodsLike()
    {
        return goodsLike;
    }
    public void setImg(String img)
    {
        this.img = img;
    }

    public String getImg()
    {
        return img;
    }
    public void setGoodsOriginalprice(BigDecimal goodsOriginalprice)
    {
        this.goodsOriginalprice = goodsOriginalprice;
    }

    public BigDecimal getGoodsOriginalprice()
    {
        return goodsOriginalprice;
    }
    public void setGoodsPrice(BigDecimal goodsPrice)
    {
        this.goodsPrice = goodsPrice;
    }

    public BigDecimal getGoodsPrice()
    {
        return goodsPrice;
    }
    public void setGoodsTotalnum(Long goodsTotalnum)
    {
        this.goodsTotalnum = goodsTotalnum;
    }

    public Long getGoodsTotalnum()
    {
        return goodsTotalnum;
    }
    public void setGoodsClaimnum(Long goodsClaimnum)
    {
        this.goodsClaimnum = goodsClaimnum;
    }

    public Long getGoodsClaimnum()
    {
        return goodsClaimnum;
    }
    public void setGoodsRemainnum(Long goodsRemainnum)
    {
        this.goodsRemainnum = goodsRemainnum;
    }

    public Long getGoodsRemainnum()
    {
        return goodsRemainnum;
    }
    public void setGoodsLimit(String goodsLimit)
    {
        this.goodsLimit = goodsLimit;
    }

    public String getGoodsLimit()
    {
        return goodsLimit;
    }
    public void setUsetime(Date usetime)
    {
        this.usetime = usetime;
    }

    public Date getUsetime()
    {
        return usetime;
    }

    public String getFundays() {
        return fundays;
    }

    public void setFundays(String fundays) {
        this.fundays = fundays;
    }

    public void setEndtime(Date endtime)
    {
        this.endtime = endtime;
    }

    public Date getEndtime()
    {
        return endtime;
    }
    public void setDiscount(Long discount)
    {
        this.discount = discount;
    }

    public Long getDiscount()
    {
        return discount;
    }
    public void setPriceStandard(Long priceStandard)
    {
        this.priceStandard = priceStandard;
    }

    public Long getPriceStandard()
    {
        return priceStandard;
    }
    public void setPriceReduction(Long priceReduction)
    {
        this.priceReduction = priceReduction;
    }

    public Long getPriceReduction()
    {
        return priceReduction;
    }
    public void setPriceOff(Long priceOff)
    {
        this.priceOff = priceOff;
    }

    public Long getPriceOff()
    {
        return priceOff;
    }
    public void setGoodsClaimstatus(Integer goodsClaimstatus)
    {
        this.goodsClaimstatus = goodsClaimstatus;
    }

    public Integer getGoodsClaimstatus()
    {
        return goodsClaimstatus;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", consultantId=" + consultantId +
                ", goodsType='" + goodsType + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsLike='" + goodsLike + '\'' +
                ", img='" + img + '\'' +
                ", goodsOriginalprice=" + goodsOriginalprice +
                ", goodsPrice=" + goodsPrice +
                ", goodsTotalnum=" + goodsTotalnum +
                ", goodsClaimnum=" + goodsClaimnum +
                ", goodsRemainnum=" + goodsRemainnum +
                ", goodsLimit='" + goodsLimit + '\'' +
                ", usetime=" + usetime +
                ", fundays='" + fundays + '\'' +
                ", endtime=" + endtime +
                ", discount=" + discount +
                ", priceStandard=" + priceStandard +
                ", priceReduction=" + priceReduction +
                ", priceOff=" + priceOff +
                ", goodsClaimstatus=" + goodsClaimstatus +
                '}';
    }
}
