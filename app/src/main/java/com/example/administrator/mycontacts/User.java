package com.example.administrator.mycontacts;

/**
 * Created by Administrator on 2015/10/29.
 */
public class User {

   public final static String NAME = "name";
    public final static String MOBILE = "moblie";
    public final static String DANWEI = "danwei";
    public  final static String QQ = "qq";
    public final static String ADDRESS = "address";


    private static String name;
    private static String moblie;
    private static String danwei;
    private static String qq;
    private static String address;
    private static int id_DB = -1;


    public static String getADDRESS() {
        return ADDRESS;
    }

    public static int getId_DB() {
        return id_DB;
    }

    public static String getNAME() {
        return NAME;

    }

    public static String getMOBILE() {
        return MOBILE;
    }

    public static String getDANWEI() {
        return DANWEI;
    }

    public static String getQQ() {
        return QQ;
    }

    public static void setName(String name) {
        User.name = name;
    }

    public static void setMoblie(String moblie) {
        User.moblie = moblie;
    }

    public static void setDanwei(String danwei) {
        User.danwei = danwei;
    }

    public static void setQq(String qq) {
        User.qq = qq;
    }

    public static void setAddress(String address) {
        User.address = address;
    }

    public static void setId_DB(int id_DB) {
        User.id_DB = id_DB;
    }


}
