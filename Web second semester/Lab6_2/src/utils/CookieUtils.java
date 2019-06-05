package utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CookieUtils {
    private static final String ATT_LOGIN_TIME = "ATTRIBUTE_FOR_LOGIN_TIME";
    private static final String ATT_NAME_USER_NAME = "ATTRIBUTE_FOR_STORE_USER_NAME_IN_COOKIE";

    /**
     * Stores info in cookie.
     *
     * @param response Response to add cookie to.
     * @param username User to store information of.
     */

    public CookieUtils(){}

    public static void storeUserCookie(HttpServletResponse response, String username) {
        Cookie cookieUsername = new Cookie(ATT_NAME_USER_NAME, username);
        // 1 day (Converted to seconds)
        cookieUsername.setMaxAge(24 * 60 * 60);
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        String reportDate = df.format(today);
        Cookie cookieLoginTime = new Cookie(ATT_LOGIN_TIME, reportDate);
        cookieLoginTime.setMaxAge(24 * 60 * 60);
        response.addCookie(cookieUsername);
        response.addCookie(cookieLoginTime);
    }

    /**
     * Gets name of the user from cookies.
     *
     * @param request Request with cookies.
     * @return Stored name.
     */
    public static String getUserNameInCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (ATT_NAME_USER_NAME.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    /**
     * Gets login time from cookies.
     *
     * @param request Request with cookies.
     * @return Stored login time.
     */
    public static String getLoginTimeInCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (ATT_LOGIN_TIME.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    /**
     * Deletes info from cookie.
     *
     * @param response Response to delete cookie.
     */
    public static void deleteUserCookie(HttpServletResponse response) {
        Cookie cookieUsername = new Cookie(ATT_NAME_USER_NAME, null);
        Cookie cookieLoginTime = new Cookie(ATT_LOGIN_TIME, null);
        // 0 seconds (This cookie will expire immediately)
        cookieUsername.setMaxAge(0);
        cookieLoginTime.setMaxAge(0);
        response.addCookie(cookieUsername);
        response.addCookie(cookieLoginTime);
    }
}
