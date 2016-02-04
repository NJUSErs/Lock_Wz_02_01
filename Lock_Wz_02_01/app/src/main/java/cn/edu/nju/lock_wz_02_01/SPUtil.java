package cn.edu.nju.lock_wz_02_01;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * SP存储工具类
 * Created by xrc on 2015/12/30.
 */
public class SPUtil {


    private static SharedPreferences sp;

    private static SPUtil instance;

    private SPUtil() {
    }

    public static SPUtil getInstance(Context context) {
        if (instance == null) {
            instance = new SPUtil();
            sp = context.getSharedPreferences("logistics", Context.MODE_PRIVATE);
        }
        return instance;
    }

    /**
     * 保存数据
     */
    public void save(String key, Object value) {
        if (value instanceof String) {
            sp.edit().putString(key, (String) value).apply();
        } else if (value instanceof Integer) {
            sp.edit().putInt(key, (Integer) value).apply();
        } else if (value instanceof Boolean) {
            sp.edit().putBoolean(key, (Boolean) value).apply();
        }
    }

    /**
     * 读取数据
     */
    public <T> T get(String key, T defaultValue) {

        if (defaultValue == null || defaultValue instanceof String) {
            return (T) sp.getString(key, (String) defaultValue);
        } else if (defaultValue instanceof Integer) {
            Integer value = sp.getInt(key, (Integer) defaultValue);
            return (T) value;
        } else if (defaultValue instanceof Boolean) {
            Boolean value = sp.getBoolean(key, (Boolean) defaultValue);
            return (T) value;
        }
        return null;
    }

    /**
     * 删除数据
     */
    public void remove(String key) {
        sp.edit().remove(key).apply();
    }

}
