package com.ruoyi.system.controller;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Shopper;
import com.ruoyi.system.domain.Verification;
import com.ruoyi.system.service.IVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 核销表接口层
 * @Author:cy
 * @Date:2023/7/21
 */
@RestController
@RequestMapping("/object/verification")
public class VerificationController extends BaseController
{
    @Autowired
    private IVerificationService verificationService;

    /**
     * 查询【请填写功能名称】列表
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('system:verification:list')")
    @GetMapping("/list")
    public TableDataInfo list(Verification verification)
    {
        startPage();
        List<Verification> list = verificationService.selectVerificationList(verification);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('system:verification:export')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Verification verification)
    {
        List<Verification> list = verificationService.selectVerificationList(verification);
        ExcelUtil<Verification> util = new ExcelUtil<Verification>(Verification.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('system:verification:query')")
    @GetMapping(value = "/{verificationId}")
    public AjaxResult getInfo(@PathVariable("verificationId") Long verificationId)
    {
        return success(verificationService.selectVerificationByVerificationId(verificationId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('system:verification:add')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Verification verification)
    {
        return toAjax(verificationService.insertVerification(verification));
    }

    /**
     * 修改【请填写功能名称】
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('system:verification:edit')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Verification verification)
    {
        return toAjax(verificationService.updateVerification(verification));
    }

    /**
     * 删除【请填写功能名称】
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('system:verification:remove')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @DeleteMapping("/{verificationIds}")
    public AjaxResult remove(@PathVariable Long[] verificationIds)
    {
        return toAjax(verificationService.deleteVerificationByVerificationIds(verificationIds));
    }

    /**
     * 根据活动id先查商家id，再根据商家id查询商家电话和核销账号
     * @param activityId
     * @return
     */
//    @Anonymous
//    @GetMapping("/selectMsg")
//    public String selectMsg(@RequestParam("activityId") Long activityId) {
//        String s = verificationService.selectShopperByActivityId(activityId);
//        return s;
//    }
}

