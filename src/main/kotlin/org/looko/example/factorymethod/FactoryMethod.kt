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

// 手机组装代工厂的工厂规范(要提供一个组装的方法)
interface MobileFactory { fun assemble(): MobilePhone }

// 实际的工厂
class HuaweiFactory: MobileFactory {
    override fun assemble(): MobilePhone {
        return HuaweiPhone("HUAWEI")
    }
}
class IphoneFactory: MobileFactory {
    override fun assemble(): MobilePhone {
        return Iphone("\uF8FF")
    }
}

// 手机的行业标准规范
interface MobilePhone {
    // 品牌信息
    val brand: String
    // 能正常启动
    fun boot()
}
// 手机的通用逻辑(如启动时显示自家品牌信息)
abstract class AbstractMobilePhone: MobilePhone {
    override fun boot() {
        println(brand)
    }
}
// 实际的手机
class HuaweiPhone(override val brand: String) : AbstractMobilePhone()
class Iphone(override val brand: String) : AbstractMobilePhone()