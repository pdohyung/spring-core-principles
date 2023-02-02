package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.MemServiceImpl;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService = new MemServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void creatOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "memeberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
