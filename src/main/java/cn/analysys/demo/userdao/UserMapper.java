package cn.analysys.demo.userdao;

import cn.analysys.demo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("slaveDataSource")
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where username=#{username} and password=#{password};")
    User login(String username,String password);

}
