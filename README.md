# springboot3 spring-security rbac jwt 脚手架

> ### 这是一个基于RBAC模型、JWT认证、SpringDOC，结合Spring Boot3和Spring Security的项目开发脚手架。

之前是做算法的，某日领导让我写个web后端顶一顶，就用python flask写了一个。后来时间比较充分就学了学Java，现在用最新的SpringBoot3搭建了脚手架，以备自己之后的不时之需。
有了这个脚手架之后，大部分情况下只要专注于业务逻辑的开发就可以了。

## 一、RBAC模型介绍

* *RBAC是Role-Based Access Control的缩写，意思就是基于角色的权限访问控制。*

**基本思想：** 对系统的各种权限不是直接授予具体的用户，而是在用户集合与权限集合之间建立一个角色集合。每一种角色对应一组相应的权限。一旦用户被分配了适当的角色后，该用户就拥有此角色的所有操作权限。 同样用户被分配了多个适当的角色，那么该用户就拥有了被分配多个角色的所有权限。

**优点：** 不必在每次创建用户时都进行分配权限的操作，只要分配用户相应的角色即可，而且角色的权限变更比用户的权限变更要少得多，这样将**简化**用户的权限管理，减少系统的开销。



---------

## 二、项目思想
本项目将对用户、角色、权限三者之间的关联状态概念交给系统管理员与数据库，对外依然具有RBAC的概念。但是在项目的权限管理中，项目只维护用户与权限的关系。
* 当用户登录成功后立即在数据库查询该用户所具有的角色，再根据所拥有的角色查询对应的权限——然后将这些权限赋予用户。
* 该项目的所有接口都是基于权限级别的身份校验，而非角色级别的身份校验。
* **优点：** 节省了对用户与角色、角色与权限之间关系的维护，对身份与接口之间的校验细化程度高，粒度级小。

---------

## 三、项目技术架构
* [ ]  **开发工具：** Maven（项目构建管理）
* [ ]  **开发环境：** JDK18、MySql8.0.32
* [ ]  **技术选型** ——
- 核心框架：SpringBoot 3.0.4.RELEASE
- 安全框架：SpringSecurity 3.0.4.RELEASE
- 持久层框架：Mybatis-Plus 3.5.3.1
- API构建工具：Springdoc 2.0.4

---------

## 四、需求说明
1. 一个用户可以拥有多个角色，该用户需拥有这些角色所具有权限的并集。
2. 权限的控制在于两方面——前端目录菜单的展示、后端接口的访问拦截。
3. 用户登录成功后立即返回该用户可访问的菜单结构。
4. 有JWT认证、有SpringDOC openAPI文档支持

## 五、获取详细支持
帮助你将项目完整跑起来（50元），您将会获得数据库构建文件、项目结构说明等。（适合毕业生等，老鸟肯定看看就会了）
VX： lu161513
