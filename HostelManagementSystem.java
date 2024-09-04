// BaseClass Person
class Person {
    private String name;
    private String branch;

    public Person(String name, String branch) {
        this.name = name;
        this.branch = branch;
    }

    public String getName() {
        return name;
    }

    public String getBranch() {
        return branch;
    }
}

// Student class inheriting from Person
class Student extends Person {
    private String studentId;

    public Student(String name, String branch, String studentId) {
        super(name, branch);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }
}

// Room class to represent a room in the hostel
class Room {
    private String roomNumber;
    private int totalBeds;
    private int occupiedBeds;
    private Student[] students;

    public Room(String roomNumber, int totalBeds) {
        this.roomNumber = roomNumber;
        this.totalBeds = totalBeds;
        this.students = new Student[totalBeds];
        this.occupiedBeds = 0;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public int getTotalBeds() {
        return totalBeds;
    }

    public int getAvailableBeds() {
        return totalBeds - occupiedBeds;
    }

    public void allotStudent(Student student) throws Exception {
        if (occupiedBeds < totalBeds) {
            students[occupiedBeds] = student;
            occupiedBeds++;
        } else {
            throw new Exception("Room is full. No available beds.");
        }
    }

    public void showStudents() {
        System.out.println("Room " + roomNumber + " has the following students:");
        for (int i = 0; i < occupiedBeds; i++) {
            System.out.println("Student ID: " + students[i].getStudentId() + ", Name: " + students[i].getName() + ", Branch: " + students[i].getBranch());
        }
    }
}

// HostelManager class to manage rooms and student allotments
class HostelManager {
    private Room[] rooms;
    private int roomCount;

    public HostelManager(int maxRooms) {
        rooms = new Room[maxRooms];
        roomCount = 0;
    }

    public void addRoom(Room room) {
        if (roomCount < rooms.length) {
            rooms[roomCount] = room;
            roomCount++;
        } else {
            System.out.println("No more rooms can be added.");
        }
    }

    public void allotRoom(String roomNumber, Student student) {
        for (int i = 0; i < roomCount; i++) {
            if (rooms[i].getRoomNumber().equals(roomNumber)) {
                try {
                    rooms[i].allotStudent(student);
                    System.out.println("Student " + student.getName() + " allotted to room " + roomNumber);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
        System.out.println("Room " + roomNumber + " not found.");
    }

    public void showRoomDetails(String roomNumber) {
        for (int i = 0; i < roomCount; i++) {
            if (rooms[i].getRoomNumber().equals(roomNumber)) {
                System.out.println("Room Number: " + roomNumber + ", Total Beds: " + rooms[i].getTotalBeds() + ", Available Beds: " + rooms[i].getAvailableBeds());
                rooms[i].showStudents();
                return;
            }
        }
        System.out.println("Room " + roomNumber + " not found.");
    }
}

// Main class
public class HostelManagementSystem {
    public static void main(String[] args) {
        // Create the HostelManager object
        HostelManager manager = new HostelManager(10); // MAX 10 rooms

        // Create and add rooms
        Room room101 = new Room("101", 2);
        Room room102 = new Room("102", 3);
        Room room103 = new Room("103", 3);
        manager.addRoom(room101);
        manager.addRoom(room102);
        manager.addRoom(room103);

        // Create students
        Student student1 = new Student("Sai Ganesh", "ECM", "S01");
        Student student2 = new Student("Vikas", "CSE", "S02");
        Student student3 = new Student("Yashwanth", "IT", "S03");
        Student student4 = new Student("Manikanth", "ECE", "S04");
        Student student5 = new Student("Anudeep", "AIML", "S05");
        Student student6 = new Student("Bhanu Prakash", "AIML", "S06");
        Student student7 = new Student("Mahesh", "EEE", "S07");
        // Allot rooms to students
        manager.allotRoom("101", student1);
        manager.allotRoom("101", student2);
        manager.allotRoom("101", student3); // This should trigger an exception as room 101 has only 2 beds
        System.out.println("---------------------------------------------------");
        manager.allotRoom("102", student3);
        manager.allotRoom("102", student4);
        System.out.println("---------------------------------------------------");
        manager.allotRoom("103", student5);
        manager.allotRoom("103", student6);
        System.out.println("---------------------------------------------------");
        manager.allotRoom("104", student7);
        // Show room details
        System.out.println("----------------- Rooms details -------------------");
        manager.showRoomDetails("101");
        System.out.println(" ");
        manager.showRoomDetails("102");
        System.out.println(" ");
        manager.showRoomDetails("103");
        System.out.println(" ");
        manager.showRoomDetails("104");
    }
}
