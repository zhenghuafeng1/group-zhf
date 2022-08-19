package demo.controller;


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
@RequestMapping("easyexcel")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;


}
