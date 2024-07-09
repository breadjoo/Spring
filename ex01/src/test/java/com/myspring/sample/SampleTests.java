package com.myspring.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;
import sample.Restaruant;
import sample.SampleHotel;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class SampleTests {
	
	@Autowired
    private Restaruant restaruant;

    @Autowired
    private SampleHotel hotel;

    @Test
    public void testHotel() {
        log.info(hotel);
    }

    @Test
    public void test1() {
        System.out.println("test1 ..............");
        log.info("test1...............");
        log.info(restaruant);
    }
}


