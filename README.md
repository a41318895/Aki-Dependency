<div align="center"> 
    <h2>自用依賴  aki-common-util-starter</h2> 
</div>
<p align="center">
   <a target="_blank" href="https://github.com/X1192176811/blog">
      <img src="https://img.shields.io/badge/JDK-17-red" alt=""/>
      <img src="https://img.shields.io/badge/log4j2-2.22.1-red" alt=""/>
   </a>
</p>

## 導入方式 :
### 一、導入依賴本體 :
```
<dependency>
    <groupId>com.akichou</groupId>
    <artifactId>aki-common-util-starter</artifactId>
    <version>1.0.0</version>
</dependency>
```
### 二、移除 SpringBoot 默認 Logback 框架 :
由於此自定義依賴基於的紀錄框架為 Log4j2, 所以需要移除 SpringBoot 默認的 Logback 框架, 否則會出現配置無法加載的問題。
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
    <exclusions>
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-logging</artifactId>
        </exclusion>
    </exclusions>
</dependency>

```
