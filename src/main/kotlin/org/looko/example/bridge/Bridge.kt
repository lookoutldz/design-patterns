package org.looko.example.bridge

/**
 * 桥接模式
 *
 * 优点：1. 虚实分离 2. 扩展优秀 3. 细节透明
 * 缺点：抽象层设计难度增加
 *
 * 用于多个独立变化的维度的整合十分有效
 * 将 m * n 数量的类变成 m + n 数量的类
 *      如下面的例子，红色，蓝色，黑色，圆，三角形共 3 + 2 个类
 *      可以实现 红圆，蓝圆，黑圆，红三角形，蓝三角形，黑三角形 3 * 2 个类的效果
 *
 * 桥接的部分是使用组合来做的，组合了颜色维度作为属性
 */
fun main() {
    // 画个红色的圆
    Circle(Red()).draw()
    // 画个蓝色的三角形
    Triangle(Blue()).draw()
    // 画个黑色的三角形
    Triangle(Black()).draw()
}

internal interface Shape {
    val shapeName: String
    fun draw()
}
internal class Circle(private val color: Color): Shape {
    override val shapeName = "圆"
    override fun draw() {
        println("画出了${color.colorName}色的$shapeName")
    }
}
internal class Triangle(private val color: Color): Shape {
    override val shapeName = "三角形"
    override fun draw() {
        println("画出了${color.colorName}色的$shapeName")
    }
}

internal interface Color { val colorName: String }
internal class Blue: Color {
    override val colorName = "蓝"
}
internal class Red: Color {
    override val colorName = "红"
}
internal class Black: Color {
    override val colorName = "黑"
}
