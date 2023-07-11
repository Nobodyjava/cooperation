package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Participant;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2023-06-01
 */
public interface IParticipantService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param participantId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Participant selectParticipantByParticipantId(Long participantId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param participant 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Participant> selectParticipantList(Participant participant);

    /**
     * 新增【请填写功能名称】
     * 
     * @param participant 【请填写功能名称】
     * @return 结果
     */
    public int insertParticipant(Participant participant);

    /**
     * 修改【请填写功能名称】
     * 
     * @param participant 【请填写功能名称】
     * @return 结果
     */
    public int updateParticipant(Participant participant);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param participantIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteParticipantByParticipantIds(Long[] participantIds);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param participantId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteParticipantByParticipantId(Long participantId);
}
