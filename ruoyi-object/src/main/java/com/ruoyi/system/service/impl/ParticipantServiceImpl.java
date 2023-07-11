package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ParticipantMapper;
import com.ruoyi.system.domain.Participant;
import com.ruoyi.system.service.IParticipantService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-01
 */
@Service
public class ParticipantServiceImpl implements IParticipantService 
{
    @Autowired
    private ParticipantMapper participantMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param participantId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Participant selectParticipantByParticipantId(Long participantId)
    {
        return participantMapper.selectParticipantByParticipantId(participantId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param participant 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Participant> selectParticipantList(Participant participant)
    {
        return participantMapper.selectParticipantList(participant);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param participant 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertParticipant(Participant participant)
    {
        return participantMapper.insertParticipant(participant);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param participant 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateParticipant(Participant participant)
    {
        return participantMapper.updateParticipant(participant);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param participantIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteParticipantByParticipantIds(Long[] participantIds)
    {
        return participantMapper.deleteParticipantByParticipantIds(participantIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param participantId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteParticipantByParticipantId(Long participantId)
    {
        return participantMapper.deleteParticipantByParticipantId(participantId);
    }
}
