package mutithreading.assignment;

public class StudentThread extends Thread{


    ClassRoom studentClassRoom;
    String classRoomName;

    StudentThread(String name,ClassRoom classRoom,String classRoomName) {
        super(name);
        this.studentClassRoom = classRoom;
        this.classRoomName=classRoomName;
        start();
    }

   public  void run() {

       try {
           studentClassRoom.studentEnter(classRoomName);
       }
       catch(Exception e) {

           }

       }
   }

