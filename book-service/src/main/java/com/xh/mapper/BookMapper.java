package com.xh.mapper;

import com.xh.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Auther: xh
 * @Date: 2022/5/9
 * @Description: com.xh.mapper
 * @Version: 1.0
 */
@Mapper
public interface BookMapper {
    @Select("select * from cloud_book where bid = #{bid}")
    Book getBookById(int id);
}
