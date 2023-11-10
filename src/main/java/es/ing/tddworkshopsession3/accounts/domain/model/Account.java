package es.ing.tddworkshopsession3.accounts.domain.model;

import lombok.Getter;

import javax.naming.OperationNotSupportedException;
import java.math.BigDecimal;
import java.util.List;

@Getter
public class Account {
    private final List<User> users;
    @Getter
    private final BigDecimal balance;
    @Getter
    private List<Movement> movements;

    public Account(List<User> users) throws OperationNotSupportedException {
        if (users.isEmpty() || users.size() > 2) {
            throw new OperationNotSupportedException();
        }

        this.users = users;
        this.balance = BigDecimal.ZERO;
    }

    public Account(List<User> users, BigDecimal balance) throws OperationNotSupportedException {
        if (users.isEmpty() || users.size() > 2 || balance.compareTo(BigDecimal.ZERO) < 0) {
            throw new OperationNotSupportedException();
        }

        this.users = users;
        this.balance = balance;
        this.movements = List.of(new Movement(balance));
    }


}
