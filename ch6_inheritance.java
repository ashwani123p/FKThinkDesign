

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
    abstract void local_spares();

    void post_initialize(String ... var) {

    }
}
class RoadBike extends Bicycle {

    String tape_color;

    void default_tire_size() {
        tire_size = 23;
    }

    void post_initialize(String s) {
        tape_color = s;
    }

    void local_spares() {
        System.out.println(tape_color);
    }
}

class MountainBike extends Bicycle {

    String front_shock;
    String rear_shock;

    void default_tire_size() {
        tire_size = 2.1;
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

    void local_spares() {
        System.out.println(front_shock);
    }
}

