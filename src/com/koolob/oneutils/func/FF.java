package com.koolob.oneutils.func;

public abstract class FF extends F{

	@Override
	public Object call(Object... args) {
		if(args.length < 2){
			return null;
		}else if(!(args[0] instanceof F)){
			return null;
		}
		return super.call(args);
	}

}
