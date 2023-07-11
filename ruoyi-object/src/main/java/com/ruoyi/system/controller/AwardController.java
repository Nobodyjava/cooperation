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
import com.ruoyi.system.domain.Award;
import com.ruoyi.system.service.IAwardService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 阶梯奖励Controller
 *
 * @author ruoyi
 * @date 2023-06-05
 */
@RestController
@RequestMapping("/object/award")
public class AwardController extends BaseController
{
    @Autowired
    private IAwardService awardService;

    /**
     * 查询阶梯奖励列表
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:award:list')")
    @GetMapping("/list")
    public TableDataInfo list(Award award)
    {
        startPage();
        List<Award> list = awardService.selectAwardList(award);
        return getDataTable(list);
    }

    /**
     * 导出阶梯奖励列表
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:award:export')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Award award)
    {
        List<Award> list = awardService.selectAwardList(award);
        ExcelUtil<Award> util = new ExcelUtil<Award>(Award.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取阶梯奖励详细信息
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:award:query')")
    @GetMapping(value = "/{awardId}")
    public AjaxResult getInfo(@PathVariable("awardId") String awardId)
    {
        return success(awardService.selectAwardByAwardId(awardId));
    }

    /**
     * 新增阶梯奖励
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:award:add')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Award award)
    {
        return toAjax(awardService.insertAward(award));
    }

    /**
     * 修改阶梯奖励
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:award:edit')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Award award)
    {
        return toAjax(awardService.updateAward(award));
    }

    /**
     * 删除阶梯奖励
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:award:remove')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @DeleteMapping("/{awardIds}")
    public AjaxResult remove(@PathVariable String[] awardIds)
    {
        return toAjax(awardService.deleteAwardByAwardIds(awardIds));
    }
}

