package com.wenjian.loopbannerdemo;

import android.text.TextUtils;

import com.tencent.mmkv.MMKV;

/**
 * Created by L
 * 2018/9/3
 */
public class SaveUtil {

    private static final String KEY_ENCRYPT_KEY = "KEY_ENCRYPT_KEY";
    private static final String KEY_SESSIONID = "KEY_SESSIONID";
    private static final String KEY_TOKEN = "KEY_TOKEN";
    public static final String KEY_COUNT_DOWN = "KEY_COUNT_DOWN";
    public static final String KEY_HOME_ID = "KEY_HOME_ID";
    public static final String KEY_HOME_NAME = "KEY_HOME_NAME";
    public static final String KEY_DEVICE_ID = "KEY_DEVICE_ID";
    public static final String KEY_DEVICE_NAME = "KEY_DEVICE_NAME";
    public static final String KEY_DEVICE_TYPE = "KEY_DEVICE_TYPE";
    public static final String KEY_ACCOUNT = "KEY_ACCOUNT";
    public static final String KEY_PASSWORD = "KEY_PASSWORD";
    public static final String KEY_MD5_PWD = "KEY_MD5_PWD";
    public static final String KEY_USERNAME = "KEY_USERNAME";
    public static final String KEY_CHECKED_PWD = "KEY_CHECKED_PWD";
    public static final String KEY_USER_LOCK_ID = "KEY_USER_LOCK_ID";
    public static final String KEY_USER_PORTRAITS_URL = "KEY_USER_PORTRAITS_URL";
    //手势密码
    public static final String KEY_GESTURE_PWD = "KEY_GESTURE_PWD";
    public static final String KEY_GESTURE_PWD_COPY = "KEY_GESTURE_PWD_COPY";

    // 蓝牙连接地址
    public static final String KEY_BLE_CONNECT_ADDR = "KEY_BLE_CONNECT_ADDR";
    // app 自动刷新数据的时间间隔
    public static final String KEY_NOTIFICATION_INTERVAL = "KEY_NOTIFICATION_INTERVAL";
    // 消息接口自动刷新时间间隔
    public static final String KEY_MSG_INTERVAL = "KEY_MSG_INTERVAL";
    // 其它图片域名
    public static final String KEY_PICTURE_DOMAIN = "KEY_PICTURE_DOMAIN";
    // 锁用户头像图片域名
    public static final String KEY_LOCK_USER_HEAD_DOMAIN = "KEY_LOCK_USER_HEAD_DOMAIN";
    // APP用户头像图片域名
    public static final String KEY_APP_USER_HEAD_DOMAIN = "KEY_APP_USER_HEAD_DOMAIN";
    // app动态配置信息
    public static final String KEY_BIND_LOCK_KINDS = "KEY_BIND_LOCK_KINDS";
    // 蓝牙连接锁 ID
    public static final String KEY_BLE_NORMAL_LOCK_ID = "KEY_BLE_NORMAL_LOCK_ID";


    private static MMKV kv = MMKV.defaultMMKV();

    public static void clearAll() {

        kv.removeValuesForKeys(new String[]{
                KEY_COUNT_DOWN,
                KEY_HOME_ID,
                KEY_HOME_NAME,
                KEY_USERNAME,
                KEY_DEVICE_ID,
                KEY_DEVICE_NAME,
                KEY_DEVICE_TYPE,
                KEY_USER_LOCK_ID,
                KEY_USER_PORTRAITS_URL,
                KEY_GESTURE_PWD,
                KEY_GESTURE_PWD_COPY
        });

    }

    public static void signOut() {
        clearAll();
        kv.removeValuesForKeys(new String[]{
                KEY_MD5_PWD,
                KEY_SESSIONID,
                KEY_TOKEN,
                KEY_PASSWORD,
                KEY_CHECKED_PWD,
        });
    }


    public static void saveKey(String key, String sessionId) {
        // 存储数据
        kv.encode(KEY_ENCRYPT_KEY, key);
        kv.encode(KEY_SESSIONID, sessionId);
    }

    public static String loadKey() {

        return kv.decodeString(KEY_ENCRYPT_KEY);
    }

    public static String loadSessionId() {
        String str = kv.decodeString(KEY_SESSIONID);
        return str;
    }

    public static void saveToken(String token) {
        if (TextUtils.isEmpty(token))
            return;

        String savetoken = loadToken();
        if (TextUtils.isEmpty(savetoken) || !savetoken.equals(token)) {
            kv.encode(KEY_TOKEN, token);
        }
    }

    public static String loadToken() {
        return kv.decodeString(KEY_TOKEN);
    }

    public static void saveNotificationInterval(long notificationInterval) {
        // 存储数据
        kv.encode(KEY_NOTIFICATION_INTERVAL, notificationInterval);
    }

    public static long getNotificationInterval() {
        long notificationInterval = kv.decodeLong(KEY_NOTIFICATION_INTERVAL) / 1000L;
        return notificationInterval;
    }

    public static void saveMsgInterval(long msgInterval) {
        // 存储数据
        kv.encode(KEY_MSG_INTERVAL, msgInterval);
    }

    public static long getMsgInterval() {
        long msgInterval = kv.decodeLong(KEY_MSG_INTERVAL) / 1000L;
        return msgInterval;
    }


    public static void savePictureDomain(String pictureDomain) {
        // 存储数据
        kv.encode(KEY_PICTURE_DOMAIN, pictureDomain);
    }

    public static String getPictureDomain() {
        String pictureDomain = kv.decodeString(KEY_PICTURE_DOMAIN);
        return pictureDomain;
    }

    public static void saveLockUserHeadDomain(String lockUserHeadDomain) {
        // 存储数据
        kv.encode(KEY_LOCK_USER_HEAD_DOMAIN, lockUserHeadDomain);
    }

    public static String getLockUserHeadDomain() {
        String lockUserHeadDomain = kv.decodeString(KEY_LOCK_USER_HEAD_DOMAIN);
        return lockUserHeadDomain;
    }

    public static void saveAppUserHeadDomain(String appUserHeadDomain) {
        // 存储数据
        kv.encode(KEY_APP_USER_HEAD_DOMAIN, appUserHeadDomain);
    }

    public static String getAppUserHeadDomain() {
        String appUserHeadDomain = kv.decodeString(KEY_APP_USER_HEAD_DOMAIN);
        return appUserHeadDomain;
    }

    public static void saveAccount(String account, String password) {
        // 存储数据
        kv.encode(KEY_ACCOUNT, account);
        kv.encode(KEY_PASSWORD, password);
    }

    public static String loadAccount() {

        return kv.decodeString(KEY_ACCOUNT);
    }

    public static String loadPassword() {

        return kv.decodeString(KEY_PASSWORD);
    }

    public static int getInt(String key, int defaultValue) {
        return kv.decodeInt(key, defaultValue);
    }

    public static void put(String key, Object value) {
        if (value == null) {
            value = "";
        }
        if (value instanceof String) {
            kv.encode(key, (String) value);
        } else if (value instanceof Integer) {
            kv.encode(key, (Integer) value);
        } else if (value instanceof Boolean) {
            kv.encode(key, (Boolean) value);
        } else if (value instanceof Float) {
            kv.encode(key, (Float) value);
        } else if (value instanceof Long) {
            kv.encode(key, (Long) value);
        }
    }

    public static void saveHomeId(Long homeId) {
        // 存储数据

        kv.encode(KEY_HOME_ID, homeId);
    }

    public static Long loadHomeId() {

        return kv.decodeLong(KEY_HOME_ID, -1);
    }

    public static void saveHomeName(String homeName) {
        kv.encode(KEY_HOME_NAME, homeName);
    }

    public static String loadHomeName() {
        return kv.decodeString(KEY_HOME_NAME, "我的家");
    }

    public static void saveDeviceId(int devicePosition) {
        // 存储数据
        kv.encode(KEY_DEVICE_ID, devicePosition);
    }

    public static String getHomeList() {
        return kv.decodeString("homelist", "");
    }

    public static void saveHomeList(String data) {
        // 存储数据
        kv.encode("homelist", data);
    }

    public static int getDeviceId() {
        return kv.decodeInt(KEY_DEVICE_ID, -1);
    }

    public static void saveDeviceNameAndType(String deviceName,int deviceType) {
        // 存储数据
        kv.encode(KEY_DEVICE_NAME, deviceName);
        kv.encode(KEY_DEVICE_TYPE, deviceType);
    }

    public static String getDeviceName() {
        return kv.decodeString(KEY_DEVICE_NAME, "添加设备");
    }

    public static int getDeviceType() {
        return kv.decodeInt(KEY_DEVICE_TYPE, -1);
    }

    public static void saveDeviceStatus(boolean isbol) {
        // 存储数据
        kv.encode("status", isbol);
    }

    public static Boolean getDeviceStatus() {
        return kv.decodeBool("status", true);
    }

    public static void saveUserLockID(Long userLockID) {
        // 存储数据
        String str;
        if (userLockID == null) {
            str = "";
        } else {
            str = String.valueOf(userLockID);
        }

        kv.encode(KEY_USER_LOCK_ID, str);
    }

    public static Long loadUserLockID() {
        String str = kv.decodeString(KEY_USER_LOCK_ID);
        if (TextUtils.isEmpty(str)) {
            return null;
        } else {
            return Long.valueOf(str);
        }
    }

    public static void savePortraitsUrl(String url) {
        // 存储数据
        kv.encode(KEY_USER_PORTRAITS_URL, url);
    }

    public static String loadPortraitsUrl() {

        return kv.decodeString(KEY_USER_PORTRAITS_URL);
    }

    public static void saveBleConnectAddr(String addr) {
        kv.encode(KEY_BLE_CONNECT_ADDR, addr);
    }

    public static String loadBleConnectAddr() {
        return kv.decodeString(KEY_BLE_CONNECT_ADDR);
    }

    public static void saveMD5Pwd(String pwd) {
        kv.encode(KEY_MD5_PWD, pwd);
    }

    public static String loadMD5Pwd() {
        return kv.decodeString(KEY_MD5_PWD);
    }

    public static void saveCheckedStatue(boolean ck) {
        kv.encode(KEY_CHECKED_PWD, ck);
    }

    public static boolean getCheckedStatue() {
        return kv.decodeBool(KEY_CHECKED_PWD);
    }

    public static void saveBindLockKinds(String kinds) {
        // 存储数据
        kv.encode(KEY_BIND_LOCK_KINDS, kinds);
    }

    public static String loadBindLockKinds() {

        return kv.decodeString(KEY_BIND_LOCK_KINDS);
    }

    public static void saveUserName(String userName) {
        kv.encode(KEY_USERNAME, userName);
    }

    public static String getUserName() {
        return kv.decodeString(KEY_USERNAME);
    }

    public static void saveBleLockId(long lockId) {
        kv.encode(KEY_BLE_NORMAL_LOCK_ID, lockId);
    }

    public static long getBleLockId() {
        return kv.decodeLong(KEY_BLE_NORMAL_LOCK_ID);
    }

    public static void saveGesturePwd(String gpwd) {
        kv.encode(KEY_GESTURE_PWD, gpwd);
    }

    public static String getGesturePwd() {
        return kv.decodeString(KEY_GESTURE_PWD);
    }

    public static void saveGesturePwdCopy(String gpwd) {
        kv.encode(KEY_GESTURE_PWD_COPY, gpwd);
    }

    public static String getGesturePwdCopy() {
        return kv.decodeString(KEY_GESTURE_PWD_COPY);
    }
}
