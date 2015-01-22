package com.jmango360.server;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.knappsack.swagger4springweb.controller.ApiDocumentationController;
import com.wordnik.swagger.model.ApiInfo;

@Controller
@RequestMapping(value = "/documentation")
public class DocumentController extends ApiDocumentationController{

	public DocumentController() {
        setBaseControllerPackage("com.jmango360.server");
        List<String> controllerPackages = new ArrayList<String>();
        controllerPackages.add("com.jmango360.server.api.rest");
        setAdditionalControllerPackages(controllerPackages);

        setBaseModelPackage("com.jmango360.server.model");
//        List<String> modelPackages = new ArrayList<String>();
//        modelPackages.add("com.knappsack.swagger4springweb.additionalModels");
//        setAdditionalModelPackages(modelPackages);

        setApiVersion("v1");

        ApiInfo apiInfo = new ApiInfo("JMango360-Raspberry API", "This is JMango Raspberry API server",
                "http://www.jmango360.com/terms-conditions/", "http://www.jmango360.com/contact/", "JMango360", "http://www.jmango360.com/");
        setApiInfo(apiInfo);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String documentation() {
        return "documentation";
    }
}
