package it.clever.opengest.web.controllers;
import it.clever.opengest.business.domain.Company;
import it.clever.opengest.business.domain.Group;
import it.clever.opengest.business.domain.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/users")
@Controller
@RooWebScaffold(path = "users", formBackingObject = User.class)
public class UserController {

    @InitBinder
    void registerConverters(WebDataBinder binder) {
        if (binder.getConversionService() instanceof GenericConversionService) {
            GenericConversionService conversionService = (GenericConversionService) binder.getConversionService();
            conversionService.addConverter(getCompanyConverter());
            conversionService.addConverter(getGroupConverter());
        }
    }

    private Converter<Group, String> getGroupConverter() {
        return new Converter<Group, String>() {

            public String convert(Group group) {
                return new StringBuilder().append(group.getName()).toString();
            }
        };
    }

    private Converter<Company, String> getCompanyConverter() {
        return new Converter<Company, String>() {

            public String convert(Company company) {
                return new StringBuilder().append(company.getDescription()).toString();
            }
        };
    }
}
