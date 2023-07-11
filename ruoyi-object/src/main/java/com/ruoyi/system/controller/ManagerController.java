package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.system.service.IActivityService;
import com.ruoyi.system.service.IShopperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.Manager;
import com.ruoyi.system.service.IManagerService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 审批人Controller
 * 
 * @author ruoyi
 * @date 2023-06-01
 */
@RestController
@RequestMapping("/object/manager")
public class ManagerController extends BaseController
{
    @Autowired
    private IManagerService managerService;

    @Autowired
    private IShopperService shopperService;

    @Autowired
    private IActivityService activityService;

    /**
     * 查询审批人列表
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:manager:list')")
    @GetMapping("/list")
    public TableDataInfo list(Manager manager)
    {
        startPage();
        List<Manager> list = managerService.selectManagerList(manager);
        return getDataTable(list);
    }

    /**
     * 导出审批人列表
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:manager:export')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Manager manager)
    {
        List<Manager> list = managerService.selectManagerList(manager);
        ExcelUtil<Manager> util = new ExcelUtil<Manager>(Manager.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取审批人详细信息
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:manager:query')")
    @GetMapping(value = "/{managerId}")
    public AjaxResult getInfo(@PathVariable("managerId") Long managerId)
    {
        return success(managerService.selectManagerByManagerId(managerId));
    }

    /**
     * 新增审批人
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:manager:add')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Manager manager)
    {
        return toAjax(managerService.insertManager(manager));
    }

    /**
     * 修改审批人
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:manager:edit')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Manager manager)
    {
        return toAjax(managerService.updateManager(manager));
    }

    /**
     * 删除审批人
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:manager:remove')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{managerIds}")
    public AjaxResult remove(@PathVariable Long[] managerIds)
    {
        return toAjax(managerService.deleteManagerByManagerIds(managerIds));
    }

    /**
     * 根据审核人手机号查询审核人信息
     * @param managerPhone
     * @return
     */
    @Anonymous
    @GetMapping("/getMsgInfo/{managerPhone}")
    public AjaxResult getMsgInfo(@PathVariable("managerPhone") String managerPhone) {
        return success(managerService.selectManagerByManagerPhone(managerPhone));
    }

    /**
     * 根据商家id修改商家和任务详情的审核码
     * @param shopperId
     * @return
     */
    @Anonymous
    @PostMapping("/check/{shopperId}")
    public AjaxResult updateStatus(@RequestParam("shopperId") Long shopperId) {
        System.out.println("6666666666666666666666666" + shopperId);
        return success(managerService.updateCheckStatus(shopperId));
    }
}
