package hello.core.member;

import hello.core.AppConfig;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService;
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findByMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());

    }
}
