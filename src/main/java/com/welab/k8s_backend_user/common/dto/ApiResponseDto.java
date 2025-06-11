package com.welab.k8s_backend_user.common.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ApiResponseDto<T> { // 클래스에 제네릭 타입 <T>를 추가하였습니다.

    private String code;
    private String message;
    private T data; // 제네릭 타입 T를 사용합니다.

    private ApiResponseDto(String code, String message) {
        this.code = code;
        this.message = message;
        // 이 생성자에서는 data 필드가 초기화되지 않으므로, T 타입의 기본값(참조 타입의 경우 null)을 갖게 됩니다.
    }

    private ApiResponseDto(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResponseDto<T> createOk(T data) {
        return new ApiResponseDto<>("OK", "요청이 성공하였습니다.", data);
    }

    public static <T> ApiResponseDto<T> defaultOk() {
        // T는 null이 전달될 때 Object 등으로 추론될 수 있습니다.
        return ApiResponseDto.createOk(null);
    }

    // 에러 응답 시에는 데이터 부분이 없을 수 있으므로, T의 타입을 명시적으로 Void 등으로 하거나
    // Object로 하여 어떤 타입의 데이터도 없음을 나타낼 수 있습니다.
    // 여기서는 일관성을 위해 제네릭 <T>를 유지하고, 호출 시 new ApiResponseDto<>(code, message)는 data를 null로 설정합니다.
    public static <T> ApiResponseDto<T> createError(String code, String message) {
        return new ApiResponseDto<>(code, message);
    }
}