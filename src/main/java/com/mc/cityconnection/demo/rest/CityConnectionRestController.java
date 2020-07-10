package com.mc.cityconnection.demo.rest;

import com.mc.cityconnection.demo.dao.CityDao;
import com.mc.cityconnection.demo.dao.EdgeDao;
import com.mc.cityconnection.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityConnectionRestController {
    @Autowired
    private CityService cityService;

    @Autowired
    private CityDao cityDao;

    @Autowired
    private EdgeDao edgeDao;

    @GetMapping("/connected")
    public boolean cityConnected(@RequestParam(name="origin") String origin,@RequestParam(name="destination") String destination){
        int v = edgeDao.getCityIndex(cityDao.getCityList(),origin);
        int w = edgeDao.getCityIndex(cityDao.getCityList(),destination);


        return cityService.connectCheck(v,w);
    }
}
