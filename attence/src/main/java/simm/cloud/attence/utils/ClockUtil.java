package simm.cloud.attence.utils;

import java.util.Map;

/**
 * 考勤机工具
 */
public class ClockUtil {
    private final static String paramFormat = "%s=%s\n";
    /**
     * 获取服务端的配置参数
     * @param params
     * @return
     */
    public static String getServerParams(Map<String,String[]> params){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GET OPTION FROM:"+ params.get("SN")[0]+"\n");
        stringBuilder.append(wrapParam("ATTLOGStamp","None"));
        stringBuilder.append(wrapParam("OPERLOGStamp","None"));
        stringBuilder.append(wrapParam("ATTPHOTOStamp","None"));
        stringBuilder.append(wrapParam("ErrorDelay","30"));
        stringBuilder.append(wrapParam("Delay","10"));
        stringBuilder.append(wrapParam("TransTimes","00:00;14:05"));
        stringBuilder.append(wrapParam("TransInterval","1"));
        stringBuilder.append(wrapParam("TransFlag","TransData AttLog WORKCODE"));
        stringBuilder.append(wrapParam("TimeZone","8"));
        stringBuilder.append(wrapParam("Realtime","1"));
        stringBuilder.append(wrapParam("Encrypt","None"));
        return stringBuilder.toString();
    }

    /**
     * 数据组装
     * @param key
     * @param val
     * @return
     */
    private static String wrapParam(String key,String val){
        return String.format(paramFormat,key,val);
    }
}
