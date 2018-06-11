package com.magic.springboot.controller;

import com.magic.springboot.dao.MobileDao;
import com.magic.springboot.model.MobilePhone;
import com.magic.springboot.repository.MobileRepository;
import com.magic.springboot.vo.MobilePhoneVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author: Magicfeng007
 * @Description:
 * @Date: Created in 2018-06-10---下午1:31
 */
@RestController
public class MobileController {

    @Autowired
    private MobileRepository mobileRepository;

    @Autowired
    private MobileDao mobileDao;

    @RequestMapping(value = "/addMobileList",method = RequestMethod.POST)
    public MobilePhone save(MobilePhone mobilePhone){
        return mobileRepository.save(mobilePhone);
    }

    /**
     * 另外一种使用Map来实现接收参数的方式，使用时请求参数必须是如下形式：
     * 具体形式详见测试类ControllerTest中的addMobilePhoneBatch方法
     * @param mobilePhoneMap 使用自定义的类（包装了Map）来接收请求参数
     * @return
     */
    @RequestMapping(value = "/addMobilePhoneBatch",method = {RequestMethod.POST})
    public Iterable<MobilePhone> addMobilePhoneBatch(MobilePhoneVO mobilePhoneMap){
        System.out.println("enter addMobilePhoneBatch...");
        System.out.println("mobilePhone size:" + mobilePhoneMap.getMobilePhoneMap().entrySet().size());
        return mobileRepository.save(mobilePhoneMap.getMobilePhoneMap().values());
    }

    /**
     * 使用数组为参数的批量新增，由于使用了@RequestBody标注了方法参数，因此使用时必须在请求体（request body）【使用请求体进行请求时看不到，如果是使用请求参数params进行请求则可以明确看到请求参数，这样不利于数据保密性】中传入如下形式的json串：
     * [{"id":null,"brand":"BlakBarry1","model":null,"price":null,"configuration":null},{"id":null,"brand":"SUNSUM1","model":null,"price":null,"configuration":null}]
     * 注意两头必须要有方扣号
     * @param mobilePhoneList 请求时须传入json对象数组
     * @return 返回保存成功后的json串数组（springboot会自动转换）
     */
    @RequestMapping(value = "/addMobilePhoneArrayBatch",method = {RequestMethod.POST})
    public MobilePhone[] addMobilePhoneArrayBatch(@RequestBody MobilePhone[] mobilePhoneList){
        System.out.println("enter addMobilePhoneArrayBatch...");
        System.out.println("mobilePhoneList size:" + mobilePhoneList.length);
        return mobilePhoneList;
    }

    /**
     * 使用泛型List为参数的批量新增，由于使用了@RequestParam标注了方法参数，因此使用时必须传入key为mobilePhoneId的key/value对参数：
     * @param mobilePhoneIds 请求参数
     * @return 返回查询到的json串数组（springboot会自动转换）如：[{"id":1,"brand":"XIAOMI","model":"NOTE","price":1499.00,"configuration":"[cpu:4core,RAM=3G,ROM=12G]"},{"id":2,"brand":"XIAOMI","model":"8","price":2999.00,"configuration":"[cpu:4core,RAM=5G,ROM=120G]"}]
     */
    @RequestMapping(value = "/addMobilePhoneListIdBatch",method = {RequestMethod.POST})
    public Iterable<MobilePhone> addMobilePhoneListIdBatch(@RequestParam(name = "mobilePhoneId") List<Integer> mobilePhoneIds){
        System.out.println("enter addMobilePhoneListBatch...");
        System.out.println("mobilePhoneList size:" + mobilePhoneIds.size());
        return mobileRepository.findAll(mobilePhoneIds);
    }

    /**
     * 使用泛型List为参数的批量新增，由于使用了@RequestBody标注了方法参数，因此使用时必须在请求体（request body）中传入如下形式的json串：
     * [{"id":null,"brand":"BlakBarry1","model":null,"price":null,"configuration":null},{"id":null,"brand":"SUNSUM1","model":null,"price":null,"configuration":null}]
     * 注意两头必须要有方扣号
     * @param mobilePhoneList 请求时须传入json对象数组
     * @return 返回保存成功后的json串数组（springboot会自动转换）
     */
    @RequestMapping(value = "/addMobilePhoneListBatch",method = {RequestMethod.POST})
    public Iterable<MobilePhone> addMobilePhoneListBatch(@RequestBody List<MobilePhone> mobilePhoneList){
        System.out.println("enter addMobilePhoneListBatch...");
        System.out.println("mobilePhoneList size:" + mobilePhoneList.size());
        return mobileRepository.save(mobilePhoneList);
    }

    /**
     * 使用泛型Map为参数的批量新增，由于使用了@RequestBody标注了方法参数，因此使用时必须在请求体（request body）中传入如下形式的json串：
     * {"a":{"id":null,"brand":"BlakBarry1","model":null,"price":null,"configuration":null},"b":{"id":null,"brand":"SUNSUM1","model":null,"price":null,"configuration":null}}
     * 注意每个单独的json对象必须与一个唯一的key值组合成一个json对象
     * @param mobilePhoneMap 请求时须传入json对象
     * @return 返回保存成功后的json串数组（springboot会自动转换）
     */
    @RequestMapping(value = "/addMobilePhoneMapBatch",method = {RequestMethod.POST})
    public Iterable<MobilePhone> addMobilePhoneMapBatch(@RequestBody Map<String,MobilePhone> mobilePhoneMap){
        System.out.println("enter addMobilePhoneMapBatch...");
        System.out.println("mobilePhoneMap size:" + mobilePhoneMap.values().size());
        return mobileRepository.save(mobilePhoneMap.values());
    }

    @RequestMapping(value = "/queryMobile",method = RequestMethod.GET)
    public Iterable<MobilePhone> queryMobile(String brand){
        Pageable pageable = new PageRequest(1,2);
        return mobileRepository.findAll(pageable);
    }

    @RequestMapping(value = "/queryMobileByJdbcTemplate",method = RequestMethod.GET)
    public List<Map<String, Object>> queryMobileByJdbcTemplate(String brand){
        return mobileDao.queryMobile(brand);
    }



}
