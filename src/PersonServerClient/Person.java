package PersonServerClient;

import java.io.Serializable;

public class Person implements Serializable {
    private int id;
    private String firstname;
    private String lastname;

    public Person(int id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

}
