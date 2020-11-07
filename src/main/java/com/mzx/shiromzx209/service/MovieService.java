package com.mzx.shiromzx209.service;

import com.mzx.shiromzx209.entity.Movie;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author Mzx
 */
public interface MovieService {

    Movie findAllByUidAndId(@Param("uid") Integer uid, @Param("mid") Integer mid);

    List<Movie> findAllByName(String username);
}
