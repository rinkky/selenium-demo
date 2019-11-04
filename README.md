# selenium demo

以企业微信为例的selenium demo.

- 部门管理：增加/删除/移动/改名
- 素材库：上传
- 用Junit的参数化实现多语言测试

## 配置

用cookie登录，cookie配置文件为`/conf/seleniumdemo/cookie.conf`, 读取配置的代码在[App.loginWithCookie()](src/test/java/com/rinkky/seleniumdemo/page/App.java)

图片上传路径暂时写死在了[TestAssetPage](src/test/java/com/rinkky/seleniumdemo/testcase/TestAssetPage.java)
