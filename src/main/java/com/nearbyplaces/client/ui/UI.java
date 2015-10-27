package com.nearbyplaces.client.ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.nearbyplaces.client.NearbyPlacesController;
import com.nearbyplaces.client.ui.model.EQueryParameters;
import com.nearbyplaces.client.ui.model.Place;
import com.nearbyplaces.client.ui.model.QueryParameter;

public class UI extends JFrame {
	private static final long serialVersionUID = 1L;
	private static UI ui = null;
	private NearbyPlacesController controller;

	public synchronized static UI getInstance() {
		if (ui == null) {
			ui = new UI();
		}
		return ui;
	}

	private UI() {
		final JFrame mainWindow = new JFrame("NearbyPlaces");
		final JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		final JPanel latitudePanel = new JPanel();
		latitudePanel.setLayout(new BoxLayout(latitudePanel, BoxLayout.X_AXIS));
		final JLabel labelLatitude = new JLabel("Latitude");
		final JTextField textFieldLatitude = new JTextField("13.039142");
		latitudePanel.add(labelLatitude);
		latitudePanel.add(textFieldLatitude);
		mainPanel.add(latitudePanel);

		final JPanel longitudePanel = new JPanel();
		longitudePanel.setLayout(new BoxLayout(longitudePanel, BoxLayout.X_AXIS));
		final JLabel labelLongitude = new JLabel("Longitude");
		final JTextField textFieldLongitude = new JTextField("77.747367");
		longitudePanel.add(labelLongitude);
		longitudePanel.add(textFieldLongitude);
		mainPanel.add(longitudePanel);

		final JPanel radiusPanel = new JPanel();
		radiusPanel.setLayout(new BoxLayout(radiusPanel, BoxLayout.X_AXIS));
		final JLabel labelRadius = new JLabel("Radius");
		final JTextField textFieldRadius = new JTextField("300");
		radiusPanel.add(labelRadius);
		radiusPanel.add(textFieldRadius);
		mainPanel.add(radiusPanel);

		final JTextArea textAreaSearchResults = new JTextArea();
		textAreaSearchResults.setEditable(false);
		final JScrollPane scrollableSearchResults = new JScrollPane(textAreaSearchResults);
		scrollableSearchResults.setPreferredSize(new Dimension(500, 500));

		final JButton buttonSearch = new JButton("Search");
		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QueryParameter location = new QueryParameter(EQueryParameters.location,
						textFieldLatitude.getText() + "," + textFieldLongitude.getText());
				QueryParameter radius = new QueryParameter(EQueryParameters.radius, textFieldRadius.getText());
				List<QueryParameter> queryParameters = new ArrayList<QueryParameter>();
				queryParameters.add(location);
				queryParameters.add(radius);
				List<Place> nearbyPlaces = controller.fetchPlaces(queryParameters);
				textAreaSearchResults.setText("");
				if (nearbyPlaces != null && nearbyPlaces.size() > 0) {
					for (Place place : nearbyPlaces) {
						textAreaSearchResults.append(place.getDisplayString());
					}
				} else {
					textAreaSearchResults.append("There is nothing interesting nearby !!");
				}
				textAreaSearchResults.repaint();
			}
		});
		mainPanel.add(buttonSearch);
		mainPanel.add(scrollableSearchResults);

		mainWindow.getContentPane().add(mainPanel);
		mainWindow.getContentPane().setPreferredSize(new Dimension(500, 500));
		mainWindow.pack();
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setVisible(true);
	}

	public void displayResults(List<Place> places) {
		this.repaint();
	}

	public void setContoller(NearbyPlacesController controller) {
		this.controller = controller;
	}
}