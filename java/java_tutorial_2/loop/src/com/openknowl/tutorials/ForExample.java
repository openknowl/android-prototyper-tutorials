package com.openknowl.tutorials;

public class ForExample {

    public static void main(String[] args) {
        // 무한루프 예제
        // for (; true; ) {
        //    System.out.println("무한루프");
        // }

        // 일반 루프
        // While 과 비교했을 때
        // 인덱스 값을 반복적으로 증감 시켜 계산하는 등의 행위에 유리함.
        for (int i = 0; i < 10; i++) {
            System.out.print("*");
        }
        System.out.println();

        // break
        for (int j = 0; j < 10; j++) {
            if (j > 5) {
                break;
            }
            System.out.print(j + " ");
        }
        System.out.println();

        // continue
        // While 문에서 이 구문은 끝나지 않았으나,
        // For문에서는 continue 가 되었을 때 증감 구문 부분이 동작하므로
        // 모두 반복 후 반복문이 종료된다.
        for (int k = 0; k < 10; k++) {
            if (k > 5) {
                continue;
            }
            System.out.print(k + " ");
        }
        System.out.println();
        System.out.println("끝");
    }
}
