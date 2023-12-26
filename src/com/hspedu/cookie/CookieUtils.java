package com.hspedu.cookie;

import javax.servlet.http.Cookie;

public class CookieUtils {
    public static Cookie readCookieByName(String name, Cookie[] cookies) {

        if (name == null || "".equals(name) || cookies == null || cookies.length == 0) {
            return null;
        }

        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                return cookie;
            }
        }

        return null;
    }
}
