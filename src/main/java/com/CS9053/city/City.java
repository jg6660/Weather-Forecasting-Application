package com.CS9053.city;

import com.CS9053.city.views.SearchPanel;

public class City {
  public int id;
  public String name;
  public Coordinate coordinate;
  public String country;

  public City(int id, String name, Coordinate coordinate, String country) {
    this.id = id;
    this.name = name;
    this.coordinate = coordinate;
    this.country = country;
  }

  public City() {
	// TODO Auto-generated constructor stub
}

public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Coordinate getCoordinate() {
    return coordinate;
  }

  public String getCountry() {
    return country;
  }

  public boolean similarNameWith(String name) {
    return this.name.toLowerCase().contains(name.toLowerCase());
  }

  @Override
  public String toString() {
    return this.getName() + ", " + this.getCountry();
  }
}
