package com.ruoyi.consumer.service;

import java.util.List;
import com.ruoyi.consumer.domain.Shoppingcart;

/**
 * 购物车Service接口
 * 
 * @author ruoyi
 * @date 2021-12-30
 */
public interface IShoppingcartService 
{
    /**
     * 查询购物车
     * 
     * @param shoppingItemId 购物车主键
     * @return 购物车
     */
    public Shoppingcart selectShoppingcartByShoppingItemId(String shoppingItemId);

    /**
     * 查询购物车列表
     * 
     * @param shoppingcart 购物车
     * @return 购物车集合
     */
    public List<Shoppingcart> selectShoppingcartList(Shoppingcart shoppingcart);

    /**
     * 新增购物车
     * 
     * @param shoppingcart 购物车
     * @return 结果
     */
    public int insertShoppingcart(Shoppingcart shoppingcart);

    /**
     * 修改购物车
     * 
     * @param shoppingcart 购物车
     * @return 结果
     */
    public int updateShoppingcart(Shoppingcart shoppingcart);

    /**
     * 批量删除购物车
     * 
     * @param shoppingItemIds 需要删除的购物车主键集合
     * @return 结果
     */
    public int deleteShoppingcartByShoppingItemIds(String[] shoppingItemIds);

    /**
     * 删除购物车信息
     * 
     * @param shoppingItemId 购物车主键
     * @return 结果
     */
    public int deleteShoppingcartByShoppingItemId(String shoppingItemId);
}
