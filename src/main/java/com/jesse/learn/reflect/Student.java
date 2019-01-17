package com.jesse.learn.reflect;

class Student
{
    private String name;
    private Integer age;

    public Student()
    {

    }

    public Student(String name)
    {
        this.name = name;
    }

    public Student(String name, Integer age)
    {
        this.name = name;
        this.age = age;
    }

    /**
     * @return int
     */
    public Integer getAge()
    {
        return this.age;
    }

    /**
     * @param age age
     */
    public void setAge(Integer age)
    {
        this.age = age;
    }

    /**
     * @return String
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * @param name name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    public void printStudentNameAge(String name, int age)
    {
        System.out.println(name + ":" + age);
    }
}
