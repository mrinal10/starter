
package com.executorservice;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Callable;

public class CallableImpl implements Callable<String> {
	private String site = "";

	public CallableImpl(String s) {
		site = s;
	}

	@Override
	public String call() throws Exception {

		URL url = new URL(this.site);
		URLConnection urlcon = url.openConnection();
		InputStream stream = urlcon.getInputStream();
		return this.site+" :::: "+stream.toString();
	}

}
