package com.mobiquityinc.packer.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
public class Thing {
    @NonNull
    private final Integer index;
    @NonNull
    private final Float weight;
    @NonNull
    private final Float cost;

}
