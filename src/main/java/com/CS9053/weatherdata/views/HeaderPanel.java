package com.CS9053.weatherdata.views;

import com.CS9053.city.City;

import javax.swing.*;
import java.awt.*;

public class HeaderPanel extends JPanel {
  private City city;
  private JLabel cityNameLabel;
  private JLabel cityCoordinateLabel;
  private ForecastsPanel forecastsPanel;

  public HeaderPanel(City city) {
    this.city = city;

    this.cityNameLabel = new JLabel();
    this.cityNameLabel.setText(this.city.toString());
    this.cityNameLabel.setFont(new Font(cityNameLabel.getFont().getName(), Font.BOLD, 20));
    this.cityNameLabel.setForeground(Color.white);
    
    this.cityCoordinateLabel = new JLabel();
    this.cityCoordinateLabel.setText(this.city.getCoordinate().toString());
    this.cityCoordinateLabel.setForeground(Color.white);
    
    this.forecastsPanel = new ForecastsPanel();

    this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    this.setAlignmentX(LEFT_ALIGNMENT);
    this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    this.add(this.cityNameLabel);
    this.add(this.cityCoordinateLabel);
    this.add(this.forecastsPanel);
    this.setBackground(Color.BLACK);
  }

  public ForecastsPanel getForecastsPanel() {
    return this.forecastsPanel;
  }
}
