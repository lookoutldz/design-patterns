package org.looko.example.strategy

/**
 * 策略模式
 *
 * 核心在于将不同的算法放入不同的类中进行解耦
 *
 * 网上有不少内容说用策略模式优化掉 if-else，我认为这种说法不正确(或者说有误导，不准确)
 * 因为策略模式并不能减少决策时所需要的判断
 *
 * 你可以用 策略+工厂 达到去除 if-else 的结果，也可以用 HashMap 的过滤式选择以达到去掉 if-else 的结果，
 * 但这不是策略模式本身的功能
 *
 * 策略模式的工作重点在于将 if-else 内的冗长逻辑剥离出来以方便维护
 * 而这个 if-else 也可以从主干代码中抽到 Context 里
 * 说到底，只是把 if-else 换了个位置 or 换了种形式
 *
 */
fun main() {
    // 需要选择哪个策略，客户端需要有自己的意见
    val context = CalPriceContext(100.0, PlatinumStrategy())
    context.executeStrategy()

    context.price = 100.0 * 2
    context.vipStrategy = GoldStrategy()
    context.executeStrategy()
}

interface VipStrategy { fun discount(price: Double): Double }

class PlatinumStrategy: VipStrategy {
    override fun discount(price: Double): Double {
        return price * 0.6
    }
}
class GoldStrategy: VipStrategy {
    override fun discount(price: Double): Double {
        return price * 0.7
    }
}
class SilverStrategy: VipStrategy {
    override fun discount(price: Double): Double {
        return price * 0.8
    }
}
class BronzeStrategy: VipStrategy {
    override fun discount(price: Double): Double {
        return price * 0.9
    }
}

class CalPriceContext(var price: Double, var vipStrategy: VipStrategy) {
    fun executeStrategy() {
        println(String.format("Total Amount: %.2f", vipStrategy.discount(price)))
    }
}
