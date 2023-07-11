package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BuildingMapper;
import com.ruoyi.system.domain.Building;
import com.ruoyi.system.service.IBuildingService;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2023-06-16
 */
@Service
public class BuildingServiceImpl implements IBuildingService
{
    @Autowired
    private BuildingMapper buildingMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param buildingId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Building selectBuildingByBuildingId(Long buildingId)
    {
        return buildingMapper.selectBuildingByBuildingId(buildingId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param building 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Building> selectBuildingList(Building building)
    {
        return buildingMapper.selectBuildingList(building);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param building 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertBuilding(Building building)
    {
        return buildingMapper.insertBuilding(building);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param building 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateBuilding(Building building)
    {
        return buildingMapper.updateBuilding(building);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param buildingIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteBuildingByBuildingIds(Long[] buildingIds)
    {
        return buildingMapper.deleteBuildingByBuildingIds(buildingIds);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param buildingId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteBuildingByBuildingId(Long buildingId)
    {
        return buildingMapper.deleteBuildingByBuildingId(buildingId);
    }
}
