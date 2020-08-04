package com.atguigu.springboot02;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Map;

//从配置文件中获取指定的值和bean的属性进行绑定
@ConfigurationProperties(
        prefix = "spring.http.encoding"
)
public class HttpEncodingProperties {
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
    private Charset charset;
    private Boolean force;
    private Boolean forceRequest;
    private Boolean forceResponse;
    private Map<Locale, Charset> mapping;

    public HttpEncodingProperties() {
        this.charset = DEFAULT_CHARSET;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public void setCharset(Charset charset) {
        this.charset = charset;
    }

    public boolean isForce() {
        return Boolean.TRUE.equals(this.force);
    }

    public void setForce(boolean force) {
        this.force = force;
    }

    public boolean isForceRequest() {
        return Boolean.TRUE.equals(this.forceRequest);
    }

    public void setForceRequest(boolean forceRequest) {
        this.forceRequest = forceRequest;
    }

    public boolean isForceResponse() {
        return Boolean.TRUE.equals(this.forceResponse);
    }

    public void setForceResponse(boolean forceResponse) {
        this.forceResponse = forceResponse;
    }

    public Map<Locale, Charset> getMapping() {
        return this.mapping;
    }

    public void setMapping(Map<Locale, Charset> mapping) {
        this.mapping = mapping;
    }

    boolean shouldForce(HttpEncodingProperties.Type type) {
        Boolean force = type == HttpEncodingProperties.Type.REQUEST ? this.forceRequest : this.forceResponse;
        if (force == null) {
            force = this.force;
        }

        if (force == null) {
            force = type == HttpEncodingProperties.Type.REQUEST;
        }

        return force;
    }

    static enum Type {
        REQUEST,
        RESPONSE;

        private Type() {
        }
    }
}
