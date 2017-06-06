package com.eking.controller;

//@Controller
//@RequestMapping(value = "/dic")
//public class CommonLanguageController extends BaseController {
//
//    @Autowired
//    private CommonLanguageService commonLanguageService;
//
//
////@ResponseBody
//@RequestMapping(value = "/query/{chinese}",method = {RequestMethod.POST,RequestMethod.GET})
//public String dicQuery(ModelMap modelMap, @PathVariable String chinese){
////        JSONObject chinese=JSON.parseObject(json);
////        String chinese1=chinese.getString("chinese");
////        String chinese=commonLanguage.getChinese();
//        CommonLanguage dicDetail= commonLanguageService.queryByCh(chinese);
////        String jsonString = JSON.toJSONString(dicDetail);
//        modelMap.put("commonlanguages",dicDetail);
//        return "userList";
//    }
//    //@ResponseBody
//    @RequestMapping(value = "/query",method = {RequestMethod.POST,RequestMethod.GET})
//    public String dicQuery(ModelMap modelMap, @PathVariable String chinese){
////        JSONObject chinese=JSON.parseObject(json);
////        String chinese1=chinese.getString("chinese");
////        String chinese=commonLanguage.getChinese();
//        CommonLanguage dicDetail= commonLanguageService.queryByCh(chinese);
////        String jsonString = JSON.toJSONString(dicDetail);
//        modelMap.put("commonlanguages",dicDetail);
//        return "userList";
//    }
//
//    @RequestMapping(value = "/create",method = RequestMethod.POST)
//    @ResponseBody
//    public String dicCreate(@RequestBody String json)throws Exception{
//        JSONObject jsonObject=JSON.parseObject(json);
////        int id=jsonObject.getInteger("id");
//        int sysid=jsonObject.getInteger("sysid");
//        int userid=jsonObject.getInteger("userid");
//        String chinese=jsonObject.getString("chinese");
//        String english=jsonObject.getString("english");
//        String remark=jsonObject.getString("remark");
//        String channel=jsonObject.getString("channel");
//        CommonLanguage commonLanguage=new CommonLanguage();
////        commonLanguage.setId(id);
//        commonLanguage.setSysid(sysid);
//        commonLanguage.setUserid(userid);
//        commonLanguage.setChinese(chinese);
//        commonLanguage.setEnglish(english);
//        commonLanguage.setChannel(channel);
//        commonLanguage.setRemark(remark);
//        //捕捉异常,如何正确捕捉异常
//          if(commonLanguageService.createDic(commonLanguage)){
//              return "success";
//          }else{throw new Exception();}
//    }
//
//    @RequestMapping(value = "/list",method = RequestMethod.POST)
//    @ResponseBody
//    public String dicList(@RequestBody String json){
//        JSONObject chinese=JSON.parseObject(json);
//        int num=chinese.getInteger("num");
//        List<CommonLanguage> dicDetail= commonLanguageService.queryForList(num);
//        String jsonString = JSON.toJSONString(dicDetail);
//        return jsonString;
//    }
//
//    @RequestMapping(value = "/sort",method = RequestMethod.POST)
//    @ResponseBody
//    public String dicSort(@RequestBody String json){
//        JSONObject chinese=JSON.parseObject(json);
//        int num=chinese.getInteger("num");
//        List dicDetail= commonLanguageService.queryForSort(num);
//        String jsonString = JSON.toJSONString(dicDetail);
//        return jsonString;
//    }
//}


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eking.model.CommonLanguage;
import com.eking.model.SpringBootResult;
import com.eking.service.CommonLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/dic")
public class CommonLanguageController extends BaseController {

    @Autowired
    private CommonLanguageService commonLanguageService;

    /** 日志 */
//    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    /**
     * 根据条件动态查询用户
     * @param user
     * @return
     */
    @RequestMapping(value = "/queryForList", method = { RequestMethod.POST, RequestMethod.GET })
    public String queryForList(ModelMap modelMap, int num) {
        List<CommonLanguage> users = commonLanguageService.queryForList(num);
        modelMap.put("users", users);
        return "dicList";
    }
    @RequestMapping(value = "/queryForSort", method = { RequestMethod.POST, RequestMethod.GET })
    public String queryForSort(ModelMap modelMap, int num1) {
        List<CommonLanguage> users = commonLanguageService.queryForList(num1);
        modelMap.put("users", users);
        return "dicList";
    }

    /**
     * restful根据id查询用户
     * @param user
     * @return
     */



//    @ResponseBody
    @RequestMapping(value = "/queryByCh", method = {RequestMethod.POST,RequestMethod.GET})
    public String query(ModelMap modelMap,  CommonLanguage commonLanguage) {
//        log.info("用户id:" + id);
//        if (id == 1) {
//            throw new MyException("id为空");
//        }
//        SpringBootResult result = new SpringBootResult();
//        CommonLanguage commonLanguage = new CommonLanguage();
//        commonLanguage.setChinese(a);
//        String a=commonLanguage.getChinese();

        List<CommonLanguage> commonLanguages = commonLanguageService.queryByCh(commonLanguage);
//        result.setData(commonLanguages);
//        result.setSuccess(true);
        String abc=JSONObject.toJSONString(commonLanguage);
        System.out.println(abc);
        modelMap.put("commonlanguages",commonLanguages);
        return "dicList";
    }

//    @ResponseBody
//    @RequestMapping(value = "/queryByCh/{chinese}", method = RequestMethod.GET)
//    public SpringBootResult queryByCh(ModelMap modelMap, @PathVariable String chinese) {
////        log.info("用户id:" + id);
////        if (id == 1) {
////            throw new MyException("id为空");
////        }
//        SpringBootResult result = new SpringBootResult();
//        CommonLanguage commonLanguage = new CommonLanguage();
//        commonLanguage.setChinese(chinese);
//        List<CommonLanguage> commonLanguages = commonLanguageService.queryByCh(commonLanguage);
//        result.setData(commonLanguages);
//        result.setSuccess(true);
//        return result;
//    }

    /**
     * 修改词汇页面初始化
     * @param modelMap
     * @param user
     */
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update(ModelMap modelMap, @RequestParam Long id) {
        CommonLanguage commonLanguage = new CommonLanguage();
        commonLanguage.setId(id);
        List<CommonLanguage> commonLanguages = commonLanguageService.queryByCh(commonLanguage);
        modelMap.put("commonLanguage", commonLanguages.get(0));
        return "update";
    }

    /**
     * 修改词汇
     * @param modelMap
     * @param user
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public SpringBootResult update(ModelMap modelMap, CommonLanguage commonLanguage) {
        SpringBootResult result = new SpringBootResult();
        commonLanguageService.updateDic(commonLanguage);
//        result.setData(i);
        result.setSuccess(true);
        return result;
    }

    /**
     * 新增用户页面初始化
     * @param modelMap
     * @param user
     */
    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public String create(ModelMap modelMap) {
        return "create";
    }

    /**
     * 新增用户
     * @param modelMap
     * @param user
     */
    @ResponseBody
    @RequestMapping(value = "/create", method =  {RequestMethod.PUT} )
    public SpringBootResult create(ModelMap modelMap,  @ModelAttribute CommonLanguage commonLanguage) {
        SpringBootResult result = new SpringBootResult();
//        commonLanguage.setGmtCreate(new Date());
//        user.setGmtModify(new Date());
            int abc=commonLanguage.getSysid();
            commonLanguageService.createDic(commonLanguage);
//            int a=commonLanguage.getSysid();
//            System.out.println(a);
            result.setData(commonLanguage.getId());
            result.setSuccess(true);
            return result;
        }


//    /**
//     * 根据id删除用户
//     * @param modelMap
//     * @param id
//     */
//    @ResponseBody
//    @RequestMapping(value = "/deleteUser", method = { RequestMethod.DELETE, RequestMethod.GET })
//    public SpringBootResult deleteUser(ModelMap modelMap, @RequestParam Long id) {
//        SpringBootResult result = new SpringBootResult();
//        int i = userSerivce.deleteUser(id);
//        result.setData(i);
//        result.setSuccess(true);
//        return result;
//    }

}
