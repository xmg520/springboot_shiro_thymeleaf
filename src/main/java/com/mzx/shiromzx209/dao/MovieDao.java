package com.mzx.shiromzx209.dao;

import com.mzx.shiromzx209.entity.Movie;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author Mzx
 */
public interface MovieDao {

    // 根据uid mid 查询电影接口
    Movie findAllByUidAndId(@Param("uid") Integer uid, @Param("mid") Integer mid);

    // 根据登录名查询电影列表接口
    List<Movie> findAllByName(String username);
}
