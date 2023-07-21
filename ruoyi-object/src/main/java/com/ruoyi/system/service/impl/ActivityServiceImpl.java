package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.system.domain.Goods;
import com.ruoyi.system.mapper.GoodsMapper;
import com.ruoyi.system.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ActivityMapper;
import com.ruoyi.system.domain.Activity;
import com.ruoyi.system.service.IActivityService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-31
 */
@Service
public class ActivityServiceImpl implements IActivityService 
{
    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    private IGoodsService goodsService;

    /**
     * 查询【请填写功能名称】
     * 
     * @param activityId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Activity selectActivityByActivityId(Long activityId)
    {
        return activityMapper.selectActivityByActivityId(activityId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param activity 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Activity> selectActivityList(Activity activity)
    {
        return activityMapper.selectActivityList(activity);
    }

    /**
     * 新增【请填写功能名称】
     * @param activity 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertActivity(Activity activity)
    {
        Goods goods = new Goods();
        goods.setGoodsId(activity.getGoodsId());
        System.out.println("获得的商品id:" + activity.getGoodsId());
        System.out.println("00000获得的商品id:" + goods.getGoodsId());
        goodsService.updateGoodsEndtime(goods, activity);

//        Goods updateGoods = goodsMapper.selectGoodsByGoodsId(activity.getGoodsId());
//        goodsS.updateGoodsEndtime(updateGoods);
//        System.out.println("修改好的商品对象:" + updateGoods.toString());
        return activityMapper.insertActivity(activity);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param activity 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateActivity(Activity activity)
    {
        return activityMapper.updateActivity(activity);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param activityIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteActivityByActivityIds(Long[] activityIds)
    {
        return activityMapper.deleteActivityByActivityIds(activityIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param activityId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteActivityByActivityId(Long activityId)
    {
        return activityMapper.deleteActivityByActivityId(activityId);
    }

    /**
     * 根据活动id修改活动审核码
     * @param activityId
     * @return
     */
    @Override
    public int updateActivityCheckStatus(Long activityId) {
        return activityMapper.updateActivityCheckStatus(activityId);
    }

    /**
     * 查询审核未通过的活动
     * @return
     */
    @Override
    public List<Activity> selectNoPassActivityList() {
        return activityMapper.selectNoPassActivityList();
    }

    /**
     * 审核成功(修改成功过后的审核码)
     * @return
     */
    @Override
    public int updateSuccessActivityCheckStatus(Activity activity) {
        return activityMapper.updateSuccessActivityCheckStatus(activity);
    }

    /**
     * 根据顾问id查询活动信息
     * @return
     */
    @Override
    public Activity[] selectActivityByconsultantId(Long consultantId) {
        return activityMapper.selectActivityByconsultantId(consultantId);
    }

    /**
     * 根据顾问id查询商家个数
     * @param consultantId
     * @return
     */
    @Override
    public int selectShopperNum(Long consultantId) {
        return activityMapper.selectShopperNum(consultantId);
    }

    /**
     * 根据顾问id查询活动数量
     * @param consultantId
     * @return
     */
    @Override
    public int selectActivityNum(Long consultantId) {
        return activityMapper.selectActivityNum(consultantId);
    }
}
