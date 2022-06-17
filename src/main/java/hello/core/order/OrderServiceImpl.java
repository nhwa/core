package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
@Component
public class OrderServiceImpl implements OrderService{
//    private final MemberRepository memoryMemberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    // final : 무조건 값이 있어야 한다 => 생성자 호출 - 1) 생성자 주입
    // ==> final을 통해 생성ㄹ장에서 값이 설정되지 안는 오류를 컴파잃시점에서 체크할 수 있음
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // 선택적 의존관계시 생성할때 값이 있어햐하는 final은 사용x - 2) 수정자 주입, 4) 메서드 주입
//    private MemberRepository memberRepository;
//    private DiscountPolicy discountPolicy;

    //  - 3) 필드 주입
//    @Autowired private DiscountPolicy discountPolicy;
//    @Autowired private MemberRepository memberRepository;

    // 생성자가 1개일때는 @Autowired 생략 가능! - 1) 생성자 주입
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    // 2) 수정자 주입
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }

    // 4) 일반 메서드 주입
//    @Autowired
//    public void init(MemberRepository memberRepository, DiscountPolicy
//            discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);

        // SRP 준수(단일책임원칙) : 하나의 클래스에서 하나의 책임만 주문쪽에서는 주문만 고침!
       int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice );
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
*/


@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // RequiredArgsConstructor => 생성자 자동 생성
//    @Autowired
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);

        // SRP 준수(단일책임원칙) : 하나의 클래스에서 하나의 책임만 주문쪽에서는 주문만 고침!
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice );
    }


}
