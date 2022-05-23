package com.ruoyi.manage.service;

import java.util.List;
import com.ruoyi.manage.domain.Goodsevaluation;

/**
 * 系统商品评价Service接口
 * 
 * @author ruoyi
 * @date 2021-12-29
 */
public interface IGoodsevaluationService 
{
    /**
     * 查询系统商品评价
     * 
     * @param goodsEvaluationId2 系统商品评价主键
     * @return 系统商品评价
     */
    public Goodsevaluation selectGoodsevaluationByGoodsEvaluationId2(Long goodsEvaluationId2);

    /**
     * 查询系统商品评价列表
     * 
     * @param goodsevaluation 系统商品评价
     * @return 系统商品评价集合
     */
    public List<Goodsevaluation> selectGoodsevaluationList(Goodsevaluation goodsevaluation);

    /**
     * 新增系统商品评价
     * 
     * @param goodsevaluation 系统商品评价
     * @return 结果
     */
    public int insertGoodsevaluation(Goodsevaluation goodsevaluation);

    /**
     * 修改系统商品评价
     * 
     * @param goodsevaluation 系统商品评价
     * @return 结果
     */
    public int updateGoodsevaluation(Goodsevaluation goodsevaluation);

    /**
     * 批量删除系统商品评价
     * 
     * @param goodsEvaluationId2s 需要删除的系统商品评价主键集合
     * @return 结果
     */
    public int deleteGoodsevaluationByGoodsEvaluationId2s(Long[] goodsEvaluationId2s);

    /**
     * 删除系统商品评价信息
     * 
     * @param goodsEvaluationId2 系统商品评价主键
     * @return 结果
     */
    public int deleteGoodsevaluationByGoodsEvaluationId2(Long goodsEvaluationId2);
}
