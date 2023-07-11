package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Claim;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2023-07-10
 */
public interface IClaimService
{
    /**
     * 查询【请填写功能名称】
     *
     * @param claimId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Claim selectClaimByClaimId(Long claimId);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param claim 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Claim> selectClaimList(Claim claim);

    /**
     * 新增【请填写功能名称】
     *
     * @param claim 【请填写功能名称】
     * @return 结果
     */
    public int insertClaim(Claim claim);

    /**
     * 修改【请填写功能名称】
     *
     * @param claim 【请填写功能名称】
     * @return 结果
     */
    public int updateClaim(Claim claim);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param claimIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteClaimByClaimIds(Long[] claimIds);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param claimId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteClaimByClaimId(Long claimId);

    /**
     * 根据openId和活动id查询优惠券信息id
     * @param openId
     * @param activityId
     * @return
     */
    public Long selectMsg(String openId,Long activityId);
}

