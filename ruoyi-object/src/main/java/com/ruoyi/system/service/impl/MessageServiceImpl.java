package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.MessageMapper;
import com.ruoyi.system.domain.Message;
import com.ruoyi.system.service.IMessageService;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2023-06-03
 */
@Service
public class MessageServiceImpl implements IMessageService
{
    @Autowired
    private MessageMapper messageMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param messageId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Message selectMessageByMessageId(String messageId)
    {
        return messageMapper.selectMessageByMessageId(messageId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param message 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Message> selectMessageList(Message message)
    {
        return messageMapper.selectMessageList(message);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param message 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertMessage(Message message)
    {
        return messageMapper.insertMessage(message);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param message 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateMessage(Message message)
    {
        return messageMapper.updateMessage(message);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param messageIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteMessageByMessageIds(String[] messageIds)
    {
        return messageMapper.deleteMessageByMessageIds(messageIds);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param messageId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteMessageByMessageId(String messageId)
    {
        return messageMapper.deleteMessageByMessageId(messageId);
    }
}

