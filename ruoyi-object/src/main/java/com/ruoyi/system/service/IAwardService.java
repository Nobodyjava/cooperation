package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Award;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2023-06-05
 */
public interface IAwardService
{
    /**
     * 查询【请填写功能名称】
     *
     * @param awardId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Award selectAwardByAwardId(String awardId);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param award 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Award> selectAwardList(Award award);

    /**
     * 新增【请填写功能名称】
     *
     * @param award 【请填写功能名称】
     * @return 结果
     */
    public int insertAward(Award award);

    /**
     * 修改【请填写功能名称】
     *
     * @param award 【请填写功能名称】
     * @return 结果
     */
    public int updateAward(Award award);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param awardIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteAwardByAwardIds(String[] awardIds);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param awardId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteAwardByAwardId(String awardId);
}
