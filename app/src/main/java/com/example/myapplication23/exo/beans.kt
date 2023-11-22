package com.example.myapplication23.exo

class CarBean(var marque: String, var model: String) {
    var couleur : String? = null

    //Méthode d'instance
    //fun print() = println("$marque son email : $email")
}

class HouseBean(var couleur: String, var largeur: Int, var longueur: Int) {

    //Méthode d'instance
    fun print() = println("La maison $couleur fait ${(largeur*longueur)} m²")
}

class TownBean(var city: String, var cp: String) {
    var country : String? = null
}

data class DataTownBean(var city: String, var cp: String) {
    var country : String? = null
}
data class WeatherBean(
    var name:String,
    var main: MainBean,
    var wind: WindBean,
)

data class MainBean(var temp:Double)

data class WindBean(var speed:Double)

data class UsersBean(
    var name:String?,
    var coord: coordBean,
    var age:Int?,
)
data class coordBean(var phone:Int?, var mail:String?)

 class randomNameBean {
    var tab:ArrayList<String>
    init {
        tab = arrayListOf<String>("Kevin", "Brian", "Bilel")
    }

    fun add(name: String?) {
        if (name != null && name.isNotBlank() && name !in tab) {
            tab.add(name);
        }
    }
        fun next(): String? {
            return if (tab.isNotEmpty()) {
                tab.random()
            } else {
                null
            }
        }

}
data class PersonBean(var name:String, var note:Int)

fun exo4(){
    val list = arrayListOf(
        PersonBean ("toto", 16),
        PersonBean ("Tata", 20),
        PersonBean ("Toto", 8),
        PersonBean ("Charles", 14)
    )

    println("Afficher la sous liste de personne ayant 10 et +")
    //println(list.filter { it.note >=10 })
    //Pour un affichage de notre choix
    println(list.filter { it.note >=10 }.joinToString("\n") { "-${it.name} : ${it.note}"})

    //TODO
    println("\n\nAfficher combien il y a de Toto dans la classe ?")
    println(list.count { it.name.equals("toto",true) })

    println("\n\nAfficher combien de Toto ayant la moyenne (10 et +)")
    println(list.count { it.name.equals("toto",true) && it.note >= 10})

    println("\n\nAfficher combien de Toto ont plus que la moyenne de la classe")
    var moy = list.map {it.note}.average()
    println(list.count{ it.name.equals("toto",true) && it.note >= moy})

    println("\n\nAfficher la list triée par nom sans doublon")
    println(list.map { it.name }.distinctBy { it }.sortedBy { it.lowercase() })
    println("\n\nAjouter un point a ceux n’ayant pas la moyenne (<10)")
    list.filter { it.note < 10 }.forEach{it.note++}
    println("\n\nAjouter un point à tous les Toto")

    println("\n\nRetirer de la liste ceux ayant la note la plus petite. (Il faut une ArrayList)")
    println("\n\nAfficher les noms de ceux ayant la moyenne(10et+) par ordre alphabétique")
}

const val LONG_TEXT = """Le Lorem Ipsum est simplement
    du faux texte employé dans la composition
    et la mise en page avant impression.
    Le Lorem Ipsum est le faux texte standard
    de l'imprimerie depuis les années 1500"""
data class PictureData(val url: String, val text: String, val longText: String)

//jeu de donnée
val pictureList = arrayListOf(
    PictureData("https://picsum.photos/200", "ABCD", LONG_TEXT),
    PictureData("https://picsum.photos/201", "BCDE", LONG_TEXT),
    PictureData("https://picsum.photos/202", "CDEF", LONG_TEXT),
    PictureData("https://picsum.photos/203", "EFGH", LONG_TEXT)
)
/*
class PrintRandomIntBean(var max: Int) {
    private var random : Random = Random()


    init {
        println(random.nextInt(max));
    }
    constructor(max: String) :this(
        max,
        100
    )
}
*/


fun main() {
    exo4();


   /* var voiture1 = CarBean("Seat","Leon");
    voiture1.couleur = "Gris";

    println(voiture1.marque + " " +voiture1.model + " " +voiture1.couleur)

    var maison = HouseBean("rouge",5,5)
    maison.print()

    var mytown1 = TownBean("Marseille","13000")
    var mytown3 = TownBean("Marseille","13000")
    var mytown2 = DataTownBean("Paris","75000")
    var mytown4 = DataTownBean("Paris","75000")
    //var rand = PrintRandomIntBean(100)

    println(mytown1);
    println(mytown2);

    println(mytown1==mytown3);
    println(mytown1===mytown3);

    println(mytown2==mytown4);
    println(mytown2===mytown4);

    var copy = mytown2.copy("Paris","75000")

    println(mytown2==copy);
    println(mytown2===copy);

    //println(rand)

    */
}