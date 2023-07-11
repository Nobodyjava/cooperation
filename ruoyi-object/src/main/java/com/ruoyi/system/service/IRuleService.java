package com.ruoyi.system.service;


import com.ruoyi.system.domain.Rule;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2023-07-08
 */
public interface IRuleService
{
    /**
     * 查询【请填写功能名称】
     *
     * @param ruleId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Rule selectRuleByRuleId(Long ruleId);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param rule 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Rule> selectRuleList(Rule rule);

    /**
     * 新增【请填写功能名称】
     *
     * @param rule 【请填写功能名称】
     * @return 结果
     */
    public int insertRule(Rule rule);

    /**
     * 修改【请填写功能名称】
     *
     * @param rule 【请填写功能名称】
     * @return 结果
     */
    public int updateRule(Rule rule);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ruleIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteRuleByRuleIds(Long[] ruleIds);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param ruleId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteRuleByRuleId(Long ruleId);

    /**
     * 查询出创建时间最晚的一条活动规则
     * @param rule
     * @return
     */
    public Rule selectRuleByTime(Rule rule);
}

