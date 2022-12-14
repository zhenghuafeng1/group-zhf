package zhf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zhf.entity.UserEntity;
import zhf.service.QueryUserService;
import zhf.service.imp.TestUserService;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("query")
public class LoginController {

    @Autowired
    QueryUserService queryUserService;

    @Autowired
    TestUserService testUserService;

    @GetMapping("/info")
    public List queryById(){
        return queryUserService.queryUserById();
    }

    @GetMapping("/test")
    public Object test(){
        return testUserService.getDefaultUser();
    }

    @GetMapping("/test2")
    public String test2(){
        ExecutorService executor= Executors.newSingleThreadExecutor();
        String name= String.valueOf(UUID.randomUUID());
        executor.execute(()->{

            for(int i=0;i<10;i++){
                System.out.println(name+"  "+i);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        return name;
    }

}
