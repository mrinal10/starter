package com.interviewbit;

/* Save this in a file called Main.java to compile and test it */

/* 
   Example file showing how to write a program that reads
   input from `input.txt` in the current directory
   and writes output to `output.txt` in the current directory
*/

/* Do not add a package declaration */
import java.util.*;
import java.io.*;

/* DO NOT CHANGE ANYTHING ABOVE THIS LINE */
/* You may add any imports here, if you wish, but only from the 
   standard library */

/* Do not add a namespace declaration */

public class Main {

	class ApiClass {
		private String apiName;
		private int version;

		ApiClass(String name, int vrsn) {
			apiName = name;
			version = vrsn;
		}

		public boolean equals(Object other) {
			if (other == null)
				return false;

			if (this.getClass() != other.getClass())
				return false;

			ApiClassMaster apiclass = (ApiClassMaster) other;
			return this.getApiName().equals(apiclass.getApiName());
		}

		public String getApiName() {
			return apiName;
		}

		public void setApiName(String apiName) {
			this.apiName = apiName;
		}

		public int getVersion() {
			return version;
		}

		public void setVersion(int version) {
			this.version = version;
		}
	}

	class ApiClassMaster {
		private String apiName;
		private PriorityQueue<Integer> version;

		ApiClassMaster(String name, int vrsn) {
			apiName = name;
			version = new PriorityQueue<>();
			version.add(vrsn);
		}

		public void addVersion(int nwVersion) {
			version.add(nwVersion);
		}

		public int getVersionCount() {
			return version.size();
		}

		public int getoldestAPI() {
			return version.peek();
		}

		public boolean equals(Object other) {
			if (other == null)
				return false;

			if (this.getClass() != other.getClass())
				return false;

			ApiClassMaster apiclass = (ApiClassMaster) other;
			return this.getApiName().equals(apiclass.getApiName());
		}

		public String getApiName() {
			return apiName;
		}

		public void setApiName(String apiName) {
			this.apiName = apiName;
		}
	}

	class AppClass {
		private String appName;
		private List<ApiClass> apiList;

		public AppClass(String name, ApiClass apicls) {
			appName = name;
			apiList = new ArrayList<>();
			apiList.add(apicls);
		}

		public void addApi(ApiClass api) {
			apiList.add(api);
		}

		public String getAppName() {
			return appName;
		}

		public void setAppName(String appName) {
			this.appName = appName;
		}

		public List<ApiClass> getApiList() {
			return apiList;
		}

		public void setApiClass(List<ApiClass> apis) {
			this.apiList = apis;
		}

		public boolean isUsingApi(String apiName, int version){
			for(ApiClass api : apiList){
				if (api.getApiName().equals(apiName) && api.getVersion()==version) {
					return true;
				}
			}
			return false;
		}
		
		public boolean equals(Object other) {
			if (other == null)
				return false;

			if (this.getClass() != other.getClass())
				return false;

			AppClass appclass = (AppClass) other;
			return this.getAppName().equals(appclass.getAppName());
		}

	}
	
	private static String processData(Scanner in){
		Set<ApiClassMaster> apiMasterSet = new HashSet<>();			
		Set<AppClass> appSet = new HashSet<>();
		Main m = new Main();
		while (in.hasNextLine()) {
			String line = in.nextLine();
			String[] data = line.split(",");
			String appName = data[0].trim();
			String apiName = data[1].trim();
			int apiVersion = Integer.parseInt(data[2].trim().substring(1));
			
			
			ApiClassMaster newApiMaster = m.new ApiClassMaster(apiName, apiVersion);
			if (apiMasterSet.isEmpty()) {
				apiMasterSet.add(newApiMaster);
			} else {
				ApiClassMaster apiDummy = null;
				for (ApiClassMaster apimaster : apiMasterSet) {
					if (apimaster.equals(newApiMaster)) {
						apiDummy = apimaster;
						break;
					}
				}
				if (apiDummy != null) {
					apiDummy.addVersion(apiVersion);
				} else {
					apiMasterSet.add(newApiMaster);
				}
			}
			
			ApiClass newApi = m.new ApiClass(apiName, apiVersion);
			AppClass newApp = m.new AppClass(appName, newApi);
			if (appSet.isEmpty()) {
				appSet.add(newApp);
			} else {
				AppClass appDummy = null;
				for (AppClass indvidualApp : appSet) {
					if (indvidualApp.equals(newApp)) {
						appDummy = newApp;
						break;
					}
				}
				if (appDummy != null) {
					appDummy.addApi(newApi);
				} else {
					appSet.add(newApp);
				}
			}			
		}
		return findApps(apiMasterSet, appSet);
	}
	
	private static String findApps(Set<ApiClassMaster> apiMasterSet, Set<AppClass> appSet){
		StringBuilder sBuilder = new StringBuilder();
		for (ApiClassMaster apiMaster : apiMasterSet) {
			if(apiMaster.getVersionCount()>1){
				for(AppClass app : appSet){
					if (app.isUsingApi(apiMaster.getApiName(), apiMaster.getoldestAPI())) {
						if (sBuilder.length()!=0) {
							sBuilder.append("\n"+app.getAppName());
						}else{
							sBuilder.append(app.getAppName());
						}
						
					}
				}
			}
		}
		return sBuilder.toString();
	}

	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(new BufferedReader(
					new FileReader("input.txt")));

			String outputLines = processData(in);
			
			PrintWriter output = new PrintWriter(new BufferedWriter(
					new FileWriter("output.txt")));
			output.println("" + outputLines);
			output.close();
		} catch (IOException e) {
			System.out.println("IO error in input.txt or output.txt");
		}
	}
}