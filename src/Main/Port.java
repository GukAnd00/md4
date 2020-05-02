package Main;

import java.util.ArrayList;

public class Port {

    ArrayList<Package> gotten = new ArrayList<>();

    public ArrayList<Package> getPackage(){
        return gotten;
    }

    public void setPackage(Package pkg){
        pkg.setTimeOut();
        gotten.add(pkg);
    }
}
