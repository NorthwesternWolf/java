package com.hkp.thread;

import java.util.Random;

public class ThreadDemo implements Runnable {
    private static ThreadLocal<Student> threadStudent = new ThreadLocal<Student>() {
        @Override
        protected Student initialValue() {
            return new Student();
        }
    };

    public void run() {
        accessStudent();
    }

    public void accessStudent() {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println(currentThreadName + " is running!");
        Random random = new Random();
        int age = random.nextInt(100);
        System.out.println("thread " + currentThreadName + " set age to:" + age);

        Student student = getStudent();
        student.setAge(age);
        System.out.println("thread " + currentThreadName + " first read age is:" + student.getAge());
        try {
            Thread.sleep(500);
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        age = student.getAge();
        age += 1;
        student.setAge(age);
        System.out.println("thread " + currentThreadName + " second read age is:" + student.getAge());
    }

    protected Student getStudent() {
        Student student = (Student) threadStudent.get();
        if (student == null) {
            // the code in this condition will not be called because threadStudent override initialValue()
            String currentThreadName = Thread.currentThread().getName();
            System.out.println("thread " + currentThreadName + " get null student");
            student = new Student();
            threadStudent.set(student);
        }
        return student;
    }
}
