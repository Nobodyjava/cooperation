package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.system.domain.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ClaimMapper;
import com.ruoyi.system.domain.Claim;
import com.ruoyi.system.service.IClaimService;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2023-07-10
 */
@Service
public class ClaimServiceImpl implements IClaimService
{
    @Autowired
    private ClaimMapper claimMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param claimId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Claim selectClaimByClaimId(Long claimId)
    {
        return claimMapper.selectClaimByClaimId(claimId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param claim 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Claim> selectClaimList(Claim claim)
    {
        return claimMapper.selectClaimList(claim);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param claim 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertClaim(Claim claim)
    {
        return claimMapper.insertClaim(claim);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param claim 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateClaim(Claim claim)
    {
        return claimMapper.updateClaim(claim);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param claimIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteClaimByClaimIds(Long[] claimIds)
    {
        return claimMapper.deleteClaimByClaimIds(claimIds);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param claimId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteClaimByClaimId(Long claimId)
    {
        return claimMapper.deleteClaimByClaimId(claimId);
    }

    /**
     * 根据openId和活动id查询优惠券信息
     * @param claim
     * @return
     */
    @Override
    public Discount selectMsg(Claim claim) {
        return claimMapper.selectMsg(claim);
    }


}

