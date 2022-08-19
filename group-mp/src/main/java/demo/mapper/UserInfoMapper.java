package demo.mapper;

import demo.entity.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import demo.entity.UserInfoPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author vicente
 * @since 2021-05-09
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
    public List getMyUser();
    public List getMyLove();
    public int setUser(@Param("roleId") String roleId,@Param("userIds") List<String> userIds);
}
