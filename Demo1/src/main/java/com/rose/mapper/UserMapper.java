package com.rose.mapper;

import com.rose.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    /**
     * 登录查询
     * @param username
     * @param password
     * @return
     */
    @Select("select * from user where username = #{username} and password = #{password};")
    User Select(@Param("username") String username,@Param("password") String password);

    /**
     * 根据用户名查询用户是否存在
     * @param username
     * @return
     */
    @Select("select * from user where username = #{username};")
    User SelectByName(String username);

    /**
     * 添加用户
     * @param user
     */
    @Insert("insert into user values (null,#{userName},#{passWord});")
    void Add(User user);

}
