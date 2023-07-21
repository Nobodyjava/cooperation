package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.system.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ForwardMapper;
import com.ruoyi.system.domain.Forward;
import com.ruoyi.system.service.IForwardService;

import static net.sf.jsqlparser.parser.feature.Feature.insert;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2023-06-14
 */
@Service
public class ForwardServiceImpl implements IForwardService
{
    @Autowired
    private ForwardMapper forwardMapper;

    @Autowired
    private IGoodsService goodsService;

    /**
     * 查询【请填写功能名称】
     *
     * @param forwardId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Forward selectForwardByForwardId(Long forwardId)
    {
        return forwardMapper.selectForwardByForwardId(forwardId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param forward 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Forward> selectForwardList(Forward forward)
    {
        return forwardMapper.selectForwardList(forward);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param forward 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertForward(Forward forward)
    {
//        Forward checkForward = forwardMapper.selectCheckForward(forward);
//        if (checkForward != null) {
//            return 500;
//        } else {
//            return forwardMapper.insertForward(forward);
//        }
        Forward checkForward = forwardMapper.selectForwardMsg(forward);
        System.out.println("查询结果:" + checkForward);
        if (checkForward == null) {
            return forwardMapper.insertForward(forward);
        }

        return -1;
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param forward 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateForward(Forward forward)
    {
        return forwardMapper.updateForward(forward);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param forwardIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteForwardByForwardIds(Long[] forwardIds)
    {
        return forwardMapper.deleteForwardByForwardIds(forwardIds);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param forwardId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteForwardByForwardId(Long forwardId)
    {
        return forwardMapper.deleteForwardByForwardId(forwardId);
    }

    /**
     * 根据活动id、openId、phone、bphone修改当前助力人数+1
     * @param forward
     * @return
     */
    @Override
    public int updateHelpCount(Forward forward) {
        Forward checkForward = forwardMapper.selectCheckForward(forward);
        if(checkForward == null){
            int i = forwardMapper.insertForward(forward);
            if (i > 0) {
                return forwardMapper.updateHelpCount(forward);
            } else {
                return -1;
            }
        }else{
            return -1;
        }

    }


    /**
     * 根据活动id和openid修改核销码状态
     * @param forward
     * @return
     */
    @Override
    public int updateStatus(Forward forward) {
        forwardMapper.updateStatus(forward);
        goodsService.updateGoodsRemainNum(forward.getActivityId());
        return forwardMapper.updateStatus(forward);
    }

    /**
     * 根据活动id和openid查询转发集赞信息
     * @param forward
     * @return
     */
    @Override
    public Forward selectForwardMsg(Forward forward) {
        return forwardMapper.selectForwardMsg(forward);
    }

    /**
     * 根据活动id和openid查询参与人手机号
     * @param forward
     * @return
     */
    @Override
    public Forward selectPhoneByAOpenId(Forward forward) {
        return forwardMapper.selectPhoneByAOpenId(forward);
    }


}

