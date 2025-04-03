package com.dlnu.byname;

import com.dlnu.byname.domain.entity.RoleDO;
import com.dlnu.byname.domain.entity.UserRoleDO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class UtilsTest {

    public static void main(String[] args) {
//        String json = "[{\"tip\": \"放空费\", \"amount\": 30},{\"tip\": \"等待费\", \"amount\": 10}]";
//        Gson gson = new Gson();
//        Type listType = new TypeToken<List<Map<String, Object>>>() {}.getType();
//        List<Map<String, Object>> array = gson.fromJson(json, listType);
//        for (Map<String, Object> stringObjectMap : array) {
//            System.out.println(stringObjectMap.get("amount"));
//        }
        UserRoleDO roleDO = new UserRoleDO();

        System.out.println(ObjectUtils.isEmpty(roleDO.getRoleId()));
        System.out.println(new Date());

    }
}
