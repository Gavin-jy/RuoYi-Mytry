package com.ruoyi.manage.service;

import java.util.List;
import com.ruoyi.manage.domain.Producttype;

/**
 * 商品类型Service接口
 * 
 * @author ruoyi
 * @date 2021-12-29
 */
public interface IProducttypeService 
{
    /**
     * 查询商品类型
     * 
     * @param productTypeId 商品类型主键
     * @return 商品类型
     */
    public Producttype selectProducttypeByProductTypeId(Long productTypeId);

    /**
     * 查询商品类型列表
     * 
     * @param producttype 商品类型
     * @return 商品类型集合
     */
    public List<Producttype> selectProducttypeList(Producttype producttype);

    /**
     * 新增商品类型
     * 
     * @param producttype 商品类型
     * @return 结果
     */
    public int insertProducttype(Producttype producttype);

    /**
     * 修改商品类型
     * 
     * @param producttype 商品类型
     * @return 结果
     */
    public int updateProducttype(Producttype producttype);

    /**
     * 批量删除商品类型
     * 
     * @param productTypeIds 需要删除的商品类型主键集合
     * @return 结果
     */
    public int deleteProducttypeByProductTypeIds(Long[] productTypeIds);

    /**
     * 删除商品类型信息
     * 
     * @param productTypeId 商品类型主键
     * @return 结果
     */
    public int deleteProducttypeByProductTypeId(Long productTypeId);
}
