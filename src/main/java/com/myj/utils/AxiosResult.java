package com.myj.utils;

import java.util.HashMap;

public class AxiosResult extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    /** 状态码 */
    public static final String CODE_TAG = "code";

    /** 返回内容 */
    public static final String MSG_TAG = "msg";

    /** 数据对象 */
    public static final String DATA_TAG = "data";

    public AxiosResult(){

    }

    public AxiosResult(int code,String msg){
        super.put(CODE_TAG,code);
        super.put(MSG_TAG,msg);
    }

    public AxiosResult(int code){
        super.put(CODE_TAG,code);
    }

    public static AxiosResult success(int code){
        return new AxiosResult(code);
    }

    public static AxiosResult error(int code){
        return new AxiosResult(code);
    }
    /**
     * 方便链式调用
     *
     * @param key 键
     * @param value 值
     * @return 数据对象
     */
    @Override
    public AxiosResult put(String key, Object value)
    {
        super.put(key, value);
        return this;
    }

}
