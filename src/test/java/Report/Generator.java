package Report;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Generator {

    public String Getdatahora (){
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        return new SimpleDateFormat("yyyyMMddhhmmss").format(ts);
    }
}
