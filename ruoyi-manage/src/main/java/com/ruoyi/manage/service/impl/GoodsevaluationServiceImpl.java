package com.ruoyi.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.manage.mapper.GoodsevaluationMapper;
import com.ruoyi.manage.domain.Goodsevaluation;
import com.ruoyi.manage.service.IGoodsevaluationService;

/**
 * 系统商品评价Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-12-29
 */
@Service
public class GoodsevaluationServiceImpl implements IGoodsevaluationService 
{
    @Autowired
    private GoodsevaluationMapper goodsevaluationMapper;

    /**
     * 查询系统商品评价
     * 
     * @param goodsEvaluationId2 系统商品评价主键
     * @return 系统商品评价
     */
    @Override
    public Goodsevaluation selectGoodsevaluationByGoodsEvaluationId2(Long goodsEvaluationId2)
    {
        return goodsevaluationMapper.selectGoodsevaluationByGoodsEvaluationId2(goodsEvaluationId2);
    }

    /**
     * 查询系统商品评价列表
     * 
     * @param goodsevaluation 系统商品评价
     * @return 系统商品评价
     */
    @Override
    public List<Goodsevaluation> selectGoodsevaluationList(Goodsevaluation goodsevaluation)
    {
        return goodsevaluationMapper.selectGoodsevaluationList(goodsevaluation);
    }

    /**
     * 新增系统商品评价
     * 
     * @param goodsevaluation 系统商品评价
     * @return 结果
     */
    @Override
    public int insertGoodsevaluation(Goodsevaluation goodsevaluation)
    {
        return goodsevaluationMapper.insertGoodsevaluation(goodsevaluation);
    }

    /**
     * 修改系统商品评价
     * 
     * @param goodsevaluation 系统商品评价
     * @return 结果
     */
    @Override
    public int updateGoodsevaluation(Goodsevaluation goodsevaluation)
    {
        return goodsevaluationMapper.updateGoodsevaluation(goodsevaluation);
    }

    /**
     * 批量删除系统商品评价
     * 
     * @param goodsEvaluationId2s 需要删除的系统商品评价主键
     * @return 结果
     */
    @Override
    public int deleteGoodsevaluationByGoodsEvaluationId2s(Long[] goodsEvaluationId2s)
    {
        return goodsevaluationMapper.deleteGoodsevaluationByGoodsEvaluationId2s(goodsEvaluationId2s);
    }

    /**
     * 删除系统商品评价信息
     * 
     * @param goodsEvaluationId2 系统商品评价主键
     * @return 结果
     */
    @Override
    public int deleteGoodsevaluationByGoodsEvaluationId2(Long goodsEvaluationId2)
    {
        return goodsevaluationMapper.deleteGoodsevaluationByGoodsEvaluationId2(goodsEvaluationId2);
    }
}
