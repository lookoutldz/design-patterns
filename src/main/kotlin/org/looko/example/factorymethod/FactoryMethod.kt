package org.looko.example.factorymethod

/**
 * 工厂方法模式
 *
 * 挺普通的一模式，就如下所示
 *
 *      FactoryInterface
 *          FactoryA
 *          FactoryB
 *
 *      ProductInterface
 *          ProductA
 *          ProductB
 *
 * FactoryA 生产 ProductA，同理 B 也一样
 * 然后把创建对象的方法向上抽象一层就行了
 */
fun main() {
    val huaweiFactory = HuaweiFactory()
    val huawei = huaweiFactory.assemble()
    huawei.boot()

    val iphoneFactory = IphoneFactory()
    val iphone = iphoneFactory.assemble()
    iphone.boot()
}

// 手机组装代工厂
interface MobileFactory { fun assemble(): MobilePhone }
class HuaweiFactory: MobileFactory {
    override fun assemble(): MobilePhone {
        return HuaweiPhone()
    }
}
class IphoneFactory: MobileFactory {
    override fun assemble(): MobilePhone {
        return Iphone()
    }
}

interface MobilePhone { fun boot() }
class HuaweiPhone: MobilePhone {
    override fun boot() {
        println("HUAWEI")
    }
}
class Iphone: MobilePhone {
    override fun boot() {
        println("\uF8FF")
    }
}