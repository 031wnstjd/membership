package com.chu.atdd.membership.app.membership.dto;

import com.chu.atdd.membership.app.enums.MembershipType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import static com.chu.atdd.membership.app.membership.validation.ValidationGroups.MembershipAccumulateMarcker;
import static com.chu.atdd.membership.app.membership.validation.ValidationGroups.MembershipAddMarker;

@Getter
@Builder
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class MembershipRequest {

    @NotNull(groups = {MembershipAddMarker.class, MembershipAccumulateMarcker.class})
    @Min(value = 0, groups = {MembershipAddMarker.class, MembershipAccumulateMarcker.class})
    private final Integer point;

    @NotNull(groups = {MembershipAddMarker.class})
    private final MembershipType membershipType;

}
