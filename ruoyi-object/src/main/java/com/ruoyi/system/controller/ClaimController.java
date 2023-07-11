package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.system.domain.Discount;
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
import com.ruoyi.system.domain.Claim;
import com.ruoyi.system.service.IClaimService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 已领取的优惠券Controller
 *
 * @author ruoyi
 * @date 2023-07-10
 */
@RestController
@RequestMapping("/object/claim")
public class ClaimController extends BaseController
{
    @Autowired
    private IClaimService claimService;

    /**
     * 查询已领取的优惠券列表
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:claim:list')")
    @GetMapping("/list")
    public TableDataInfo list(Claim claim)
    {
        startPage();
        List<Claim> list = claimService.selectClaimList(claim);
        return getDataTable(list);
    }

    /**
     * 导出已领取的优惠券列表
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:claim:export')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Claim claim)
    {
        List<Claim> list = claimService.selectClaimList(claim);
        ExcelUtil<Claim> util = new ExcelUtil<Claim>(Claim.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取已领取的优惠券详细信息
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:claim:query')")
    @GetMapping(value = "/{claimId}")
    public AjaxResult getInfo(@PathVariable("claimId") Long claimId)
    {
        return success(claimService.selectClaimByClaimId(claimId));
    }

    /**
     * 新增已领取的优惠券
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:claim:add')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Claim claim)
    {
        return toAjax(claimService.insertClaim(claim));
    }

    /**
     * 修改已领取的优惠券
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:claim:edit')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Claim claim)
    {
        return toAjax(claimService.updateClaim(claim));
    }

    /**
     * 删除【请填写功能名称】
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:claim:remove')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @DeleteMapping("/{claimIds}")
    public AjaxResult remove(@PathVariable Long[] claimIds)
    {
        return toAjax(claimService.deleteClaimByClaimIds(claimIds));
    }

    /**
     * 根据openId和活动id查询优惠券信息
     * @param claim
     * @return
     */
    @Anonymous
    @PostMapping("/selectMsg")
    public Discount selectMsg(@RequestBody Claim claim) {
        Discount discount = claimService.selectMsg(claim);
        System.out.println("返回的优惠券对象:" + discount.toString());
        return discount;
    }
}

