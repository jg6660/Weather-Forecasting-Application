package com.CS9053.weatherdata.listeners;

import com.CS9053.weatherdata.Weather;
import com.CS9053.weatherdata.views.WeatherPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ForecastPanelMouseListener implements MouseListener {
  private WeatherPanel weatherPanel;
  private Weather weather;

  public ForecastPanelMouseListener(WeatherPanel weatherPanel, Weather weather) {
    this.weatherPanel = weatherPanel;
    this.weather = weather;
  }

  public void mouseClicked(MouseEvent e) {
    this.weatherPanel.setWeather(weather);
  }

  public void mousePressed(MouseEvent e) {}

  public void mouseReleased(MouseEvent e) {}

  public void mouseEntered(MouseEvent e) {}

  public void mouseExited(MouseEvent e) {}
}
