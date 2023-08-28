package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.system.domain.Manager;
import com.ruoyi.system.domain.Shopper;
import com.ruoyi.system.mapper.ShopperMapper;
import com.ruoyi.system.service.IManagerService;
import com.ruoyi.system.service.IShopperService;
import com.ruoyi.system.utils.TokenGenerator;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.Consultant;
import com.ruoyi.system.service.IConsultantService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 顾问Controller
 *
 * @author ruoyi
 * @date 2023-06-10
 */
@RestController
@RequestMapping("/object/consultant")
public class ConsultantController extends BaseController
{
    @Autowired
    private IConsultantService consultantService;

    @Autowired
    private IManagerService managerService;

    @Autowired
    private IShopperService shopperService;

    /**
     * 查询顾问列表
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:consultant:list')")
    @GetMapping("/list")
    public TableDataInfo list(Consultant consultant)
    {
        startPage();
        List<Consultant> list = consultantService.selectConsultantList(consultant);
        return getDataTable(list);
    }

    /**
     * 导出顾问列表
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:consultant:export')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Consultant consultant)
    {
        List<Consultant> list = consultantService.selectConsultantList(consultant);
        ExcelUtil<Consultant> util = new ExcelUtil<Consultant>(Consultant.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取顾问详细信息
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:consultant:query')")
    @GetMapping(value = "/{consultantId}")
    public AjaxResult getInfo(@PathVariable("consultantId") Long consultantId)
    {
        return success(consultantService.selectConsultantByConsultantId(consultantId));
    }

    /**
     * 新增顾问
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:consultant:add')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Consultant consultant)
    {
        return toAjax(consultantService.insertConsultant(consultant));
    }

    /**
     * 修改顾问
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:consultant:edit')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Consultant consultant)
    {
        return toAjax(consultantService.updateConsultant(consultant));
    }

    /**
     * 删除顾问
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:consultant:remove')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @DeleteMapping("/{consultantIds}")
    public AjaxResult remove(@PathVariable Long[] consultantIds)
    {
        return toAjax(consultantService.deleteConsultantByConsultantIds(consultantIds));
    }

    /**
     * 根据顾问手机号查询顾问信息
     * @param consultantPhone
     * @return
     */
    @Anonymous
    @GetMapping("/getMsgInfo/{consultantPhone}")
    public AjaxResult getMsgInfo(@PathVariable String consultantPhone) {
        return AjaxResult.success(consultantService.selectConsultantByConsultantPhone(consultantPhone));
    }


    /**
     * 校验登录时的顾问、审核人信息
     * @param request
     */
    @Anonymous
    @ResponseBody
    @GetMapping("/checkMsg")
    public AjaxResult checkMsg(HttpServletRequest request) throws ServletException {
        String token = TokenGenerator.generateToken();
        // 获取前端输入的联系电话和密码
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        System.out.println("联系电话:" + phone);
        System.out.println("密码:" + password);
        Consultant checkConsultant1 = consultantService.selectConsultantByConsultantPhone(phone);
        // 前端用户输入的联系电话为空时的提示
        if (phone == null) {
            throw new ServletException("输入的联系电话为空!");
        }
        // 前端用户输入的密码为空时的提示
        if (password == null) {
            throw new ServletException("输入的密码为空!");
        }
        // 如果前端输入的用户名或密码不为空时
        if (phone != null && password != null) {
            //根据前端输入的手机号去查询数据库
            Consultant checkConsultant = consultantService.selectConsultantByConsultantPhone(phone);
            Manager checkManager = managerService.selectManagerByManagerPhone(phone);
            List<Shopper> shopperByPhone = shopperService.getShopperByPhone(phone);
            System.out.println("shopperByPhoneSize"+shopperByPhone.size());
            System.out.println(checkConsultant);
            System.out.println(checkManager);
            // 如果根据前端输入的联系电话没查询到相关信息，则提示该账号为空
            if (checkConsultant == null && checkManager == null && shopperByPhone.size()==0) {
                throw new ServletException("该账号为空,请重新输入!");
                // 如果查询出来的顾问信息不为空,审核人信息为空
            } else if (checkConsultant != null && checkManager == null && shopperByPhone.size()==0) {
                if (password.equals(checkConsultant.getConsultantPassword())) {
                    // 添加顾问token进数据库
                    checkConsultant.setConsultantToken(token);
                    consultantService.updateConsultant(checkConsultant);
                    System.out.println("登录成功!");
                } else {
                    System.out.println("密码错误!");
                    return AjaxResult.error();
                }
                // 如果查询出来的顾问信息为空,审核人信息不为空
            } else if (checkConsultant == null && checkManager != null && shopperByPhone.size()==0) {
                if (password.equals(checkManager.getManagerPassword())) {
                    System.out.println("登录成功!");
                } else {
                    System.out.println("密码错误!");
                    return AjaxResult.error();
                }
            }else if(checkConsultant == null && checkManager == null && shopperByPhone.size()!=0){
                Shopper shopper = shopperByPhone.get(0);
                if(password.equals(shopper.getAccount())){
                    System.out.println("登录成功");
                    token = "abc";
                    return AjaxResult.success(token,shopper);
                }else{
                    System.out.println("密码错误");
                    return AjaxResult.error();
                }
            }
        }
        // 返回顾问token及对象
        return AjaxResult.success(token,checkConsultant1);
    }


    /**
     * 审核人根据id修改审核码状态
     * @param activityId
     * @param shopperId
     * @return
     */
    @Anonymous
    @GetMapping("/updateCheckStatus")
    public AjaxResult updateCheckStatus(@RequestParam Long activityId,@RequestParam Long shopperId) {
        int i = consultantService.updateActivityCheckStatus(activityId);
        int j = consultantService.updateShopperCheckStatus(shopperId);
        if(i == 1 && j == 1) {
            return AjaxResult.success();
        }

        return AjaxResult.success();
    }
}

