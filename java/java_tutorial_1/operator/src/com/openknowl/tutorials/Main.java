package com.openknowl.tutorials;

public class Main {

    public static void main(String[] args) {
        int i = 0;
        int j = 0;

        i = i++;
        j = ++j;

        System.out.println("\n단항 연산자\n");
        System.out.println("i : " + i);
        System.out.println("j : " + j);

        System.out.println("\n산술 연산자\n");
        System.out.println(10000 + 2);
        System.out.println(10000 - 2);
        System.out.println(10000 * 2);
        System.out.println(10000 / 2);
        System.out.println(10000 % 2);

        System.out.println("\n비교 연산자\n");
        System.out.println(10000 > 2);
        System.out.println(10000 < 2);
        System.out.println(10000 >= 10000);
        System.out.println(10000 <= 9999);
        System.out.println(10000 == 2);
        System.out.println(10000 != 2);

        System.out.println("\n논리 연산자\n");

        System.out.println("&&(AND)\n");
        System.out.println(true && true);
        System.out.println(true && false);
        System.out.println(false && true);
        System.out.println(false && false);

        System.out.println("\n||(OR)\n");
        System.out.println(true || true);
        System.out.println(true || false);
        System.out.println(false || true);
        System.out.println(false || false);

        System.out.println("\n");
        // 문자열끼리 결합시에도 사용
        String name = "김철수";
        String job = "개발자";
        System.out.println("안녕하세요 제 이름은 " + name + "입니다.\n" + "직업은 " + job + "입니다.");

        // 우선순위
        // 일반적으로 우리가 생각하는 우선순위와 같다.
        System.out.println(10 + 33 * 3);
        System.out.println((10 + 33) * 3);
        System.out.println(10 + 33 * 3 > 100);
        System.out.println((10 + 33 * 3) > 100);
        System.out.println(((10 + 33) * 3 > 100) && (10 + 33) * 10 > 1000);
    }
}
