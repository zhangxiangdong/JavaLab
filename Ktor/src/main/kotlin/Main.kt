import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.features.DefaultHeaders
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

/**
 * Created by Zhang on 3/25/2018 4:07 PM.
 */
fun main(args: Array<String>) {
    val server = embeddedServer(Netty, port = 8080, module = Application::module)
    server.start(wait = true)
}

fun Application.module() {
    install(DefaultHeaders)
    install(CallLogging)
    @Suppress("EXPERIMENTAL_FEATURE_WARNING")
    install(Routing) {
        get("/") {
            call.respondText("Hello World!", ContentType.Text.Plain)
        }
        get("/demo") {
            call.respondText("HELLO WORLD!")
        }
    }
}