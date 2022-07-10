package ktorchat.lnight.plugins

import io.ktor.server.routing.*
import io.ktor.server.application.*
import ktorchat.lnight.room.RoomController
import ktorchat.lnight.routes.chatSocket
import ktorchat.lnight.routes.getAllMessages
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val roomController by inject<RoomController>()
    install(Routing){
        chatSocket(roomController)
        getAllMessages(roomController)
    }
}
