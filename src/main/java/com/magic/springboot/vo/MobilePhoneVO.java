package com.magic.springboot.vo;

import com.magic.springboot.model.MobilePhone;

import java.util.Map;

/**
 * @Author: Magicfeng007
 * @Description:
 * @Date: Created in 2018-06-10---下午4:23
 */
public class MobilePhoneVO {
    private Map<String,MobilePhone> mobilePhoneMap;

    public Map<String, MobilePhone> getMobilePhoneMap() {
        return mobilePhoneMap;
    }

    public void setMobilePhoneMap(Map<String, MobilePhone> mobilePhoneMap) {
        this.mobilePhoneMap = mobilePhoneMap;
    }
}
