package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 提现表实体类
 * @Author:cy
 * @Date:2023/7/21
 */
public class Withdrawal extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增长id */
    private Long withdrawalId;

    /** 顾问id */
    private Long consultantId;

    /** 提现人手机号 */
    @Excel(name = "提现人手机号")
    private String phone;

    /** 提现金额 */
    @Excel(name = "提现金额")
    private BigDecimal money;

    /** 提现时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "提现时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date withdrawalTime;

    public Withdrawal() {
    }

    public Withdrawal(Long withdrawalId, Long consultantId, String phone, BigDecimal money, Date withdrawalTime) {
        this.withdrawalId = withdrawalId;
        this.consultantId = consultantId;
        this.phone = phone;
        this.money = money;
        this.withdrawalTime = withdrawalTime;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getWithdrawalId() {
        return withdrawalId;
    }

    public void setWithdrawalId(Long withdrawalId) {
        this.withdrawalId = withdrawalId;
    }

    public Long getConsultantId() {
        return consultantId;
    }

    public void setConsultantId(Long consultantId) {
        this.consultantId = consultantId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Date getWithdrawalTime() {
        return withdrawalTime;
    }

    public void setWithdrawalTime(Date withdrawalTime) {
        this.withdrawalTime = withdrawalTime;
    }

    @Override
    public String toString() {
        return "Withdrawal{" +
                "withdrawalId=" + withdrawalId +
                ", consultantId=" + consultantId +
                ", phone='" + phone + '\'' +
                ", money=" + money +
                ", withdrawalTime=" + withdrawalTime +
                '}';
    }
}

