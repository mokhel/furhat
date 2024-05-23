package furhatos.app.echobot.flow

import furhatos.app.echobot.flow.main.Idle
import furhatos.app.echobot.flow.main.Greeting
import furhatos.app.echobot.setting.activate
import furhatos.app.echobot.setting.DISTANCE_TO_ENGAGE
import furhatos.app.echobot.setting.MAX_NUMBER_OF_USERS
import furhatos.app.echobot.setting.vickiNeural
import furhatos.flow.kotlin.State
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.state
import furhatos.flow.kotlin.users

val Init: State = state {
    init {
        /** Set our default interaction parameters */
        users.setSimpleEngagementPolicy(DISTANCE_TO_ENGAGE, MAX_NUMBER_OF_USERS)

        /** Set character - defined in personas */
        activate(vickiNeural)
    }
    onEntry {
        /** Check if virtual environment */
        when {
            furhat.isVirtual() -> goto(Greeting) // Convenient to bypass the need for user when running Virtual Furhat
            users.hasAny() -> {
                furhat.attend(users.random)
                goto(Greeting)
            }
            else -> goto(Idle)
        }
    }

}

