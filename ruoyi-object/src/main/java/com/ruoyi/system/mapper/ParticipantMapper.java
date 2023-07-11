package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Participant;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2023-06-01
 */
public interface ParticipantMapper 
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
     * 删除【请填写功能名称】
     * 
     * @param participantId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteParticipantByParticipantId(Long participantId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param participantIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteParticipantByParticipantIds(Long[] participantIds);
}
