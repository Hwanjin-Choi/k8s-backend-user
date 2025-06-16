package com.welab.k8s_backend_user.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Component
public class SiteUserLoginDto {
    @NotBlank(message = "아이디를 입력하세요.")
    private String userId;
    @NotBlank(message = "비밀번호를 입력하세요.")
    private String password;
}

