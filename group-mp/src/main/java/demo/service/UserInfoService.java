package demo.service;

import demo.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import demo.entity.UserInfoPo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author vicente
 * @since 2021-05-09
 */
public interface UserInfoService extends IService<UserInfo> {
    public List getMyUser();
    public List getMyLove();
    public int setUser(String roleId,List<String> userIds);
}
