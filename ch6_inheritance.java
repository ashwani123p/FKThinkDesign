

abstract class Bicycle {
    public int size;
    public String chain;
    public String tire_size;

    Bicycle(int s, String ... arg) {
        size = s;
        if (arg.length == 2) {
            chain = arg[0];
            tire_size = arg[1];
        }
        else if (arg.length == 1) {
            tire_size = arg[0];
            default_chain();
        }
    }

    public void default_chain() {
        chain = "10-speed";
    }

    public void spares () {
        System.out.println(chain + " " + tire_size);
        local_spares();
    }

    abstract void default_tire_size();
    abstract void local_spares(String s);

    void post_initialize(String ... var) {

    }
}
class RoadBike extends Bicycle {

    public String tape_color;

    public String default_tire_size() {
        return "23";
    }

    void post_initialize(String s) {
        tape_color = s;
    }

    void local_spares(String s) {
        tape_color=s;
    }
}

class MountainBike extends Bicycle {

    public String front_shock;
    public String rear_shock;

    public String default_tire_size() {
        return  "2.1";
    }

    void post_initialize(String ... arg) {
        if (arg.length == 2) {
            front_shock = arg[0];
            rear_shock = arg[1];
        }
        else {
            front_shock = arg[0];
        }
    }

    void local_spares(String s) {
        front_shock=s;
    }
}

// class RecumbentBike < Bicycle attr_reader :flag
// def post_initialize(args) @flag = args[:flag]
// end
// def local_spares {flag: flag}
// end
// def default_chain "9-speed"
// end
// def default_tire_size '28'
// end end

class RecumbentBike extends Bicycle{
	public String flag;

    String default_tire_size() {
        return  "28";
    }

    void post_initialize(String ... s) {
        flag=s[0];
    }

    void local_spares(String flag) {
    	   flag=flag; 
    }
    String default_chain(){
    	return "9-speed";
    }

}


















