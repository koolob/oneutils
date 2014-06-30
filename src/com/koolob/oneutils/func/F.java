package com.koolob.oneutils.func;

public abstract class F {

	protected abstract Object apply(Object... args);

	public Object call(Object... args){
		return this.apply(args);
	}
}
