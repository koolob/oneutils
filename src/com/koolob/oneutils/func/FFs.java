package com.koolob.oneutils.func;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class FFs {

	public static F map = new FF() {
		@Override
		protected Object apply(Object... args) {
			F fn = (F) args[0];
			List list = (List) args[1];
			Iterator i = list.iterator();
			List result = new ArrayList();
			while (i.hasNext()) {
				result.add(fn.call(i.next()));
			}
			return result;
		}
	};

	public static F reduce = new FF() {
		@Override
		protected Object apply(Object... args) {
			F fn = (F) args[0];
			List list = (List) args[1];
			Iterator i = list.iterator();
			Object init = args.length == 3 ? args[2] : i.next();
			while (i.hasNext()) {
				init = fn.call(init, i.next());
			}
			return init;
		}
	};

	public static F not = new FF() {
		@Override
		protected Object apply(Object... args) {
			final F fn = (F) args[0];
			return new F() {
				@Override
				public Object apply(Object... args) {
					return !(Boolean) fn.call(args);
				}
			};
		}
	};

	public static F memoize = new FF() {
		@Override
		protected Object apply(Object... args) {
			final F fn = (F) args[0];
			final HashMap<String, Object> cache = new HashMap<String, Object>();
			return new F() {
				@Override
				public Object apply(Object... args) {
					StringBuilder key = new StringBuilder();
					for (Object arg : args) {
						key.append(arg.hashCode());
					}
					String cackek = key.toString();
					if (cache.containsKey(cackek)) {
						return cache.get(cackek);
					} else {
						Object result = fn.apply(args);
						cache.put(cackek, result);
						return result;
					}
				}
			};
		}
	};
}
