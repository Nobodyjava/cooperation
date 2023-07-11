package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Sponsor;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2023-06-12
 */
public interface SponsorMapper
{
    /**
     * 查询【请填写功能名称】
     *
     * @param sponsorId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Sponsor selectSponsorBySponsorId(Long sponsorId);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param sponsor 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Sponsor> selectSponsorList(Sponsor sponsor);

    /**
     * 新增【请填写功能名称】
     *
     * @param sponsor 【请填写功能名称】
     * @return 结果
     */
    public int insertSponsor(Sponsor sponsor);

    /**
     * 修改【请填写功能名称】
     *
     * @param sponsor 【请填写功能名称】
     * @return 结果
     */
    public int updateSponsor(Sponsor sponsor);

    /**
     * 删除【请填写功能名称】
     *
     * @param sponsorId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteSponsorBySponsorId(Long sponsorId);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param sponsorIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSponsorBySponsorIds(Long[] sponsorIds);
}
