package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SponsorMapper;
import com.ruoyi.system.domain.Sponsor;
import com.ruoyi.system.service.ISponsorService;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2023-06-12
 */
@Service
public class SponsorServiceImpl implements ISponsorService
{
    @Autowired
    private SponsorMapper sponsorMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param sponsorId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Sponsor selectSponsorBySponsorId(Long sponsorId)
    {
        return sponsorMapper.selectSponsorBySponsorId(sponsorId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param sponsor 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Sponsor> selectSponsorList(Sponsor sponsor)
    {
        return sponsorMapper.selectSponsorList(sponsor);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param sponsor 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSponsor(Sponsor sponsor)
    {
        return sponsorMapper.insertSponsor(sponsor);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param sponsor 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSponsor(Sponsor sponsor)
    {
        return sponsorMapper.updateSponsor(sponsor);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param sponsorIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSponsorBySponsorIds(Long[] sponsorIds)
    {
        return sponsorMapper.deleteSponsorBySponsorIds(sponsorIds);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param sponsorId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSponsorBySponsorId(Long sponsorId)
    {
        return sponsorMapper.deleteSponsorBySponsorId(sponsorId);
    }
}
