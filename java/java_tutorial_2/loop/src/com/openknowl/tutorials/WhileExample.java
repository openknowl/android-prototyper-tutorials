package com.openknowl.tutorials;

public class WhileExample {

    public static void main(String[] args) {
        // 무한루프 예제
        // while(true) {
        //     System.out.println("무한루프");
        // }

        // 일반 루프
        int i = 0;
        while (i < 10) {
            System.out.print("*");
            i++;
        }
        System.out.println();

        // break
        int j = 0;
        while (j < 10) {
            if (j > 5) {
                break;
            }
            System.out.print(j + " ");
            j++;
        }
        System.out.println();

        // continue
        // 이 구문은 끝나지 않음 ..
        // continue 때문에 k++가 실행이 계속 안되기 때문.
        int k = 0;
        while (k < 10) {
            if (k > 5) {
                continue;
            }
            System.out.print(k + " ");
            k++;
        }
        System.out.println();
        System.out.println("끝");
    }
}
