package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.Activity;
import com.ruoyi.system.domain.Consultant;
import com.ruoyi.system.domain.Shopper;
import com.ruoyi.system.domain.Verification;
import com.ruoyi.system.mapper.ActivityMapper;
import com.ruoyi.system.mapper.ConsultantMapper;
import com.ruoyi.system.mapper.ShopperMapper;
import com.ruoyi.system.mapper.VerificationMapper;
import com.ruoyi.system.service.IVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 核销表业务逻辑层
 * @Author:cy
 * @Date:2023/7/21
 */
@Service
public class VerificationServiceImpl implements IVerificationService
{
    @Autowired
    private VerificationMapper verificationMapper;

    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    private ShopperMapper shopperMapper;

    @Autowired
    private ConsultantMapper consultantMapper;


    /**
     * 查询【请填写功能名称】
     *
     * @param verificationId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Verification selectVerificationByVerificationId(Long verificationId)
    {
        return verificationMapper.selectVerificationByVerificationId(verificationId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param verification 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Verification> selectVerificationList(Verification verification)
    {
        return verificationMapper.selectVerificationList(verification);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param verification 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertVerification(Verification verification)
    {
        return verificationMapper.insertVerification(verification);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param verification 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateVerification(Verification verification)
    {
        return verificationMapper.updateVerification(verification);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param verificationIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteVerificationByVerificationIds(Long[] verificationIds)
    {
        return verificationMapper.deleteVerificationByVerificationIds(verificationIds);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param verificationId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteVerificationByVerificationId(Long verificationId)
    {
        return verificationMapper.deleteVerificationByVerificationId(verificationId);
    }

    /**
     * 根据活动id先查商家id，再根据商家id查询商家电话和核销账号
     * @param activityId
     * @return
     */
    @Override
    public String selectShopperByActivityId(Long activityId) {
        Activity activity = activityMapper.selectActivityByActivityId(activityId);
        Long shopperId = activity.getShopperId();
        System.out.println("得到的商家id:" + shopperId);
        Shopper shopper = shopperMapper.selectShopperByShopperId(shopperId);
        System.out.println("查到的商家信息:" + shopper);
        String validatedAccount = shopper.getValidatedAccount();
        System.out.println("查到的商家核销账户:" + validatedAccount);
        Consultant consultant = consultantMapper.selectConsultantByConsultantId(activity.getConsultantId());
        String consultantPhone = consultant.getConsultantPhone();
        System.out.println("查到的顾问手机号:" + consultantPhone);
        return consultantPhone + ";" + validatedAccount+";"+shopper.getAccount();
    }
}

