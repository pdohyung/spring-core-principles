package hello.core.member;

public class MemServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    public MemServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void join(Member member){
        memberRepository.save(member);
    }

    public Member findMember(Long memberId)
    {
        return memberRepository.findById(memberId);
    }

}
