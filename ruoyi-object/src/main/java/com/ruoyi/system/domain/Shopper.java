package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 shopper
 *
 * @author ruoyi
 * @date 2023-06-13
 */
public class Shopper extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商家id */
    private Long shopperId;

    /** 顾问id */
    @Excel(name = "顾问id")
    private Long consultantId;

    /** 商家名称 */
    @Excel(name = "商家名称")
    private String shopperName;

    /** 商家分类 */
    @Excel(name = "商家分类")
    private String shopperType;

    /** 收款账号 */
    @Excel(name = "收款账号")
    private String account;

    /** 核销账户 */
    @Excel(name = "核销账户")
    private String validatedAccount;

    /** 商家收益 */
    @Excel(name = "商家收益")
    private BigDecimal shopperGain;

    /** 顾问归属项目 */
    @Excel(name = "顾问归属项目")
    private String project;

    /** 商家联系电话 */
    @Excel(name = "商家联系电话")
    private String shopperPhone;

    /** 商家地址 */
    @Excel(name = "商家地址")
    private String shopperAddress;

    /** 商家门牌号 */
    @Excel(name = "商家门牌号")
    private String shopperHousenumber;

    /** 是否有分店 0没有1有 */
    @Excel(name = "是否有分店 0没有1有")
    private Integer status;

    /** 分店地址 */
    @Excel(name = "分店地址")
    private String branchAddress;

    /** 宣传图 */
    @Excel(name = "宣传图")
    private String img;

    /** 审核码 0通过1不通过 */
    @Excel(name = "审核码 0通过1不通过")
    private Integer checkStatus;

    public void setShopperId(Long shopperId)
    {
        this.shopperId = shopperId;
    }

    public Long getShopperId()
    {
        return shopperId;
    }
    public void setConsultantId(Long consultantId)
    {
        this.consultantId = consultantId;
    }

    public Long getConsultantId()
    {
        return consultantId;
    }
    public void setShopperName(String shopperName)
    {
        this.shopperName = shopperName;
    }

    public String getShopperName()
    {
        return shopperName;
    }
    public void setShopperType(String shopperType)
    {
        this.shopperType = shopperType;
    }

    public String getShopperType()
    {
        return shopperType;
    }
    public void setAccount(String account)
    {
        this.account = account;
    }

    public String getAccount()
    {
        return account;
    }
    public void setValidatedAccount(String validatedAccount)
    {
        this.validatedAccount = validatedAccount;
    }

    public String getValidatedAccount()
    {
        return validatedAccount;
    }
    public void setShopperGain(BigDecimal shopperGain)
    {
        this.shopperGain = shopperGain;
    }

    public BigDecimal getShopperGain()
    {
        return shopperGain;
    }
    public void setProject(String project)
    {
        this.project = project;
    }

    public String getProject()
    {
        return project;
    }
    public void setShopperPhone(String shopperPhone)
    {
        this.shopperPhone = shopperPhone;
    }

    public String getShopperPhone()
    {
        return shopperPhone;
    }
    public void setShopperAddress(String shopperAddress)
    {
        this.shopperAddress = shopperAddress;
    }

    public String getShopperAddress()
    {
        return shopperAddress;
    }
    public void setShopperHousenumber(String shopperHousenumber)
    {
        this.shopperHousenumber = shopperHousenumber;
    }

    public String getShopperHousenumber()
    {
        return shopperHousenumber;
    }
    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
    }
    public void setBranchAddress(String branchAddress)
    {
        this.branchAddress = branchAddress;
    }

    public String getBranchAddress()
    {
        return branchAddress;
    }
    public void setImg(String img)
    {
        this.img = img;
    }

    public String getImg()
    {
        return img;
    }
    public void setCheckStatus(Integer checkStatus)
    {
        this.checkStatus = checkStatus;
    }

    public Integer getCheckStatus()
    {
        return checkStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("shopperId", getShopperId())
                .append("consultantId", getConsultantId())
                .append("shopperName", getShopperName())
                .append("shopperType", getShopperType())
                .append("account", getAccount())
                .append("validatedAccount", getValidatedAccount())
                .append("shopperGain", getShopperGain())
                .append("project", getProject())
                .append("shopperPhone", getShopperPhone())
                .append("shopperAddress", getShopperAddress())
                .append("shopperHousenumber", getShopperHousenumber())
                .append("status", getStatus())
                .append("branchAddress", getBranchAddress())
                .append("img", getImg())
                .append("checkStatus", getCheckStatus())
                .toString();
    }
}
