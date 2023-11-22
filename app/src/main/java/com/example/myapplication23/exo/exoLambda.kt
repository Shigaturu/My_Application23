package com.example.myapplication23.exo

fun exo1() {
    var lower =  { texte :String -> println("${texte.lowercase()}") }
    var heure =  { minutes :Int -> println(minutes/60) }
    var max =  { nb1 :Int, nb2 :Int -> println(Math.max(nb1,nb2)) }
    var reverse =  { texte :String -> println("${texte.reversed()}") }
    var minToHour = { minutes: Int ->
        println(Pair(minutes / 60,minutes % 60))
    }


    lower("TEXTE")
    heure(3600)
    max(5,8)
    reverse("TEXTE")
    minToHour(90)

}

fun main(){

    return exo1();
}