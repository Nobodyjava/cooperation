package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Building;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2023-06-16
 */
public interface IBuildingService
{
    /**
     * 查询【请填写功能名称】
     *
     * @param buildingId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Building selectBuildingByBuildingId(Long buildingId);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param building 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Building> selectBuildingList(Building building);

    /**
     * 新增【请填写功能名称】
     *
     * @param building 【请填写功能名称】
     * @return 结果
     */
    public int insertBuilding(Building building);

    /**
     * 修改【请填写功能名称】
     *
     * @param building 【请填写功能名称】
     * @return 结果
     */
    public int updateBuilding(Building building);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param buildingIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteBuildingByBuildingIds(Long[] buildingIds);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param buildingId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteBuildingByBuildingId(Long buildingId);
}
