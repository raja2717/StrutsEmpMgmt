
package com.exavalu.services;


import com.exavalu.models.Country;
import com.exavalu.models.District;
import com.exavalu.models.Province;

import com.exavalu.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author LenovoRaja
 */
public class LocationService {
    public static ArrayList getAllCountry()
    {
        ArrayList countryList = new ArrayList();
        String sql = "SELECT * FROM countries";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                Country country = new Country();
                country.setCountryCode(rs.getString("countryCode"));
                country.setCountryName(rs.getString("countryName"));
                
                countryList.add(country);
            }
            
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.err.println("Total rows:"+countryList.size());
        return countryList;
    }
    public static ArrayList getAllState(String countryCode)
    {
        ArrayList stateList = new ArrayList();
        String sql = "SELECT * FROM countries c, states s where c.countryCode = s.countryCode AND s.countryCode=?";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, countryCode);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                Province province = new Province();
                province.setCountryCode(rs.getString("countryCode"));
                province.setProvinceName(rs.getString("stateName"));
                province.setProvinceCode(rs.getString("stateCode"));
                stateList.add(province);
            }
            
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.err.println("Total rows:"+stateList.size());
        return stateList;
    }
    public static ArrayList getAllDistrict(String provinceCode)
    {
        ArrayList districtList = new ArrayList();
        String sql = "SELECT * FROM states s,districts d where s.stateCode=d.stateCode AND s.stateCode=?";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, provinceCode);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                District district = new District();
                district.setProvinceCode(rs.getString("stateCode"));
                district.setDistName(rs.getString("districtName"));
                district.setDistCode(rs.getString("districtCode"));
               
                districtList.add(district);
            }
            
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.err.println("Total rows:"+districtList.size());
        return districtList;
    }
}
