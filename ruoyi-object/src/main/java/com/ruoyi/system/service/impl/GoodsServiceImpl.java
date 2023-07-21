package com.ruoyi.system.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.ruoyi.system.domain.Activity;
import com.ruoyi.system.mapper.ActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.GoodsMapper;
import com.ruoyi.system.domain.Goods;
import com.ruoyi.system.service.IGoodsService;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2023-06-01
 */
@Service
public class GoodsServiceImpl implements IGoodsService
{
    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private ActivityMapper activityMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param goodsId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Goods selectGoodsByGoodsId(Long goodsId)
    {
        return goodsMapper.selectGoodsByGoodsId(goodsId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param goods 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Goods> selectGoodsList(Goods goods)
    {
        return goodsMapper.selectGoodsList(goods);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param goods 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertGoods(Goods goods)
    {
        return goodsMapper.insertGoods(goods);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param goods 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateGoods(Goods goods)
    {
        return goodsMapper.updateGoods(goods);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param goodsIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteGoodsByGoodsIds(Long[] goodsIds)
    {
        return goodsMapper.deleteGoodsByGoodsIds(goodsIds);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param goodsId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteGoodsByGoodsId(Long goodsId)
    {
        return goodsMapper.deleteGoodsByGoodsId(goodsId);
    }

    /**
     * 根据顾问id查询商品信息
     * @param consultantId
     * @return
     */
    @Override
    public List<Goods> selectGoodsByConsultantId(Long consultantId) {
        return goodsMapper.selectGoodsByConsultantId(consultantId);
    }

    /**
     * 根据商品id修改截止核销时间
     * @param goods
     * @return
     */
    @Override
    public int updateGoodsEndtime(Goods goods,Activity activity) {
        System.out.println("goodsId"+goods.getGoodsId());
        Goods updateGoods = goodsMapper.selectGoodsByGoodsId(goods.getGoodsId());
        System.out.println("111111111111111111111=>"+updateGoods.toString());
        long baseTime = new Date(String.valueOf(activity.getEndtime())).getTime();
        long endTime = baseTime + (1000 * 60 * 60 * 24 *Integer.parseInt(updateGoods.getFundays()));
        Date goodsEndTime = new Date(endTime);
        updateGoods.setEndtime(goodsEndTime);
        return goodsMapper.updateGoodsEndtime(updateGoods);
    }

    /**
     * 根据活动id查询到商品id，再通过商品id查询到商品剩余数量，进行核销后剩余数量-1
     * @param activityId
     * @return
     */
    @Override
    public Long updateGoodsRemainNum(Long activityId) {
        Activity activity = activityMapper.selectActivityByActivityId(activityId);
        Long goodsId = activity.getGoodsId();
        System.out.println("查询到的商品id:" + goodsId);
        Goods goods = goodsMapper.selectGoodsByGoodsId(goodsId);
        Long goodsRemainnum = goods.getGoodsRemainnum();
        System.out.println("查询到的商品剩余数量:" + goodsRemainnum);
        goodsRemainnum = goodsRemainnum - 1;
        goods.setGoodsRemainnum(goodsRemainnum);
        System.out.println("修改完的商品剩余数量:" + goodsRemainnum);
        return goodsRemainnum;
    }

}

