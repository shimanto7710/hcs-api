package com.rookie.hcsapi.data_handler
import com.rookie.hcsapi.core.Response
import com.rookie.hcsapi.model.UserModel
import com.rookie.hcsapi.repo.BookRepository
import com.rookie.hcsapi.repo.UserRepository
import net.minidev.json.JSONArray
import net.minidev.json.JSONObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.util.*

@Repository("realData")
class RealData : DataHandlerInterface {

    @Autowired
    var userRepository: UserRepository? = null

    @Autowired
    var bookRepository: BookRepository? = null

    override fun sendOtp(phoneNumber: String): Response? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllUser(): List<UserModel>? {
        return userRepository?.findAll()
    }

    override fun getUserById(id:Long): Optional<UserModel>? {
        return userRepository?.findById(id)
    }

    override fun createUser(userModel: UserModel): UserModel? {
        return userRepository?.save(userModel)

    }

    override fun removeUser(id: Long): Unit? {
        return userRepository?.deleteById(id)
    }

    override fun getAllBook(): JSONArray? {
        var data = bookRepository?.findAll()
        val bookArray: JSONArray = JSONArray()
        for (book in data!!) {

            val bookObj = JSONObject()
            bookObj.put("id", book?.id)
            bookObj.put("title", book?.title)
            bookObj.put("author", book?.author)
            bookObj.put("details", book?.details)
            bookObj.put("rating", book?.rating)
            bookObj.put("price", book?.price)
            bookObj.put("type", book?.type)
            bookObj.put("image_url", book?.image_url)

            val authorObj = JSONObject()
            authorObj.put("id", book?.author?.id)
            authorObj.put("name", book?.author?.name)
            authorObj.put("details", book?.author?.details)
            authorObj.put("rating", book?.author?.rating)
            authorObj.put("type", book?.author?.type)
            authorObj.put("image_url", book?.author?.imageUrl)

            bookObj.put("author",authorObj)

            bookArray.appendElement(bookObj)
        }

        return bookArray
    }


}