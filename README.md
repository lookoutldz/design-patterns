# Design Patterns

**用最通俗易懂的案例诠释常用设计模式**



接口 = 规范

抽象类 = 规范的具象化

普通类 = 遵循规范的运作者

## 目录

打勾表示已实现

若实现上无语言特性上的差别则优先选择 Kotlin 实现

否则 Java 与 Kotlin 版本均实现一遍

- [x] 单例模式 Singleton ([java](./src/main/java/org/looko/example/singleton/ThreadSafeSingleton.java) / [kotlin](./src/main/kotlin/org/looko/example/singleton/ThreadSafeSingletonKt.kt))
- [x] 责任链模式 ChainOfResponsibility ([java](./src/main/java/org/looko/example/chainofresponsibility/ChainOfResponsibility.java) / [kotlin](./src/main/kotlin/org/looko/example/chainofresponsibility/ChainOfResponsibility.kt))
- [x] 适配器模式 Adapter ([java](./src/main/java/org/looko/example/adapter/Adapter.java) / [kotlin](./src/main/kotlin/org/looko/example/adapter/Adapter.kt))
- [x] 桥接模式 Bridge ([java](./src/main/java/org/looko/example/bridge/Bridge.java) / [kotlin](./src/main/kotlin/org/looko/example/bridge/Bridge.kt))
- [ ] 组合模式 Composite ([java](./src/main/java/org/looko/example/composite/Composite.java) / [kotlin](./src/main/kotlin/org/looko/example/composite/Composite.kt))
- [x] 装饰器模式 Decorator ([java](./src/main/java/org/looko/example/decorator/Decorator.java) / [kotlin](./src/main/kotlin/org/looko/example/decorator/Decorator.kt))
- [ ] 外观模式 Facade ([java](./src/main/java/org/looko/example/facade/Facade.java) / [kotlin](./src/main/kotlin/org/looko/example/facade/Facade.kt))
- [x] 工厂方法模式 Factory Method ([java](./src/main/java/org/looko/example/factorymethod/FactoryMethod.java) / [kotlin](./src/main/kotlin/org/looko/example/factorymethod/FactoryMethod.kt))
- [ ] 原型模式 Prototype ([java](./src/main/java/org/looko/example/prototype/Prototype.java) / [kotlin](./src/main/kotlin/org/looko/example/prototype/Prototype.kt))
- [ ] 享元模式 Flyweight ([java](./src/main/java/org/looko/example/flyweight/Flyweight.java) / [kotlin](./src/main/kotlin/org/looko/example/flyweight/Flyweight.kt))
- [x] 代理模式 Proxy ([java](./src/main/java/org/looko/example/proxy/Proxy.java) / [kotlin](./src/main/kotlin/org/looko/example/proxy/Proxy.kt))
- [ ] 模板方法模式 Template Method ([java](./src/main/java/org/looko/example/template/TemplateMethod.java) / [kotlin](./src/main/kotlin/org/looko/example/template/TemplateMethod.kt))
- [x] 策略模式 Strategy ([java](./src/main/java/org/looko/example/strategy/Strategy.java) / [kotlin](./src/main/kotlin/org/looko/example/strategy/Strategy.kt))
- [ ] 命令模式 Command ([java](./src/main/java/org/looko/example/command/Command.java) / [kotlin](./src/main/kotlin/org/looko/example/command/Command.kt))
- [ ] 迭代器模式 Iterator ([java](./src/main/java/org/looko/example/iterator/Iterator.java) / [kotlin](./src/main/kotlin/org/looko/example/iterator/Iterator.kt))
- [x] 观察者模式 Observer ([java](./src/main/java/org/looko/example/observer/Observer.java) / [kotlin](./src/main/kotlin/org/looko/example/observer/Observer.kt))
- [ ] 中介者模式 Mediator ([java](./src/main/java/org/looko/example/mediator/Mediator.java) / [kotlin](./src/main/kotlin/org/looko/example/mediator/Mediator.kt))
- [ ] 备忘录模式 Memento ([java](./src/main/java/org/looko/example/memento/Memento.java) / [kotlin](./src/main/kotlin/org/looko/example/memento/Memento.kt))
- [ ] 解释器模式 Interpreter ([java](./src/main/java/org/looko/example/interpreter/Interpreter.java) / [kotlin](./src/main/kotlin/org/looko/example/interpreter/Interpreter.kt))
- [ ] 访问者模式 Visitor ([java](./src/main/java/org/looko/example/visitor/Visitor.java) / [kotlin](./src/main/kotlin/org/looko/example/visitor/Visitor.kt))
- [ ] 状态模式 State ([java](./src/main/java/org/looko/example/state/State.java) / [kotlin](./src/main/kotlin/org/looko/example/state/State.kt))
- [x] 构造者模式 Builder ([java](./src/main/java/org/looko/example/builder/Builder.java) / [kotlin](./src/main/kotlin/org/looko/example/builder/Builder.kt))

## 心得

但凡写过几年代码的，大多数人其实哪怕不知道某个设计模式，也可能在无意用使用过了。

因为不论什么模式，其核心是相通的，就是让代码更加符合软件设计原则

但如果是系统性学习设计模式的话，一板一眼的设计模式非常无趣，
如果把设计模式当成开箱即用的工具，那情况会有所不同。
这也是为什么会将设计模式进行分类的一个原因。

写代码（尤其是 Java 这样的面向对象的代码）无非有以下几种情况：

1. 管理对象创建
2. 管理数据结构
3. 管理运行逻辑

这也是设计模式对应的三大类：

1. 创建型模式
   * 工厂方法
   * 抽象工厂
   * 单例
   * 原型
2. 结构型模式
   * 适配器
   * 桥接
   * 组合
   * 装饰
   * 外观
   * 享元
   * 代理
3. 行为型模式
   * 责任链
   * 命令
   * 迭代器
   * 中介者
   * 备忘录
   * 观察者
   * 状态
   * 策略
   * 模板方法
   * 访问者

只要在平时写代码中保持一种敏感性，时刻将当下要写或在写的代码做一个类型鉴别，
是对象创建，数据结构，还是业务逻辑。 
当有所区分后，就可以考虑是否有对应的设计模式来处理当下的代码。

习惯以后，设计模式本身也就不太需要再特地提起了，
无论面对什么复杂的业务情况，都能像武林高手一样见招拆招。
