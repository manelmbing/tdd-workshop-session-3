package es.ing.tddworkshopsession3.accounts.domain.model;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Movement {
    private final BigDecimal value;

    public Movement(BigDecimal value) {
        this.value = value;
    }

}
