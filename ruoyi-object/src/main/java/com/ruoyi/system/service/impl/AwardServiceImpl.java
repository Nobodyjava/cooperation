package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AwardMapper;
import com.ruoyi.system.domain.Award;
import com.ruoyi.system.service.IAwardService;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2023-06-05
 */
@Service
public class AwardServiceImpl implements IAwardService
{
    @Autowired
    private AwardMapper awardMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param awardId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Award selectAwardByAwardId(String awardId)
    {
        return awardMapper.selectAwardByAwardId(awardId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param award 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Award> selectAwardList(Award award)
    {
        return awardMapper.selectAwardList(award);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param award 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertAward(Award award)
    {
        return awardMapper.insertAward(award);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param award 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateAward(Award award)
    {
        return awardMapper.updateAward(award);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param awardIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteAwardByAwardIds(String[] awardIds)
    {
        return awardMapper.deleteAwardByAwardIds(awardIds);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param awardId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteAwardByAwardId(String awardId)
    {
        return awardMapper.deleteAwardByAwardId(awardId);
    }
}

