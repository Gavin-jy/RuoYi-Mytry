package com.ruoyi.manage.controller;

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
import com.ruoyi.manage.domain.Deliveryorder;
import com.ruoyi.manage.service.IDeliveryorderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 物流订单Controller
 * 
 * @author ruoyi
 * @date 2021-12-29
 */
@RestController
@RequestMapping("/manage/deliveryorder")
public class DeliveryorderController extends BaseController
{
    @Autowired
    private IDeliveryorderService deliveryorderService;

    /**
     * 查询物流订单列表
     */
    @PreAuthorize("@ss.hasPermi('manage:deliveryorder:list')")
    @GetMapping("/list")
    public TableDataInfo list(Deliveryorder deliveryorder)
    {
        startPage();
        List<Deliveryorder> list = deliveryorderService.selectDeliveryorderList(deliveryorder);
        return getDataTable(list);
    }

    /**
     * 导出物流订单列表
     */
    @PreAuthorize("@ss.hasPermi('manage:deliveryorder:export')")
    @Log(title = "物流订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Deliveryorder deliveryorder)
    {
        List<Deliveryorder> list = deliveryorderService.selectDeliveryorderList(deliveryorder);
        ExcelUtil<Deliveryorder> util = new ExcelUtil<Deliveryorder>(Deliveryorder.class);
        util.exportExcel(response, list, "物流订单数据");
    }

    /**
     * 获取物流订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:deliveryorder:query')")
    @GetMapping(value = "/{deliveryOrderId3}")
    public AjaxResult getInfo(@PathVariable("deliveryOrderId3") Long deliveryOrderId3)
    {
        return AjaxResult.success(deliveryorderService.selectDeliveryorderByDeliveryOrderId3(deliveryOrderId3));
    }

    /**
     * 新增物流订单
     */
    @PreAuthorize("@ss.hasPermi('manage:deliveryorder:add')")
    @Log(title = "物流订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Deliveryorder deliveryorder)
    {
        return toAjax(deliveryorderService.insertDeliveryorder(deliveryorder));
    }

    /**
     * 修改物流订单
     */
    @PreAuthorize("@ss.hasPermi('manage:deliveryorder:edit')")
    @Log(title = "物流订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Deliveryorder deliveryorder)
    {
        return toAjax(deliveryorderService.updateDeliveryorder(deliveryorder));
    }

    /**
     * 删除物流订单
     */
    @PreAuthorize("@ss.hasPermi('manage:deliveryorder:remove')")
    @Log(title = "物流订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{deliveryOrderId3s}")
    public AjaxResult remove(@PathVariable Long[] deliveryOrderId3s)
    {
        return toAjax(deliveryorderService.deleteDeliveryorderByDeliveryOrderId3s(deliveryOrderId3s));
    }
}
