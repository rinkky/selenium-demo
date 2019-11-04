# selenium demo

以企业微信为例的selenium demo.

- 部门管理测试：增加/删除/移动/改名
- 素材库测试：上传
- 用Junit的参数化实现多语言测试

## 配置

用cookie登录，cookie配置文件为`/conf/seleniumdemo/cookie.conf`, 读取配置的代码在[App.loginWithCookie()](src/test/java/com/rinkky/seleniumdemo/page/App.java)

图片上传路径暂时写死在了[TestAssetPage](src/test/java/com/rinkky/seleniumdemo/testcase/TestAssetPage.java)

## 主要目录

- page
    - [BasePage](src/test/java/com/rinkky/seleniumdemo/page/BasePage.java)
    - [App](src/test/java/com/rinkky/seleniumdemo/page/App.java)
    - [AssetPage](src/test/java/com/rinkky/seleniumdemo/page/AssetPage.java)
    - [ContactsPage](src/test/java/com/rinkky/seleniumdemo/page/ContactsPage.java)
- testcase
    - [MultiLanguageCase](src/test/java/com/rinkky/seleniumdemo/testcase/MultiLanguageCase.java)
    - [TestAssetPage](src/test/java/com/rinkky/seleniumdemo/testcase/TestAssetPage.java)
    - [TestDepartmentManagement](src/test/java/com/rinkky/seleniumdemo/testcase/TestDepartmentManagement.java)
