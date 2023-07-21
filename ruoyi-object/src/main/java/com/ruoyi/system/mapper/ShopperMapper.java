package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Shopper;
import com.ruoyi.system.domain.Withdrawal;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2023-05-31
 */
public interface ShopperMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param shopperId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Shopper selectShopperByShopperId(Long shopperId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param shopper 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Shopper> selectShopperList(Shopper shopper);

    /**
     * 新增【请填写功能名称】
     * 
     * @param shopper 【请填写功能名称】
     * @return 结果
     */
//    public int insertShopper(Shopper shopper);
    public int insertShopper(Shopper shopper);

    /**
     * 修改【请填写功能名称】
     * 
     * @param shopper 【请填写功能名称】
     * @return 结果
     */
    public int updateShopper(Shopper shopper);

    /**
     * 删除【请填写功能名称】
     * 
     * @param shopperId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteShopperByShopperId(Long shopperId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param shopperIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteShopperByShopperIds(Long[] shopperIds);

    /**
     * 根据商家id修改商家审核码
     * @param shopperId
     * @return
     */
    public int updateShopperCheckStatus(Long shopperId);

    /**
     * 根据顾问id查询商家信息
     * @param consultantId
     * @return
     */
    public Shopper selectShopperByConsultantId(Long consultantId);

    public List<Shopper> selectShopperByConsultantId1(Long consultantId);

    /**
     * 提现(根据顾问id修改商家总收益为0)
     * @param consultantId
     * @return
     */
    public int updateShopperGainByConsultantId(Long consultantId);

}
