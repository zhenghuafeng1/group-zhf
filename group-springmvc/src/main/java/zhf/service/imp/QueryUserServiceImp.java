package zhf.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhf.entity.UserEntity;
import zhf.service.QueryUserService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

@Service("QueryUserService")
public class QueryUserServiceImp implements QueryUserService {

    @PostConstruct
    public void test() {
        UserEntity userEntity=new UserEntity();
        userEntity.setName("zhenghuafeng");
        System.out.println("my name is "+userEntity.getName());
    }

    @PreDestroy
    public void test2() {
        UserEntity userEntity=new UserEntity();
        userEntity.setName("sunyueli");
        System.out.println("my name is "+userEntity.getName());
    }

    @Override
    public List<UserEntity> queryUserById() {
        return null;
    }
}
