package com.welab.k8s_backend_user.remote.alim;

import com.welab.k8s_backend_user.common.dto.ApiResponseDto;
import lombok.NoArgsConstructor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@NoArgsConstructor
@FeignClient(name = "RemoteAlimService", url = "http://k8s-backend-alim-service:8080", path = "/backend/alim/v1")
public interface RemoteAlimService {
    @GetMapping(value = "/hello")
    public ApiResponseDto<String> hello();
}