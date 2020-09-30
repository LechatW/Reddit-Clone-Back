package com.reddit.clone.dto;

import javax.validation.constraints.NotBlank;

public class RefreshTokenRequest {

    public RefreshTokenRequest() {}

    public RefreshTokenRequest(String refreshToken, String username) {
        this.refreshToken = refreshToken;
        this.username = username;
    }

    @NotBlank
    private String refreshToken;
    private String username;

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
