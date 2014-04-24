package com.xplusz.mercury.services;

import java.sql.*;
public class DButil {

    /**
     * @param args
     */
    public static String username = "allenli";
    public static String password = "shine";
    public static String url = "jdbc:postgresql://localhost:5432/allenli";


    public static Connection getcon() {
        Connection con = null;
        try {

            Class.forName("org.postgresql.Driver").newInstance();

            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;

    }

    public static boolean addstudent(String name) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        boolean result = false;
        Connection con = getcon();
        try {
            String stusql = "insert into testtable (name) values(?)";
            PreparedStatement stmt = null;
            stmt = getcon().prepareStatement(stusql);
            //stmt.setInt(1, id);
            stmt.setString(1,name);
            int count = stmt.executeUpdate();
            if (count == 1) {
                result = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static boolean deletestudent(int id) {

        boolean result = false;
        Connection con = getcon();
        try {
            String stusql = "delete  from testtable where id=?";
            PreparedStatement stmt = null;
            stmt = getcon().prepareStatement(stusql);
            stmt.setInt(1, id);
           int count=stmt.executeUpdate();
            if (count==1) {
                result = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;


    }

    public static int getid() {

        boolean result = false;
        Connection con = getcon();
        int id = -10;
        try {
            String stusql = "select max(id) as bid from testtable ";
            PreparedStatement stmt = null;
            stmt = con.prepareStatement(stusql);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt("bid");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return id;


    }

    public static String  search(int id) {

        boolean result = false;
        Connection con = getcon();
        boolean a=false;
        ResultSet rs = null;
        String name="";
        try {
            String stusql = "select name from testtable where id=? ";
            PreparedStatement stmt = null;
            stmt = con.prepareStatement(stusql);
            stmt.setInt(1,id);


            rs=stmt.executeQuery();
            if (rs.next()) {
                a=true;
                System.out.println("a+result"+a);
                name=rs.getString(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return name;
}
    public boolean testname(String name)
    {
        Connection con=getcon();
        ResultSet rs=null;
        boolean bs=false;
        try{
            String sql="select * from testtable where name=?";
            PreparedStatement stmt=null;
            stmt=con.prepareStatement(sql);
            stmt.setString(1,name);
            rs=stmt.executeQuery();
            if(rs.next())
            {
            bs=true;
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }

        return bs;
    }

    public boolean update(int id,String name)
    {
        Connection con=getcon();

        boolean bs=false;
        try{
            String sql="update testtable set name=? where id=?";
            PreparedStatement stmt=null;
            stmt=con.prepareStatement(sql);
            stmt.setInt(2,id);
            stmt.setString(1,name);
            int a=stmt.executeUpdate();
            if(a==1)
            {
                bs=true;
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }

        return bs;
    }
}








