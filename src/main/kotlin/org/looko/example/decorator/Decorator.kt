package org.looko.example.decorator

/**
 * 装饰器模式
 * 就像穿衣服一样，随意搭配喜欢的方式，但核心都是身体
 */
fun main() {
    val message = "明天不用上班！"
    // 发个邮件通知一下
    val baseNotifier = BaseNotifier()
    val emailNotifier = EmailNotifier(baseNotifier)
    emailNotifier.notify(message)
    // 怕大家不看邮件，QQ 和电话也通知一遍
    val qqDecorator = QQDecorator(baseNotifier)
    val phoneNotifier = PhoneNotifier(qqDecorator)
    phoneNotifier.notify(message)
}

interface Notifier { fun notify(message: String) }

class BaseNotifier: Notifier {
    override fun notify(message: String) {
        println("消息记录存档：$message")
    }
}
class EmailNotifier(private val notifier: Notifier): Notifier {
    override fun notify(message: String) {
        notifier.notify(message)
        println("通过邮件通知员工：$message")
    }
}
class QQDecorator(private val notifier: Notifier): Notifier {
    override fun notify(message: String) {
        notifier.notify(message)
        println("通过QQ通知员工：$message")
    }
}
class PhoneNotifier(private val notifier: Notifier): Notifier {
    override fun notify(message: String) {
        notifier.notify(message)
        println("通过电话通知员工：$message")
    }
}