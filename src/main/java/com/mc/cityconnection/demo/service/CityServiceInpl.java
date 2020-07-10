package com.mc.cityconnection.demo.service;

import com.mc.cityconnection.demo.dao.CityDao;
import com.mc.cityconnection.demo.dao.ConnectCheck;
import com.mc.cityconnection.demo.dao.EdgeDao;
import com.mc.cityconnection.demo.entity.City;
import com.mc.cityconnection.demo.entity.Edge;
import com.mc.cityconnection.demo.entity.Graph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceInpl implements CityService {
    @Autowired
    private CityDao cityDao;

    @Autowired
    private EdgeDao edgeDao;



    @Override
    public boolean connectCheck(int v, int w) {
        List<City> cityList = cityDao.getCityList();
        List<Edge> edgesList = edgeDao.getEdgeList();

        Graph cityGraph = new Graph(cityList.size());
        for(Edge e:edgesList){
            int start=e.getV();
            int end=e.getW();
            cityGraph.addEdge(start,end);
        }


        return new ConnectCheck(cityGraph).connected(v,w);
    }


}
