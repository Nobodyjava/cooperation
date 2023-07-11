package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 discount
 *
 * @author ruoyi
 * @date 2023-06-06
 */
public class Discount extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 优惠券id */
    private Long discountId;

    /** 优惠券类型 */
    @Excel(name = "优惠券类型")
    private String discountType;

    /** 优惠券名称 */
    @Excel(name = "优惠券名称")
    private String discountName;

    public void setDiscountId(Long discountId)
    {
        this.discountId = discountId;
    }

    public Long getDiscountId()
    {
        return discountId;
    }
    public void setDiscountType(String discountType)
    {
        this.discountType = discountType;
    }

    public String getDiscountType()
    {
        return discountType;
    }
    public void setDiscountName(String discountName)
    {
        this.discountName = discountName;
    }

    public String getDiscountName()
    {
        return discountName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("discountId", getDiscountId())
                .append("discountType", getDiscountType())
                .append("discountName", getDiscountName())
                .toString();
    }
}

