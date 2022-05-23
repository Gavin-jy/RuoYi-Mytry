package com.ruoyi.consumer.mapper;

import java.util.List;
import com.ruoyi.consumer.domain.Mycollect;

/**
 * 我的收藏Mapper接口
 * 
 * @author ruoyi
 * @date 2021-12-30
 */
public interface MycollectMapper 
{
    /**
     * 查询我的收藏
     * 
     * @param mycollectId 我的收藏主键
     * @return 我的收藏
     */
    public Mycollect selectMycollectByMycollectId(Long mycollectId);

    /**
     * 查询我的收藏列表
     * 
     * @param mycollect 我的收藏
     * @return 我的收藏集合
     */
    public List<Mycollect> selectMycollectList(Mycollect mycollect);

    /**
     * 新增我的收藏
     * 
     * @param mycollect 我的收藏
     * @return 结果
     */
    public int insertMycollect(Mycollect mycollect);

    /**
     * 修改我的收藏
     * 
     * @param mycollect 我的收藏
     * @return 结果
     */
    public int updateMycollect(Mycollect mycollect);

    /**
     * 删除我的收藏
     * 
     * @param mycollectId 我的收藏主键
     * @return 结果
     */
    public int deleteMycollectByMycollectId(Long mycollectId);

    /**
     * 批量删除我的收藏
     * 
     * @param mycollectIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMycollectByMycollectIds(Long[] mycollectIds);
}
