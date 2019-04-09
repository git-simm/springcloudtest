package simm.cloud.attence.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import simm.cloud.attence.utils.ClockUtil;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/iclock")
public class IClockController {
    private final static Logger logger = LoggerFactory.getLogger(IClockController.class);

    /**
     * push协议 数据交互
     * @return
     */
    @RequestMapping(value = "cdata",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String cdata(HttpServletRequest request,@RequestBody(required = false) String body){
        String msg = "cdata running.....";
        logger.info(request.getRequestURI()+"?"+request.getQueryString());
        Map<String,String[]> params = request.getParameterMap();
        if(params.containsKey("options")){
            logger.info("设备从服务器上读取配置信息");
            String content = ClockUtil.getServerParams(params);
            return content;
        }
        logger.info("设备提交考勤数据，开始解析...");
        if(params.containsKey("table")){
            String table = params.get("table")[0];
            String[] data = body.split("\\t");
            System.out.println(data);
            logger.info(body);
        }
        return "OK";
    }

    /**
     * push协议获取服务器的操作命令
     * @return
     */
    @RequestMapping(value = "getrequest",method = RequestMethod.GET)
    @ResponseBody
    public String getrequest(){
        return "OK";
    }
    /**
     * push协议服务端接收到返回结果后，做出响应
     * @return
     */
    @RequestMapping(value = "devicecmd",method = RequestMethod.GET)
    @ResponseBody
    public String devicecmd(){
        return "OK";
    }
}
