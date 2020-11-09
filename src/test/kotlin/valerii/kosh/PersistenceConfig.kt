package valerii.kosh

import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.SqlSessionFactoryBean
import org.mybatis.spring.annotation.MapperScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType
import javax.sql.DataSource


@Configuration
@MapperScan("valerii.kosh")
class PersistenceConfig {
    @Bean
    fun dataSource(): DataSource {
        return EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                .addScript("schema.sql").addScript("data.sql")
                .build()
    }

    @Bean
    fun sqlSessionFactory(): SqlSessionFactory? {
        val factoryBean = SqlSessionFactoryBean()
        factoryBean.setDataSource(dataSource())
        return factoryBean.getObject()
    }
}