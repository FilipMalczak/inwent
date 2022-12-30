package com.github.fmd.backend.impl.auth;

import com.github.fmd.backend.api.AdminAPI;
import com.github.fmd.backend.api.model.AccessTokenResponse;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class AdminController implements AdminAPI {
    @Override
    public Mono<AccessTokenResponse> makeToken(String name) {
        return null;
    }

    @Override
    public Mono<Void> revokeToken(String name) {
        return null;
    }
}
