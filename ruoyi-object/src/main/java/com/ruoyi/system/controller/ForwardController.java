package com.ruoyi.system.controller;

import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSON;
import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Weixin;
import com.ruoyi.system.service.IVerificationService;
import org.apache.poi.ss.usermodel.FormulaError;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.Forward;
import com.ruoyi.system.service.IForwardService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.client.RestTemplate;

/**
 * 【请填写功能名称】Controller
 *
 * @author ruoyi
 * @date 2023-06-14
 */
@RestController
@RequestMapping("/object/forward")
public class ForwardController extends BaseController
{
    @Autowired
    private IForwardService forwardService;

    @Autowired
    private IVerificationService verificationService;

    private String appid = "wx2b25712ec17c6900";

    private String secret = "f1c3505b35d8785d84b610895ae1f5e8";

    /**
     * 查询【请填写功能名称】列表
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:forward:list')")
    @GetMapping("/list")
    public TableDataInfo list(Forward forward)
    {
        startPage();
        List<Forward> list = forwardService.selectForwardList(forward);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:forward:export')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Forward forward)
    {
        List<Forward> list = forwardService.selectForwardList(forward);
        ExcelUtil<Forward> util = new ExcelUtil<Forward>(Forward.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:forward:query')")
    @GetMapping(value = "/{forwardId}")
    public AjaxResult getInfo(@PathVariable("forwardId") Long forwardId)
    {
        return success(forwardService.selectForwardByForwardId(forwardId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('system:forward:add')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/insert")
    public AjaxResult add(@RequestBody Forward forward)
    {
        return toAjax(forwardService.insertForward(forward));
    }

    /**
     * 修改【请填写功能名称】
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:forward:edit')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Forward forward)
    {
        return toAjax(forwardService.updateForward(forward));
    }

    /**
     * 删除【请填写功能名称】
     */
    @Anonymous
    //@PreAuthorize("@ss.hasPermi('object:forward:remove')")
    //@Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @DeleteMapping("/{forwardIds}")
    public AjaxResult remove(@PathVariable Long[] forwardIds)
    {
        return toAjax(forwardService.deleteForwardByForwardIds(forwardIds));
    }

    @Anonymous
    @GetMapping("/getPhone")
    public AjaxResult getPhoneNumber(@RequestParam String code) {
        Weixin weixin = new Weixin();
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+secret
                ;
        String method = "GET"; // 请求方法，可以是GET、POST等
        String headers = "-H 'Content-Type: application/json' -H 'Authorization: Bearer token'"; // 请求头部信息

        String command = "curl -X " + method + " " + headers + "' '" + url + "'";

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);

        // 处理响应结果
        if (response.getStatusCode().is2xxSuccessful()) {
//            responseBody = response.getBody();
            weixin = JSON.parseObject(response.getBody(),Weixin.class);
            // 在这里处理返回的响应体

            String url1 = "https://api.weixin.qq.com/wxa/business/getuserphonenumber?access_token="+weixin.getAccess_token()+"&code="+code;
            String methods = "GET"; // 请求方法，可以是GET、POST等
            String headerss = "-H 'Content-Type: application/json' -H 'Authorization: Bearer token'"; // 请求头部信息

            String commands = "curl -X " + method + " " + headers + "' '" + url + "'";

            ResponseEntity<String> responses = restTemplate.exchange(url1, HttpMethod.GET, null, String.class);
            weixin = JSON.parseObject(responses.getBody(),Weixin.class);
        }
        return AjaxResult.success(weixin.toString());
    }

    /**
     * 根据活动id、openId、phone、bphone修改当前助力人数+1
     * @return
     */
    @Anonymous
    @PostMapping("/update")
    public AjaxResult updateHelpCount(@RequestBody Forward forward) {
        System.out.println("forward:" + forward.toString());
        return AjaxResult.success(forwardService.updateHelpCount(forward));
    }

    /**
     * 根据活动id和openid修改核销码状态
     * @param forward
     * @return
     */
    @Anonymous
    @PostMapping("updateMsg")
    public AjaxResult updateMsg(@RequestBody Forward forward,@RequestParam("phone") String phone) {
        String s = selectMsg(forward.getActivityId());
        String[] parts = s.split(";");
        List<String> list = Arrays.asList(parts);
        System.out.println("sssssss"+list.contains(phone));
        if (list.contains(phone)) {
            return AjaxResult.success(forwardService.updateStatus(forward));
        }
         return AjaxResult.error();

    }

    public String selectMsg(Long activityId) {
        String s = verificationService.selectShopperByActivityId(activityId);
        System.out.println("sssssssss"+s);
        return s;
    }

    /**
     * 根据活动id和openid查询转发集赞信息
     * @param forward
     * @return
     */
    @Anonymous
    @PostMapping("/selectMsg")
    public Forward selectMsg(@RequestBody Forward forward) {
        Forward forwardMsg = forwardService.selectForwardMsg(forward);
        return forwardMsg;
    }

    /**
     * 根据活动id和openid查询参与人手机号
     * @param forward
     * @return
     */
    @Anonymous
    @PostMapping("/selectPhone")
    public AjaxResult selectPhone(@RequestBody Forward forward) {
//        String phone = forwardService.selectPhoneByAOpenId(forward);
//        return phone;
        return AjaxResult.success(forwardService.selectPhoneByAOpenId(forward));
    }

}
