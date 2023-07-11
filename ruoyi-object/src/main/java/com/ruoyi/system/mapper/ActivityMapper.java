package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Activity;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2023-05-31
 */
public interface ActivityMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param activityId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Activity selectActivityByActivityId(Long activityId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param activity 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Activity> selectActivityList(Activity activity);

    /**
     * 新增【请填写功能名称】
     * 
     * @param activity 【请填写功能名称】
     * @return 结果
     */
    public int insertActivity(Activity activity);

    /**
     * 修改【请填写功能名称】
     * 
     * @param activity 【请填写功能名称】
     * @return 结果
     */
    public int updateActivity(Activity activity);

    /**
     * 删除【请填写功能名称】
     * 
     * @param activityId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteActivityByActivityId(Long activityId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param activityIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteActivityByActivityIds(Long[] activityIds);

    /**
     * 根据活动id修改活动审核码
     * @param activityId
     * @return
     */
    public int updateActivityCheckStatus(Long activityId);

    /**
     * 查询审核未通过的活动
     * @return
     */
    public List<Activity> selectNoPassActivityList();

    /**
     * 审核成功(修改成功过后的审核码)
     * @return
     */
    public int updateSuccessActivityCheckStatus(Activity activity);

    /**
     * 根据顾问id查询活动信息
     * @return
     */
    public Activity[] selectActivityByconsultantId(Long consultantId);

    /**
     * 根据顾问id查询商家个数
     * @return
     */
    public int selectShopperNum(Long consultantId);

    /**
     * 根据顾问id查询活动个数
     * @param consultantId
     * @return
     */
    public int selectActivityNum(Long consultantId);

}
