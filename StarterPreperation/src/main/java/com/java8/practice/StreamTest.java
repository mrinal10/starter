package com.java8.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class City {
	private String name;
	private long cityPopulation;
	private String state;
	
	City(String cName, long population, String stateName){
		name = cName;
		cityPopulation = population;
		state = stateName;
	}

	public String getName() {
		return name;
	}

	public long getCityPopulation() {
		return cityPopulation;
	}

	public String getState() {
		return state;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCityPopulation(long cityPopulation) {
		this.cityPopulation = cityPopulation;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "City [name=" + name + ", cityPopulation=" + cityPopulation + ", state=" + state + "]";
	}
}



public class StreamTest {
	public static void main(String[] args) {
		City city1 = new City("kolkata",5000, "WB");
		City city2 = new City("Mumbai",3000, "MH");
		City city3 = new City("Hyderabad",1000, "TG");
		List<City> cityList = new ArrayList<City>();
		cityList.add(city3);
		cityList.add(city2);
		cityList.add(city1);
		
		Stream<City> cityStream = cityList.stream();
		
//		Stream<City> cityStream1 = cityStream.filter(city -> city.getName().startsWith("k"));
//		cityStream1.forEach(city -> System.out.println(city.toString()));
		
//		Stream<City> cityStream2 = cityStream.filter(city -> city.getCityPopulation()>1000);
//		cityStream2.forEach(city -> System.out.println(city.toString()));
		
		
		
		
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
		Integer sum = integers.stream()
		  .mapToInt(Integer::intValue)
		  .sum();
		System.out.println(sum);
		
		List<String> elements =
				  Stream.of("obhdja", "ble", "c").filter(element -> element.contains("b"))
		    .collect(Collectors.toList());
		Optional<String> anyElement = elements.stream().findAny();
		Optional<String> firstElement = elements.stream().findFirst();
		
		System.out.println(anyElement+" ::: "+firstElement);
	}
}
