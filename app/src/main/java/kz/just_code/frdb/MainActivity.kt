package kz.just_code.frdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kz.just_code.frdb.databinding.ActivityMainBinding
import java.util.UUID

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        val userDao = UserDao()
        userDao.getData()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        userDao.getDataLiveData.observe(this){
            binding.savedData.text = it.toString()
        }

        binding.saveBtn.setOnClickListener {
            userDao.saveData(getUser())
        }
    }
    private fun getUser() = User(
        name = "User",
        lastname = "Userovich",
        age = 20,
        gender = UserGender.M.name,
        bio = "This is bio",
        pictureUrl = "https:/example",
        favoriteList = listOf(
            Product("Product 1", pid = UUID.randomUUID().toString()),
            Product("Product 2", pid = UUID.randomUUID().toString()),
            Product("Product 3", pid = UUID.randomUUID().toString())
        )
    )
}