package kz.just_code.frdb

class UserDao:FRDBWrapper<User>() {
    override fun getTableName(): String {
        return "User"
    }

    override fun getClassType(): Class<User> {
        return User::class.java
    }
}