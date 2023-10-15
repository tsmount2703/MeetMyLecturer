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
public class Timetables {
    private String subjectCode;
    private String slotID;
    private String lecturerID;
    private String semesterID;

    public Timetables() {
    }

    public Timetables(String subjectCode, String slotID, String lecturerID, String semesterID) {
        this.subjectCode = subjectCode;
        this.slotID = slotID;
        this.lecturerID = lecturerID;
        this.semesterID = semesterID;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSlotID() {
        return slotID;
    }

    public void setSlotID(String slotID) {
        this.slotID = slotID;
    }

    public String getLecturerID() {
        return lecturerID;
    }

    public void setLecturerID(String lecturerID) {
        this.lecturerID = lecturerID;
    }

    public String getSemesterID() {
        return semesterID;
    }

    public void setSemesterID(String semesterID) {
        this.semesterID = semesterID;
    }
    
    
}
