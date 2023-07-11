package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Consultant;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2023-06-10
 */
public interface IConsultantService
{
    /**
     * 查询【请填写功能名称】
     *
     * @param consultantId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Consultant selectConsultantByConsultantId(Long consultantId);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param consultant 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Consultant> selectConsultantList(Consultant consultant);

    /**
     * 新增【请填写功能名称】
     *
     * @param consultant 【请填写功能名称】
     * @return 结果
     */
    public int insertConsultant(Consultant consultant);

    /**
     * 修改【请填写功能名称】
     *
     * @param consultant 【请填写功能名称】
     * @return 结果
     */
    public int updateConsultant(Consultant consultant);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param consultantIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteConsultantByConsultantIds(Long[] consultantIds);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param consultantId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteConsultantByConsultantId(Long consultantId);

    /**
     * 根据顾问手机号查询顾问信息
     * @param consultantPhone
     * @return
     */
    public Consultant selectConsultantByConsultantPhone(String consultantPhone);

    /**
     * 审核人根据活动id修改活动审核码状态
     * @param activityId
     * @return
     */
    public int updateActivityCheckStatus(Long activityId);

    /**
     * 审核人根据商家id修改商家审核码状态
     * @param shopperId
     * @return
     */
    public int updateShopperCheckStatus(Long shopperId);
}
