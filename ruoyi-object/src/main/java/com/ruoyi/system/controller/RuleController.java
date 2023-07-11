package com.ruoyi.system.controller;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Rule;
import com.ruoyi.system.service.IRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 活动规则Controller
 *
 * @author ruoyi
 * @date 2023-07-08
 */
@RestController
@RequestMapping("/object/rule")
public class RuleController extends BaseController
{
    @Autowired
    private IRuleService ruleService;

    /**
     * 查询活动规则列表
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:rule:list')")
    @GetMapping("/list")
    public TableDataInfo list(Rule rule)
    {
        startPage();
        List<Rule> list = ruleService.selectRuleList(rule);
        return getDataTable(list);
    }

    /**
     * 导出活动规则列表
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:rule:export')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Rule rule)
    {
        List<Rule> list = ruleService.selectRuleList(rule);
        ExcelUtil<Rule> util = new ExcelUtil<Rule>(Rule.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取活动规则详细信息
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:rule:query')")
    @GetMapping(value = "/{ruleId}")
    public AjaxResult getInfo(@PathVariable("ruleId") Long ruleId)
    {
        return success(ruleService.selectRuleByRuleId(ruleId));
    }

    /**
     * 新增活动规则
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:rule:add')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Rule rule)
    {
        return toAjax(ruleService.insertRule(rule));
    }

    /**
     * 修改活动规则
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:rule:edit')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Rule rule)
    {
        return toAjax(ruleService.updateRule(rule));
    }

    /**
     * 删除活动规则
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:rule:remove')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ruleIds}")
    public AjaxResult remove(@PathVariable Long[] ruleIds)
    {
        return toAjax(ruleService.deleteRuleByRuleIds(ruleIds));
    }

    /**
     * 查询出创建时间最晚的一条活动规则
     * @param rule
     * @return
     */
    @Anonymous
    @GetMapping("/selectRule")
    public AjaxResult selectRule(Rule rule) {
        return success(ruleService.selectRuleByTime(rule));
    }
}