package cn.springhub.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import sun.nio.cs.UTF_8;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 *  序列化工具类
 * @author A.I.
 * @createAt 2019/12/14 15:54
**/
public class SerializerUtils {

    /**
     *  将对象序列化成字节数组
     * @param obj
     * @return
     */
    public static byte[] serialize(Object obj) {
        if(obj == null) {
            return new byte[0];
        }

        if(obj instanceof byte[]) {
            // 如果对象本身就是字节数组，直接返回
            return (byte[]) obj;
        } else if(obj instanceof String) {
            try {
                return ((String) obj).getBytes("UTF-8");
            } catch (UnsupportedEncodingException e) {
                // ignore
            }
        }

        return JSON.toJSONBytes(obj, SerializerFeature.WriteClassName);
    }

    /**
     *  将字节数组反序列化成对象
     * @param obj
     * @return
     */
    public static Object deSerialize(byte[] obj) {
        if(obj == null || obj.length == 0) {
            return null;
        }

        return JSON.parse(obj);
    }
}
