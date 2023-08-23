package org.looko.example.abstractfactory


fun main() {
    val huaweiFactory = HuaweiFactory()
    val iphoneFactory = IphoneFactory()

    val mate30pro5g = huaweiFactory.assemblePhone()
    val iphone13mini = iphoneFactory.assemblePhone()
    mate30pro5g.boot()
    mate30pro5g.call114()
    iphone13mini.boot()
    iphone13mini.call114()

    val matebookx = huaweiFactory.assembleLaptop()
    val macbookpro = iphoneFactory.assembleLaptop()
    matebookx.boot()
    matebookx.runIDEA()
    macbookpro.boot()
    macbookpro.runIDEA()
}

// 综合组装代工厂规范
interface AssembleFactory {
    fun assemblePhone(): Product
    fun assembleLaptop(): Product
}
class HuaweiFactory: AssembleFactory {
    override fun assemblePhone(): MobilePhone {
        return MobilePhone("HUAWEI Mate30 Pro 5G")
    }

    override fun assembleLaptop(): Laptop {
        return Laptop("Matebook X")
    }

}
class IphoneFactory: AssembleFactory {
    override fun assemblePhone(): MobilePhone {
        return MobilePhone("\uF8FF")
    }

    override fun assembleLaptop(): Laptop {
        return Laptop("\uF8FF")
    }
}

// 组装产品的规范
interface Product {
    // 产品名称
    val name: String
}
class MobilePhone(override val name: String) : Product {
    fun boot() {
        println(name)
    }
    fun call114() {
        println("114...")
    }
}
class Laptop(override val name: String) : Product {
    fun boot() {
        println(name)
    }
    fun runIDEA() {
        println("Running IntelliJ IDEA... by $name")
    }
}