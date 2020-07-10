package com.mc.cityconnection.demo.service;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityServiceInplTest {

    @Autowired
    private CityService cityService;

    @org.junit.Test
    public void connectCheck() {
        Assert.assertTrue(cityService.connectCheck(2,1));
        Assert.assertTrue(cityService.connectCheck(2,3));
        Assert.assertTrue(cityService.connectCheck(2,4));
        Assert.assertTrue(cityService.connectCheck(1,3));
        Assert.assertTrue(cityService.connectCheck(1,4));
        Assert.assertTrue(cityService.connectCheck(5,0));
        Assert.assertFalse(cityService.connectCheck(2,0));
    }
}