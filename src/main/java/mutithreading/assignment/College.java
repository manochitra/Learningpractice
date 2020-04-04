package mutithreading.assignment;

import valueobject.Lecture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;

public class College {
     List<String> classRooms = Arrays.asList("W201","W202");
     List<String> lectures =  Arrays.asList("Osam","Barry");


    public List<String> getClassRooms() {
        return classRooms;
    }

    public void setClassRooms(List<String> classRooms) {
        this.classRooms = classRooms;
    }

    public List<String> getLectures() {
        return lectures;
    }

    public void setLectures(List<String> lectures) {
        this.lectures = lectures;
    }

    public static void main (String[] args){
        ClassRoom classRoom = new ClassRoom();
        Semaphore lectureSemaphore = new Semaphore(1);

        Lecture firstLecture = new Lecture();
        firstLecture.setLecturename("Osama");
        firstLecture.setClassRoomName("W201");

        Lecture secondLecturer = new Lecture();
        secondLecturer.setLecturename("Barry");
        secondLecturer.setClassRoomName("JS101");

        List<Lecture> lecturers = Arrays.asList(firstLecture,secondLecturer);

        lecturers.stream().forEach(lecturer -> {

                LecturerThread lecturerThread = new LecturerThread(lecturer, classRoom,lectureSemaphore);
                StudentThread studentThread = new StudentThread("StudentThread",classRoom,lecturer.getClassRoomName());
            });




        //VisitorsSemaphore visitorsSemaphore = new VisitorsSemaphore();
    }


}
