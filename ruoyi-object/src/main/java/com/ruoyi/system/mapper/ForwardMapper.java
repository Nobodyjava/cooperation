package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Forward;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2023-06-14
 */
public interface ForwardMapper
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
     * 删除【请填写功能名称】
     *
     * @param forwardId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteForwardByForwardId(Long forwardId);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param forwardIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteForwardByForwardIds(Long[] forwardIds);

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
