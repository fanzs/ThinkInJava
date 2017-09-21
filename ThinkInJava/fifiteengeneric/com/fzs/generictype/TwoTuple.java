package com.fzs.generictype;

public class TwoTuple<A,B> {
	//声明为final类型的成员变量必须初始化
	public final A first;
	public final B second;
	
	public TwoTuple(A a,B b) {
		first=a;
		second=b;
	}
	
	@Override
	public String toString() {
		return "("+first+","+second+")";
	}
	public static void main(String[] args) {
		TwoTuple<Integer,String> twoTuple = new TwoTuple<Integer,String>(10,"fzs");
		System.out.println(twoTuple);
	}
}
