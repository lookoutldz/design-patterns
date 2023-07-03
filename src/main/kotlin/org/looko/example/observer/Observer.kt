package org.looko.example.observer

/**
 * 观察者模式
 * 通俗地讲即为发布订阅模式
 * 主要角色有几个
 *      observer        subject
 * 理解上可以是
 *      subscriber      publisher
 * 亦或者是
 *      eventListener   eventManager
 */
fun main() {
    val gameNewsPublisher = ConcretePublisher()
    gameNewsPublisher.subscribe(ConcreteSubscriber("小明"))
    gameNewsPublisher.subscribe(ConcreteSubscriber("小红"))
    gameNewsPublisher.subscribe(ConcreteSubscriber("张三"))

    gameNewsPublisher.publish("GTA6将于2024年发布")
    gameNewsPublisher.publish("塞尔达传说王国之泪 将角逐今年年度最佳")
}

interface Subscriber { fun doSomething(context: String) }
class ConcreteSubscriber(private val subscriberName: String): Subscriber {
    override fun doSomething(context: String) {
        println("$subscriberName 收到了刚发布的 《$context》")
    }
}

interface Publisher {
    fun subscribe(subscriber: Subscriber)
    fun unSubscribe(subscriber: Subscriber)
    fun publish(context: String)
}
class ConcretePublisher: Publisher {
    private val subscribers: MutableCollection<Subscriber> = mutableListOf()
    override fun subscribe(subscriber: Subscriber) {
        subscribers.add(subscriber)
    }
    override fun unSubscribe(subscriber: Subscriber) {
        subscribers.remove(subscriber)
    }
    override fun publish(context: String) {
        for (subscriber in subscribers) {
            subscriber.doSomething(context)
        }
    }
}