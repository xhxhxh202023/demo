package com.xh.mapper;

import com.xh.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserMapper {
    @Select("select * from cloud_user where uid = #{uid}")
    User getUserById(Integer id);
}
