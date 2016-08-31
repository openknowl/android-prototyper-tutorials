package com.openknowl.tutorials;

public class Main {

    public static void main(String[] args) {
        // 변수를 선언만 함
        String phoneNumber;
        double height;

        // 변수의 초기화를 함
        phoneNumber = "010-1234-5678";
        height = 187.9;

        // 변수의 선언과 초기화를 같이 함
        int age = 25;
        String name = "김철수";
        char grade = 'A';
        double weight = 61.2;

        // 변수는 선언과 초기화를 동시에 할 수 있다.
        String profile = "안녕하세요 김철수 입니다.", job = "rapper";
        boolean isTrue = false;

        // System.out.println(); 콘솔 출력을 할 수 있는 자바 내장 함수
        System.out.println("age : " + age);
        System.out.println("name : " + name);
        System.out.println("height : " + height);
        System.out.println("phoneNumber : " + phoneNumber);
        System.out.println("grade : " + grade);
        System.out.println("weight : " + weight);
        System.out.println("job : " + job);
        System.out.println("profile :" + profile);
        System.out.println("isTrue : " + isTrue);

        // 변수의 필요성 - https://opentutorials.org/module/516/5293
        System.out.println(100 + 10);
        System.out.println((100 + 10) / 10);
        System.out.println(((100 + 10) / 10) - 10);
        System.out.println((((100 + 10) / 10) - 10) * 10);

        int a = 100;
        System.out.println(a + 10);
        System.out.println((a+ 10) / 10);
        System.out.println(((a + 10) / 10) - 10);
        System.out.println((((a + 10) / 10) - 10) * 10);
    }
}
