package FKThink;

import java.lang.Math.*;

class Gear{
	public int chainring,cog;
	public Wheel wheel;
	Gear(int chainring,int cog,Wheel wheel ){
		this.chainring=chainring;
		this.cog=cog;
		this.wheel=wheel;
	}
	public double ratio(){
		return chainring/(double)cog;
	}
	public double gear_inches(){
		return ratio()*wheel.diameter();
	}

}

public class Wheel{
	public int rim;
	public double tire;
	Wheel(int rim,double tire){
		this.rim=rim;
		this.tire=tire;
	}
	public double diameter(){
		return rim+(tire*2);
	}
	public double circumference(){
		return diameter()*Math.PI;
	}
	public static void main(String[] args){
		Wheel wheel=new Wheel(26,1.5);
		System.out.println(wheel.circumference());
		System.out.println(new Gear(52,11,wheel).gear_inches());
		System.out.println(new Gear(52,11,wheel).ratio());
	}
}