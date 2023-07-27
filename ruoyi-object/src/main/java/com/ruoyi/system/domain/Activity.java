package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 activity
 *
 * @author ruoyi
 * @date 2023-06-20
 */
public class Activity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 活动id */
    private Long activityId;

    /** 顾问id */
    @Excel(name = "顾问id")
    private Long consultantId;

    /** 商家id */
    @Excel(name = "商家id")
    private Long shopperId;

    /** 商品id */
    @Excel(name = "商品id")
    private Long goodsId;

    /** 活动主题 */
    @Excel(name = "活动主题")
    private String activityTopic;

    /** 活动开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Excel(name = "活动开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date begintime;

    /** 活动结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Excel(name = "活动结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endtime;

    /** 活动推广城市 */
    @Excel(name = "活动推广城市")
    private String activityCity;

    /** 项目负责人 */
    @Excel(name = "项目负责人")
    private String leader;

    /** 商品核销截止日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "商品核销截止日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date goodsEndtime;

    /** 微信分享语 */
    @Excel(name = "微信分享语")
    private String sharing;

    /** 分享卡片 */
    @Excel(name = "分享卡片")
    private String cards;

    /** 活动列表封面图 */
    @Excel(name = "活动列表封面图")
    private String pic;

    /** 是否通过凤凰通成交金额奖励 0通过1不通过 */
    @Excel(name = "是否通过凤凰通成交金额奖励 0通过1不通过")
    private Integer status;

    /** 审核码 0通过1不通过 */
    @Excel(name = "审核码 0通过1不通过")
    private Integer checkStatus;

    public void setActivityId(Long activityId)
    {
        this.activityId = activityId;
    }

    public Long getActivityId()
    {
        return activityId;
    }
    public void setConsultantId(Long consultantId)
    {
        this.consultantId = consultantId;
    }

    public Long getConsultantId()
    {
        return consultantId;
    }
    public void setShopperId(Long shopperId)
    {
        this.shopperId = shopperId;
    }

    public Long getShopperId()
    {
        return shopperId;
    }
    public void setGoodsId(Long goodsId)
    {
        this.goodsId = goodsId;
    }

    public Long getGoodsId()
    {
        return goodsId;
    }
    public void setActivityTopic(String activityTopic)
    {
        this.activityTopic = activityTopic;
    }

    public String getActivityTopic()
    {
        return activityTopic;
    }
    public void setBegintime(Date begintime)
    {
        this.begintime = begintime;
    }

    public Date getBegintime()
    {
        return begintime;
    }
    public void setEndtime(Date endtime)
    {
        this.endtime = endtime;
    }

    public Date getEndtime()
    {
        return endtime;
    }
    public void setActivityCity(String activityCity)
    {
        this.activityCity = activityCity;
    }

    public String getActivityCity()
    {
        return activityCity;
    }
    public void setLeader(String leader)
    {
        this.leader = leader;
    }

    public String getLeader()
    {
        return leader;
    }
    public void setGoodsEndtime(Date goodsEndtime)
    {
        this.goodsEndtime = goodsEndtime;
    }

    public Date getGoodsEndtime()
    {
        return goodsEndtime;
    }
    public void setSharing(String sharing)
    {
        this.sharing = sharing;
    }

    public String getSharing()
    {
        return sharing;
    }
    public void setCards(String cards)
    {
        this.cards = cards;
    }

    public String getCards()
    {
        return cards;
    }
    public void setPic(String pic)
    {
        this.pic = pic;
    }

    public String getPic()
    {
        return pic;
    }
    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
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
                .append("activityId", getActivityId())
                .append("consultantId", getConsultantId())
                .append("shopperId", getShopperId())
                .append("goodsId", getGoodsId())
                .append("activityTopic", getActivityTopic())
                .append("begintime", getBegintime())
                .append("endtime", getEndtime())
                .append("activityCity", getActivityCity())
                .append("leader", getLeader())
                .append("goodsEndtime", getGoodsEndtime())
                .append("sharing", getSharing())
                .append("cards", getCards())
                .append("pic", getPic())
                .append("status", getStatus())
                .append("checkStatus", getCheckStatus())
                .toString();
    }
}
