package com.mc.cityconnection.demo.dao;

import com.mc.cityconnection.demo.entity.City;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class CityDaoInpl implements CityDao {

    @Override
    public List<City> getCityList() {
        List<City> cityList = new ArrayList<>();
        String path="city.txt";
        ClassPathResource resource = new ClassPathResource(path);
        try{
            byte[] bytes =  FileCopyUtils.copyToByteArray(resource.getInputStream());
            List<String> list = Arrays.stream(new String(bytes).split("\n"))
                    .collect(Collectors.toList());
            Set<String> citySet = new TreeSet<>();
            for(String s:list){
                s = s.trim();
                String[] str = s.split(", ");
                for(int i=0;i<str.length;i++){
                    String cityName = str[i];
                    //System.out.println(city);
                    //System.out.println(city.length());
                    citySet.add(cityName);
                }
            }

            int cityNum = 0;
            Iterator<String> it=citySet.iterator();
            while (it.hasNext()){
                String name = it.next();
                //System.out.println(name);
                City theCity = new City(name,cityNum);
                cityList.add(theCity);
                cityNum++;
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }


        return cityList;
    }


//    public static void main(String[] args) {
//        System.out.println(new CityDaoInpl().getCityList());
//    }
}
