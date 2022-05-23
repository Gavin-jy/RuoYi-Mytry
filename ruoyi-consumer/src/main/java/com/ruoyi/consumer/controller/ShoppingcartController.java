package com.ruoyi.consumer.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.consumer.domain.Shoppingcart;
import com.ruoyi.consumer.service.IShoppingcartService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 购物车Controller
 * 
 * @author ruoyi
 * @date 2021-12-30
 */
@RestController
@RequestMapping("/consumer/shoppingcart")
public class ShoppingcartController extends BaseController
{
    @Autowired
    private IShoppingcartService shoppingcartService;

    /**
     * 查询购物车列表
     */
    @PreAuthorize("@ss.hasPermi('consumer:shoppingcart:list')")
    @GetMapping("/list")
    public TableDataInfo list(Shoppingcart shoppingcart)
    {
        startPage();
        List<Shoppingcart> list = shoppingcartService.selectShoppingcartList(shoppingcart);
        return getDataTable(list);
    }

    /**
     * 导出购物车列表
     */
    @PreAuthorize("@ss.hasPermi('consumer:shoppingcart:export')")
    @Log(title = "购物车", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Shoppingcart shoppingcart)
    {
        List<Shoppingcart> list = shoppingcartService.selectShoppingcartList(shoppingcart);
        ExcelUtil<Shoppingcart> util = new ExcelUtil<Shoppingcart>(Shoppingcart.class);
        util.exportExcel(response, list, "购物车数据");
    }

    /**
     * 获取购物车详细信息
     */
    @PreAuthorize("@ss.hasPermi('consumer:shoppingcart:query')")
    @GetMapping(value = "/{shoppingItemId}")
    public AjaxResult getInfo(@PathVariable("shoppingItemId") String shoppingItemId)
    {
        return AjaxResult.success(shoppingcartService.selectShoppingcartByShoppingItemId(shoppingItemId));
    }

    /**
     * 新增购物车
     */
    @PreAuthorize("@ss.hasPermi('consumer:shoppingcart:add')")
    @Log(title = "购物车", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Shoppingcart shoppingcart)
    {
        return toAjax(shoppingcartService.insertShoppingcart(shoppingcart));
    }

    /**
     * 修改购物车
     */
    @PreAuthorize("@ss.hasPermi('consumer:shoppingcart:edit')")
    @Log(title = "购物车", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Shoppingcart shoppingcart)
    {
        return toAjax(shoppingcartService.updateShoppingcart(shoppingcart));
    }

    /**
     * 删除购物车
     */
    @PreAuthorize("@ss.hasPermi('consumer:shoppingcart:remove')")
    @Log(title = "购物车", businessType = BusinessType.DELETE)
	@DeleteMapping("/{shoppingItemIds}")
    public AjaxResult remove(@PathVariable String[] shoppingItemIds)
    {
        return toAjax(shoppingcartService.deleteShoppingcartByShoppingItemIds(shoppingItemIds));
    }
}
