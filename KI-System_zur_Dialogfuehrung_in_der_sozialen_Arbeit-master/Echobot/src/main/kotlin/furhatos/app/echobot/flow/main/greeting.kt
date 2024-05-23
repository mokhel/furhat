package furhatos.app.echobot.flow.main

import furhatos.app.echobot.flow.Parent
import furhatos.flow.kotlin.State
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.onResponse
import furhatos.flow.kotlin.state
import furhatos.nlu.common.No
import furhatos.nlu.common.Yes


val Greeting: State = state(Parent) {
    onEntry {
        furhat.say("Hallo und herzlich willkommen. Heute werde ich Sätze wiederholen die Sie gesagt haben " +
            "und abschließend auf Korrektheit überprüfen.")

        furhat.ask("Haben Sie alles verstanden?")
    }

    onResponse<Yes> {
        goto(Repeat)
    }

    onResponse<No> {
        furhat.say("Bitte entschuldigen Sie, ich werde mich wiederholen ")
        reentry()
    }

}

