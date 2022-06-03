package com.mytests.spring.jpa.dateFunctionsInQueries.repos;

import com.mytests.spring.jpa.dateFunctionsInQueries.model.FooBar;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * *
 * <p>Created by irina on 6/3/2022.</p>
 * <p>Project: spring-jpa-dates</p>
 * <p> dot in entity.name: <a href="https://youtrack.jetbrains.com/issue/IDEA-295357">IDEA-295357</a></p>
 * *
 */
public interface FooBarRepository extends CrudRepository<FooBar,Integer> {

    @Query("select f from foo.bar f where f.name = :name")
    List<FooBar> query(@Param("name") String name);
}
