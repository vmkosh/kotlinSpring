package valerii.kosh.mapper

import org.apache.ibatis.annotations.*
import valerii.kosh.model.Prop
import valerii.kosh.model.Sender

interface SenderMapper {

    @Results(id = "senderResultMap", value = [
        Result(property = "id", column = "id"),
        Result(property = "code", column = "code"),
        Result(property = "props", column = "id", javaType = List::class, many = Many(select = "getSenderProps"))
    ])
    @Select ("SELECT id, code FROM SENDER WHERE id = #{id}")
    fun getSenderById(@Param("id") id:Int): Sender

    @Results(value = [
        Result(property = "name", column = "code"),
        Result(property = "value", column = "property")
    ])
    @Select("select code, property from SENDER_PROPERTIES where senderId = #{senderId}")
    fun getSenderProps(@Param("senderId") senderId: Int): List<Prop>
}