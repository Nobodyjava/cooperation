package com.ruoyi.system.domain;

/**
 * 封装的实体类
 * @Author:cy
 * @Date:2023/7/21
 */
public class CommonData {
    private Activity activity;
    private Shopper shopper;
    private Goods goods;

    public CommonData() {
    }

    public CommonData(Activity activity, Shopper shopper, Goods goods) {
        this.activity = activity;
        this.shopper = shopper;
        this.goods = goods;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Shopper getShopper() {
        return shopper;
    }

    public void setShopper(Shopper shopper) {
        this.shopper = shopper;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "common{" +
                "activity=" + activity +
                ", shopper=" + shopper +
                ", goods=" + goods +
                '}';
    }
}
