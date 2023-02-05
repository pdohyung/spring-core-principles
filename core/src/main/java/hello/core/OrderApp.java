package hello.core;

import hello.core.member.Grade;
import hello.core.member.MemberServiceImpl;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {

        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();
        //OrderService orderService = appConfig.orderService();
        // AppConfig에서 꺼내쓰기 , 외부에서 꺼내쓴다

        ApplicationContext appliCationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = appliCationContext.getBean("memberService", MemberService.class);
        OrderService orderService = appliCationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;

        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);
        System.out.println("order = " + order);
        //System.out.println("order.caculatePrice() = " + order.caculatePrice());
    }
}
