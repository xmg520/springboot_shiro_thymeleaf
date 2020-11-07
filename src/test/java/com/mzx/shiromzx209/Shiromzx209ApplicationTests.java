package com.mzx.shiromzx209;

import com.mzx.shiromzx209.entity.Movie;
import com.mzx.shiromzx209.service.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class Shiromzx209ApplicationTests {

    @Autowired
    MovieService movieService;

    @Test
    void contextLoads() {
        Movie movie = movieService.findAllByUidAndId(4,10);
        System.out.println(movie == null);
    }

}
