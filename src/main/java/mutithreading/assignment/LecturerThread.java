
package mutithreading.assignment;

import valueobject.Lecture;

import java.util.concurrent.Semaphore;

public class LecturerThread extends Thread {

    boolean isClassRoomAcquiredLock=false;
    String lecturerName = "";
    String  lectureClassRoomName="";
    Semaphore lectureSemaphore;
    ClassRoom lectureClassRoom;
    String previousOccupiedClassRoom=null;

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public String getLectureClassRoomName() {
        return lectureClassRoomName;
    }

    public void setLectureClassRoomName(String lectureClassRoomName) {
        this.lectureClassRoomName = lectureClassRoomName;
    }

    LecturerThread(Lecture lecturer, ClassRoom classRoom, Semaphore lectureSemaphore){
        super(lecturer.getLecturename());
        this.lectureClassRoom=classRoom;
        this.lecturerName=lecturer.getLecturename();
        this.lectureClassRoomName=lecturer.getClassRoomName();
        this.lectureSemaphore =lectureSemaphore;
        start();

    }

    public  void run () {
        StringBuilder builderforPrintingInSysout = new StringBuilder();
                try {


                    if(previousOccupiedClassRoom !=null && previousOccupiedClassRoom.equals(lectureClassRoomName)) {
                        lectureSemaphore.acquire();
                        isClassRoomAcquiredLock=true;
                        builderforPrintingInSysout.append("Lecturer").append(" ").append(lecturerName).append(" ").append("acquired the lock on classroom").append(lectureClassRoomName);
                        System.out.println(builderforPrintingInSysout);
                    }

                    lectureClassRoom.lecturerEnter(lecturerName,lectureClassRoomName);
                    previousOccupiedClassRoom=lectureClassRoomName;


                }catch (Exception e) {
                   builderforPrintingInSysout=new StringBuilder();
                    builderforPrintingInSysout.append("Lecturer").append(" ").append(lecturerName).append(" ").append("released the lock due to error ");
                    System.out.println(builderforPrintingInSysout);
                }finally {

                    if(isClassRoomAcquiredLock){
                        builderforPrintingInSysout=new StringBuilder();
                        builderforPrintingInSysout.append("Lecturer").append(" ").append(lecturerName).append(" ").append("released the lock  ");
                        System.out.println(builderforPrintingInSysout);
                        lectureSemaphore.release();
                    }

                }
            }

        }




