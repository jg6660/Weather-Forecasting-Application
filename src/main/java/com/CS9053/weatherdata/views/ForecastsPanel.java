package com.CS9053.weatherdata.views;

import java.awt.Color;

import javax.swing.*;

public class ForecastsPanel extends JPanel {
  private ForecastPanel[] forecastPanels;
  private final int numOfDays = 5;

  public ForecastsPanel() {
    this.forecastPanels = new ForecastPanel[this.numOfDays];
    for (int i=0; i<this.numOfDays; i++) {
      this.forecastPanels[i] = new ForecastPanel(i);
      this.add(this.forecastPanels[i]);
    }
    this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
    this.setAlignmentX(LEFT_ALIGNMENT);
    this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
  }

  public ForecastPanel getForecastPanels(int i) {
    return this.forecastPanels[i];
  }
}
