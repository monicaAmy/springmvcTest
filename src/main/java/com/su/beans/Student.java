package com.su.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Student
{

    private String sname;
    private int age;
    private Teacher teacher;
}
