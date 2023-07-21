package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.system.domain.Activity;
import com.ruoyi.system.domain.Goods;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2023-06-01
 */
public interface IGoodsService
{
    /**
     * 查询【请填写功能名称】
     *
     * @param goodsId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Goods selectGoodsByGoodsId(Long goodsId);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param goods 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Goods> selectGoodsList(Goods goods);

    /**
     * 新增【请填写功能名称】
     *
     * @param goods 【请填写功能名称】
     * @return 结果
     */
    public int insertGoods(Goods goods);

    /**
     * 修改【请填写功能名称】
     *
     * @param goods 【请填写功能名称】
     * @return 结果
     */
    public int updateGoods(Goods goods);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param goodsIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteGoodsByGoodsIds(Long[] goodsIds);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param goodsId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteGoodsByGoodsId(Long goodsId);

    /**
     * 根据顾问id查询商品信息
     * @param consultantId
     * @return
     */
    public List<Goods> selectGoodsByConsultantId(Long consultantId);

    /**
     * 根据商品id修改截止核销时间
     * @param goods
     * @return
     */
    public int updateGoodsEndtime(Goods goods, Activity activity);

    /**
     * 根据活动id查询到商品id，再通过商品id查询到商品剩余数量，进行核销后剩余数量-1
     * @param activityId
     * @return
     */
    public Long updateGoodsRemainNum(Long activityId);
}

