package com.ruoyi.system.service;

import com.ruoyi.system.domain.Shopper;
import com.ruoyi.system.domain.Verification;

import java.util.List;

/**
 * 核销表业务逻辑层
 * @Author:cy
 * @Date:2023/7/21
 */
public interface IVerificationService
{
    /**
     * 查询【请填写功能名称】
     *
     * @param verificationId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Verification selectVerificationByVerificationId(Long verificationId);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param verification 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Verification> selectVerificationList(Verification verification);

    /**
     * 新增【请填写功能名称】
     *
     * @param verification 【请填写功能名称】
     * @return 结果
     */
    public int insertVerification(Verification verification);

    /**
     * 修改【请填写功能名称】
     *
     * @param verification 【请填写功能名称】
     * @return 结果
     */
    public int updateVerification(Verification verification);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param verificationIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteVerificationByVerificationIds(Long[] verificationIds);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param verificationId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteVerificationByVerificationId(Long verificationId);

    /**
     * 根据活动id先查商家id，再根据商家id查询商家电话和核销账号
     * @param activityId
     * @return
     */
    public String selectShopperByActivityId(Long activityId);
}

