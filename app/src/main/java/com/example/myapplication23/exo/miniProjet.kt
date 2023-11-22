package com.example.myapplication23.exo

import okhttp3.OkHttpClient
import okhttp3.Request

object WeatherAPI {
    val client = OkHttpClient()

    //Méthode qui prend en entrée une url, execute la requête
    //Retourne le code HTML/JSON reçu
    fun sendGet(url: String): String {
        println("url : $url")
        //Création de la requête
        val request = Request.Builder().url(url).build()
        //Execution de la requête
        return client.newCall(request).execute().use { //it:Response
            //use permet de fermer la réponse qu'il y ait ou non une exception
            //Analyse du code retour
            if (!it.isSuccessful) {
                throw Exception("Réponse du serveur incorrect :${it.code}")
            }
            //Résultat de la requête
            it.body.string()
        }
    }
}

//Utilisation
fun main() {
   /* //Lazy loading + une seule instanciation
    var html = WeatherAPI.sendGet("https://www.google.fr")
    println(html.toString());
*/
    //var html2 = Weather2API.sendGet("https://api.openweathermap.org/data/2.5/weather?q=Toulouse&appid=b80967f0a6bd10d23e44848547b26550&units=metric&lang=fr")
    var cityName = "Montredon-des-Corbières"
    var weather = Weather2API.loadWeather(cityName)
    println("Il fait ${weather.main.temp}°C à ${weather.name} et le vent et de ${weather.wind.speed} m/s");

    var user = UsersAPI.loadUsers()

    println("L'utilisateur s'appelle ${user.name ?: "pas de prénom"}, son age est de ${user.age ?: "pas d'age"} son numéro est ${user.coord?.phone ?: "pas de numéro"}, son mail est ${user.coord?.mail ?: "pas de mail"}")


    val randomName = randomNameBean()
    randomName.add("bobby")
    repeat(10) {
        println(randomName.next() + " ")
    }
}