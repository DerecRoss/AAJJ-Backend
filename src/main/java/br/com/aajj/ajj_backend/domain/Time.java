package br.com.aajj.ajj_backend.domain;

import java.time.LocalTime;

public enum Time {

    H_8AM(LocalTime.of(8, 0)),
    H_16PM(LocalTime.of(16, 0)),
    H_17PM(LocalTime.of(17, 0)),
    H_18PM(LocalTime.of(18, 0)),
    H_19PM(LocalTime.of(19, 0)),
    H_20PM(LocalTime.of(20, 0));

    private final LocalTime localTime;

    Time(LocalTime localTime) {
        this.localTime = localTime;
    }

    public LocalTime toLocalTime() {
        return localTime;
    }
}
