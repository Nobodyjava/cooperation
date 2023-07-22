package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.CommonData;
import com.ruoyi.system.domain.Goods;
import com.ruoyi.system.mapper.ActivityMapper;
import com.ruoyi.system.mapper.GoodsMapper;
import com.ruoyi.system.mapper.ShopperMapper;
import com.ruoyi.system.service.ICommonDataService;
import com.ruoyi.system.service.IGoodsService;
import com.ruoyi.system.service.IShopperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:cy
 * @Date:2023/7/21
 */
@Service
public class CommonDataServiceImpl implements ICommonDataService {

    @Autowired
    private IShopperService shopperService;

    @Autowired
    private IGoodsService goodsService;

    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public int InsertCommonData(CommonData commonData) {
        shopperService.insertShopper(commonData.getShopper());
        goodsService.insertGoods(commonData.getGoods());
        Goods goods = new Goods();
        goods.setGoodsId(commonData.getGoods().getGoodsId());

        goodsService.updateGoodsEndtime(goods, commonData.getActivity());
        commonData.getActivity().setShopperId(commonData.getShopper().getShopperId());
        commonData.getActivity().setGoodsId(commonData.getGoods().getGoodsId());

//        Goods updateGoods = goodsMapper.selectGoodsByGoodsId(activity.getGoodsId());
//        goodsS.updateGoodsEndtime(updateGoods);
//        System.out.println("修改好的商品对象:" + updateGoods.toString());
        return activityMapper.insertActivity(commonData.getActivity());
    }
}
