package org.looko.example.builder

/**
 * 建造者模式
 */
fun main() {
    // 来一份 KFC 套餐
    val kfcDinnerCombo1 = KfcDinnerComboBuilder()
        .combo1(Hamburger())
        .combo2(Taco())
        .combo3(Cola())
        .build()

    println(kfcDinnerCombo1)

    // 没吃饱，再来一份
    val kfcDinnerCombo2 = KfcDinnerComboBuilder()
        .combo1(Pizza())
        .combo2(FrenchFries())
        .combo3(OrangeJuice())
        .build()

    println(kfcDinnerCombo2)
}

class KfcDinnerCombo {
    lateinit var combo1: Eat
    lateinit var combo2: Eat
    lateinit var combo3: Drink
    override fun toString(): String {
        return "[${combo1::class.java.simpleName},${combo2::class.java.simpleName},${combo3::class.java.simpleName}]"
    }
}

interface Eat
class Hamburger(): Eat
class Pizza(): Eat
class FrenchFries(): Eat
class Taco(): Eat

interface Drink
class Coffee(): Drink
class Cola(): Drink
class OrangeJuice(): Drink

class KfcDinnerComboBuilder {
    private val kfcDinnerCombo: KfcDinnerCombo = KfcDinnerCombo()
    fun combo1(eat: Eat): KfcDinnerComboBuilder {
        kfcDinnerCombo.combo1 = eat
        return this
    }
    fun combo2(eat: Eat): KfcDinnerComboBuilder {
        kfcDinnerCombo.combo2 = eat
        return this
    }
    fun combo3(drink: Drink): KfcDinnerComboBuilder {
        kfcDinnerCombo.combo3 = drink
        return this
    }
    fun build(): KfcDinnerCombo {
        return kfcDinnerCombo
    }
}