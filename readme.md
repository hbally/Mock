##  本地搭建服务器，测试api接口

####1. 引用工程

     compile project(':androidstubserver')
    
    or
    
    compile 'com.byoutline.androidstubserver:stubserver:2.0.0-SNAPSHOT'
    
    
####2. 在assets目录下配置api接口，主要是config.json;
```java {
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
        ...
```

####3. Application 中初始化
  `AndroidStubServer.start(this, NetworkType.UMTS);`

####4. 处理http GET,请求无差别

## License
```text
 Copyright 2016 li yao

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
```