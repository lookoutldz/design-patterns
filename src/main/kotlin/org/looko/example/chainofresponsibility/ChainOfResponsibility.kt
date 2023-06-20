package org.looko.example.chainofresponsibility

/**
 * 责任链模式
 * 常用于日志，业务审批等业务
 * 此处以请假审批为例
 */

fun main() {
    // 处理人上线
    val handler =
        GroupLeaderHandler("GroupLeader", 1,
            TeamLeaderHandler("TeamLeader", 5,
                DepartmentLeaderHandler("DepartmentLeader", 10,
                    CompanyLeaderHandler("Boss", 30,
                        FinalHandler()))))
    // 申请
    val a1 = LeaveApplication(1, "Ben", "Private", "Date a girl.")
    val a2 = LeaveApplication(2, "Ken", "Sick", "Have code.")
    val a3 = LeaveApplication(30, "Zen", "Travel", "For travel.")
    val a4 = LeaveApplication(60, "Hen", "Travel", "For travel.")
    // 处理
    handler.process(a1)
    handler.process(a2)
    handler.process(a3)
    handler.process(a4)
}

/** 申请
 *  * @param weight 申请权重，此案例中以日期表示权重
 *  * @param name 申请人
 *  * @param subject 申请主题
 *  * @param detail 详细信息
 */
interface ApplicationRequest {
    val weight: Int
    val name: String
    val subject: String
    val detail: String
}
// 处理
interface RequestHandler<T> { fun process(t: T) }

// 公式化的处理逻辑，抽一层
abstract class AbstractRequestHandler(
    private val handlerName: String,
    private val maxHandleWeight: Int,
    private val nextHandler: RequestHandler<ApplicationRequest>
): RequestHandler<ApplicationRequest> {
    override fun process(t: ApplicationRequest) {
        if (t.weight <= maxHandleWeight) {
            println("Request [${t.subject}] for [${t.weight}] day(s) from [${t.name}] has been approved by [$handlerName].")
        } else {
            println("Request [${t.subject}] for [${t.weight}] day(s) from [${t.name}] has been sent to next handler.")
            nextHandler.process(t)
        }
    }
}
// 兜底处理逻辑
class FinalHandler(): RequestHandler<ApplicationRequest> {
    override fun process(t: ApplicationRequest) {
        println("Request [${t.subject}] for [${t.weight}] day(s) from [${t.name}] has been rejected by System.")
    }
}

// 请假申请实体
data class LeaveApplication(
    override val weight: Int,
    override val name: String,
    override val subject: String,
    override val detail: String): ApplicationRequest
// 组内审批
class GroupLeaderHandler(handlerName: String, maxHandleWeight: Int, nextHandler: RequestHandler<ApplicationRequest>):
    AbstractRequestHandler(handlerName, maxHandleWeight, nextHandler)
// 团队审批
class TeamLeaderHandler(handlerName: String, maxHandleWeight: Int, nextHandler: RequestHandler<ApplicationRequest>):
    AbstractRequestHandler(handlerName, maxHandleWeight, nextHandler)
// 部门审批
class DepartmentLeaderHandler(handlerName: String, maxHandleWeight: Int, nextHandler: RequestHandler<ApplicationRequest>):
    AbstractRequestHandler(handlerName, maxHandleWeight, nextHandler)
// 公司审批
class CompanyLeaderHandler(handlerName: String, maxHandleWeight: Int, nextHandler: RequestHandler<ApplicationRequest>):
    AbstractRequestHandler(handlerName, maxHandleWeight, nextHandler)
