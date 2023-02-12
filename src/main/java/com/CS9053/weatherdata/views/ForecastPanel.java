package com.CS9053.weatherdata.views;

import com.CS9053.weatherdata.Weather;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ForecastPanel extends JPanel {
  private JLabel dateLabel;
  private JLabel weatherSummaryLabel;
  private Weather weather;

  public ForecastPanel(int difference) {
    this.weather = null;
    this.dateLabel = new JLabel();
    this.dateLabel.setFont(new Font(dateLabel.getFont().getName(), Font.BOLD, 20));
    dateLabel.setForeground(Color.WHITE);
    this.setDay(difference);
    this.setBackground(Color.BLACK);

    this.weatherSummaryLabel = new JLabel();
    this.weatherSummaryLabel.setText("Loading ...");
    weatherSummaryLabel.setForeground(Color.white);

    this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    this.setAlignmentX(LEFT_ALIGNMENT);
    this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    this.setBorder(new CompoundBorder(
        BorderFactory.createEmptyBorder(10, 10, 10, 10),
        new CompoundBorder(
            BorderFactory.createLineBorder(Color.getHSBColor((float) 0.65, (float) 0.0, (float) 1.0), 2),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)
        )
    ));
    this.add(dateLabel);
    this.add(weatherSummaryLabel);
  }

  public void setDay(int difference) {
    Date date = new Date();
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat formatter = new SimpleDateFormat("dd MMMMM");

    calendar.setTime(date);
    calendar.add(Calendar.DATE, difference);
    date = calendar.getTime();
    this.dateLabel.setText(formatter.format(date));
  }

  public void setWeather(Weather weather) {
    this.weather = weather;
    this.weatherSummaryLabel.setText(weather.getWeatherSummaries()[0].getSummary());
    this.repaint();
  }
}
