package com.ghsong.security.account;

import lombok.*;

import javax.persistence.*;

@Getter
@EqualsAndHashCode(of = "id")
@Entity
@NoArgsConstructor
@ToString
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;

    @Builder
    public Account(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
