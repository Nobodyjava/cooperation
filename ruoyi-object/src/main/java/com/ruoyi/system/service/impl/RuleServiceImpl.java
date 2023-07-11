package com.ruoyi.system.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.Rule;
import com.ruoyi.system.mapper.RuleMapper;
import com.ruoyi.system.service.IRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2023-07-08
 */
@Service
public class RuleServiceImpl implements IRuleService
{
    @Autowired
    private RuleMapper ruleMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param ruleId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Rule selectRuleByRuleId(Long ruleId)
    {
        return ruleMapper.selectRuleByRuleId(ruleId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param rule 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Rule> selectRuleList(Rule rule)
    {
        return ruleMapper.selectRuleList(rule);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param rule 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertRule(Rule rule)
    {
        rule.setCreateTime(DateUtils.getNowDate());
        return ruleMapper.insertRule(rule);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param rule 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateRule(Rule rule)
    {
        return ruleMapper.updateRule(rule);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ruleIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteRuleByRuleIds(Long[] ruleIds)
    {
        return ruleMapper.deleteRuleByRuleIds(ruleIds);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param ruleId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteRuleByRuleId(Long ruleId)
    {
        return ruleMapper.deleteRuleByRuleId(ruleId);
    }

    /**
     * 查询出创建时间最晚的一条活动规则
     * @param rule
     * @return
     */
    @Override
    public Rule selectRuleByTime(Rule rule) {
        return ruleMapper.selectRuleByTime(rule);
    }
}

