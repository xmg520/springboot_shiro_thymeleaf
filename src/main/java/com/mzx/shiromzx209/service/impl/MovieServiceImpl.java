package com.mzx.shiromzx209.service.impl;

import com.mzx.shiromzx209.dao.MovieDao;
import com.mzx.shiromzx209.entity.Movie;
import com.mzx.shiromzx209.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Mzx
 */
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieDao movieDao;

    @Override
    public Movie findAllByUidAndId(Integer uid, Integer mid) {
        return movieDao.findAllByUidAndId(uid,mid);
    }

    @Override
    public List<Movie> findAllByName(String username) {
        return movieDao.findAllByName(username);
    }


}
