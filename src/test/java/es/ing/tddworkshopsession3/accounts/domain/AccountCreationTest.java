package es.ing.tddworkshopsession3.accounts.domain;

import es.ing.tddworkshopsession3.accounts.domain.model.Account;
import es.ing.tddworkshopsession3.accounts.domain.model.User;
import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AccountCreationTest {

    /*
    * As a Client, I want to create an account that stores my balance and my movements.
    * Given an existing client
    * When account is created
    * Then account information is persisted
    *
    * Acceptance Criteria:
    * + An error is expected if no holders are provided (Z)
    * + Account can be created with one holder (O)
    * + Account can be created with two holders (M)
    * + An error is expected if more than two holders are provided (B)
    * + Account can be created with no initial balance, initial balance will be 0.
    * + Account can be created with initial balance, then a movement will be created too.
    * - An error is expected if initial balance is lower than 0. (B)
    * - Balance must be a real (decimal) number. (I)
    * - Holders must be registered clientes (E)
    *
    */

    @Test
    void shouldReturnErrorIfClientNotProvided() {
        assertThrows(OperationNotSupportedException.class, () -> new Account(new ArrayList<>()));
    }

    @Test
    void shouldCreateAnAccountWithOneClient() throws OperationNotSupportedException {
        Account account = new Account(List.of(new User(UUID.randomUUID())));

        assertEquals(1, account.getUsers().size());
    }

    @Test
    void shouldCreateAnAccountWithTwoClients() throws OperationNotSupportedException {
        Account account = new Account(List.of(new User(UUID.randomUUID()), new User(UUID.randomUUID())));

        assertEquals(2, account.getUsers().size());
    }

    @Test
    void shouldReturnErrorIfMoreThanTwoClientsAreProvided() {
        assertThrows(OperationNotSupportedException.class, () -> new Account(List.of(new User(UUID.randomUUID()), new User(UUID.randomUUID()), new User(UUID.randomUUID()))));
    }

    @Test
    void shouldHaveBalanceOfZeroIfCreatedWithNoBalance() throws OperationNotSupportedException {
        Account account = new Account(List.of(new User(UUID.randomUUID())));
        assertEquals(BigDecimal.ZERO, account.getBalance());
    }

    @Test
    void shouldHaveBalanceOfTenIfCreatedWithBalanceParameterOfTen() throws OperationNotSupportedException {
        Account account = new Account(List.of(new User(UUID.randomUUID())), BigDecimal.TEN);
        assertEquals(BigDecimal.TEN, account.getBalance());
    }

    @Test
    void shouldHaveBalanceOfHundredIfCreatedWithBalanceParameterOfHundred() throws OperationNotSupportedException {
        Account account = new Account(List.of(new User(UUID.randomUUID())), BigDecimal.valueOf(100));
        assertEquals(BigDecimal.valueOf(100), account.getBalance());
    }

    @Test
    void shouldReturnErrorIfBalanceProvidedIsNegative() {
        assertThrows(OperationNotSupportedException.class, () -> new Account(List.of(new User(UUID.randomUUID())), BigDecimal.ONE.negate()));
    }

    @Test
    void shouldCreateMovementIfCreatedWithBalance() throws OperationNotSupportedException {
        Account account = new Account(List.of(new User(UUID.randomUUID())), BigDecimal.TEN);
        assertEquals(1, account.getMovements().size());
        assertEquals(BigDecimal.TEN, account.getMovements().get(0).getValue());
    }



}
