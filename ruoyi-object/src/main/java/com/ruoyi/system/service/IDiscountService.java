package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Discount;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2023-06-06
 */
public interface IDiscountService
{
    /**
     * 查询【请填写功能名称】
     *
     * @param discountId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Discount selectDiscountByDiscountId(Long discountId);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param discount 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Discount> selectDiscountList(Discount discount);

    /**
     * 新增【请填写功能名称】
     *
     * @param discount 【请填写功能名称】
     * @return 结果
     */
    public int insertDiscount(Discount discount);

    /**
     * 修改【请填写功能名称】
     *
     * @param discount 【请填写功能名称】
     * @return 结果
     */
    public int updateDiscount(Discount discount);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param discountIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteDiscountByDiscountIds(Long[] discountIds);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param discountId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteDiscountByDiscountId(Long discountId);

    /**
     * 根据查询出来的优惠券集合索引随机再查询出一张优惠券
     * @param discount
     * @return
     */
    public Discount selectDiscountByIndex(Discount discount);
}

