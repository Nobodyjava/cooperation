package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Forward;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2023-06-14
 */
public interface IForwardService
{
    /**
     * 查询【请填写功能名称】
     *
     * @param forwardId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Forward selectForwardByForwardId(Long forwardId);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param forward 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Forward> selectForwardList(Forward forward);

    /**
     * 新增【请填写功能名称】
     *
     * @param forward 【请填写功能名称】
     * @return 结果
     */
    public int insertForward(Forward forward);

    /**
     * 修改【请填写功能名称】
     *
     * @param forward 【请填写功能名称】
     * @return 结果
     */
    public int updateForward(Forward forward);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param forwardIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteForwardByForwardIds(Long[] forwardIds);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param forwardId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteForwardByForwardId(Long forwardId);

    /**
     * 根据活动id和openId修改当前助力人数+1
     * @return
     */
    public int updateHelpCount(Forward forward);

    /**
     * 根据活动id和openid修改核销码状态
     * @param forward
     * @return
     */
    public int updateStatus(Forward forward);

    /**
     * 根据活动id和openid查询转发集赞信息
     * @param forward
     * @return
     */
    public Forward selectForwardMsg(Forward forward);
}
