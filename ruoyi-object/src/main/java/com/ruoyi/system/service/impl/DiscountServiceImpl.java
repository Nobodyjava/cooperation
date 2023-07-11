package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.DiscountMapper;
import com.ruoyi.system.domain.Discount;
import com.ruoyi.system.service.IDiscountService;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2023-06-06
 */
@Service
public class DiscountServiceImpl implements IDiscountService
{
    @Autowired
    private DiscountMapper discountMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param discountId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Discount selectDiscountByDiscountId(Long discountId)
    {
        return discountMapper.selectDiscountByDiscountId(discountId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param discount 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Discount> selectDiscountList(Discount discount)
    {
        return discountMapper.selectDiscountList(discount);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param discount 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertDiscount(Discount discount)
    {
        return discountMapper.insertDiscount(discount);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param discount 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateDiscount(Discount discount)
    {
        return discountMapper.updateDiscount(discount);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param discountIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteDiscountByDiscountIds(Long[] discountIds)
    {
        return discountMapper.deleteDiscountByDiscountIds(discountIds);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param discountId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteDiscountByDiscountId(Long discountId)
    {
        return discountMapper.deleteDiscountByDiscountId(discountId);
    }

    /**
     * 根据查询出来的优惠券集合索引随机再查询出一张优惠券
     * @param discount
     * @return
     */
    @Override
    public Discount selectDiscountByIndex(Discount discount) {
        // 初始化序号
        int index = 0;
        // 先查询出所有优惠券的集合
        List<Discount> discounts = discountMapper.selectDiscountList(discount);
        // 循环遍历，取出序号
        for (int i = 0; i < discounts.size(); i++) {
            Discount targetDiscount = discounts.get(i);
            index = i;
            System.out.println("序号:" + index);
        }

        // 生成随机数对象
        Random random = new Random();
        // 从取出的优惠券集合中随机取出一个优惠券序号
        int randomIndex = random.nextInt(discounts.size());
        System.out.println("随机产生的序号:" + randomIndex);
        // 根据随机取出的优惠券序号获取随机优惠券对象
        Discount randomDiscount = discounts.get(randomIndex);
        // 返回随机的优惠券对象
        return randomDiscount;
    }
}
