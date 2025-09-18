package com.company.java008_ex;

import java.util.Scanner;

public class MethodEx006 {
    public static void main(String[] args) {
        // (1) 변수 선언
        Scanner scanner = new Scanner(System.in);
        String name = "";
        int attack, defense, speed, total;
        float avg = 0.0f;
        String grade = "";
        String star = "";
        String quest = "";
        String type = "";

        // (2) 입력
        System.out.print("캐릭터 이름을 입력하세요: ");
        name = scanner.nextLine();
        System.out.print("공격력(0~100): ");
        attack = scanner.nextInt();
        System.out.print("방어력(0~100): ");
        defense = scanner.nextInt();
        System.out.print("민첩성(0~100): ");
        speed = scanner.nextInt();

        // (3) 처리
        total = process_total(attack, defense, speed);
        avg = process_avg(total);
        grade = process_grade(avg);
        star = process_star(avg);
        quest = process_quest(avg);         // ⭐ 퀘스트 추천
        type = process_type(attack, defense, speed); // ⭐ 캐릭터 타입

        // (4) 출력
        process_show(name, attack, defense, speed, total, avg, grade, star, quest, type);

        scanner.close();
    }

    public static int process_total(int a, int d, int s) {
        return a + d + s;
    }

    public static float process_avg(int total) {
        return total / 3.0f;
    }

    public static String process_grade(float avg) {
        if (avg >= 90) return "S등급";
        else if (avg >= 80) return "A등급";
        else if (avg >= 70) return "B등급";
        else if (avg >= 60) return "C등급";
        else return "D등급";
    }

    public static String process_star(float avg) {
        int stars = (int) avg / 10;
        return "*".repeat(stars);
    }

    // ⭐ 퀘스트 추천
    public static String process_quest(float avg) {
        if (avg >= 90) return "전설의 용 퇴치";
        else if (avg >= 80) return "왕국 수호 임무";
        else if (avg >= 70) return "숲 속 보물 탐험";
        else if (avg >= 60) return "마을 경비 훈련";
        else return "초보자 연습 퀘스트";
    }

    // ⭐ 캐릭터 타입 부여
    public static String process_type(int a, int d, int s) {
        if (a >= d && a >= s) return "전사형";
        else if (d >= a && d >= s) return "탱커형";
        else return "도적형";
    }

    // 출력 메서드
    public static void process_show(String name, int a, int d, int s, int total, float avg,
                                    String grade, String star, String quest, String type) {
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("캐릭터\t공격력\t방어력\t민첩성\t총합\t평균\t등급\t랭킹\t추천퀘스트\t캐릭터타입");
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.printf("%s\t%d\t%d\t%d\t%d\t%.1f\t%s\t%s\t%s\t%s\n",
                name, a, d, s, total, avg, grade, star, quest, type);
        System.out.println("-------------------------------------------------------------------------------------------------");
    }
}


/*
 

## 연습문제 6)   금일 오전까지~!  놓치면 금일숙제입니다~!
패키지명: com.company.java008_ex 
클래스명: MethodEx006
1. 당신은 게임 캐릭터의 능력치를 분석하는 프로그램을 만들려고 합니다.  
사용자로부터 캐릭터 이름과 공격력, 방어력, 민첩성을 입력받아 
총합, 평균, 등급, 별표 랭킹, 추천 퀘스트, 캐릭터 타입을 출력하는 프로그램을 작성하세요.


#### (1단계) 변수 선언  
아래와 같은 변수를 선언하세요:
- `String name` : 캐릭터 이름  
- `int attack, defense, speed` : 능력치  
- `int total` : 능력치 총합  
- `float avg` : 평균  
- `String grade, star, quest, type` : 등급, 별표, 퀘스트, 캐릭터 타입  
- `Scanner scanner` : 입력 도구

#### (2단계) 입력 처리  
사용자로부터 다음 정보를 입력받으세요:
- 캐릭터 이름
- 공격력 (0~100)
- 방어력 (0~100)
- 민첩성 (0~100)

#### (3단계) 메서드 작성 및 호출  
아래 기능을 각각 메서드로 작성하고, main 메서드에서 호출하세요:

| 기능 | 메서드명 | 설명 |
|------|----------|------|
| 총합 계산 | `process_total()` | 공격력 + 방어력 + 민첩성 |
| 평균 계산 | `process_avg()` | 총합 ÷ 3 |
| 등급 처리 | `process_grade()` | 평균에 따라 S~D 등급 |
| 별표 처리 | `process_star()` | 평균 점수대별 별 개수 |
| 퀘스트 추천 | `process_quest()` | 평균에 따라 추천 퀘스트 |
| 캐릭터 타입 | `process_type()` | 가장 높은 능력치 기준 |


#### (4단계) 출력 메서드 작성  
`process_show()` 메서드를 만들어 다음 정보를 출력하세요:

:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
캐릭터	공격력	방어력	민첩성	총합	평균	등급	랭킹	추천퀘스트	캐릭터타입
-------------------------------------------------------------------------------------------------
피카츄	85	90	95	270	90.0	S등급	*********	전설의 용 퇴치	도적형
-------------------------------------------------------------------------------------------------
 
###   보너스 과제 (선택)
- 평균이 100점이면 “전설의 영웅” 칭호를 부여해보세요.
- 여러 캐릭터를 배열로 입력받아 비교하는 기능으로 확장해보세요.
 
*/