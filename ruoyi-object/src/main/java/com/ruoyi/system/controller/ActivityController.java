package com.ruoyi.system.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.system.domain.CommonData;
import com.ruoyi.system.domain.Goods;
import com.ruoyi.system.service.ICommonDataService;
import com.ruoyi.system.service.IGoodsService;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Activity;
import com.ruoyi.system.service.IActivityService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 活动Controller
 * 
 * @author ruoyi
 * @date 2023-05-31
 */
@RestController
@RequestMapping("/object/activity")
public class ActivityController extends BaseController
{
    @Autowired
    private IActivityService activityService;

    @Autowired
    private IGoodsService goodsService;

    @Autowired
    private ICommonDataService commonDataService;

    /**
     * 查询活动列表
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:activity:list')")
    @GetMapping("/list")
    public TableDataInfo list(Activity activity)
    {
        startPage();
        List<Activity> list = activityService.selectActivityList(activity);
        return getDataTable(list);
    }

    /**
     * 导出活动列表
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:activity:export')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Activity activity)
    {
        List<Activity> list = activityService.selectActivityList(activity);
        ExcelUtil<Activity> util = new ExcelUtil<Activity>(Activity.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取活动详细信息
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:activity:query')")
    @GetMapping("/getInfo")
    public AjaxResult getInfo(@RequestParam("activityId") Long activityId)
    {
        return success(activityService.selectActivityByActivityId(activityId));
    }

    /**
     * 新增活动
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:activity:add')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Activity activity)
    {
        activityService.insertActivity(activity);
        return AjaxResult.success(activity.getActivityId());
    }

    @PostMapping("/insertActivity")
    public AjaxResult insertActivity(@RequestBody CommonData commonData){
        System.out.println("commonData"+commonData.toString());
        System.out.println("shopper"+commonData.getShopper());
        System.out.println("goods"+commonData.getGoods().toString());
        System.out.println("activity"+commonData.getActivity().toString());
        commonDataService.InsertCommonData(commonData);
        return AjaxResult.success(commonData.getActivity().getActivityId());
    }

    /**
     * 修改活动
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:activity:edit')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Activity activity)
    {
        return toAjax(activityService.updateActivity(activity));
    }

    /**
     * 删除活动
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:activity:remove')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{activityIds}")
    public AjaxResult remove(@PathVariable Long[] activityIds)
    {
        return toAjax(activityService.deleteActivityByActivityIds(activityIds));
    }

    /**
     * 根据活动id修改活动审核码
     */
    @Anonymous
    @PutMapping("/updateStatus/{activityId}")
    public AjaxResult updateStatus(@PathVariable Long activityId) {
        return success(activityService.updateActivityCheckStatus(activityId));
    }

    /**
     * 查询审核未成功的活动
     * @return
     */
    @Anonymous
    @GetMapping("/selectNoPass")
    public AjaxResult selectNoPassActivity() {
        return AjaxResult.success(activityService.selectNoPassActivityList());
    }

    /**
     * 审核成功(修改成功过后的审核码)
     * @return
     */
    @Anonymous
    @PostMapping("/updateSuccess")
    public AjaxResult updateSuccess(@RequestBody Activity activity) {
        System.out.println("6666666666666666" + activity.toString());
        return success(activityService.updateSuccessActivityCheckStatus(activity));
    }

    /**
     * 根据顾问id查询活动信息
     * @return
     */
    @Anonymous
    @PostMapping("/selectMsg")
    public AjaxResult selectMsg(@RequestBody Activity activity) {
        return success(activityService.selectActivityByconsultantId(activity.getConsultantId()));
    }

    /**
     * 统计顾问的商家、活动数量
     * @param activity
     * @return
     */
    @Anonymous
    @PostMapping("/count")
    public List selectCount(@RequestBody Activity activity) {
        ArrayList<Object> list = new ArrayList<>();
        // 商家数量
        int total = activityService.selectShopperNum(activity.getConsultantId());
        // 活动数量
        int total2 = activityService.selectActivityNum(activity.getConsultantId());
        list.add(total);
        list.add(total2);
        return list;
    }

}
