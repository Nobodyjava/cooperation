package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Withdrawal;

import java.math.BigDecimal;
import java.util.List;

/**
 * 提现表数据交互层
 * @Author:cy
 * @Date:2023/7/21
 */
public interface WithdrawalMapper
{
    /**
     * 查询【请填写功能名称】
     *
     * @param withdrawalId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Withdrawal selectWithdrawalByWithdrawalId(Long withdrawalId);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param withdrawal 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Withdrawal> selectWithdrawalList(Withdrawal withdrawal);

    /**
     * 新增【请填写功能名称】
     *
     * @param withdrawal 【请填写功能名称】
     * @return 结果
     */
    public int insertWithdrawal(Withdrawal withdrawal);

    /**
     * 修改【请填写功能名称】
     *
     * @param withdrawal 【请填写功能名称】
     * @return 结果
     */
    public int updateWithdrawal(Withdrawal withdrawal);

    /**
     * 删除【请填写功能名称】
     *
     * @param withdrawalId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteWithdrawalByWithdrawalId(Long withdrawalId);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param withdrawalIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWithdrawalByWithdrawalIds(Long[] withdrawalIds);

    /**
     * 根据提现时间降序查询提现记录
     * @param withdrawal
     * @return
     */
    public List<Withdrawal> selectWithdrawalByTime(Withdrawal withdrawal);

    /**
     * 查询钱包金额
     * @param consultantId
     * @return
     */
    public BigDecimal selectSumMoney(Long consultantId);
}

