package models;

import java.util.*;
import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public class Record extends Model {
    @Id
    public Long id;
    @Required
    public String name;
    
    public Long phone;
    @Required
    public Long mobilephone;
    

    public static Finder<Long,Record> find = new Finder(
            Long.class, Record.class
    );

    public static List<Record> all() {
        return find.all();
    }

    public static void create(Record record) {
        record.save();
    }

    public static void delete(Long id) {
        find.ref(id).delete();
    }
}
