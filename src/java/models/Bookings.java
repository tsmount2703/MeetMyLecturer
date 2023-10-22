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
public class Bookings {
    private int ID;
    private String bookingID;
    private String studentID;
    private String freeSlotID;
    private boolean status;
    private String subjectCode;
    private String lecturerID;
    private Date startTime;
    private Date endTime;

    public Bookings() {
    }

    public Bookings(String studentID, String freeSlotID, boolean status) {
        this.studentID = studentID;
        this.freeSlotID = freeSlotID;
        this.status = status;
    }

    public Bookings(int ID, String studentID, String freeSlotID, boolean status) {
        this.ID = ID;
        this.studentID = studentID;
        this.freeSlotID = freeSlotID;
        this.status = status;
    }
    
    

    public Bookings(int ID, String bookingID, String studentID, String freeSlotID, boolean status, String subjectCode, String lecturerID, Date startTime, Date endTime) {
        this.ID = ID;
        this.bookingID = bookingID;
        this.studentID = studentID;
        this.freeSlotID = freeSlotID;
        this.status = status;
        this.subjectCode = subjectCode;
        this.lecturerID = lecturerID;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
    

    public Bookings(int ID, String bookingID, String studentID, String freeSlotID, boolean status, String subjectCode, String lecturerID) {
        this.ID = ID;
        this.bookingID = bookingID;
        this.studentID = studentID;
        this.freeSlotID = freeSlotID;
        this.status = status;
        this.subjectCode = subjectCode;
        this.lecturerID = lecturerID;
    }
    
    

    public Bookings(int ID, String bookingID, String studentID, String freeSlotID, boolean status) {
        this.ID = ID;
        this.bookingID = bookingID;
        this.studentID = studentID;
        this.freeSlotID = freeSlotID;
        this.status = status;
    }

    public Bookings(String bookingID, String studentID, String freeSlotID, boolean status) {
        this.bookingID = bookingID;
        this.studentID = studentID;
        this.freeSlotID = freeSlotID;
        this.status = status;
    }
    
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getFreeSlotID() {
        return freeSlotID;
    }

    public void setFreeSlotID(String freeSlotID) {
        this.freeSlotID = freeSlotID;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getLecturerID() {
        return lecturerID;
    }

    public void setLecturerID(String lecturerID) {
        this.lecturerID = lecturerID;
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
    
    
    
    
    
}
