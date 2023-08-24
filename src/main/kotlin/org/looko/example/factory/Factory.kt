package org.looko.example.factory

/**
 * 简单工厂模式
 * 最基础的工厂，可以看作是工厂方法模式的简化版
 */
fun main() {
    val factory = ConcreteMobileFactory()
    val iPhone = factory.assemble("\uF8FF")
    val huawei = factory.assemble("HUAWEI")

    iPhone.boot()
    huawei.boot()
}

// --------------以下是要制造的产品（在软件项目中就是要创建的类）--------------------
// 手机的行业标准规范
interface MobilePhone {
    // 品牌信息
    val brand: String
    // 能正常启动
    fun boot()
}

// -----------------------------以下是工厂------------------------------------
// 这是简单工厂的一个标准
interface MobileFactory {
    // 根据品牌组装不同手机
    fun assemble(mobileBrand: String): MobilePhone
}

// 这是根据标构建的工厂
class ConcreteMobileFactory: MobileFactory {
    override fun assemble(mobileBrand: String): MobilePhone {
        return object: MobilePhone {
            override val brand: String
                get() = mobileBrand

            override fun boot() {
                println(this.brand)
            }
        }
    }
}