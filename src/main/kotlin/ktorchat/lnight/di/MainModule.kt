package ktorchat.lnight.di


import ktorchat.lnight.data.MessageDataSource
import ktorchat.lnight.data.MessageDataSourceImpl
import ktorchat.lnight.room.RoomController
import org.koin.dsl.module
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo


val mainModule = module {
    single {
        KMongo.createClient()
            .coroutine
            .getDatabase("message_db")
    }
    single<MessageDataSource> {
        MessageDataSourceImpl(get())
    }
    single {
        RoomController(get())
    }
}