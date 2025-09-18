package com.company.java008_ex;
 
import java.util.Scanner;
import java.util.Random;

public class MethodEx010 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] pets = {
            {"콩이", "010-1234-5678", "예방접종"},
            {"초코", "010-2345-6789", "건강검진"},
            {"보리", "010-3456-7890", "치아관리"}
        };
        String[] recommendations = {"피부검사", "심장검사", "영양상담", "스트레스검사"};

        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기

            switch (choice) {
                case 1:
                    viewTreatment(scanner, pets);
                    break;
                case 2:
                    pets = changeTreatment(scanner, pets);
                    break;
                case 3:
                    System.out.println("👋 시스템을 종료합니다. 안녕히 가세요!");
                    return;
                case 4:
                    pets = registerNewPet(scanner, pets);
                    break;
                case 5:
                    printAllReservations(pets);
                    break;
                case 6:
                    recommendTreatment(recommendations);
                    break;
                default:
                    System.out.println("❌ 올바른 메뉴 번호를 선택해주세요.");
            }
        }
    }

    static void printMenu() {
        System.out.println("\n🐾 동물 병원 시스템 메뉴");
        System.out.println("1. 진료 항목 조회");
        System.out.println("2. 진료 항목 변경");
        System.out.println("3. 종료");
        System.out.println("4. 신규 동물 등록 (보너스)");
        System.out.println("5. 전체 예약 목록 출력 (보너스)");
        System.out.println("6. 진료 항목 추천 (보너스)");
        System.out.print("👉 메뉴 번호를 선택해주세요: ");
    }

    static void viewTreatment(Scanner scanner, String[][] pets) {
        System.out.print("🐶 동물 이름을 입력해주세요 > ");
        String name = scanner.nextLine();

        for (String[] pet : pets) {
            if (pet[0].equals(name)) {
                System.out.println("✅ " + name + "는 " + pet[2] + " 예약이 되어 있어요.");
                return;
            }
        }
        System.out.println("❌ 해당 동물 정보를 찾을 수 없습니다.");
    }

    static String[][] changeTreatment(Scanner scanner, String[][] pets) {
        System.out.print("🐱 동물 이름을 입력해주세요 > ");
        String name = scanner.nextLine();
        System.out.print("📞 보호자 전화번호를 입력해주세요 > ");
        String phone = scanner.nextLine();

        for (int i = 0; i < pets.length; i++) {
            if (pets[i][0].equals(name) && pets[i][1].equals(phone)) {
                System.out.print("🩺 변경하실 진료 항목을 입력해주세요 > ");
                String newTreatment = scanner.nextLine();
                pets[i][2] = newTreatment;
                System.out.println("✅ 예약 정보 확인: [" + pets[i][0] + ", " + pets[i][1] + ", " + pets[i][2] + "]");
                return pets;
            }
        }
        System.out.println("❌ 등록 정보를 확인해주세요!");
        return pets;
    }

    static String[][] registerNewPet(Scanner scanner, String[][] pets) {
        System.out.print("🆕 동물 이름을 입력해주세요 > ");
        String name = scanner.nextLine();
        System.out.print("📞 보호자 전화번호를 입력해주세요 > ");
        String phone = scanner.nextLine();
        System.out.print("🩺 진료 항목을 입력해주세요 > ");
        String treatment = scanner.nextLine();

        String[][] newPets = new String[pets.length + 1][3];
        for (int i = 0; i < pets.length; i++) {
            newPets[i] = pets[i];
        }
        newPets[pets.length] = new String[]{name, phone, treatment};
        System.out.println("✅ 신규 등록 완료: [" + name + ", " + phone + ", " + treatment + "]");
        return newPets;
    }

    static void printAllReservations(String[][] pets) {
        System.out.println("📋 전체 예약 목록:");
        for (String[] pet : pets) {
            System.out.println("- " + String.join(", ", pet));
        }
    }

    static void recommendTreatment(String[] recommendations) {
        Random rand = new Random();
        String suggestion = recommendations[rand.nextInt(recommendations.length)];
        System.out.println("🎯 추천 진료 항목: " + suggestion);
    }
}


/*

연습문제10)  method
패키지명 : com.company.java008_ex
클래스명 :  MethodEx010
다음 조건을 만족하는 동물 병원 예약 시스템을 만들어보세요.

■[1단계] 데이터 구성
다음과 같은 정보를 담고 있는 2차원 배열을 선언하세요:

String[][] pets = {
    {"콩이", "010-1234-5678", "예방접종"},
    {"초코", "010-2345-6789", "건강검진"},
    {"보리", "010-3456-7890", "치아관리"}
};

- 각 행은 한 마리의 동물에 대한 정보입니다.
  - [0] 동물 이름
  - [1] 보호자 전화번호
  - [2] 예약된 진료 항목

■ [2단계] 메뉴 출력 및 선택
다음과 같은 메뉴를 **무한 반복**으로 출력하세요:

🐾 동물 병원 시스템 메뉴
1. 진료 항목 조회
2. 진료 항목 변경
3. 종료
👉 메뉴 번호를 선택해주세요:
 


■ [3단계] 기능 구현

#### ① 진료 항목 조회
- 동물 이름을 입력받아 해당 동물의 진료 항목을 출력하세요.
> 출력예시
🐶 동물 이름을 입력해주세요 > 콩이
✅ 콩이는 예방접종 예약이 되어 있어요.
 

#### ② 진료 항목 변경
> 출력예시
- 동물 이름과 보호자 전화번호를 입력받아 정보가 맞으면 진료 항목을 변경하세요.

🐱 동물 이름을 입력해주세요 > 초코
📞 보호자 전화번호를 입력해주세요 > 010-2345-6789
🩺 변경하실 진료 항목을 입력해주세요 > 피부검사
✅ 예약 정보 확인: [초코, 010-2345-6789, 피부검사]
 

- 정보가 틀리면 다음과 같이 출력하세요:
 
❌ 등록 정보를 확인해주세요!
 

#### ③ 종료
- 메뉴에서 3번을 선택하면 프로그램을 종료하세요.
 
👋 시스템을 종료합니다. 안녕히 가세요!
 
 
 

###  ④  보너스 과제 (선택)

- 신규 동물 등록 기능을 추가 
- 전체 예약 목록을 출력하는 기능 
- 진료 항목을 랜덤으로 추천해주는 기능 
 

*/