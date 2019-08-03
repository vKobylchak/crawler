package ua.crawler.entityHelper;

import ua.crawler.model.Link;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

public class LinkHelper {
    private static PodamFactory factory = new PodamFactoryImpl();

    public static Link generateLink(){
        return factory.manufacturePojoWithFullData(Link.class);
    }
}
