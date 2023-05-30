# Default Setting SpringBoot Project

### 🔥프로젝트 목적🔥
새 프로젝트 생성시 쉽게 시작할 수 있도록 디폴트 세팅된 프로젝트
  
  
### ✅버전 및 적용 항목
```
- SpringBoot 3.1.0
- gradle 7.6.1
- java 17

1. HikariCP Datasource Config
2. JPA & QueryDSL
3. p6spy custom
4. Member base entity
```

자세한 항목은 아래 `build.gradle` 참조

``` 
plugins {
    id 'java'
    id 'org.springframework.boot' version '3.1.0'
    id 'io.spring.dependency-management' version '1.1.0'
    id 'com.ewerk.gradle.plugins.querydsl' version '1.0.10'
}

group = 'com.complete.default-setting-springboot-java'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '17'

configurations {
    compileOnly {
        extendsFrom annotationProcessor
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.springframework.boot:spring-boot-starter-jdbc'
    implementation 'org.springframework.boot:spring-boot-starter-validation'

    // Querydsl
    implementation 'com.querydsl:querydsl-jpa:5.0.0:jakarta'
    annotationProcessor 'com.querydsl:querydsl-apt:5.0.0:jakarta'
    annotationProcessor "jakarta.annotation:jakarta.annotation-api"
    annotationProcessor "jakarta.persistence:jakarta.persistence-api"

    // p6spy
    implementation 'com.github.gavlyukovskiy:p6spy-spring-boot-starter:1.9.0'
    // mariadb
    implementation 'org.mariadb.jdbc:mariadb-java-client'

    compileOnly 'org.projectlombok:lombok'

    developmentOnly 'org.springframework.boot:spring-boot-devtools'

    runtimeOnly 'com.mysql:mysql-connector-j'

    annotationProcessor 'org.springframework.boot:spring-boot-configuration-processor'
    annotationProcessor 'org.projectlombok:lombok'

    testImplementation 'org.springframework.boot:spring-boot-starter-test'
}

tasks.named('test') {
    useJUnitPlatform()
}

def querydslDir = "$buildDir/generated/querydsl"

querydsl {
    jpa = true
    querydslSourcesDir = querydslDir
}

sourceSets {
    main.java.srcDir querydslDir
}

configurations {
    querydsl.extendsFrom compileClasspath
}
compileQuerydsl {
    options.annotationProcessorPath = configurations.querydsl
}
```
