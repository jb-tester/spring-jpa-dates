package com.mytests.spring.jpa.dateFunctionsInQueries.repos;

import com.mytests.spring.jpa.dateFunctionsInQueries.model.Message;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

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

    
    
}
