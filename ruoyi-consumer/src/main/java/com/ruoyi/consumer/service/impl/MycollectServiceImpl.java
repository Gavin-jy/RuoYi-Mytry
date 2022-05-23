package com.ruoyi.consumer.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.consumer.mapper.MycollectMapper;
import com.ruoyi.consumer.domain.Mycollect;
import com.ruoyi.consumer.service.IMycollectService;

/**
 * 我的收藏Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-12-30
 */
@Service
public class MycollectServiceImpl implements IMycollectService 
{
    @Autowired
    private MycollectMapper mycollectMapper;

    /**
     * 查询我的收藏
     * 
     * @param mycollectId 我的收藏主键
     * @return 我的收藏
     */
    @Override
    public Mycollect selectMycollectByMycollectId(Long mycollectId)
    {
        return mycollectMapper.selectMycollectByMycollectId(mycollectId);
    }

    /**
     * 查询我的收藏列表
     * 
     * @param mycollect 我的收藏
     * @return 我的收藏
     */
    @Override
    public List<Mycollect> selectMycollectList(Mycollect mycollect)
    {
        return mycollectMapper.selectMycollectList(mycollect);
    }

    /**
     * 新增我的收藏
     * 
     * @param mycollect 我的收藏
     * @return 结果
     */
    @Override
    public int insertMycollect(Mycollect mycollect)
    {
        return mycollectMapper.insertMycollect(mycollect);
    }

    /**
     * 修改我的收藏
     * 
     * @param mycollect 我的收藏
     * @return 结果
     */
    @Override
    public int updateMycollect(Mycollect mycollect)
    {
        mycollect.setUpdateTime(DateUtils.getNowDate());
        return mycollectMapper.updateMycollect(mycollect);
    }

    /**
     * 批量删除我的收藏
     * 
     * @param mycollectIds 需要删除的我的收藏主键
     * @return 结果
     */
    @Override
    public int deleteMycollectByMycollectIds(Long[] mycollectIds)
    {
        return mycollectMapper.deleteMycollectByMycollectIds(mycollectIds);
    }

    /**
     * 删除我的收藏信息
     * 
     * @param mycollectId 我的收藏主键
     * @return 结果
     */
    @Override
    public int deleteMycollectByMycollectId(Long mycollectId)
    {
        return mycollectMapper.deleteMycollectByMycollectId(mycollectId);
    }
}
