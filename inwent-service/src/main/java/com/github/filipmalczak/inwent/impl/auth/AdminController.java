package com.github.filipmalczak.inwent.impl.auth;

import com.github.filipmalczak.inwent.api.model.domain.accesstoken.AccessTokenResponse;
import com.github.filipmalczak.inwent.api.security.AdminAPI;
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
