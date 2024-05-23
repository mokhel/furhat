package furhatos.app.echobot.flow.main

import furhatos.app.echobot.flow.Parent
import furhatos.app.echobot.nlu.Correct
import furhatos.app.echobot.nlu.Incorrect
import furhatos.flow.kotlin.State
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.onResponse
import furhatos.flow.kotlin.state

val Repeat: State = state(Parent)
{
    onEntry {
        furhat.say("Bitte sagen Sie nun etwas.")
        furhat.listen()
    }

    onResponse<Correct> {
        furhat.say("Einen schönen Tag noch")
        goto(Idle)
    }

    onResponse<Incorrect> {
        furhat.say("Bitte wiederholen Sie was Sie gesagt haben")
        furhat.listen()
    }

    // Default response
    onResponse {
        furhat.say("Ich werde jetzt das Gesagte wiederholen. ${it.text}")
        furhat.ask("War das korrekt?")
    }
}