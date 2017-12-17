package timesend;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.ws.Endpoint;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@WebService()
public class f3k {

    public static String getWsEndpoint(){
        String port = "6543";
        String host = "127.0.0.1"; // GetPublicHostName.tellMyIP();
        return "http://" + host + ":" + port + "/services/timesend/f3k";
    }

    @WebMethod @WebResult(name="login")
    public Answer beginSession( @WebParam(name="agent") String agent) {  // where agent = Something like a User-Agent info ( Software/Hardware/etc)
        String sid=MD5.buildSecret(agent);
        Answer a = new Answer( "OK", sid ); // session_id for this client during current contest

        System.out.println("beginSession '" + agent + "' session_id = " + sid);
        return a;
    }

    @WebMethod @WebResult(name="tasklist")
    public Answer getTasklist( @WebParam(name="session_id") String sid  ) {  // where sid = session_id
        System.out.println("getTasklist " + sid);

        Answer a = new Answer( "OK", sid, "List of tasks"  );
        List<Values> v = new ArrayList<Values>();

        v.add( new Values("1", "A") );
        v.add( new Values("2", "B") );
        v.add( new Values("3", "M", "Big ladder") );
        v.add( new Values("4", "H", "1234") );

        a.setResponse(v);
        // a = new Answer( "FAIL", sid, "Task list is not prepared yet!" );  // In case of error
        return a;
    }

    @WebMethod @WebResult(name="pilots")
    public Answer getPilots( @WebParam(name="session_id") String sid  ) {
        System.out.println("getPilots " + sid);

        Answer a = new Answer( "OK", sid, "List of pilots"  );
        List<Values> v = new ArrayList<Values>();

        v.add( new Values("1", "John Doe") );
        v.add( new Values("2", "Noel Wien") );
        v.add( new Values("3", "James H. Doolittle") );

        a.setResponse(v);
        return a;
    }

    @WebMethod @WebResult(name="accepted")
    public Answer setScores( @WebParam(name="session_id")  String sid,
                             @WebParam(name="pilot_number") java.math.BigInteger pn,
                             @WebParam(name="round_number") java.math.BigInteger rn,
                             @WebParam(name="time") List<java.math.BigInteger> times

    ){
        System.out.println("setScores " + sid);

        List<Values> v = new ArrayList<Values>();
/*
        v.add( new Values("1", "0:59") );
        v.add( new Values("2", "1:59") );
        v.add( new Values("3", "2:59") );
        v.add( new Values("4", "3:59") );
*/
        Iterator iterator = times.iterator();
        int i = 0;
        while(iterator.hasNext()){
            BigInteger t = (BigInteger) iterator.next();
            int seconds =  t.intValue()          % 60 ;
            int minutes = (t.intValue() / 60   ) % 60 ;
            int hours   = (t.intValue() / 3600 ) % 24 ;
            String time = hours > 0 ?
                   String.format("%d:%02d:%02d", hours, minutes, seconds)  :
                   String.format("%d:%02d",  minutes, seconds)  ;
            // And finally we add time to response
            v.add( new Values(  Integer.toString(++i), time ) );
        }

        // Case OK
        Answer a = new Answer( "OK", sid, "Next scores are accepted" );

        // Case Warn
        // a = new Answer( "WARN", sid, "Warning! Only next scores are accepted!" );

        a.setResponse(v);

        // Case Already presented
        // a = new Answer( "ALR", sid, "Error! Your scores doesn't accepted because someone already filled results. Check it in judges tent, please! " );

        // Case FAIL
        // a = new Answer( "FAIL", sid, "Failed! Go to the judges tent, please!" );

        return a;
    }

    public static void main(String[] argv) {
        Object implementor = new f3k();
        Endpoint.publish(getWsEndpoint(), implementor);
    }

}

