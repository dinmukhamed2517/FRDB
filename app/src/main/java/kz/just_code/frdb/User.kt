package kz.just_code.frdb

data class User(
    var name:String? = null,
    var lastname:String? = null,
    var age:Int? = null,
    var bio:String? = null,
    var gender:String?= null,
    var pictureUrl:String? = null,
    var favoriteList:List<Product>? = null

){
    fun getUserGender(): UserGender = UserGender.values().firstOrNull {
        it.name == gender
    } ?: UserGender.W

    override fun toString(): String {
        return "Name ${name}; Lastname: ${lastname}; Age ${age}; Bio: ${bio}; Gender: ${getUserGender()}, Favorite List: ${favoriteList}"
    }
}

enum class UserGender {
    M, W
}


data class Product(
    val title:String? =null,
    val pid:String?=null,
)