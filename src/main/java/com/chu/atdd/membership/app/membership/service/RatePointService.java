package com.chu.atdd.membership.app.membership.service;

import org.springframework.stereotype.Service;

@Service
public class RatePointService implements PointService {

    private static final int POINT_RATE = 1;

    public int calculateAmount(int price) {
        return price * POINT_RATE / 100;
    }

}
