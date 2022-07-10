package ktorchat.lnight.data

import ktorchat.lnight.data.model.Message

interface MessageDataSource {

    suspend fun getAllMessages(): List<Message>

    suspend fun insertMessage(message: Message)

}