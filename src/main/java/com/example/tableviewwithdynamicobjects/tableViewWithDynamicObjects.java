package com.example.tableviewwithdynamicobjects;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class tableViewWithDynamicObjects extends Application {
    @Override
    public void start(Stage stage) {
        TableView<RowData> tableView = new TableView<>();

        TableColumn<RowData, String> studentNameColumn = new TableColumn<>("Student Name");
        studentNameColumn.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getStudent().getName()));
        tableView.getColumns().add(studentNameColumn);

        TableColumn<RowData, String> teacherClassColumn = new TableColumn<>("Teacher's Class");
        teacherClassColumn.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getTeacher().getClassTaught()));
        tableView.getColumns().add(teacherClassColumn);

        RowData rowData = new RowData(new Student("John", 33), new Teacher("Computer Science", 1));
        tableView.getItems().add(rowData);

        Scene scene = new Scene(tableView, 800, 800);
        stage.setScene(scene);
        stage.show();
    }

    public class RowData {
        private Student student;
        private Teacher teacher;

        public RowData(Student student) {
            this.student = student;
        }

        public RowData(Teacher teacher) {
            this.teacher = teacher;
        }

        public RowData(Student student, Teacher teacher) {
            this.student = student;
            this.teacher = teacher;
        }

        public Student getStudent() {
            return student;
        }

        public Teacher getTeacher() {
            return teacher;
        }
    }

    public class Student {
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    public class Teacher {
        private String classTaught;
        private int yearsTaught;

        public Teacher(String classTaught, int yearsTaught) {
            this.classTaught = classTaught;
            this.yearsTaught = yearsTaught;
        }

        public String getClassTaught() {
            return classTaught;
        }

        public void setClassTaught(String classTaught) {
            this.classTaught = classTaught;
        }

        public int getYearsTaught() {
            return yearsTaught;
        }

        public void setYearsTaught(int yearsTaught) {
            this.yearsTaught = yearsTaught;
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
