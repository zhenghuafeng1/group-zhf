package zhf.service.imp;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import zhf.entity.UserEntity;

/**
 * @Autor zhenghf
 * @Date 2022/8/11
 * @ClassName
 * @Customer
 **/
@Service
public class TestUserService implements InitializingBean{

    private UserEntity defaultUser;


    @Override
    public void afterPropertiesSet() throws Exception {
        UserEntity user=new UserEntity();
        user.setName("光辉");
        user.setSex("girl");
        user.setAge(18);
        this.setDefaultUser(user);
    }

    public UserEntity getDefaultUser() {
        return defaultUser;
    }

    public void setDefaultUser(UserEntity defaultUser) {
        this.defaultUser = defaultUser;
    }
}
