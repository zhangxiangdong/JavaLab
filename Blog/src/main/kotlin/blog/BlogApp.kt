package blog

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.features.DefaultHeaders
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get

/**
 * Created by Zhang on 3/25/2018 4:07 PM.
 */
@Suppress("unused")
fun Application.main() {
    install(DefaultHeaders)
    install(CallLogging)
    @Suppress("EXPERIMENTAL_FEATURE_WARNING")
    install(Routing) {
        get("/") {
            val port = this@install.application.environment.config.propertyOrNull("ktor.deployment.port")?.getString()
                    ?: "null"
            call.respondText("Hello World!\n port: $port", ContentType.Text.Plain)
        }
        get("/demo") {
            call.respondText("HELLO WORLD!")
        }
    }
}