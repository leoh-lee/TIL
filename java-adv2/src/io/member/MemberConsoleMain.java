package io.member;

import io.member.impl.FileMemberRepository;
import io.member.impl.MemoryMemberRepository;
import io.member.impl.ObjectMemberRepository;

import java.io.CharArrayReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MemberConsoleMain {

//    private static final MemberRepository memberRepository = new MemoryMemberRepository();
//private static final MemberRepository memberRepository = new FileMemberRepository();

    private static final MemberRepository memberRepository = new ObjectMemberRepository();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1.회원 등록 | 2.회원 목록 조회 | 3. 종료");
            System.out.println("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();     // new line 제거

            switch (choice) {
                case 1:
                    // 회원 등록
                    registerMember(scanner);
                    break;
                case 2:
                    displayMembers();
                    // 회원 목록 조회
                    break;
                case 3:
                    System.out.println("프로그앰을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
        }
    }

    private static void registerMember(Scanner scanner) {
        System.out.print("ID 입력: ");
        String id = scanner.nextLine();

        System.out.print("Name 입력: ");
        String name = scanner.nextLine();

        System.out.print("Age 입력: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        Member newMember = new Member(id, name, age);
        memberRepository.add(newMember);
        System.out.println("회원이 성공적으로 등록되었습니다.");
    }

    private static void displayMembers() {
        List<Member> members = memberRepository.findAll();
        for (Member member : members) {
            System.out.printf("[ID: %s, Name: %s, Age: %d]\n", member.getId(), member.getName(), member.getAge());        }
    }
}
