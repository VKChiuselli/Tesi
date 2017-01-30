// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package it.clever.opengest.web.controllers;

import it.clever.opengest.business.domain.Customer;
import it.clever.opengest.business.domain.Order;
import it.clever.opengest.business.domain.Product;
import it.clever.opengest.web.controllers.OrderController;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect OrderController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String OrderController.create(@Valid Order order, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, order);
            return "orders/create";
        }
        uiModel.asMap().clear();
        order.persist();
        return "redirect:/orders/" + encodeUrlPathSegment(order.getIdOrdine().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String OrderController.createForm(Model uiModel) {
        populateEditForm(uiModel, new Order());
        return "orders/create";
    }
    
    @RequestMapping(value = "/{idOrdine}", produces = "text/html")
    public String OrderController.show(@PathVariable("idOrdine") Integer idOrdine, Model uiModel) {
        uiModel.addAttribute("order", Order.findOrder(idOrdine));
        uiModel.addAttribute("itemId", idOrdine);
        return "orders/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String OrderController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("orders", Order.findOrderEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) Order.countOrders() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("orders", Order.findAllOrders(sortFieldName, sortOrder));
        }
        return "orders/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String OrderController.update(@Valid Order order, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, order);
            return "orders/update";
        }
        uiModel.asMap().clear();
        order.merge();
        return "redirect:/orders/" + encodeUrlPathSegment(order.getIdOrdine().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{idOrdine}", params = "form", produces = "text/html")
    public String OrderController.updateForm(@PathVariable("idOrdine") Integer idOrdine, Model uiModel) {
        populateEditForm(uiModel, Order.findOrder(idOrdine));
        return "orders/update";
    }
    
    @RequestMapping(value = "/{idOrdine}", method = RequestMethod.DELETE, produces = "text/html")
    public String OrderController.delete(@PathVariable("idOrdine") Integer idOrdine, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Order order = Order.findOrder(idOrdine);
        order.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/orders";
    }
    
    void OrderController.populateEditForm(Model uiModel, Order order) {
        uiModel.addAttribute("order", order);
        uiModel.addAttribute("customers", Customer.findAllCustomers());
        uiModel.addAttribute("products", Product.findAllProducts());
    }
    
    String OrderController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
    
}
