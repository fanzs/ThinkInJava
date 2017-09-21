package com.fzs.genericinterface;

import java.util.Iterator;
import java.util.Random;

public class CoffeeGenerate implements Generator<Coffee>, Iterable<Coffee> {
	@SuppressWarnings("rawtypes")
	private Class[] types={
			Latte.class,Mocha.class,
			Cappuccino.class,Breve.class,Americano.class
	};
	private static Random rand=new Random(47);
	public CoffeeGenerate() {
	}
	private int size=0;
	public CoffeeGenerate(int size) {
		this.size=size;
	}
	@Override
	public Coffee next(){
		try {
			return (Coffee) types[rand.nextInt(types.length)].newInstance();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	class CoffeeIterator implements Iterator<Coffee>{
		int count=size;
		@Override
		public boolean hasNext() {
			return count>0;
		}
		
		@Override
		public Coffee next() {
			--count;
			return CoffeeGenerate.this.next();
		}
		public void remove(){
			throw new UnsupportedOperationException();
		}
	}
	
	@Override
	public Iterator<Coffee> iterator() {
		return new CoffeeIterator();
	}
	public static void main(String[] args) {
		CoffeeGenerate gen=new CoffeeGenerate();
		for(int i=0;i<5;++i){
			System.out.println(gen.next());
		}
		for(Coffee c:new CoffeeGenerate(5)){
			System.out.println(c);
		}
	}
}
