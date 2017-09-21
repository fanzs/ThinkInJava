package com.fzs.genericinterface;

public class Fibonacci implements Generator<Integer> {
	private int count=0;
	@Override
	public Integer next() {
		return fib(count++);
	}
	private Integer fib(int n) {
		if(n<2)return 1;
		return fib(n-1)+fib(n-2);
	}
	public static void main(String[] args) {
		Fibonacci fibonacci = new Fibonacci();
		for(int i=0;i<100;++i){
			System.out.println(fibonacci.next()+" ");
		}
	}

}
