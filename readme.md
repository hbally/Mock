##本地搭建服务器，测试api接口

1. 引用工程

    ` compile project(':androidstubserver')`

    或者

    `compile 'com.byoutline.androidstubserver:stubserver:2.0.0-SNAPSHOT'`
2. 在assets目录下配置api接口，主要是config.json;


   >{
      "requests": [
        {
          "method": "GET",
          "path": {
            "base": "/v1/discover",
            "queries matching method": "EXACT",
            "queries":
            {
              "client_id": ".*"
            }
          },
          "response file": "discover.json"
        },

   3. Application中初始化

> AndroidStubServer.start(this, NetworkType.UMTS);


   4.处理http GET,请求无差别