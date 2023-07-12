package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Claim;
import com.ruoyi.system.domain.Discount;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2023-07-10
 */
public interface ClaimMapper
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
     * 删除【请填写功能名称】
     *
     * @param claimId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteClaimByClaimId(Long claimId);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param claimIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteClaimByClaimIds(Long[] claimIds);

    /**
     * 根据openId和活动id查询优惠券信息
     * @param claim
     * @return
     */
    public List<Discount> selectMsg(Claim claim);
}

