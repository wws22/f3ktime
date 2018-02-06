package timesend;
import java.net.*;
import java.util.*;

import java.util.regex.Pattern;

public class GetPublicHostName
{
    public static void main(String[] args) throws Throwable
    {
        System.out.println("The " + tellMyIP());
    }

    public static String tellMyIP()
    {
        NetworkInterface iface = null;
        String ethr;
        String myip = "127.0.0.1";
        String regex = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +	"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
        try
        {
            for(Enumeration ifaces = NetworkInterface.getNetworkInterfaces();ifaces.hasMoreElements();)
            {
                iface = (NetworkInterface)ifaces.nextElement();
                ethr = iface.getDisplayName();
                //if((Pattern.matches("eth[0-9]", ethr)) || (Pattern.matches("wlan[0-9]", ethr)))
                {
                    InetAddress ia = null;
                    for(Enumeration ips = iface.getInetAddresses();ips.hasMoreElements();)
                    {
                        ia = (InetAddress)ips.nextElement();
                        if (Pattern.matches(regex, ia.getHostAddress()))  //getHostAddress | getCanonicalHostName
                        {
                            if( ! ia.getHostAddress().equals("127.0.0.1") ){
                                myip = ia.getHostAddress(); //getHostAddress | getCanonicalHostName
                                return myip;
                            }
                        }
                    }
                }
            }
        }
        catch (SocketException e){}
        return myip;
    }
}