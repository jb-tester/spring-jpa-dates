package com.mytests.spring.jpa.dateFunctionsInQueries.repos;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * *
 * <p>Created by irina on 8/11/2022.</p>
 * <p>Project: spring6-jpa-persistence31</p>
 * *
 */
@Service
public class UsingEntityManager {

    @Autowired
    EntityManager em;

    public void displayResults(){
        
        jakarta.persistence.Query query1 =
                em.createQuery("select a from DatesAndNumbers a  where a.firstDate between a.secondDate and current_date() ");
        System.out.println("current_date() test: " + query1.getResultList());
        jakarta.persistence.Query query2 =
                em.createQuery("select a from DatesAndNumbers a  where a.firstDate between a.secondDate and local_date() ");
        System.out.println("local_date() test: " + query2.getResultList());
        jakarta.persistence.Query query3 =
                em.createQuery("select a from DatesAndNumbers a  where a.timeTwo < current_timestamp() ");
        System.out.println("current_timestamp() test: " + query3.getResultList());
        jakarta.persistence.Query query4 =
                em.createQuery("select d from DatesAndNumbers d where ceiling(d.floatTwo) > 100  ");
        System.out.println("ceiling(float) test: " + query4.getResultList());
        jakarta.persistence.Query query5 =
                em.createQuery("select d from DatesAndNumbers d where extract(YEAR from d.secondDate) = YEAR(d.firstDate)");
        System.out.println("extract(..) test: " + query5.getResultList());
        jakarta.persistence.Query query6 =
                em.createQuery("select d from DatesAndNumbers d where exp(d.firstNum) > 100");
        System.out.println("exp(..) test: " + query6.getResultList());
        jakarta.persistence.Query query7 =
                em.createQuery("select d from DatesAndNumbers d where power(d.firstNum+100, d.secondNum) > 5");
        System.out.println("power(..) test: " + query7.getResultList());
        jakarta.persistence.Query query8 =
                em.createQuery("select o from DatesAndNumbers o where cast(o.firstDate as LocalDate) is not null");
        System.out.println("cast() test: " + query8.getResultList());
        jakarta.persistence.Query query9 =
                em.createQuery("select d from DatesAndNumbers d where d.id > 1 order by d.firstNum desc, d.timeOne desc nulls last, d.timeTwo asc nulls first ");
        System.out.println("order by nulls test: " + query9.getResultList());

    }
}
