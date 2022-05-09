package com.xh.mapper;

import com.xh.entity.Borrow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: xh
 * @Date: 2022/5/9
 * @Description: com.xh.mapper
 * @Version: 1.0
 */
@Mapper
public interface BorrowMapper {

    @Select("select * from cloud_borrow where uid = #{uid}")
    List<Borrow> getBorrowByUserId(int uid);

    @Select("select * from cloud_borrow where bid = #{bid}")
    List<Borrow> getBorrowByBookId(int bid);

    @Select("select * from cloud_borrow where uid = #{uid} and bid = #{bid}")
    List<Borrow> getBorrow(int uid, int bid);

}
