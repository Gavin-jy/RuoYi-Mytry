package com.ruoyi.consumer.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.consumer.mapper.ShoppingcartMapper;
import com.ruoyi.consumer.domain.Shoppingcart;
import com.ruoyi.consumer.service.IShoppingcartService;

/**
 * 购物车Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-12-30
 */
@Service
public class ShoppingcartServiceImpl implements IShoppingcartService 
{
    @Autowired
    private ShoppingcartMapper shoppingcartMapper;

    /**
     * 查询购物车
     * 
     * @param shoppingItemId 购物车主键
     * @return 购物车
     */
    @Override
    public Shoppingcart selectShoppingcartByShoppingItemId(String shoppingItemId)
    {
        return shoppingcartMapper.selectShoppingcartByShoppingItemId(shoppingItemId);
    }

    /**
     * 查询购物车列表
     * 
     * @param shoppingcart 购物车
     * @return 购物车
     */
    @Override
    public List<Shoppingcart> selectShoppingcartList(Shoppingcart shoppingcart)
    {
        return shoppingcartMapper.selectShoppingcartList(shoppingcart);
    }

    /**
     * 新增购物车
     * 
     * @param shoppingcart 购物车
     * @return 结果
     */
    @Override
    public int insertShoppingcart(Shoppingcart shoppingcart)
    {
        return shoppingcartMapper.insertShoppingcart(shoppingcart);
    }

    /**
     * 修改购物车
     * 
     * @param shoppingcart 购物车
     * @return 结果
     */
    @Override
    public int updateShoppingcart(Shoppingcart shoppingcart)
    {
        shoppingcart.setUpdateTime(DateUtils.getNowDate());
        return shoppingcartMapper.updateShoppingcart(shoppingcart);
    }

    /**
     * 批量删除购物车
     * 
     * @param shoppingItemIds 需要删除的购物车主键
     * @return 结果
     */
    @Override
    public int deleteShoppingcartByShoppingItemIds(String[] shoppingItemIds)
    {
        return shoppingcartMapper.deleteShoppingcartByShoppingItemIds(shoppingItemIds);
    }

    /**
     * 删除购物车信息
     * 
     * @param shoppingItemId 购物车主键
     * @return 结果
     */
    @Override
    public int deleteShoppingcartByShoppingItemId(String shoppingItemId)
    {
        return shoppingcartMapper.deleteShoppingcartByShoppingItemId(shoppingItemId);
    }
}
