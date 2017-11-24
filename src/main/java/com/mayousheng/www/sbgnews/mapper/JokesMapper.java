package com.mayousheng.www.sbgnews.mapper;

import com.mayousheng.www.sbgnews.pojo.joke.Joke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("jokesMapper")
public interface JokesMapper extends JpaRepository<Joke, Integer> {

    public Joke getJokesByTitle(String title);

    @Query(nativeQuery = true, value = "select * from joke order by id desc limit :offset,:count")
    public List<Joke> getJokeByOffset(@Param("count") Integer count, @Param("offset") Integer offset);

}
