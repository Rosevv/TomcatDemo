package com.rose.mapper;

import com.rose.joke.Brand;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandMapper {

    @Select("select * from brand;") @ResultMap("brandResult")
    List<Brand> selectAll();
}
