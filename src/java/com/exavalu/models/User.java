package com.exavalu.models;

import com.exavalu.services.DepartmentService;
import com.exavalu.services.EmployeeService;
import com.exavalu.services.LocationService;
import com.exavalu.services.LoginService;
import com.exavalu.services.RoleService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import java.util.ArrayList;
import java.util.Map;
import org.apache.log4j.Logger;

import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author LenovoRaja
 */
public class User extends ActionSupport implements ApplicationAware, SessionAware, Serializable {

    public SessionMap<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(SessionMap<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public ApplicationMap getMap() {
        return map;
    }

    public void setMap(ApplicationMap map) {
        this.map = map;
    }

    private SessionMap<String, Object> sessionMap = (SessionMap) ActionContext.getContext().getSession();
    private ApplicationMap map = (ApplicationMap) ActionContext.getContext().getApplication();

    @Override
    public void setApplication(Map<String, Object> application) {
        map = (ApplicationMap) application;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        sessionMap = (SessionMap) session;
        sessionMap.put("Loggedin", this);
    }

    public String doLogin() throws Exception {
        String result = "FAILURE";
        boolean success = LoginService.getInstance().doLogin(this);

        if (success) {
            sessionMap.put("UpdateMsg", null);
            ArrayList empList = new ArrayList();
            empList = EmployeeService.getInstance().getAllEmployees();
            ArrayList depList = DepartmentService.getAllDepartment();
            ArrayList roleList = RoleService.getAllRole();
            sessionMap.put("DepList", depList);
            sessionMap.put("RoleList", roleList);
            sessionMap.put("EmpListHome", empList);
            sessionMap.put("Loggedin", this);

            System.out.println("returning Success from doLogin method");
            result = "SUCCESS";

        } else {
            Logger log = Logger.getLogger(LoginService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.SHORT))+"::either user id or password is incorrect");
            System.out.println("returning Failure from doLogin method");
        }

        return result;
    }

    public String doLogout() {
        String result = "SUCCESS";
        sessionMap.clear();
        return result;
    }

    public String doSignUp() {
        String result = "FAILURE";
        boolean success = LoginService.getInstance().doSignUp(this);
        if (success) {
            String createmsg = "User created !";
            sessionMap.put("Createmsg", createmsg);

            System.out.println("returning Success from doLogin method");
            result = "SUCCESS";

        } else {
            
            System.out.println("returning Failure from doLogin method");
        }
        return result;
    }

    public String doPreSignUp() {
        String result = "SUCCESS";
        ArrayList countryList = LocationService.getAllCountry();
        ArrayList stateList = null;
        ArrayList distList = null;

        System.out.println("countryList size=" + countryList.size());
        sessionMap.put("CountryList", countryList);
        sessionMap.put("Loggedin", null);

        System.out.println("countryCode=" + this.countryCode);
        if (this.countryCode != null) {
            System.out.println("countrycode::"+this.countryCode);
            stateList = LocationService.getAllState(this.countryCode);

            System.out.println("stateList size=" + stateList.size());
            sessionMap.put("StateList", stateList);
            sessionMap.put("User", this);
            result = "STATELIST";
        }
         if (this.provinceCode != null) {
            //System.out.println("countrycode::"+this.countryCode);
            distList = LocationService.getAllDistrict(this.provinceCode);

           // System.out.println("stateList size=" + stateList.size());
            sessionMap.put("DistList", distList);
            sessionMap.put("User", this);
            result = "DISTLIST";
        }
//        if (this.countryCode != null && this.provinceCode != null) {
////             stateList = LocationService.getAllState(this.countryCode);
//            distList = LocationService.getAllDistrict(this.provinceCode);
//            //System.out.println("stateList size="+stateList.size());
//            sessionMap.put("DistList", distList);
//            sessionMap.put("User", this);
//        }

        return result;
    }

    private String emailAddress;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String countryCode;
    private String provinceCode;
    private String distCode;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getDistCode() {
        return distCode;
    }

    public void setDistCode(String distCode) {
        this.distCode = distCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
