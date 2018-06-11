package com.magic.springboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author: Magicfeng007
 * @Description:
 * @Date: Created in 2018-06-11---下午8:27
 */
@Repository
public class MobileDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> queryMobile(String brand){
        String sql = "select * from mobile_phone where brand=?";
        return jdbcTemplate.queryForList(sql,new Object[]{brand});
    }
}
