package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ShopperMapper;
import com.ruoyi.system.domain.Shopper;
import com.ruoyi.system.service.IShopperService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-31
 */
@Service
public class ShopperServiceImpl implements IShopperService {
    @Autowired
    private ShopperMapper shopperMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param shopperId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Shopper selectShopperByShopperId(Long shopperId) {
        return shopperMapper.selectShopperByShopperId(shopperId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param shopper 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Shopper> selectShopperList(Shopper shopper) {
        return shopperMapper.selectShopperList(shopper);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param shopper 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertShopper(Shopper shopper) {

        return shopperMapper.insertShopper(shopper);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param shopper 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateShopper(Shopper shopper) {
        return shopperMapper.updateShopper(shopper);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param shopperIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteShopperByShopperIds(Long[] shopperIds) {
        return shopperMapper.deleteShopperByShopperIds(shopperIds);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param shopperId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteShopperByShopperId(Long shopperId) {
        return shopperMapper.deleteShopperByShopperId(shopperId);
    }

    /**
     * 根据商家id修改商家审核码
     *
     * @param shopperId
     * @return
     */
    @Override
    public int updateShopperCheckStatus(Long shopperId) {
        return shopperMapper.updateShopperCheckStatus(shopperId);
    }

    /**
     * 根据顾问id查询商家信息
     *
     * @param consultantId
     * @return
     */
    @Override
    public Shopper selectShopperByConsultantId(Long consultantId) {
        return shopperMapper.selectShopperByConsultantId(consultantId);
    }

    /**
     * 提现(根据顾问id修改商家总收益为0)
     *
     * @param consultantId
     * @return
     */
    @Override
    public int updateShopperGainByConsultantId(Long consultantId) {
        return shopperMapper.updateShopperGainByConsultantId(consultantId);
    }

    @Override
    public List<Shopper> getShopperByPhone(String userPhone) {
        return shopperMapper.getShopperByPhone(userPhone);
    }
}
