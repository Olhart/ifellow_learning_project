package api.reqres.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.aeonbits.owner.Reloadable;

@Config.Sources({
        "file:src/test/resources/properties/regresapi.properties"
})
public interface Properties extends Reloadable {
    Properties properties = ConfigFactory.create(Properties.class);

    @Key("jsonfile.name")
    String jsonFileName();

    @Key("baseURL")
    String baseURL();
}