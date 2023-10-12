package api.rickandmorty.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.aeonbits.owner.Reloadable;

@Config.Sources({"file:src/test/resources/properties/rickandmorty.properties"})
public interface Properties extends Reloadable {
    Properties properties = ConfigFactory.create(Properties.class);


    @Key("baseURL")
    String baseURL();
}