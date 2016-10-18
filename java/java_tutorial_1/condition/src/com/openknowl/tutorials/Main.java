package com.openknowl.tutorials;

public class Main {

    public static void main(String[] args) {
        // if 구문 동작 방식
        boolean isEmpty = 0 == 0;
        if (isEmpty) {
            System.out.println("if구문의 평가 결과가 true 면 실행된다.");
        }

        // 즉 ..
        if (true) {
            System.out.println("실행된다!");
        }
        if (false) {
            System.out.println("실행이 안된다!");
        }

        if (!false) {
            System.out.println("실행된다!");
        }

        // 즉 비교 연산자를 통해서 사용할 수 있다.
        int value = 0;
        if (value == 0) {
            System.out.println("value 값은 0 이다.");
        }

        value = 10;
        // if-else
        // if 거나 아니거나
        if (value == 0) {
            System.out.println("value 값은 0 이다.");
        } else {
            System.out.println("Value 값은 비어있지 않다. value 값은 " + value + " 이다.");
        }

        // 1970년부터 현재시간까지 지난 시간을
        // 현재 시간을 1000 분의 1초 단위로 가져온다.
        // 시간 값을 11로 나눈 나머지를 가져온다.
        // 즉 0~10의 값을 가져올 수 있는 일종의 랜덤함수로 사용하였다.
        value = (int) System.currentTimeMillis() % 11;
        // if-else if-else
        // if 만족하지 않으면 else if 이것도 만족하지 않으면 else 실행
        if (value == 0) {
            System.out.println("value 값은 0 이다.");
        } else if (value == 1) {
            System.out.println("value 값은 1 이다.");
        } else if (value == 2) {
            System.out.println("value 값은 2 이다.");
        } else if (value == 3) {
            System.out.println("value 값은 3 이다.");
        } else {
            System.out.println("value 값은 4와 10 사이의 " + value + " 이다.");
        }

        // 중첩 if
        if (value > 5) {
            System.out.println("value 값은 5보다 크다.");
            if (value == 6) {
                System.out.println("value 값은 6 이다.");
            } else if (value == 7) {
                System.out.println("value 값은 7 이다.");
            } else if (value == 8) {
                System.out.println("value 값은 8 이다.");
            } else if (value == 9) {
                System.out.println("value 값은 9 이다.");
            } else if (value == 10) {
                System.out.println("value 값은 10 이다.");
            }
        } else {
            System.out.println("value 값은 5보다 작다.");
            System.out.println("value 값은 " + value + " 이다.");
        }
    }
}
