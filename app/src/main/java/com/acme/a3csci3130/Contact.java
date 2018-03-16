package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines how the data will be stored in the
 * Firebase databse. This is converted to a JSON format
 */

public class Contact implements Serializable
{

    public  String id;
    public  String name;
    public  String number;
    public  String business;
    public  String address;
    public  String province;


    public Contact()
    {
        // Default constructor required for calls to DataSnapshot.getValue
    }

    /**
     * @param id unique user id
     * @param name name
     * @param number business number
     * @param business business area / job type
     * @param address address
     * @param province province or territory
     */
    public Contact(String id, String name, String number, String business, String address, String province)
    {
        this.id = id;
        this.name = name;
        this.number = number;
        this.business = business;
        this.address = address;
        this.province = province;
    }

    @Exclude
    public Map<String, Object> toMap()
    {
        HashMap<String, Object> result = new HashMap<>();
        result.put("id", id);
        result.put("name", name);
        result.put("number", number);
        result.put("business", business);
        result.put("address", address);
        result.put("province", province);
        return result;
    }
}
