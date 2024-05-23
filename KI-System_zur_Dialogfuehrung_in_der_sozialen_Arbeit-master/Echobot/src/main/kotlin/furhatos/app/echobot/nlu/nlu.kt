package furhatos.app.echobot.nlu

import furhatos.nlu.Intent
import furhatos.util.Language


// Inherit from class Intent() and define own intents
class Correct: Intent()
{
    override fun getExamples(lang: Language): List<String>
    {
        return listOf("Ja", "Korrekt", "Stimmt", "Richtig")
    }
}

class Incorrect: Intent()
{
    override fun getExamples(lang: Language): List<String>
    {
        return listOf("Nein", "Nicht korrekt", "Falsch", "Stimmt nicht")
    }
}