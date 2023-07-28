package com.mua;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ASUS XuWei
 * @Since: 2023-07-28 上午 11:09
 * @Comment: 测试类
 */
@RestController
@RequestMapping("getIp")
public class TestController {

    @GetMapping
    public Map<String,Object> getIp(HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        String ip = IpAddressUtil.getIpAddress(request);
        String ipSource = IpAddressUtil.getIpSource(ip);
        Map<String, String> map = UserAgentUtils.parseOsAndBrowser(request.getHeader("User-Agent"));
        result.put("ip",ip);
        result.put("ipSource",ipSource);
        result.put("type",map);
        return result;
    }
}
