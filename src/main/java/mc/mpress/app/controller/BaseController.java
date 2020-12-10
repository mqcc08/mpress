package mc.mpress.app.controller;


import mc.mpress.app.util.MPressContants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class BaseController {

    @RequestMapping(value = {"/" , "/index"})
    public Object index(){
        return "";
    }



    @RequestMapping(value = {"/admin"})
    public Object admin(Model model){
        Map<String, Object> returnMap = this.getReturnMap(MPressContants.ADMIN_INDEX);
        model.addAllAttributes(returnMap);
        return this.getReturnAdminPage("index");
    }


    @RequestMapping(value = {"/tabs/{pageName}"})
    public Object tabPageName(Model model , @PathVariable String pageName){
        Map<String, Object> returnMap = this.getReturnMap(MPressContants.ADMIN_INDEX);
        model.addAllAttributes(returnMap);
        return this.getReturnAdminPage("tabs/"+pageName);
    }


    /**
     *
     * @param pageName
     * @return
     */
    public String getReturnFrontPage(String pageName){
        String returnPageName = "front/";
        if (StringUtils.isNotBlank(MPressContants.FRONT.THEME_NAME)){
            returnPageName = returnPageName+ MPressContants.FRONT.THEME_NAME +"/"+pageName;
        }else{
            returnPageName = returnPageName+pageName;
        }
        return returnPageName;
    }

    public String getReturnAdminPage(String pageName){
        String returnPageName = "admin/";
        if (StringUtils.isNotBlank(MPressContants.ADMIN.THEME_NAME)){
            returnPageName = returnPageName+ MPressContants.ADMIN.THEME_NAME +"/"+pageName;
        }else{
            returnPageName = returnPageName+pageName;
        }
        return returnPageName;
    }

    public Map<String , Object>  getReturnMap(int index){
        Map<String , Object> returnMap = new HashMap<>();
        String cdnString = "";
        String themeNameString = "";
        if (index == MPressContants.FRONT_INDEX){
            cdnString = MPressContants.FRONT.CDN_PREFIX;
            themeNameString = MPressContants.FRONT.THEME_NAME;
        }else if (index == MPressContants.ADMIN_INDEX){
            cdnString = MPressContants.ADMIN.CDN_PREFIX;
            themeNameString = MPressContants.ADMIN.THEME_NAME;
        }
        returnMap.put("CDN" , cdnString);
        returnMap.put("THEME_NAME" , themeNameString);
        return returnMap;
    }


}
