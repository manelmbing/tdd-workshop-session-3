package es.ing.tddworkshopsession3.accounts.domain.model;

import lombok.Getter;

import java.util.UUID;

@Getter
public class User {
    private final UUID uuid;

    public User(UUID uuid) {
        this.uuid = uuid;
    }

}
