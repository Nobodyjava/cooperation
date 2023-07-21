package com.ruoyi.system.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.annotation.Anonymous;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Goods;
import com.ruoyi.system.service.IGoodsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品Controller
 *
 * @author ruoyi
 * @date 2023-06-01
 */
@CrossOrigin
@RestController
@RequestMapping("/object/goods")
public class GoodsController extends BaseController
{
    @Autowired
    private IGoodsService goodsService;

    /**
     * 查询商品列表
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('system:goods:list')")
    @GetMapping("/list")
    public TableDataInfo list(Goods goods)
    {
        startPage();
        List<Goods> list = goodsService.selectGoodsList(goods);
        return getDataTable(list);
    }

    /**
     * 导出商品列表
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('system:goods:export')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Goods goods)
    {
        List<Goods> list = goodsService.selectGoodsList(goods);
        ExcelUtil<Goods> util = new ExcelUtil<Goods>(Goods.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取商品详细信息
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('system:goods:query')")
    @GetMapping("/getInfo")
    public AjaxResult getInfo(@RequestParam("goodsId") Long goodsId)
    {
        return success(goodsService.selectGoodsByGoodsId(goodsId));
    }

    /**
     * 新增商品
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('system:goods:add')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Goods goods)
    {
        goodsService.insertGoods(goods);
        return AjaxResult.success(goods.getGoodsId());
    }

    /**
     * 修改商品
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('system:goods:edit')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Goods goods)
    {
        return toAjax(goodsService.updateGoods(goods));
    }

    /**
     * 删除商品
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('system:goods:remove')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @DeleteMapping("/{goodsIds}")
    public AjaxResult remove(@PathVariable Long[] goodsIds)
    {
        return toAjax(goodsService.deleteGoodsByGoodsIds(goodsIds));
    }

    /**
     * 根据顾问id查询商品信息
     * @param consultantId
     * @return
     */
    @Anonymous
    @GetMapping("/getMsgInfo")
    public AjaxResult getMsgInfo(@RequestParam Long consultantId) {
        return AjaxResult.success(goodsService.selectGoodsByConsultantId(consultantId));
    }

    /**
     * 获取到商品的已领取数量(核销数量)
     * @param consultantId
     * @return
     */
    @Anonymous
    @GetMapping("/getRemain")
    public List<Goods> getRemain(@RequestParam Long consultantId) {
        // 根据顾问id获取到商品信息
        List<Goods> goods = goodsService.selectGoodsByConsultantId(consultantId);
        // 返回集合
        return goods;
    }

//    /**
//     * 根据商品id修改截止核销时间
//     * @param goods
//     * @return
//     */
//    @Anonymous
//    @PostMapping("/updateGoodsEndtime")
//    public int updateGoodsEndtime(@RequestBody Goods goods) {
//        return goodsService.updateGoodsEndtime(goods);
//    }

}

