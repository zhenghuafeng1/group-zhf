package demo.service.impl;

import demo.mapper.UserInfoMapper;
import demo.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author vicente
 * @since 2021-05-09
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public List getMyUser() {
        return userInfoMapper.getMyUser();
    }

    @Override
    public List getMyLove() {
        return userInfoMapper.getMyLove();
    }

    @Override
    public int setUser(String roleId,List<String> userIds) {
        return userInfoMapper.setUser(roleId,userIds);
    }
}
