package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Message;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2023-06-03
 */
public interface MessageMapper
{
    /**
     * 查询【请填写功能名称】
     *
     * @param messageId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Message selectMessageByMessageId(String messageId);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param message 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Message> selectMessageList(Message message);

    /**
     * 新增【请填写功能名称】
     *
     * @param message 【请填写功能名称】
     * @return 结果
     */
    public int insertMessage(Message message);

    /**
     * 修改【请填写功能名称】
     *
     * @param message 【请填写功能名称】
     * @return 结果
     */
    public int updateMessage(Message message);

    /**
     * 删除【请填写功能名称】
     *
     * @param messageId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteMessageByMessageId(String messageId);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param messageIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMessageByMessageIds(String[] messageIds);
}
