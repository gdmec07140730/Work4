package com.example.administrator.mycontacts;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.Vector;

public class ContactsTable {
    private final static String TABLENAME="contactsTable";
    private MyDB db;
    public ContactsTable(Context context){
        db=new MyDB(context);
        if (!db.isTableExits(TABLENAME)) {
            String createTableSql="CREATE TABLE IF NOT EXISTS " +
                    TABLENAME +" (id_DB integer primary key AUTOINCREMENT, " +
                    User.getNAME() + " VARCHAR," +
                    User.getMOBILE() + " VARCHAR," +
                    User.getQQ() + " VARCHAR," +
                    User.getDANWEI() + " VARCHAR," +
                    User.getADDRESS() + " VARCHAR)";
            db.creatTable(createTableSql);
        }
    }
    //添加数据到成绩表
    public boolean addDate(User user){
        ContentValues values=new ContentValues();
        values.put(User.NAME,user.getNAME());
        values.put(User.MOBILE,user.getMOBILE());
        values.put(User.DANWEI,user.getDANWEI());
        values.put(User.QQ,user.getQQ());
        values.put(User.ADDRESS,user.getADDRESS());
        return db.save(TABLENAME,values);
    }
    //获取联系人表的所有记录
    public User[] getAllUser(){
        Vector<User> v = new Vector<User>();
        Cursor cursor = null;
        try{
            cursor = db.find("select * from "+TABLENAME,null);
            while (cursor.moveToNext()){
                User temp = new User();
                temp.setId_DB(cursor.getInt(cursor.getColumnIndex("id_DB")));
                temp.setAddress(cursor.getString(cursor.getColumnIndex(User.NAME)));
                temp.setQq(cursor.getString(cursor.getColumnIndex(User.QQ)));
                temp.setDanwei(cursor.getString(cursor.getColumnIndex(User.DANWEI)));
                temp.setName(cursor.getString(cursor.getColumnIndex(User.NAME)));
                temp.setMoblie(cursor.getString(cursor.getColumnIndex(User.MOBILE)));
                v.add(temp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(cursor != null){
                cursor.close();
            }
            db.closeConnection();
        }
        if (v.size()>0){
            return v.toArray(new User[]{});
        }else {
            User[] users = new User[1];
            User user = new User();
            user.setName("无结果");
            users[0]=user;
            return users;
        }
    }
    //根据联系人的ID来获取联系人
    public User getUserByID(int id){
        Cursor cursor=null;
        try{
            cursor = db.find("select * from "+ TABLENAME+" where id_DB=?",new String[]{id+""});
                User temp = new User();
                cursor.moveToNext();
                temp.setId_DB(cursor.getInt(cursor.getColumnIndex("id_DB")));
                temp.setAddress(cursor.getString(cursor.getColumnIndex(User.NAME)));
                temp.setQq(cursor.getString(cursor.getColumnIndex(User.QQ)));
                temp.setDanwei(cursor.getString(cursor.getColumnIndex(User.DANWEI)));
                temp.setName(cursor.getString(cursor.getColumnIndex(User.NAME)));
                temp.setMoblie(cursor.getString(cursor.getColumnIndex(User.MOBILE)));
                return temp;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(cursor != null){
                cursor.close();
            }
            db.closeConnection();
        }
        return null;
    }
    //更新联系人信息
    public boolean updateUser(User user){
        ContentValues values=new ContentValues();
        values.put(User.NAME,user.getNAME());
        values.put(User.MOBILE,user.getMOBILE());
        values.put(User.DANWEI,user.getDANWEI());
        values.put(User.QQ,user.getQQ());
        values.put(User.ADDRESS,user.getADDRESS());
        return db.update(TABLENAME,values," id_db=?",new String[]{user.getId_DB()+""});
    }
    //根据特定条件查询联系人信息
    public User[] findUserByKey(String key){
        Vector<User> v = new Vector<>();
        Cursor cursor = null;
        try{
            cursor = db.find("select * from " + TABLENAME + " where " + User.NAME + " like '%"+key+"%'" + " or " + User.MOBILE + " like '%"+key+"%'" + " or " + User.QQ + " like '%"+key+"%'",null);
            while (cursor.moveToNext()) {
                User temp = new User();
                temp.setId_DB(cursor.getInt(cursor.getColumnIndex("id_DB")));
                temp.setAddress(cursor.getString(cursor.getColumnIndex(User.NAME)));
                temp.setQq(cursor.getString(cursor.getColumnIndex(User.QQ)));
                temp.setDanwei(cursor.getString(cursor.getColumnIndex(User.DANWEI)));
                temp.setName(cursor.getString(cursor.getColumnIndex(User.NAME)));
                temp.setMoblie(cursor.getString(cursor.getColumnIndex(User.MOBILE)));
                v.add(temp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(cursor != null){
                cursor.close();
            }
            db.closeConnection();
        }
        if (v.size()>0){
            return v.toArray(new User[]{});
        }else {
            User[] users = new User[1];
            User user = new User();
            user.setName("无结果");
            users[0]=user;
            return users;
        }
    }
    //删除联系人
    public boolean deleteByUser(User user){
        return db.delete(TABLENAME," id_DB=?",new String[]{user.getId_DB()+""});
    }
}
