package com.openknowl.tutorials;

import java.util.Scanner;

public class Subject {
    /*
     * 로그인 시나리오.
     *
     * 관리자 시스템에서
     * id 와 password 를 입력받아서 관리자인지 확인하고
     * 아이디와 패스워드가 일치하지 않으면 일치하지 않습니다.
     * 라는 메세지와 함께 프로그램을 종료시킬 것
     *
     * return; 구문을 통해 프로그램을 종료할 수 있다.
     * 종료하기전 scanner.close()을 꼭 호출할 것
     *
     * 아이디와 패스워드가 일치하면
     * 현재 직원들의 정보를 출력할 것
     *
     * 관리자 아이디는 admin
     * 관리자 패스워드는 1234 으로 작성할 것
     *
     * 문자열 비교는 "문자열".equals(String 변수) 로 해야한다.
     * 검색도 공부다. 인터넷 검색을 통해서 사용법을 익혀볼 것.
     */
    public static void main(String[] args) {
        // 직원 데이터
        // 직원 1
        String employee1Name = "홍길동";
        int employee1Age = 25;
        String employee1Position = "개발팀";

        // 직원 2
        String employee2Name = "임꺽정";
        int employee2Age = 24;
        String employee2Position = "개발팀 팀장";

        // 직원 3
        String employee3Name = "전우치";
        int employee3Age = 20;
        String employee3Position = "개발팀";

        // 콘솔을 통해 입력받을 수 있음.
        Scanner scanner = new Scanner(System.in);
        System.out.print("아이디를 입력하세요 : ");
        String id = scanner.nextLine();
        System.out.print("패스워드를 입력하세요 : ");
        String password = scanner.nextLine();

        System.out.println("id = " + id + " / " + "password = " + password +
                "\n입력하신 정보로 로그인 시도합니다.");

        // TODO 로그인 성공여부 판단 소스코드 작성
        // 로그인에 실패했을시 밑의 소스코드가 실행되지 않도록 return 문을 통해서
        // 처리할 것

        /*
         * TODO 아래의 양식에 맞도록 직원 정보 출력 소스코드를 작성할 것
         * Console 출력 양식
         * `이름 : 홍길동 / 나이 : 25 / 업무 : 개발팀` 과 일치하도록 작성
         */

        // 지우지 말 것 !
        scanner.close();
    }
}
