# AppiumCrossPlataformTestsWithJava

Appium testing **Android**, **IOS** and **Web** using selenium grid.

## Required to run this project

- *Java (used version 8)*
- *Appium*
- *Node*
- *Android Emulator*
- *Maven*
- *MacOS*
- *Xcode*

## Set your configuration

1. To run this project you need to change some files to your configuration!
2. Set your own capabilities in all java test files :
 **TestAndroidCalculator.java** ,
 **TestIosCalculator.java** and
 **TestWebCalculator.java**
3. Go to directory **nodes-config/** and change node capabilities :
**android-node.json** and
**ios-node.json**
4. Configure script **start-all-config.sh**, just change ports if you need and android emulator directory and name.

## Run Test

- Run script **start-all-config.sh** to start hub, nodes and android emulator :

```
$ ./start-all-config.sh
```

- Run tests :

```
$ mvn clean test
```

- Generete evidences with allure :

```
$ mvn allure:serve
```

## Docs and Libs

- Appium: http://appium.io/downloads.html
- Allure: https://github.com/allure-framework/allure2
- Surefire: http://maven.apache.org/surefire/maven-surefire-plugin/examples/junit.html
- Selenium Grid: https://www.seleniumhq.org/docs/07_selenium_grid.jsp
