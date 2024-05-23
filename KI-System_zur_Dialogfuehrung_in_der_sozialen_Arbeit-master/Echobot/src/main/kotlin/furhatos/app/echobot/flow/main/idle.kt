package furhatos.app.echobot.flow.main

import furhatos.flow.kotlin.*

val Idle: State = state {
    onEntry {
        if (furhat.isVirtual())
            goto(Greeting)
        else
            furhat.attendNobody()
    }

    onUserEnter {
        furhat.attend(it)
        goto(Greeting)
    }

}
