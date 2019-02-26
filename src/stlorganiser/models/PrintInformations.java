/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stlorganiser.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Model entity for 3D prints informations
 * @author Jean-Christophe Chatelain
 */
public class PrintInformations implements Comparable<PrintInformations> {
    private Long checksum;
    private String name;
    private String path;
    private int size;
    private int grade;
    private String description;
    private String printTime;
    private boolean needSupport;
    
    
    /**
     *
     */
    public PrintInformations() {
    }

    public PrintInformations(Long checksum, String name, String path, int size, int grade, String description, String printTime, boolean needSupport) {
        this.checksum = checksum;
        this.name = name;
        this.path = path;
        this.size = size;
        this.grade = grade;
        this.description = description;
        this.printTime = printTime;
        this.needSupport = needSupport;
    }
    
    
    public PrintInformations(ResultSet resultSet) throws SQLException {
        loadFromSQL(resultSet);
    }

    /**
     *
     * @return
     */
    public long getChecksum() {
        return checksum;
    }

    /**
     *
     * @param checksum
     */
    public void setChecksum(Long checksum) {
        this.checksum = checksum;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getPath() {
        return path;
    }

    /**
     *
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     *
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }
    /**
     *
     * @return
     */
    public int getGrade() {
        return grade;
    }

    /**
     *
     * @param grade
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    public String getPrintTime() {
        return printTime;
    }

    /**
     *
     * @param printTime
     */
    public void setPrintTime(String printTime) {
        this.printTime = printTime;
    }

    /**
     *
     * @return
     */
    public boolean isNeedSupport() {
        return needSupport;
    }

    /**
     *
     * @param needSupport
     */
    public void setNeedSupport(boolean needSupport) {
        this.needSupport = needSupport;
    }


    @Override
    public int compareTo(PrintInformations o) {
         return this.checksum.compareTo(o.getChecksum());
    }

    public String getSQLInsert() {
        return "INSERT INTO PrintInformations (checksum, name, grade, size, path, description, support, printTime)"
                + "VALUES ('" + checksum + "', '" + name + "', " + grade + " ,'" 
                + size + "', '"+path+"', '"
                + description + "', " + needSupport + ", '"+printTime+
                "');";
    }

    public String getSQLUpdate() {
        return "UPDATE PrintInformations "
            + "SET checksum = '" + checksum + "',name ='"+name
            + "' , grade = "+grade+" ,size = "+size+" ,path='"+path+"',description = '" + description
            + "', support = " + needSupport + ", printTime = '" + printTime
            + "' WHERE checksum ='" + checksum + "';";
    }

    private void loadFromSQL(ResultSet rs) throws SQLException
    {
        this.checksum = rs.getLong("checksum");
        this.name = rs.getString("name");
        this.path = rs.getString("path");
        this.size = rs.getInt("size");
        this.grade = rs.getInt("grade");
        this.description = rs.getString("description");
        this.printTime = rs.getString("printTime");
        this.needSupport = rs.getBoolean("support");
    }
    
    public Object[] getTableObject(){
        return new Object[]{checksum,name, path, size, grade, description, printTime, needSupport};
    }
}
