package valerii.kosh

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import valerii.kosh.mapper.SenderMapper


@RunWith(SpringJUnit4ClassRunner::class)
@ContextConfiguration(classes = [PersistenceConfig::class])
class InMemoryTests{
    @Autowired lateinit var senderMapper: SenderMapper

    @Test
    fun simpleSenderTest() {
        val sender = senderMapper.getSenderById(1)
        Assert.assertEquals("TestSender", sender.code)
        Assert.assertEquals("propValue", sender.properties["prop"])
    }


}