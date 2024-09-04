# Hostel Management System

## Overview

The Hostel Management System is a Java-based project designed to manage the allocation of students to available rooms in a hostel. It tracks students' names, branches, and the rooms they are assigned to. The system also manages the number of beds in each room and prevents over-allocation by handling errors.

## Features

- **Student Management**: Add and manage student details like name, branch, and student ID.
- **Room Management**: Add and manage rooms in the hostel, including room numbers and bed capacity.
- **Student Allotment**: Allot students to rooms while ensuring that rooms do not exceed their bed capacity.
- **Error Handling**: Prevents over-allocation of rooms and handles cases where a room does not exist.
- **Encapsulation and Inheritance**: The project is designed using object-oriented principles, including encapsulation and inheritance.

## Project Structure

- **Person.java**: Base class representing a person with attributes like `name` and `branch`.
- **Student.java**: Inherits from `Person`, representing a student with an additional attribute `studentId`.
- **Room.java**: Represents a room in the hostel, with attributes like `roomNumber`, `totalBeds`, and `occupiedBeds`. It includes methods for allotting students and displaying room details.
- **HostelManager.java**: Manages the rooms and student allotments. It includes methods for adding rooms, allotting students, and showing room details.
- **HostelManagementSystem.java**: The main class that demonstrates the functionality of the system, including creating rooms, students, and managing the allotment.

## Usage

### Step 1: Clone the Repository

```bash
git clone https://github.com/saiganesh1976/hostel-management-system.git
cd hostel-management-system
