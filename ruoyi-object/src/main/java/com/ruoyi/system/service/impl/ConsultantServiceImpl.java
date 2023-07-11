package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ConsultantMapper;
import com.ruoyi.system.domain.Consultant;
import com.ruoyi.system.service.IConsultantService;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2023-06-10
 */
@Service
public class ConsultantServiceImpl implements IConsultantService
{
    @Autowired
    private ConsultantMapper consultantMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param consultantId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Consultant selectConsultantByConsultantId(Long consultantId)
    {
        return consultantMapper.selectConsultantByConsultantId(consultantId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param consultant 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Consultant> selectConsultantList(Consultant consultant)
    {
        return consultantMapper.selectConsultantList(consultant);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param consultant 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertConsultant(Consultant consultant)
    {
        return consultantMapper.insertConsultant(consultant);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param consultant 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateConsultant(Consultant consultant)
    {
        return consultantMapper.updateConsultant(consultant);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param consultantIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteConsultantByConsultantIds(Long[] consultantIds)
    {
        return consultantMapper.deleteConsultantByConsultantIds(consultantIds);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param consultantId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteConsultantByConsultantId(Long consultantId)
    {
        return consultantMapper.deleteConsultantByConsultantId(consultantId);
    }

    /**
     * 根据顾问手机号查询顾问信息
     * @param consultantPhone
     * @return
     */
    @Override
    public Consultant selectConsultantByConsultantPhone(String consultantPhone) {
        return consultantMapper.selectConsultantByConsultantPhone(consultantPhone);
    }

    /**
     * 审核人根据活动id修改活动审核码状态
     * @param activityId
     * @return
     */
    @Override
    public int updateActivityCheckStatus(Long activityId) {
        return consultantMapper.updateActivityCheckStatus(activityId);
    }

    /**
     * 审核人根据商家id修改商家审核码状态
     * @param shopperId
     * @return
     */
    @Override
    public int updateShopperCheckStatus(Long shopperId) {
        return consultantMapper.updateShopperCheckStatus(shopperId);
    }
}
