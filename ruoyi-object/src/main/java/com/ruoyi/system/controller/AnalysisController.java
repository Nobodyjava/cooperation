package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.annotation.Anonymous;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Analysis;
import com.ruoyi.system.service.IAnalysisService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品分析Controller
 *
 * @author ruoyi
 * @date 2023-06-07
 */
@RestController
@RequestMapping("/object/analysis")
public class AnalysisController extends BaseController
{
    @Autowired
    private IAnalysisService analysisService;

    /**
     * 查询商品分析列表
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:analysis:list')")
    @GetMapping("/list")
    public TableDataInfo list(Analysis analysis)
    {
        startPage();
        List<Analysis> list = analysisService.selectAnalysisList(analysis);
        return getDataTable(list);
    }

    /**
     * 导出商品分析列表
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:analysis:export')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Analysis analysis)
    {
        List<Analysis> list = analysisService.selectAnalysisList(analysis);
        ExcelUtil<Analysis> util = new ExcelUtil<Analysis>(Analysis.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取商品分析详细信息
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:analysis:query')")
    @GetMapping(value = "/{analyseId}")
    public AjaxResult getInfo(@PathVariable("analyseId") Long analyseId)
    {
        return success(analysisService.selectAnalysisByAnalyseId(analyseId));
    }

    /**
     * 新增商品分析
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:analysis:add')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Analysis analysis)
    {
        return toAjax(analysisService.insertAnalysis(analysis));
    }

    /**
     * 修改商品分析
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:analysis:edit')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Analysis analysis)
    {
        return toAjax(analysisService.updateAnalysis(analysis));
    }

    /**
     * 删除商品分析
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:analysis:remove')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @DeleteMapping("/{analyseIds}")
    public AjaxResult remove(@PathVariable Long[] analyseIds)
    {
        return toAjax(analysisService.deleteAnalysisByAnalyseIds(analyseIds));
    }
}
