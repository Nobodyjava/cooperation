package com.ruoyi.system.controller;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.system.domain.Goods;
import com.ruoyi.system.mapper.GoodsMapper;
import com.ruoyi.system.mapper.ShopperMapper;
import com.ruoyi.system.service.IActivityService;
import com.ruoyi.system.service.IGoodsService;
import org.aspectj.bridge.MessageUtil;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Shopper;
import com.ruoyi.system.service.IShopperService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 商家Controller
 *
 * @author ruoyi
 * @date 2023-05-31
 */
//@CrossOrigin
@RestController
@RequestMapping("/object/shopper")
public class ShopperController extends BaseController {
    @Autowired
    private IShopperService shopperService;

    @Autowired
    private IActivityService activityService;

    @Autowired
    private IGoodsService goodsService;

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private ShopperMapper shopperMapper;

    /**
     * 查询商家
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:shopper:list')")
    @GetMapping("/list")
    public TableDataInfo list(Shopper shopper) {
        startPage();
        List<Shopper> list = shopperService.selectShopperList(shopper);
        return getDataTable(list);
    }

    /**
     * 导出商家
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:shopper:export')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Shopper shopper) {
        List<Shopper> list = shopperService.selectShopperList(shopper);
        ExcelUtil<Shopper> util = new ExcelUtil<Shopper>(Shopper.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取商家详细信息
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:shopper:query')")
    @GetMapping("/getInfo")
    public AjaxResult getInfo(@RequestParam(value = "shopperId") Long shopperId) {
        return success(shopperService.selectShopperByShopperId(shopperId));
    }

    /**
     * 新增商家
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:shopper:add')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Shopper shopper) {
        shopperService.insertShopper(shopper);
        return AjaxResult.success(shopper.getShopperId());
    }

    /**
     * 修改商家
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:shopper:edit')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Shopper shopper) {
        return toAjax(shopperService.updateShopper(shopper));
    }

    /**
     * 删除商家
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:shopper:remove')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @DeleteMapping("/{shopperIds}")
    public AjaxResult remove(@PathVariable Long[] shopperIds) {
        return toAjax(shopperService.deleteShopperByShopperIds(shopperIds));
    }

    /**
     * 根据商家id修改商家审核码
     *
     * @param shopperId
     * @return
     */
    @Anonymous
    @GetMapping("/updateStatus/{shopperId}/{activityId}")
    public AjaxResult updateCheckStatus(@PathVariable Long shopperId) {
        return success(shopperService.updateShopperCheckStatus(shopperId));
    }

    /**
     * 图片上传
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
//        判断系统生成路径
        String os = System.getProperty("os.name");
        String path = "";
        if (os.startsWith("Windows")) {
            path = "D:/image";
        }else{
            path = "/home/ruoyi/uploadPath/upload";
        }
        File fileRealPath = new File(path);
//        判断videos文件夹是否存在，不存在，则创建
        if (!fileRealPath.exists()) {
            fileRealPath.mkdirs();
        }
//        获取文件上传名称
        String fileName = file.getOriginalFilename();
//        构造文件最终路径
        String finalFilePath = fileRealPath + "/upload" + fileName.trim();
        System.out.println(finalFilePath);
//        构造插入数据库路径
        String dbFilePath = "/profile/upload/" + fileName.trim();
//        上传文件，若存在，则替换
        File desFile = new File(finalFilePath);
        if (desFile.exists()) {
            desFile.delete();
        }
        file.transferTo(desFile);
        return fileName;
    }

    /**
     * 删除图片
     * @param imgFile
     * @return
     */
    @PostMapping("/deleteImg")
    public AjaxResult deleteImage(@RequestParam("imgFile") String imgFile) throws IOException {
        String os = System.getProperty("os.name");
        String path = "";
        if (os.startsWith("Windows")) {
            path = ("D:/image" + imgFile).replace("/", "\\");
        }else{
            path = "/home/ruoyi/uploadPath/upload"+imgFile;
        }
        File desFile = new File(path);
        System.out.println(desFile.exists());
        if (desFile.exists()) {
            if (desFile.delete()) {
                return AjaxResult.success();
            }
        }
//        System.out.println("66666666666666666666666" + imgFile);
        return AjaxResult.success(path);
    }

    /**
     * 根据顾问id查询商家信息
     * @param consultantId
     * @return
     */
    @Anonymous
    @GetMapping("/getMsgInfo")
    public AjaxResult getMsgInfo(@RequestParam("consultantId") Long consultantId) {
        return AjaxResult.success(shopperService.selectShopperByConsultantId(consultantId));
    }

    /**
     * 获取商家收益
     * @return
     */
    @Anonymous
    @GetMapping("/getGain")
    public BigDecimal getGain(@RequestParam("userPhone") String userPhone) {
        // 根据顾问id获取到商品信息
        //List<Goods> goods = goodsService.selectGoodsByConsultantId(consultantId);
        List<Goods> goods = goodsMapper.getAllGoodsInfoByParam(userPhone);
        // 定义总收益
        BigDecimal sum = new BigDecimal("0.00");
        // 循环查询出来的商品信息
        for (Goods good : goods) {
            // 获取到商品的投放总量
            Long goodsTotalnum = good.getGoodsTotalnum()-good.getGoodsRemainnum();
            // 获取到商品的补贴商家费用
            BigDecimal goodsPrice = good.getGoodsPrice();
            // 计算出商家的总收益(总收益 = (商品的投放总量-商品核销量) * 商品的补贴商家费用))
            BigDecimal gain = BigDecimal.valueOf(goodsTotalnum).multiply(goodsPrice);
            // 累加总收益
            sum = sum.add(gain);
        }
        // 根据顾问id查询到商家信息
        List<Shopper> shopper = shopperMapper.getShopperByPhone(userPhone);
        for (Shopper s:
             shopper) {
            // 将计算出来的商家总收益添加入库
            s.setShopperGain(sum);
            shopperService.updateShopper(s);
        }
        // 返回商家收益
        return sum;
    }

    /**
     * 提现(根据顾问id修改商家总收益为0)
     * @param consultantId
     * @return
     */
    @Anonymous
    @GetMapping("/updateGain")
    public AjaxResult updateGain(@RequestParam Long consultantId) {
        return AjaxResult.success(shopperService.updateShopperGainByConsultantId(consultantId));
    }

}
