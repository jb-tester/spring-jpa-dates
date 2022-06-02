package com.mytests.spring.jpa.dateFunctionsInQueries.repos;

import com.mytests.spring.jpa.dateFunctionsInQueries.model.Message;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * *
 * <p>Created by irina on 28.05.2022.</p>
 * <p>Project: spring-jpa-dates</p>
 * *
 */
public interface MessageRepository extends CrudRepository<Message,Long> {
    // https://youtrack.jetbrains.com/issue/IDEA-173857
    @Query("select m from Message m where m.delivered > current_timestamp() ")
    List<Message> query1();
    
    //  https://youtrack.jetbrains.com/issue/IDEA-135708
    @Query("select m from Message m where CAST(m.sent AS timestamp) > CURRENT_TIMESTAMP ")
    List<Message> query2();

    //  https://youtrack.jetbrains.com/issue/IDEA-135708
    @Query("select m from Message m where CAST(m.status boolean) = :flag ")
    List<Message> query3(@Param("flag") boolean flag);

    //  https://youtrack.jetbrains.com/issue/IDEA-135708
    @Query("select CAST(m.sent as date) from Message m where m.from = :author ")
    List<Date> query4(@Param("author") String author);

/*
     // @Transient attribute tests:
    // 'flag' is annotated with @Transient: should not be available in queries
    List<Message> findByFlag(boolean flag);

    @Query("select m from Message m where m.flag = true")
    List<Message> transientFieldQuery(boolean flag);
*/


}
