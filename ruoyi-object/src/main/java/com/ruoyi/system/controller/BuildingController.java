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
import com.ruoyi.system.domain.Building;
import com.ruoyi.system.service.IBuildingService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 *
 * @author ruoyi
 * @date 2023-06-16
 */
@RestController
@RequestMapping("/object/building")
public class BuildingController extends BaseController
{
    @Autowired
    private IBuildingService buildingService;

    /**
     * 查询【请填写功能名称】列表
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:building:list')")
    @GetMapping("/list")
    public TableDataInfo list(Building building)
    {
        startPage();
        List<Building> list = buildingService.selectBuildingList(building);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:building:export')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Building building)
    {
        List<Building> list = buildingService.selectBuildingList(building);
        ExcelUtil<Building> util = new ExcelUtil<Building>(Building.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:building:query')")
    @GetMapping(value = "/{buildingId}")
    public AjaxResult getInfo(@PathVariable("buildingId") Long buildingId)
    {
        return success(buildingService.selectBuildingByBuildingId(buildingId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:building:add')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Building building)
    {
        return toAjax(buildingService.insertBuilding(building));
    }

    /**
     * 修改【请填写功能名称】
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:building:edit')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Building building)
    {
        return toAjax(buildingService.updateBuilding(building));
    }

    /**
     * 删除【请填写功能名称】
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:building:remove')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @DeleteMapping("/{buildingIds}")
    public AjaxResult remove(@PathVariable Long[] buildingIds)
    {
        return toAjax(buildingService.deleteBuildingByBuildingIds(buildingIds));
    }
}
