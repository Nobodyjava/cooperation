package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.Goods;
import com.ruoyi.system.domain.Shopper;
import com.ruoyi.system.domain.Withdrawal;
import com.ruoyi.system.mapper.ShopperMapper;
import com.ruoyi.system.mapper.WithdrawalMapper;
import com.ruoyi.system.service.IWithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * 提现表业务逻辑层
 * @Author:cy
 * @Date:2023/7/21
 */
@Service
public class WithdrawalServiceImpl implements IWithdrawalService
{
    @Autowired
    private WithdrawalMapper withdrawalMapper;

    @Autowired
    private ShopperMapper shopperMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param withdrawalId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Withdrawal selectWithdrawalByWithdrawalId(Long withdrawalId)
    {
        return withdrawalMapper.selectWithdrawalByWithdrawalId(withdrawalId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param withdrawal 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Withdrawal> selectWithdrawalList(Withdrawal withdrawal)
    {
        return withdrawalMapper.selectWithdrawalList(withdrawal);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param withdrawal 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertWithdrawal(Withdrawal withdrawal)
    {
        return withdrawalMapper.insertWithdrawal(withdrawal);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param withdrawal 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateWithdrawal(Withdrawal withdrawal)
    {
        return withdrawalMapper.updateWithdrawal(withdrawal);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param withdrawalIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteWithdrawalByWithdrawalIds(Long[] withdrawalIds)
    {
        return withdrawalMapper.deleteWithdrawalByWithdrawalIds(withdrawalIds);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param withdrawalId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteWithdrawalByWithdrawalId(Long withdrawalId)
    {
        return withdrawalMapper.deleteWithdrawalByWithdrawalId(withdrawalId);
    }

    /**
     * 根据提现时间降序查询提现记录
     * @param withdrawal
     * @return
     */
    @Override
    public List<Withdrawal> selectWithdrawalByTime(Withdrawal withdrawal) {
        return withdrawalMapper.selectWithdrawalByTime(withdrawal);
    }

    /**
     * 查询钱包金额
     * @param consultantId
     * @return
     */
    @Override
    public BigDecimal selectSumMoney(Long consultantId) {
        BigDecimal sumMoney = withdrawalMapper.selectSumMoney(consultantId);
        sumMoney = sumMoney==null ? new BigDecimal(0.00) :sumMoney;
        System.out.println("提现的总金额:" + sumMoney);
        // 根据顾问id获取到商品信息
        List<Shopper> shoppers = shopperMapper.selectShopperByConsultantId1(consultantId);
        System.out.println(shoppers.size());
        // 定义总收益
        BigDecimal sum = new BigDecimal("0.00");
        // 循环查询出来的商品信息
        for (Shopper shopper : shoppers) {
            System.out.println(shopper.getShopperGain()+",");

            BigDecimal a = shopper.getShopperGain()!=null ? shopper.getShopperGain() : new BigDecimal("0.00");
            sum = sum.add(a);
        }
//        BigDecimal shopperGain = shopper.getShopperGain();
        BigDecimal money = sum.subtract(sumMoney);
        return money;
    }

}

