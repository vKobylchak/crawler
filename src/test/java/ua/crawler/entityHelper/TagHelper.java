package ua.crawler.entityHelper;

import ua.crawler.model.Tag;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

public class TagHelper {
    private static PodamFactory factory = new PodamFactoryImpl();

    public static Tag generateTag(){
        return factory.manufacturePojoWithFullData(Tag.class);
    }
}
