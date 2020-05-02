package Main;

import java.sql.Timestamp;
import java.util.Random;

public class Package {
    private int AddressPort;
    private int Data;
    private long timeIn;
    private long timeOut;
    private long awaiting;

    Package(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Random r = new Random();

        timeIn=timestamp.getTime();
        Data=r.nextInt(7587224) + 1394834;
        AddressPort=r.nextInt(4) + 1;

    }

    public int getAddressPort(){
        return AddressPort;
    }

    public int getData(){
        return Data;
    }

    public long getAwaiting(){
        return awaiting;
    }

    public void setAwaiting(){
        awaiting=timeOut-timeIn;
    }

    public void setTimeOut(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        timeOut=timestamp.getTime();
        setAwaiting();
    }
}
