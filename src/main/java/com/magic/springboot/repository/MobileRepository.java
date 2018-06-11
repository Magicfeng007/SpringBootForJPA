package com.magic.springboot.repository;

import com.magic.springboot.model.MobilePhone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: Magicfeng007
 * @Description:
 * @Date: Created in 2018-06-10---下午1:16
 */
@Repository
public interface MobileRepository extends PagingAndSortingRepository<MobilePhone,Integer> {


}
