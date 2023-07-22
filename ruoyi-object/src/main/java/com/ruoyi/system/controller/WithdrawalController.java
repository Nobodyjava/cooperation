package com.ruoyi.system.controller;


import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Withdrawal;
import com.ruoyi.system.service.IWithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 提现表接口层
 * @Author:cy
 * @Date:2023/7/21
 */
@RestController
@RequestMapping("/object/withdrawal")
public class WithdrawalController extends BaseController
{
    @Autowired
    private IWithdrawalService withdrawalService;

    /**
     * 查询【请填写功能名称】列表
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('system:withdrawal:list')")
    @GetMapping("/list")
    public TableDataInfo list(Withdrawal withdrawal)
    {
        startPage();
        List<Withdrawal> list = withdrawalService.selectWithdrawalList(withdrawal);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('system:withdrawal:export')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Withdrawal withdrawal)
    {
        List<Withdrawal> list = withdrawalService.selectWithdrawalList(withdrawal);
        ExcelUtil<Withdrawal> util = new ExcelUtil<Withdrawal>(Withdrawal.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('system:withdrawal:query')")
    @GetMapping(value = "/{withdrawalId}")
    public AjaxResult getInfo(@PathVariable("withdrawalId") Long withdrawalId)
    {
        return success(withdrawalService.selectWithdrawalByWithdrawalId(withdrawalId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('system:withdrawal:add')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Withdrawal withdrawal)
    {
        return toAjax(withdrawalService.insertWithdrawal(withdrawal));
    }

    /**
     * 修改【请填写功能名称】
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('system:withdrawal:edit')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Withdrawal withdrawal)
    {
        return toAjax(withdrawalService.updateWithdrawal(withdrawal));
    }

    /**
     * 删除【请填写功能名称】
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('system:withdrawal:remove')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @DeleteMapping("/{withdrawalIds}")
    public AjaxResult remove(@PathVariable Long[] withdrawalIds)
    {
        return toAjax(withdrawalService.deleteWithdrawalByWithdrawalIds(withdrawalIds));
    }

    /**
     * 根据提现时间降序查询提现记录
     * @param withdrawal
     * @return
     */
    @Anonymous
    @PostMapping("/selectMsg")
    public AjaxResult selectMsg(@RequestBody Withdrawal withdrawal) {
        return AjaxResult.success(withdrawalService.selectWithdrawalByTime(withdrawal));
    }

    /**
     * 查询钱包金额
     * @param consultantId
     * @return
     */
    @Anonymous
    @GetMapping("/selectMoney")
    public BigDecimal selectMoney(@RequestParam("consultantId") Long consultantId) {
        BigDecimal money = withdrawalService.selectSumMoney(consultantId);
        return money;
    }

    /**
     * 提现
     * @param withdrawal
     * @return
     */
    @Anonymous
    @PostMapping("/withdrawMoney")
    public AjaxResult withdrawMoney(@RequestBody Withdrawal withdrawal) {
//        return AjaxResult.success(withdrawalService.insertWithdrawal(withdrawal));
//        withdrawalService.insertWithdrawal(withdrawal);
        withdrawal.setWithdrawalTime(new Date());
        return AjaxResult.success(withdrawalService.insertWithdrawal(withdrawal));
    }
}
