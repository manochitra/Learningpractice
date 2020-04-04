package mutithreading.assignment;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;

public class ClassRoom {
    Semaphore semaphore ;
    boolean isAllStudentsSatDown =false;


    synchronized  void studentLeave(){
        System.out.println("Student trying to leave");


    }

    synchronized  void lecturerStartLecture(String lecturerName ,String classRoomName){

        System.out.println( lecturerName + " Lecture has started the lecture in the classroom " + classRoomName);
        try {
            Thread.sleep(10000);
        }catch (Exception e){

        }
        isAllStudentsSatDown=false;


    }

    synchronized  void lecturerEnter(String lecturerName,String classRoomName) throws InterruptedException{
        StringBuilder builder = new StringBuilder();
        builder.append("Lecturer").append(" ").append(lecturerName).append(" ").append("entered the classroom").append(" ").append(classRoomName);
        System.out.println(builder);
        while(!isAllStudentsSatDown) {

            wait();
        }
        lecturerStartLecture(lecturerName,classRoomName);



    }

    synchronized  void lecturerLeave() {
        System.out.println("Lecturer leaving the classroom");

    }

    synchronized  void studentEnter(String classRoomName) throws Exception{
        System.out.println("Student Entering the classroom "+ classRoomName);
        Thread.sleep(5000);
        isAllStudentsSatDown=true;
        System.out.println("Students Sat down in the classroom "+classRoomName);
        notify();


        


    }
}
