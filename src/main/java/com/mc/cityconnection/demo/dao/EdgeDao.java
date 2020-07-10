package com.mc.cityconnection.demo.dao;

import com.mc.cityconnection.demo.entity.City;
import com.mc.cityconnection.demo.entity.Edge;

import java.util.List;

public interface EdgeDao {
    public List<Edge> getEdgeList();
    public int getCityIndex(List<City> cityList, String cityName);
}
