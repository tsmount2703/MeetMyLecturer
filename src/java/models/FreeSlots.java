/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author Dell
 */
public class FreeSlots {
    private int ID;
    private String freeSlotID;
    private String subjectCode;
    private Date startTime;
    private Date endTime;
    private String password;
    private int capacity;
    private String meetLink;
    private int count;
    private String lecturerID;

    public FreeSlots() {
    }

    public FreeSlots(int ID, String freeSlotID, String subjectCode, Date startTime, Date endTime, String password, int capacity, String meetLink, int count, String lecturerID) {
        this.ID = ID;
        this.freeSlotID = freeSlotID;
        this.subjectCode = subjectCode;
        this.startTime = startTime;
        this.endTime = endTime;
        this.password = password;
        this.capacity = capacity;
        this.meetLink = meetLink;
        this.count = count;
        this.lecturerID = lecturerID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFreeSlotID() {
        return freeSlotID;
    }

    public void setFreeSlotID(String freeSlotID) {
        this.freeSlotID = freeSlotID;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getMeetLink() {
        return meetLink;
    }

    public void setMeetLink(String meetLink) {
        this.meetLink = meetLink;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getLecturerID() {
        return lecturerID;
    }

    public void setLecturerID(String lecturerID) {
        this.lecturerID = lecturerID;
    }
    
    
}
