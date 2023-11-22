package com.example.myapplication23.exo

fun main() {
    println("Hello World");
    var v1 = "toto";
    println(v1.uppercase());
    var v2:String? = "toto";
    println(v2?.uppercase() ?: "-");
    var v3:String? = null;
    println(v3?.uppercase() ?: "-");

    println(min(3,4,5))

    println(pair(5))

    boulangerie(baguette = 2, sandwich = 3)

    val baguette = scanNumber("Nombre de baguettes :")

    scanText("Votre nom ?");
}

/*
fun min(a: Int, b:Int, c:Int): Int {
    if (a < b && a < c){
        return a
    }else if (b < c && b < c){
        return b
    }else{
        return c
    }
}
*/

fun min(a: Int, b:Int, c:Int) = if(a <b ) a else if(b < c && b < c) b else c

fun pair(c: Int): Boolean {
    return c%2 == 0;
}

fun myPrint(chaine:String):String {
    return "#$chaine";
}

fun boulangerie(croisant:Int=0,baguette:Int=0,sandwich:Int=0): String = println("Prix total = " + (croisant* prix_croisant +baguette* prix_baguette +sandwich* prix_sandwich)).toString()


fun scanText(question:String): String {
    print(question)
    return println(readlnOrNull() ?: "-").toString();
}

fun scanNumber(question: String): Int = scanText(question).toIntOrNull() ?: -1;

