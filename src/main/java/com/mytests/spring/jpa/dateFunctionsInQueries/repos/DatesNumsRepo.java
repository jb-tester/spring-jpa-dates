package com.mytests.spring.jpa.dateFunctionsInQueries.repos;

import com.mytests.spring.jpa.dateFunctionsInQueries.model.DatesAndNumbers;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * *
 * <p>Created by irina on 28.05.2022.</p>
 * <p>Project: spring-jpa-dates</p>
 * *
 */
public interface DatesNumsRepo extends CrudRepository<DatesAndNumbers, Integer> {

    @Query("select d from DatesAndNumbers d where d.firstDate = local date ")
    List<DatesAndNumbers> query1();

    @Query("select d from DatesAndNumbers d where local datetime > d.timeOne and local time > d.timeTwo ")
    List<DatesAndNumbers> query2(@Param("time") LocalDateTime time);

    @Query("select d from DatesAndNumbers d where (extract(YEAR from :date) = YEAR(d.firstDate)) or (extract(MONTH from d.secondDate) = extract(MONTH from local date))")
    List<DatesAndNumbers> query3(@Param("date") Date date);

    @Query("select d from DatesAndNumbers d where ceiling(d.floatTwo) > 100 ")
    List<DatesAndNumbers> query4();

    @Query("select d from DatesAndNumbers d where exp(d.firstNum) > 100 ")
    List<DatesAndNumbers> query5();

    @Query("select d from DatesAndNumbers d where floor(d.floatTwo) > d.firstNum ")
    List<DatesAndNumbers> query6();

    @Query("select d from DatesAndNumbers d where ln(d.secondNum) < d.firstNum + 10")
    List<DatesAndNumbers> query7();

    @Query("select d from DatesAndNumbers d where power(d.firstNum+100, d.secondNum) > :num ")
    List<DatesAndNumbers> query8(@Param("num") int num);

    @Query("select d from DatesAndNumbers d where round(d.firstNum, d.secondNum) = :num ")
    List<DatesAndNumbers> query9(@Param("num") int num);

    @Query("select d from DatesAndNumbers d where sign(d.floatTwo) = -1 ")
    List<DatesAndNumbers> query10();

    @Query("select SUM(d.secondNum) from DatesAndNumbers d where coalesce(:foo, d.firstNum) > coalesce(d.floatTwo, d.floatOne)")
    Integer query11(@Param("foo") Integer foo);

    // @Query("select d from DatesAndNumbers d where d.firstNum > ?") // shows error, and this is ok!
    @Query("select d from DatesAndNumbers d where d.firstNum > ?1")
    List<DatesAndNumbers> query12(Integer param);

    @Query("select a from DatesAndNumbers a  where a.firstDate between a.secondDate and current_timestamp()")
    List<DatesAndNumbers> query13();

    @Query("select a from DatesAndNumbers a  where a.firstDate between a.secondDate and local_date()")
    List<DatesAndNumbers> query14();

    // https://youtrack.jetbrains.com/issue/IDEA-299266: new cast()
    @Query("select o from DatesAndNumbers o where CAST(o.firstDate as LocalDate) is not null ")
    List<DatesAndNumbers> testCastingToLocalDate();

    @Query("select o from DatesAndNumbers o where CAST(o.secondDate as LocalDateTime) is not null ")
    List<DatesAndNumbers> testCastingToLocalDateTime();

    @Query("select o from DatesAndNumbers o where CAST(o.firstNum as BigInteger) is not null ")
    List<DatesAndNumbers> testCastingToBigInteger();

    @Query("select o from DatesAndNumbers o where CAST(o.floatTwo as BigDecimal) is not null ")
    List<DatesAndNumbers> testCastingToBigDecimal();

    @Query("select d from DatesAndNumbers d where d.id > 0" +
            "and (d.floatTwo > 0)" +
            "and ((d.floatTwo > 10) " +
            "or not (d.floatOne < 100)" +
            "or (?1 < cast(d.firstNum as integer))" +
            "or (?2 = cast(d.firstDate as date))" +
            ")")
    List<DatesAndNumbers> logicalOperatorsExpr(int arg1, Date arg2);

    // https://youtrack.jetbrains.com/issue/IDEA-300505
    @Query("select o from DatesAndNumbers o where (day(o.firstDate) = ?#{[0]?.day}) or (month(?#{[1]}) = month(o.secondDate)) ")
    List<DatesAndNumbers> testSpEL1(Date myDate1, Date myDate2);

    @Query("select o from DatesAndNumbers o where cast(o.firstDate as localdate) >= ?#{T(java.time.LocalDate).now().minusMonths(40).withDayOfMonth(1)}")
    List<DatesAndNumbers> testSpEL2( );

    // doesn't work - fails with exception
    /*@Query("select count(d) filter(d.secondNum > ?1) from DatesAndNumbers d")
    int useFilter(int arg1);*/

    @Query("select d from DatesAndNumbers d order by d.firstNum desc, d.timeOne desc nulls last, d.timeTwo asc nulls first ")
    List<DatesAndNumbers> testMultipleOrderBy();

    @Query("select d from DatesAndNumbers d where d.firstDate between d.secondDate and sysdate()")
    List<DatesAndNumbers> checkSysdate();

    // nullif: find entries where firstNum is not null or does not equal the passed parameter.
    @Query(value = "SELECT m FROM DatesAndNumbers m WHERE nullif(m.firstNum, :parameter) IS NOT NULL")
    List<DatesAndNumbers> findMyEntityByColumnIsNotNull(@Param("parameter") Integer parameter);

    // TODO: !!! to check
    /*@Query("select d from DatesAndNumbers d where treat(d as DateAndNumbers).firstNum > 10")
    List<DatesAndNumbers> useTreat();*/

    @Query("select d.secondNum*java.lang.Math.PI from DatesAndNumbers d")
    List<Double> test_pi();


    @Query("select minute(d.firstDate)-minute(d.secondDate) from DatesAndNumbers d where year(local date) - year(d.secondDate) > 1")
    List<String> functionInSelectClause();

    // https://youtrack.jetbrains.com/issue/IDEA-337145
    @Query("select a from com.mytests.spring.jpa.dateFunctionsInQueries.model.DatesAndNumbers a where a.firstDate between a.secondDate and current_date()")
    List<DatesAndNumbers> useEntityFQN();

    // https://youtrack.jetbrains.com/issue/IDEA-342172
    @Query("select a from DatesAndNumbers a where a.firstDate = a.secondDate + 1 hour")
    List<DatesAndNumbers> testDateAndTimesArithmetics1();
   // https://youtrack.jetbrains.com/issue/IDEA-342172
    @Query("select a from DatesAndNumbers a where a.firstDate <= current time - :arg second")
    List<DatesAndNumbers> testDateAndTimesArithmetics2(int arg);

    // https://youtrack.jetbrains.com/issue/IDEA-342686/JPA-QL-support-Hibernate-by-unit-operation-on-date-and-time
    @Query("select a from DatesAndNumbers a where a.firstNum = 1+ (local date) by day")
    List<DatesAndNumbers> testDateAndTimesArithmetics3();


}
