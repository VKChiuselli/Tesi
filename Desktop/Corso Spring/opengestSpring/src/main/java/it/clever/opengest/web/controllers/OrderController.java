package it.clever.opengest.web.controllers;
import it.clever.opengest.business.domain.Order;
import it.clever.opengest.utils.DateUtil;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/orders")
@Controller
@RooWebScaffold(path = "orders", formBackingObject = Order.class)
public class OrderController {
	
    void addDateTimeFormatPatterns(ModelMap modelMap) {
    	modelMap.addAttribute("wharehouse_view_date_format", DateUtil.patternForStyleAndLocale(DateUtil.DateStyle.DATE, LocaleContextHolder.getLocale()));
    	modelMap.addAttribute("person_birthdate_date_format", DateUtil.patternForStyleAndLocale(DateUtil.DateStyle.DATE, LocaleContextHolder.getLocale()));
    	modelMap.addAttribute("person_docdate_date_format", DateUtil.patternForStyleAndLocale(DateUtil.DateStyle.DATE, LocaleContextHolder.getLocale()));
    	modelMap.addAttribute("person_docexp_date_format", DateUtil.patternForStyleAndLocale(DateUtil.DateStyle.DATE, LocaleContextHolder.getLocale()));
    }
}
