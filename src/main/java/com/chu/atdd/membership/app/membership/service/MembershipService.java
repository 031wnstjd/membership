package com.chu.atdd.membership.app.membership.service;

import com.chu.atdd.membership.exception.MembershipErrorResult;
import com.chu.atdd.membership.exception.MembershipException;
import com.chu.atdd.membership.app.enums.MembershipType;
import com.chu.atdd.membership.app.membership.dto.MembershipResponse;
import com.chu.atdd.membership.app.membership.entity.Membership;
import com.chu.atdd.membership.app.membership.repository.MembershipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MembershipService {

    private final MembershipRepository membershipRepository;

    public MembershipResponse addMembership(final String userId, final MembershipType membershipType, final Integer point) {
        final Membership result = membershipRepository.findByUserIdAndMembershipType(userId, membershipType);
        if (result != null) {
            throw new MembershipException(MembershipErrorResult.DUPLICATED_MEMBERSHIP_REGISTER);
        }

        final Membership membership = Membership.builder()
                .userId(userId)
                .point(point)
                .membershipType(membershipType)
                .build();

        final Membership savedMembership = membershipRepository.save(membership);

        return MembershipResponse.builder()
                .id(savedMembership.getId())
                .membershipType(savedMembership.getMembershipType())
                .build();
    }

}
