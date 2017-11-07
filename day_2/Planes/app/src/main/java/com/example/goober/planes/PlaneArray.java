package com.example.goober.planes;

import java.util.ArrayList;

import static com.example.goober.planes.R.drawable.f4;

/**
 * Created by goober on 07/11/2017.
 */

public class PlaneArray {

    private ArrayList<Plane> planes;

    public PlaneArray() {

        planes = new ArrayList<Plane>();
        planes.add(new Plane("f4", "Phantom", "1966"));
        planes.add(new Plane("f14", "Tomcat", "1970"));
        planes.add(new Plane("f15", "Eagle", "1986"));
        planes.add(new Plane("fa18", "Hornet", "1995"));
        planes.add(new Plane("f3", "Tornado", "1974"));
        planes.add(new Plane("c130", "Hercules", "1954"));
        planes.add(new Plane("su27", "Flanker", "1977"));
        planes.add(new Plane("f1", "Lightning", "1954"));
        planes.add(new Plane("mig29", "Fulcrum", "1977"));
        planes.add(new Plane("c16", "Typhoon", "1994"));
        planes.add(new Plane("gr7", "Harrier", "1985"));
        planes.add(new Plane("mig25", "Foxbat", "1970"));
        planes.add(new Plane("gr1", "Jaguar", "1968"));
        planes.add(new Plane("s2b", "Buccaneer", "1958"));


    }

    public ArrayList<Plane> getList(){
        return new ArrayList<Plane>(planes);
    }
}
