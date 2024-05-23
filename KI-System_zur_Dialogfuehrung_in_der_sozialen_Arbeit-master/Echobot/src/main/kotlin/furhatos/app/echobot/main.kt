package furhatos.app.echobot

import furhatos.app.echobot.flow.Init
import furhatos.flow.kotlin.Flow
import furhatos.skills.Skill

class EchobotSkill : Skill() {
    override fun start() {
        Flow().run(Init)
    }
}

fun main(args: Array<String>) {
    Skill.main(args)
}
