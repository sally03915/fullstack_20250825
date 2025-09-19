package com.company.java008_ex_MiniProject_Bank;
 

import java.util.Scanner;

public class Bank003_Method {

    private static final Scanner scanner = new Scanner(System.in); // 공통 Scanner

    public static void main(String[] args) {
        String[] id = new String[3];
        String[] pass = new String[3];
        double[] balance = new double[3];
        int num = -1;

        while (num != 9) {
            showMenu();
            num = inputInt("👉 번호를 선택하세요: ");

            if (num == 1) {
                addAccount(id, pass, balance);
            } else if (num >= 2 && num <= 5) {
                int find = authenticate(id, pass);
                if (find == -1) {
                    System.out.println("❌ 아이디와 비밀번호를 확인해주세요!");
                    continue;
                }

                if (num == 2) {
                    showAccount(id, pass, balance, find);
                } else if (num == 3) {
                    deposit(balance, find);
                } else if (num == 4) {
                    withdraw(balance, find);
                } else if (num == 5) {
                    deleteAccount(id, pass, balance, find);
                }
            } else {
                System.out.println("❗ 메뉴를 확인해주세요~!");
            }
        }

        scanner.close(); // 프로그램 종료 시 Scanner 닫기
    }

    static void showMenu() {
        System.out.println("\n\n🌟💰 WELCOME TO BANK SYSTEM 💰🌟");
        System.out.println("[1] ➕ 계좌 추가");
        System.out.println("[2] 🔍 계좌 조회");
        System.out.println("[3] 💵 입금하기");
        System.out.println("[4] 💸 출금하기");
        System.out.println("[5] 🗑️ 계좌 삭제");
        System.out.println("[9] ❌ 종료");
    }

    static void addAccount(String[] id, String[] pass, double[] balance) {
        int find = -1;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == null) {
                find = i;
                break;
            }
        }

        if (find == -1) {
            System.out.println("⚠️ 계좌를 생성할 수 없습니다.");
            return;
        }

        id[find] = inputString("[1] 아이디 입력 > ");
        pass[find] = inputString("[2] 비밀번호 입력 > ");
        balance[find] = inputDouble("[3] 금액 입력 > ");
    }

    static int authenticate(String[] id, String[] pass) {
        String tempId = inputString("[1] 아이디 입력 > ");
        String tempPass = inputString("[2] 비밀번호 입력 > ");

        for (int i = 0; i < id.length; i++) {
            if (tempId.equals(id[i]) && tempPass.equals(pass[i])) {
                return i;
            }
        }
        return -1;
    }

    static void showAccount(String[] id, String[] pass, double[] balance, int index) {
        System.out.println("\n[1] 아이디 > " + id[index]);
        System.out.println("[2] 비밀번호 > " + pass[index]);
        System.out.println("[3] 잔액 > " + balance[index]);
    }

    static void deposit(double[] balance, int index) {
        double amount = inputDouble("\n입금할 금액 > ");
        balance[index] += amount;
    }

    static void withdraw(double[] balance, int index) {
        double amount = inputDouble("\n출금할 금액 > ");
        balance[index] -= amount;
    }

    static void deleteAccount(String[] id, String[] pass, double[] balance, int index) {
        String confirm = inputString("\n정말로 삭제하시겠습니까? (y/n) > ");
        if (confirm.equalsIgnoreCase("y")) {
            id[index] = null;
            pass[index] = null;
            balance[index] = 0;
            System.out.println("✅ 계좌가 삭제되었습니다.");
        }
    }

    // 🧵 입력 메서드들 (Scanner는 내부에서 공통 인스턴스 사용)
    static String inputString(String message) {
        System.out.print(message);
        return scanner.next();
    }

    static double inputDouble(String message) {
        System.out.print(message);
        return scanner.nextDouble();
    }

    static int inputInt(String message) {
        System.out.print(message);
        return scanner.nextInt();
    }
}

/*
## 💻 자바 미니 프로젝트: 은행 계좌 관리 시스템

**패키지명**: `com.company.java008_ex_MiniProject_Bank`  
**클래스명**: `Bank003_Array`

다음 조건을 만족하는 **은행 계좌 관리 시스템**을 배열과 메서드를 활용하여 구현하세요.

---

### ■ [1단계] 데이터 구성

다음과 같은 정보를 저장할 수 있는 배열을  main 안에 선언하세요:
```java
String[] id = new String[3];
String[] pass = new String[3];
double[] balance = new double[3];
```

- 각 배열의 인덱스는 하나의 계좌를 의미합니다.
  - `id[i]`: 계좌 아이디
  - `pass[i]`: 계좌 비밀번호
  - `balance[i]`: 계좌 잔액

---

### ■ [2단계] 메뉴 출력 및 선택

다음과 같은 메뉴를 **무한 반복**으로 출력하세요:

```
🌟💰 WELCOME TO BANK SYSTEM 💰🌟
[1] ➕ 계좌 추가
[2] 🔍 계좌 조회
[3] 💵 입금하기
[4] 💸 출금하기
[5] 🗑️ 계좌 삭제
[9] ❌ 종료
👉 번호를 선택하세요:
```

> 🔧 **각 기능은 반드시 별도의 메서드로 분리하여 구현**하세요.  
> 메뉴 선택에 따라 해당 기능을 수행할 때는,
   **배열을 매개변수로 전달**하여 메서드가 데이터를 처리하도록 하세요.

예시:
```java
addAccount(id, pass, balance); // 계좌 추가
```

---

### ■ [3단계] 기능 구현

#### ① 계좌 추가

- 빈 공간이 있을 경우, 아이디, 비밀번호, 초기 금액을 입력받아 계좌를 생성하세요.
- 계좌가 3개 모두 찼을 경우 다음과 같이 출력하세요:

```
⚠️ 계좌를 생성할 수 없습니다.
```

---

#### ② 계좌 조회

- 아이디와 비밀번호를 입력받아 인증 후 해당 계좌 정보를 출력하세요.

> 출력 예시:
```
[1] 아이디 > hong123
[2] 비밀번호 > 1234
[3] 잔액 > 50000.0
```

- 인증 실패 시:
```
❌ 아이디와 비밀번호를 확인해주세요!
```

---

#### ③ 입금하기

- 인증 후 입금할 금액을 입력받아 잔액을 증가시키세요.

> 출력 예시:
```
입금할 금액 > 10000
✅ 입금 완료! 현재 잔액: 60000.0
```

---

#### ④ 출금하기

- 인증 후 출금할 금액을 입력받아 잔액을 감소시키세요.
- 잔액이 부족할 경우 출금되지 않도록 처리하세요.

> 출력 예시:
```
출금할 금액 > 70000
❌ 잔액이 부족합니다!
```

---

#### ⑤ 계좌 삭제

- 인증 후 삭제 여부를 확인하고, `y`를 입력하면 계좌 정보를 삭제하세요.

> 출력 예시:
```
정말로 삭제하시겠습니까? (y/n) > y
✅ 계좌가 삭제되었습니다.
```

---

#### ⑥ 종료

- 메뉴에서 `9`번을 선택하면 프로그램을 종료하세요.

> 출력 예시:
```
👋 시스템을 종료합니다. 안녕히 가세요!
```

---

### 🎁 [보너스 과제] 선택 구현

- ✅ 전체 계좌 목록을 출력하는 기능
- ✅ 계좌 추가 시 중복 아이디 방지 기능 
  
 */



