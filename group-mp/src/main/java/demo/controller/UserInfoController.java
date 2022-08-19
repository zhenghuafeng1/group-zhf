package demo.controller;


import demo.entity.UserInfoPo;
import demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author vicente
 * @since 2021-05-09
 */
@RestController
@RequestMapping("query")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @GetMapping("/info1")
    public List query1(){
        return userInfoService.list();
    }

    @GetMapping("/info2")
    public List query2(){
        return userInfoService.getMyUser();
    }

    @GetMapping("/info3")
    public List query3(){
        return userInfoService.getMyLove();
    }

    @PostMapping("/info4")
    public String query4(String roleId,@RequestParam(value = "userIds",required=false)List<String> userIds){
        int index=userInfoService.setUser(roleId,userIds);
        return String.valueOf(index);

    }

    @PostMapping("/info5")
    public String query5(@RequestBody Map<String,Object> map){
        String roleId=(String)map.get("roleId");
        List<String> userIds=(ArrayList)map.get("userIds");
        int index=userInfoService.setUser(roleId,userIds);
        return String.valueOf(index);

    }
}
