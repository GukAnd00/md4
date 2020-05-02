package Main;

import java.util.Random;

public class Switch {

    private Port port65532 = new Port();
    private Port port65533 = new Port();
    private Port port65534 = new Port();
    private Port port65535 = new Port();

    public Port getPort65532(){
        return port65532;
    }

    public Port getPort65533(){
        return port65533;
    }

    public Port getPort65534(){
        return port65534;
    }

    public Port getPort65535(){
        return port65535;
    }

    public void sendToPort65532(Package pckg){
        port65532.setPackage(pckg);
        System.out.println("Send to port #65532 a package, with this data: "+pckg.getData()+",  awaiting time: "+pckg.getAwaiting());
    }

    public void sendToPort65533(Package pckg){
        port65533.setPackage(pckg);
        System.out.println("Send to port #65533 a package, with this data: "+pckg.getData()+",  awaiting time: "+pckg.getAwaiting());
    }

    public void sendToPort65534(Package pckg){
        port65534.setPackage(pckg);
        System.out.println("Send to port #65534 a package, with this data: "+pckg.getData()+",  awaiting time: "+pckg.getAwaiting());
    }

    public void sendToPort65535(Package pckg){
        port65535.setPackage(pckg);
        System.out.println("Send to port #65535 a package, with this data: "+pckg.getData()+",  awaiting time: "+pckg.getAwaiting());
    }

    public int commutate(Package pckg){
        Random r = new Random();
        switch (pckg.getAddressPort()){
            case 1:{
                if ((r.nextInt(4)) == 2) {
                    sendToPort65532(pckg);
                    return 1;
                }
            }
            case 2:{
                if ((r.nextInt(4)) == 2) {
                    sendToPort65533(pckg);
                    return 1;
                }
            }
            case 3:{
                if ((r.nextInt(4)) == 2) {
                    sendToPort65534(pckg);
                    return 1;
                }
            }
            case 4:{
                if ((r.nextInt(4)) == 2) {
                    sendToPort65535(pckg);
                    return 1;
                }
            }
            default: return 0;
        }
    }
}
