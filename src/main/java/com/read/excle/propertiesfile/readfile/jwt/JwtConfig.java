package com.read.excle.propertiesfile.readfile.jwt;

import com.google.common.net.HttpHeaders;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "application.jwt")
public class JwtConfig {
   // @Value("${application.jwt.secretKey}")
    private String secretKey;
   // @Value("${application.jwt.tokenPrefix}")
    private String tokenPrefix;
 //   @Value("${application.jwt.tokenExpirattionDays}")
    private int tokenExpirattionDays;

    public JwtConfig() {
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getTokenPrefix() {
        return tokenPrefix;
    }

    public void setTokenPrefix(String tokenPrefix) {
        this.tokenPrefix = tokenPrefix;
    }

    public int getTokenExpirattionDays() {
        return tokenExpirattionDays;
    }

    public void setTokenExpirattionDays(int tokenExpirattionDays) {
        this.tokenExpirattionDays = tokenExpirattionDays;
    }

    public String getAuthorizationHeader(){
        return HttpHeaders.AUTHORIZATION;
    }
}
