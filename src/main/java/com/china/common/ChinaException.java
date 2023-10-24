package com.china.common;

import cn.dev33.satoken.util.SaFoxUtil;
import cn.dev33.satoken.util.SaResult;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class ChinaException extends LinkedHashMap<String, Object> {
    private static final long serialVersionUID = 1L;
    public static final int CODE_SUCCESS = 200;
    public static final int CODE_ERROR = 500;

    public ChinaException() {
    }

    public ChinaException(int code, String msg, Object data) {
        this.setCode(code);
        this.setMsg(msg);
        this.setData(data);
    }

    public ChinaException(Map<String, ?> map) {
        this.setMap(map);
    }

    public Integer getCode() {
        return (Integer)this.get("code");
    }

    public String getMsg() {
        return (String)this.get("msg");
    }

    public Object getData() {
        return this.get("data");
    }

    public ChinaException setCode(int code) {
        this.put("code", code);
        return this;
    }

    public ChinaException setMsg(String msg) {
        this.put("msg", msg);
        return this;
    }

    public ChinaException setData(Object data) {
        this.put("data", data);
        return this;
    }

    public ChinaException set(String key, Object data) {
        this.put(key, data);
        return this;
    }

    public <T> T get(String key, Class<T> cs) {
        return SaFoxUtil.getValueByType(this.get(key), cs);
    }

    public ChinaException setMap(Map<String, ?> map) {
        Iterator var2 = map.keySet().iterator();

        while(var2.hasNext()) {
            String key = (String)var2.next();
            this.put(key, map.get(key));
        }

        return this;
    }

    public static ChinaException ok() {
        return new ChinaException(200, "ok", (Object)null);
    }

    public static ChinaException ok(String msg) {
        return new ChinaException(200, msg, (Object)null);
    }

    public static ChinaException code(int code) {
        return new ChinaException(code, (String)null, (Object)null);
    }

    public static ChinaException data(Object data) {
        return new ChinaException(200, "ok", data);
    }

    public static ChinaException error() {
        return new ChinaException(500, "error", (Object)null);
    }

    public static ChinaException error(String msg) {
        return new ChinaException(500, msg, (Object)null);
    }

    public static ChinaException get(int code, String msg, Object data) {
        return new ChinaException(code, msg, data);
    }

    public String toString() {
        return "{\"code\": " + this.getCode() + ", \"msg\": " + this.transValue(this.getMsg()) + ", \"data\": " + this.transValue(this.getData()) + "}";
    }

    private String transValue(Object value) {
        if (value == null) {
            return null;
        } else {
            return value instanceof String ? "\"" + value + "\"" : String.valueOf(value);
        }
    }
}
