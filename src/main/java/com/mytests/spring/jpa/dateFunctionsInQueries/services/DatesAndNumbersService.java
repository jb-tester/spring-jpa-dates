package com.mytests.spring.jpa.dateFunctionsInQueries.services;

import com.mytests.spring.jpa.dateFunctionsInQueries.model.DatesAndNumbers;
import com.mytests.spring.jpa.dateFunctionsInQueries.repos.DatesNumsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * *
 * <p>Created by irina on 5/4/2022.</p>
 * <p>Project: sb3-web-freemarker</p>
 * *
 */
@Service
//@DeclareRoles({"ROLE_USER","ROLE_ADMIN"})
public class DatesAndNumbersService {


    @Autowired
    private DatesNumsRepo datesNumsRepo;

    //@RolesAllowed("ROLE_ADMIN")
    public List<DatesAndNumbers> listAll() {
        return (List<DatesAndNumbers>) datesNumsRepo.findAll();
    }

    public List<DatesAndNumbers> qwe1() {
        return datesNumsRepo.query1();
    }

    public List<DatesAndNumbers> qwe2() {
        return datesNumsRepo.query2(LocalDateTime.of(2015,
                Month.JULY, 29, 19, 30, 40));
    }

    public List<DatesAndNumbers> qwe3() {
        return datesNumsRepo.query3(new Date((2022 - 1900), Calendar.MAY, 5));
    }

    public List<DatesAndNumbers> qwe4() {
        return datesNumsRepo.query4();
    }

    public List<DatesAndNumbers> qwe5() {
        return datesNumsRepo.query5();
    }

    public List<DatesAndNumbers> qwe6() {
        return datesNumsRepo.query6();
    }

    public List<DatesAndNumbers> qwe7() {
        return datesNumsRepo.query7();
    }

    public List<DatesAndNumbers> qwe8() {
        return datesNumsRepo.query8(7);
    }

    public List<DatesAndNumbers> qwe9() {
        return datesNumsRepo.query9(25);
    }

    public List<DatesAndNumbers> qwe10() {
        return datesNumsRepo.query10();
    }

    public Integer qwe11() {
        return datesNumsRepo.query11(1000);
    }

    public List<DatesAndNumbers> qwe12() {
        return datesNumsRepo.query12(10);
    }

    public List<DatesAndNumbers> qwe13() {
        return datesNumsRepo.query13();
    }

    public List<DatesAndNumbers> qwe14() {
        return datesNumsRepo.query14();
    }

    public List<DatesAndNumbers> qwe15() {
        return datesNumsRepo.testCastingToBigInteger();
    }

    public List<DatesAndNumbers> qwe16() {
        return datesNumsRepo.testCastingToBigDecimal();
    }

    public List<DatesAndNumbers> qwe17() {
        return datesNumsRepo.testCastingToLocalDate();
    }

    public List<DatesAndNumbers> qwe18() {
        return datesNumsRepo.testCastingToLocalDateTime();
    }

    public List<DatesAndNumbers> qwe19() {
        return datesNumsRepo.logicalOperatorsExpr(5, new Date());
    }

    public List<DatesAndNumbers> qwe20() {
        return datesNumsRepo.testSpEL1(new Date((2020 - 1900), Calendar.MARCH, 21), new Date((2022 - 1900), Calendar.DECEMBER, 21));
    }

    public List<DatesAndNumbers> qwe21() {
        return datesNumsRepo.testSpEL2();
    }

    public List<DatesAndNumbers> qwe22(){
        return datesNumsRepo.useEntityFQN();
    }


}
