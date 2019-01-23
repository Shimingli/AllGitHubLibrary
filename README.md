# AllGitHubLibrary
* 这是我生成所有依赖的地方，后续要维护更新 
* 目前依赖的项目 

| 项目名 | 文档说明 |源码 | Demo |最新版本|
| :------| ------: | :------: | :------: | :------: |
| 基于Glide4.7.1二次封装 | [基于Glide4.7.1二次封装](https://www.jianshu.com/p/aecd92515cea) | [源码](https://github.com/Shimingli/ImageLoader) | 无 | 发布中|
| rxbus | [rxbus](https://www.jianshu.com/u/a58eb984bda4) | [源码](https://github.com/Shimingli/AllGitHubLibrary/tree/master/rxbuslibrary) | 无 | 发布中|




```
    api 'com.lsm.test:test:1.0.1'
    api 'com.lsm.maven:rxbuslibrary:1.0.1'
    api 'com.lsm.maven:imageloader:1.0.0'

```

* tks [
GitHub+jitpack生成自己的Compile依赖](https://blog.csdn.net/DeMonliuhui/article/details/78066784) 提供的帮助
* 使用以上的上传的方式， 会导致aar引用不到第三方的依赖


* https://jitpack.io/#Shimingli/AllGitHubLibrary/1.0

* [
idea中terminal的配置](https://blog.csdn.net/fz13768884254/article/details/82761143)



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





```

gradlew clean build bintrayUpload -PbintrayUser=shimingli  -PbintrayKey=636e4efc45ad6cc33c2d60ce73c0fedda6ea463d -PbryRun=false

> Task :app:lint 
Ran lint on variant release: 10 issues found
Ran lint on variant debug: 10 issues found
Wrote HTML report to file:///E:/Android/2019_Worck_Space/AllGitHubLibrary/app/build/reports/lint-results.html
Wrote XML report to file:///E:/Android/2019_Worck_Space/AllGitHubLibrary/app/build/reports/lint-results.xml

> Task :test:javadoc 
E:\Android\2019_Worck_Space\AllGitHubLibrary\test\src\main\java\com\lsm\test\TestUtils.java:9: 警告: <p> 标记为空
 * </p>
   ^
1 个警告

> Task :test:lint 
Ran lint on variant release: 1 issues found
Ran lint on variant debug: 1 issues found
Wrote HTML report to file:///E:/Android/2019_Worck_Space/AllGitHubLibrary/test/build/reports/lint-results.html
Wrote XML report to file:///E:/Android/2019_Worck_Space/AllGitHubLibrary/test/build/reports/lint-results.xml

> Task :test:bintrayUpload 
Uploading to https://api.bintray.com/content/lishiming/maven/test/1.0.1/com/lsm/test/test/1.0.1/test-1.0.1.pom...
Uploaded to 'https://api.bintray.com/content/lishiming/maven/test/1.0.1/com/lsm/test/test/1.0.1/test-1.0.1.pom'.
Uploading to https://api.bintray.com/content/lishiming/maven/test/1.0.1/com/lsm/test/test/1.0.1/test-1.0.1-javadoc.jar...
Uploaded to 'https://api.bintray.com/content/lishiming/maven/test/1.0.1/com/lsm/test/test/1.0.1/test-1.0.1-javadoc.jar'.
Uploading to https://api.bintray.com/content/lishiming/maven/test/1.0.1/com/lsm/test/test/1.0.1/test-1.0.1-sources.jar...
Uploaded to 'https://api.bintray.com/content/lishiming/maven/test/1.0.1/com/lsm/test/test/1.0.1/test-1.0.1-sources.jar'.
Uploading to https://api.bintray.com/content/lishiming/maven/test/1.0.1/com/lsm/test/test/1.0.1/test-1.0.1.aar...
Uploaded to 'https://api.bintray.com/content/lishiming/maven/test/1.0.1/com/lsm/test/test/1.0.1/test-1.0.1.aar'.


BUILD SUCCESSFUL in 5m 34s
127 actionable tasks: 123 executed, 4 up-to-date
E:\Android\2019_Worck_Space\AllGitHubLibrary>


```














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
