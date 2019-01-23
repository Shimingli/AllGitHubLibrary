# AllGitHubLibrary
* 这是我生成所有依赖的地方，后续要维护更新 

* tks [
GitHub+jitpack生成自己的Compile依赖](https://blog.csdn.net/DeMonliuhui/article/details/78066784) 提供的帮助
* 使用以上的上传的方式， 会导致aar引用不到第三方的依赖


* https://jitpack.io/#Shimingli/AllGitHubLibrary/1.0

* [
idea中terminal的配置](https://blog.csdn.net/fz13768884254/article/details/82761143)

```

implementation 'com.github.Shimingli:AllGitHubLibrary:1.0'
```

* RxBus中的依赖

```
    api  "com.jakewharton.rxrelay2:rxrelay:2.0.0"
    api 'io.reactivex.rxjava2:rxjava:2.2.2'
    api 'io.reactivex.rxjava2:rxandroid:2.1.0'
```



* 另外一种方式
* [
Android 快速发布开源项目到jcenter](https://blog.csdn.net/lmj623565791/article/details/51148825)




```
https://bintray.com/profile/edit  查看key的网址 


.\gradlew clean build bintrayUpload

```



* 终极参考[Android上传Library到Jcenter的坑与解](https://www.jianshu.com/p/65d8485b4d34)
License
-------

    Copyright 2014 Netflix, Inc.
    Copyright 2015 Jake Wharton
    Copyright 2019 Lishiming

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
