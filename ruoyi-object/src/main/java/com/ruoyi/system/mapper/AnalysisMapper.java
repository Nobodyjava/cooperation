package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Analysis;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2023-06-07
 */
public interface AnalysisMapper
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
     * 删除【请填写功能名称】
     *
     * @param analyseId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteAnalysisByAnalyseId(Long analyseId);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param analyseIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAnalysisByAnalyseIds(Long[] analyseIds);
}
