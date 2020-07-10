package com.mc.cityconnection.demo.dao;

import com.mc.cityconnection.demo.entity.City;
import com.mc.cityconnection.demo.entity.Edge;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EdgeDaoInpl implements EdgeDao{
    @Override
    public List<Edge> getEdgeList() {
        List<City> cityList = new CityDaoInpl().getCityList();
        List<Edge> edgeList = new ArrayList<>();
        String path="city.txt";
        ClassPathResource resource = new ClassPathResource(path);
        try{
            byte[] bytes =  FileCopyUtils.copyToByteArray(resource.getInputStream());
            List<String> list = Arrays.stream(new String(bytes).split("\n"))
                    .collect(Collectors.toList());

            for(String s:list){
                s = s.trim();
                int[] edge =new int[2];
                String[] str = s.split(", ");
                int v =getCityIndex(cityList,str[0]);
                int w =getCityIndex(cityList,str[1]);
                Edge theEdge = new Edge(v,w);
                edgeList.add(theEdge);
//                edge[0]=listOfCity.get(str[0]);
//                edge[1]=listOfCity.get(str[1]);
//                edgeList.add(edge);
            }

                return edgeList;
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public int getCityIndex(List<City> cityList,String cityName){
        for(City c :cityList){
            if(cityName.equals(c.getName())){
                return c.getIndex();
            }
        }
        return -1;
    }

//    public static void main(String[] args) {
//        System.out.println(new EdgeDaoInpl().getEdgeList());
//    }
}
