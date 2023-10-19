/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

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

    public Bookings() {
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
    
    
}
