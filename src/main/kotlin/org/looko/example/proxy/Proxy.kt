package org.looko.example.proxy

/**
 * 代理模式
 * 本质作用：
 *      控制对象的访问(隐藏被访问对象)
 * 为何要控制对象访问：
 *      需要添加一层功能但不便修改原代码(比如需要延迟加载巨型对象，需要加log功能，加缓存功能等)
 * 常见场景:
 *      延迟初始化 （虚拟代理）
 *      访问控制 （保护代理）
 *      本地执行远程服务 （远程代理）
 *      记录日志请求 （日志记录代理）
 *      缓存请求结果 （缓存代理）
 */
fun main() {
    val service = ServiceLogProxy(ServiceImpl())
    service.doService()
}

interface Service { fun doService() }
class ServiceImpl: Service {
    override fun doService() {
        // 处理业务逻辑
    }
}

class ServiceLogProxy(private val target: Service): Service {
    override fun doService() {
        println("处理业务逻辑开始")
        target.doService()
        println("处理业务逻辑结束")
    }
}
