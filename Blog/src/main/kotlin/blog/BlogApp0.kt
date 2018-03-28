package blog

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

/**
 * Created by zhangxiangdong on 2018/3/26 11:46.
 */
fun main(args: Array<String>) {
    embeddedServer(
            Netty,
            configure = {
                requestQueueLimit = 16
                shareWorkGroup = false
                configureBootstrap = {

                }
                responseWriteTimeoutSeconds = 10
            },
            port = 8080,
            watchPaths = listOf("java-lab/Blog"),
            module = Application::module
    ).start(true)
}

fun Application.module() {
    routing {
        get("/") {
            call.respondText("Hello World!", ContentType.Text.Plain)
        }
        get("/demo") {
            call.respondText("HELLO WORLD!")
        }
    }
}