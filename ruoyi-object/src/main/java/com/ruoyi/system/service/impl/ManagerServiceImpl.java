package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ManagerMapper;
import com.ruoyi.system.domain.Manager;
import com.ruoyi.system.service.IManagerService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-01
 */
@Service
public class ManagerServiceImpl implements IManagerService 
{
    @Autowired
    private ManagerMapper managerMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param managerId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Manager selectManagerByManagerId(Long managerId)
    {
        return managerMapper.selectManagerByManagerId(managerId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param manager 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Manager> selectManagerList(Manager manager)
    {
        return managerMapper.selectManagerList(manager);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param manager 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertManager(Manager manager)
    {
        return managerMapper.insertManager(manager);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param manager 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateManager(Manager manager)
    {
        return managerMapper.updateManager(manager);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param managerIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteManagerByManagerIds(Long[] managerIds)
    {
        return managerMapper.deleteManagerByManagerIds(managerIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param managerId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteManagerByManagerId(Long managerId)
    {
        return managerMapper.deleteManagerByManagerId(managerId);
    }

    /**
     * 根据商家id修改商家和任务详情的审核码
     * @param shopperId
     * @return
     */
    @Override
    public int updateCheckStatus(Long shopperId) {
        return managerMapper.updateCheckStatus(shopperId);
    }

    /**
     * 根据审核人手机号查询审核人信息
     * @param managerPhone
     * @return
     */
    @Override
    public Manager selectManagerByManagerPhone(String managerPhone) {
        return managerMapper.selectManagerByManagerPhone(managerPhone);
    }
}
