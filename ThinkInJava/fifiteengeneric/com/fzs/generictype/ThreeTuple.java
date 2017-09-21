package com.fzs.generictype;

public class ThreeTuple<A,B,C> extends TwoTuple<A,B> {
	public final C third;

	public ThreeTuple(A a, B b,C c) {
		super(a, b);
		this.third=c;
	}

	@Override
	public String toString() {
		return "("+first+","+second+","+third+")";
	}
	
	public static void main(String[] args) {
		ThreeTuple<Integer,String,String> threeTuple = new ThreeTuple<Integer,String,String>(10,"fzs","guet");
		System.out.println(threeTuple);
//		threeTuple.first=11;
	}
}
