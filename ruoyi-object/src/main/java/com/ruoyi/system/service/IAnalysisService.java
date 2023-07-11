package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Analysis;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2023-06-07
 */
public interface IAnalysisService
{
    /**
     * 查询【请填写功能名称】
     *
     * @param analyseId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Analysis selectAnalysisByAnalyseId(Long analyseId);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param analysis 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Analysis> selectAnalysisList(Analysis analysis);

    /**
     * 新增【请填写功能名称】
     *
     * @param analysis 【请填写功能名称】
     * @return 结果
     */
    public int insertAnalysis(Analysis analysis);

    /**
     * 修改【请填写功能名称】
     *
     * @param analysis 【请填写功能名称】
     * @return 结果
     */
    public int updateAnalysis(Analysis analysis);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param analyseIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteAnalysisByAnalyseIds(Long[] analyseIds);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param analyseId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteAnalysisByAnalyseId(Long analyseId);
}
