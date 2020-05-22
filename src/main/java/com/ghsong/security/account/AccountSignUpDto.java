package com.ghsong.security.account;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountSignUpDto {

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    public Account toEntity() {
        return Account.builder()
                .email(this.email)
                .password(this.password)
                .build();
    }

}
