
package FKThink;

import java.util.ArrayList;

class Bicycle {
    char  size;
    Parts parts;

    public Bicycle(char size, Parts parts)
    {
        this.parts=parts;
        this.size=size;

    }
    public void spares()
    {
        ArrayList<Part> temp = parts.spares();
        for(Part i:temp)
        {
            System.out.println(i.name+" "+i.description);
        }

    }

}

class Part {
    String name, description;
    boolean needs_spare=true;
    public Part(String name,String description,boolean needs_spare) {
        this.name=name;
        this.description=description;
        this.needs_spare=needs_spare;

    }


}
class Parts {
    Part part;
    ArrayList<Part> temp1;
    public Parts(Part ...part)
    {
        temp1 = new ArrayList<Part>();
        for(Part i:part)
            temp1.add(i);
    }
    public ArrayList<Part> spares()
    {
        ArrayList<Part> temp = new ArrayList<Part>();
        for(Part i: temp1)
        {
            if(i!=null&&i.needs_spare)
                temp.add(i);
        }
        return temp;
    }
}

public class Composition_ch8 {

    public static void main(String[] args) {
        Part chain = new Part("chain","10-speed",true);
        Part  road_tire  = new Part("tire_size",  "23",true);
        Part tape = new Part("tape_color", "red",true);
        Part mountain_tire = new Part("tire_size", "2.1",true);
        Part rear_shock =new Part("rear_shock", "Fox",true);
        Part front_shock = new Part( "front_shock", "Manitou", false);
        Parts road_bike_part = new Parts(chain,road_tire,tape);
        Bicycle road_bike = new Bicycle('L',road_bike_part);
        System.out.println(road_bike.size);
        road_bike.spares();
        Bicycle mountain_bike = new Bicycle( 'L' ,new Parts(chain, mountain_tire,front_shock, rear_shock));
        System.out.println(mountain_bike.size);
        mountain_bike.spares();

    }
}