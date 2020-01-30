package FKThink;

import java.lang.Math.*;
// Reversing Dependencies
class Gear{
	public int chainring,cog;
	Gear(int chainring,int cog ){
		this.chainring=chainring;
		this.cog=cog;
	}
	public double ratio(){
		return chainring/(double)cog;
	}
	public double gear_inches(double diameter){
		return ratio()*diameter;
	}

}

public class Wheel_three{
	public int rim;
	public double tire;
	public Gear gear;
	Wheel_three(int rim,double tire,int chainring,int cog){
		this.rim=rim;
		this.tire=tire;
		this.gear=new Gear(chainring,cog);
	}
	public double diameter(){
		return rim+(tire*2);
	}
	public double gear_inches(){
		return gear.gear_inches(diameter());
	}
	public static void main(String[] args){
		new Wheel_three(26,1.5,52,11).gear_inches();
	}
}