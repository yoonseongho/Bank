import java.util.Scanner;

public class BankApplication {
    private static Account[] accountArray = new Account[100];
    private static Scanner scanner = new Scanner(System.in);
    static int num = 0;
    public static void main(String[] args) {
        boolean run = true;

        while (run) {
            System.out.println("============================================");
            System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료 ");
            System.out.println("============================================");
            System.out.print("선택 >> ");
            int selectNo = scanner.nextInt();

            if (selectNo == 1) {
                String ano = "";
                String owner = "";
                int balance = 0;

                System.out.println("--- 계좌생성 ---");
                System.out.print("계좌번호 : ");
                ano = scanner.next();

                System.out.print("예금주 : ");
                owner = scanner.next();

                System.out.print("초기입금액 : ");
                balance = scanner.nextInt();

                accountArray[num] = new Account(ano, owner, balance);
                num++;
            } else if (selectNo == 2) {
                System.out.println("--- 계좌 목록 ---");
                for (int i = 0 ; i < num; i++ ) {
                    System.out.println(accountArray[i].getAno() + "\t" + accountArray[i].getOwner() +
                            "\t" + accountArray[i].getBalance());
                }
            } else if (selectNo == 3) {
                System.out.println("--- 예금 ---");
                System.out.print("계좌번호 : ");
                String ano = scanner.next();
                System.out.print("예금액 : ");
                findAccount(ano).setBalance(findAccount(ano).getBalance() + scanner.nextInt());
                System.out.println("예금이 성공되었습니다.");
            } else if (selectNo == 4) {
                System.out.println("--- 출금 ---");
                System.out.print("계좌번호  : ");
                String ano = scanner.next();
                System.out.print("출금액 : ");
                int remain = findAccount(ano).getBalance() - scanner.nextInt();
                if (remain < 0) {
                    System.out.println("잔액이 부족합니다.");
                } else {
                    findAccount(ano).setBalance(remain);
                    System.out.println("출금이 성공되었습니다.");
                }
            } else if (selectNo == 5) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            else {
                System.out.println("잘못된 값을 입력 하였습니다.");
            }
        }

    }
    private static Account findAccount(String ano) {
        for (int i = 0 ; i < num; i++) {
            if (accountArray[i].getAno().equals(ano)) {
                return accountArray[i];
            }
        }
        System.out.println("해당 계좌번호를 찾을 수 없습니다.");
        return null;
    }
}