package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Manager;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2023-06-01
 */
public interface ManagerMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param managerId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Manager selectManagerByManagerId(Long managerId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param manager 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Manager> selectManagerList(Manager manager);

    /**
     * 新增【请填写功能名称】
     * 
     * @param manager 【请填写功能名称】
     * @return 结果
     */
    public int insertManager(Manager manager);

    /**
     * 修改【请填写功能名称】
     * 
     * @param manager 【请填写功能名称】
     * @return 结果
     */
    public int updateManager(Manager manager);

    /**
     * 删除【请填写功能名称】
     * 
     * @param managerId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteManagerByManagerId(Long managerId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param managerIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteManagerByManagerIds(Long[] managerIds);

    /**
     * 根据商家id修改商家和任务详情的审核码
     * @param shopperId
     * @return
     */
    public int updateCheckStatus(Long shopperId);

    /**
     * 根据审核人手机号查询审核人信息
     * @param managerPhone
     * @return
     */
    public Manager selectManagerByManagerPhone(String managerPhone);
}
