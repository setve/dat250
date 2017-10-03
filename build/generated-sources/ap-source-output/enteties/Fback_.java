package enteties;

import enteties.UserE;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-03T18:51:40")
@StaticMetamodel(Fback.class)
public class Fback_ { 

    public static volatile SingularAttribute<Fback, Integer> rating;
    public static volatile SingularAttribute<Fback, String> feedbackMessage;
    public static volatile SingularAttribute<Fback, Long> id;
    public static volatile SingularAttribute<Fback, UserE> user;

}