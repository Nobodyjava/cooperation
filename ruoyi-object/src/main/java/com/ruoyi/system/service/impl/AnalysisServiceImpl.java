package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AnalysisMapper;
import com.ruoyi.system.domain.Analysis;
import com.ruoyi.system.service.IAnalysisService;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2023-06-07
 */
@Service
public class AnalysisServiceImpl implements IAnalysisService
{
    @Autowired
    private AnalysisMapper analysisMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param analyseId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Analysis selectAnalysisByAnalyseId(Long analyseId)
    {
        return analysisMapper.selectAnalysisByAnalyseId(analyseId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param analysis 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Analysis> selectAnalysisList(Analysis analysis)
    {
        return analysisMapper.selectAnalysisList(analysis);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param analysis 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertAnalysis(Analysis analysis)
    {
        return analysisMapper.insertAnalysis(analysis);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param analysis 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateAnalysis(Analysis analysis)
    {
        return analysisMapper.updateAnalysis(analysis);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param analyseIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteAnalysisByAnalyseIds(Long[] analyseIds)
    {
        return analysisMapper.deleteAnalysisByAnalyseIds(analyseIds);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param analyseId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteAnalysisByAnalyseId(Long analyseId)
    {
        return analysisMapper.deleteAnalysisByAnalyseId(analyseId);
    }
}
