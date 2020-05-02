package Main;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int timeout = 5000;
        int intensity = 50;
        long avgAwaiting;
        Switch switcher = new Switch();
        ArrayList<Package> pckg = new ArrayList<>();
        Random r = new Random();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        long timeStart = timestamp.getTime();
        Timestamp timestampEnd ;

        do {
            if ((r.nextInt(101)) <= intensity) {
                Package tmp = new Package();
                pckg.add(tmp);
            }

            if(pckg.size()>=1)
            {int pos = r.nextInt(pckg.size());
            if((switcher.commutate(pckg.get(pos)))==1)
            {pckg.remove(pos);}}

            timestampEnd = new Timestamp(System.currentTimeMillis());
         }while((timestampEnd.getTime()-timeStart)<=timeout);



        long awaitingOn65532=0;
        long awaitingOn65533=0;
        long awaitingOn65534=0;
        long awaitingOn65535=0;

//avg awaiting time for port #65532
        for(int j=0; j<switcher.getPort65532().getPackage().size(); j++)
            {awaitingOn65532+=switcher.getPort65532().getPackage().get(j).getAwaiting();}
        awaitingOn65532/=switcher.getPort65532().getPackage().size();

//avg awaiting time for port #65533
        for(int j=0; j<switcher.getPort65533().getPackage().size(); j++)
        {awaitingOn65533+=switcher.getPort65533().getPackage().get(j).getAwaiting();}
        awaitingOn65533/=switcher.getPort65533().getPackage().size();

//avg awaiting time for port #65534
        for(int j=0; j<switcher.getPort65534().getPackage().size(); j++)
        {awaitingOn65534+=switcher.getPort65534().getPackage().get(j).getAwaiting();}
        awaitingOn65534/=switcher.getPort65534().getPackage().size();

//avg awaiting time for port #65535
        for(int j=0; j<switcher.getPort65535().getPackage().size(); j++)
        {awaitingOn65535+=switcher.getPort65535().getPackage().get(j).getAwaiting();}
        awaitingOn65535/=switcher.getPort65535().getPackage().size();
//avg awaiting time for all
        avgAwaiting=(awaitingOn65532+awaitingOn65533+awaitingOn65534+awaitingOn65535)/4;

        System.out.println("\n\n      Average awaiting time:\n\nFor packages at port#65532 is: " + awaitingOn65532);
        System.out.println("For packages at port#65533 is: " +awaitingOn65533);
        System.out.println("For packages at port#65534 is: " +awaitingOn65534);
        System.out.println("For packages at port#65535 is: " +awaitingOn65535);
        System.out.println("\nFor all packages is: " +avgAwaiting+"\n");

    }
}


