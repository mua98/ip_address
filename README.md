# ip_address
✌️获取客户端IP及地址

## Demo
### 演示地址： [api.mua98.top/api/getIp](api.mua98.top/api/getIp)

###返回数据：
~~~
{
    "ip": "54.254.249.187",
    "ipSource": "新加坡|亚马逊",
    "type": {
        "os": "Windows NT ??",
        "browser": "Chrome 115"
    }
}
~~~

## Config

###nginx配置
~~~shell
server {
    listen  80;
    server_name  localhost;

    location /api/ {
    proxy_pass http://127.0.0.1:8084;
    #重点
    proxy_set_header   Host             $host;
    proxy_set_header   X-Real-IP        $remote_addr;
    proxy_set_header   X-Forwarded-For  $proxy_add_x_forwarded_for;
    }
}
~~~
###访问地址：localhost/api/getIp
