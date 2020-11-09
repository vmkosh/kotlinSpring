package valerii.kosh.mapper

import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

interface MessageMapper {

    @Select("SELECT * FROM MESSAGE WHERE id = #{id}")
    fun getMessageById(@Param("id") id:Long)
}