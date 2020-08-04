package center.wxp.dataway.module;

import net.hasor.core.ApiBinder;
import net.hasor.core.DimModule;

import net.hasor.core.Hasor;
import net.hasor.db.JdbcModule;
import net.hasor.db.Level;
import net.hasor.spring.SpringModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * 先新建一个 Hasor 的 模块，并且将其交给 Spring 管理。
 * 然后把数据源通过 Spring 注入进来
 *
 * @author wxp
 */
@DimModule
@Component
public class ExampleModule implements SpringModule {
    @Autowired
    private DataSource dataSource = null;

    @Override
    public void loadModule(ApiBinder apiBinder) throws Throwable {
        apiBinder.installModule(new JdbcModule(Level.Full, this.dataSource));
    }
}
