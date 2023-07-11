package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.annotation.Anonymous;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Sponsor;
import com.ruoyi.system.service.ISponsorService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 活动赞助方Controller
 *
 * @author ruoyi
 * @date 2023-06-12
 */
@RestController
@RequestMapping("/object/sponsor")
public class SponsorController extends BaseController
{
    @Autowired
    private ISponsorService sponsorService;

    /**
     * 查询活动赞助方列表
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:sponsor:list')")
    @GetMapping("/list")
    public TableDataInfo list(Sponsor sponsor)
    {
        startPage();
        List<Sponsor> list = sponsorService.selectSponsorList(sponsor);
        return getDataTable(list);
    }

    /**
     * 导出活动赞助方列表
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:sponsor:export')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Sponsor sponsor)
    {
        List<Sponsor> list = sponsorService.selectSponsorList(sponsor);
        ExcelUtil<Sponsor> util = new ExcelUtil<Sponsor>(Sponsor.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取活动赞助方详细信息
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:sponsor:query')")
    @GetMapping(value = "/getInfo")
    public AjaxResult getInfo(@RequestParam("sponsorId") Long sponsorId)
    {
        return success(sponsorService.selectSponsorBySponsorId(sponsorId));
    }

    /**
     * 新增活动赞助方
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:sponsor:add')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Sponsor sponsor)
    {
        return toAjax(sponsorService.insertSponsor(sponsor));
    }

    /**
     * 修改活动赞助方
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:sponsor:edit')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Sponsor sponsor)
    {
        return toAjax(sponsorService.updateSponsor(sponsor));
    }

    /**
     * 删除活动赞助方
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:sponsor:remove')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @DeleteMapping("/{sponsorIds}")
    public AjaxResult remove(@PathVariable Long[] sponsorIds)
    {
        return toAjax(sponsorService.deleteSponsorBySponsorIds(sponsorIds));
    }
}
