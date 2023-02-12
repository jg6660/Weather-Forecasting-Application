package com.CS9053.city.views;

import com.CS9053.city.listeners.CityResultPanelMouseListener;
import com.CS9053.city.City;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class CityResultPanel extends JPanel {
  private City city;
  private JLabel cityNameLabel;
  private JLabel cityCoordinateLabel;

  public CityResultPanel(City city) {
    this.city = city;
    this.setBackground(Color.BLACK);
    cityNameLabel = new JLabel();
    cityNameLabel.setText(this.city.toString());
    cityNameLabel.setFont(new Font(cityNameLabel.getFont().getName(), Font.BOLD, 30));
    cityNameLabel.setForeground(Color.white);

    cityCoordinateLabel = new JLabel();
    cityCoordinateLabel.setText(this.city.getCoordinate().toString());
    cityCoordinateLabel.setForeground(Color.white);

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
    this.add(cityNameLabel);
    this.add(cityCoordinateLabel);
    this.addMouseListener(new CityResultPanelMouseListener(this.city));
  }
}
