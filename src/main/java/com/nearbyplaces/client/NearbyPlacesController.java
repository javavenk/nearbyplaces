package com.nearbyplaces.client;

import java.util.List;

import com.nearbyplaces.client.query.QueryProcessor;
import com.nearbyplaces.client.ui.UI;
import com.nearbyplaces.client.ui.model.Place;
import com.nearbyplaces.client.ui.model.QueryParameter;

public class NearbyPlacesController {

	public static void main(String[] args) {
		NearbyPlacesController thisApplication = new NearbyPlacesController();
		UI ui = UI.getInstance();
		ui.setContoller(thisApplication);
	}

	public List<Place> fetchPlaces(List<QueryParameter> queryParameters) {
		return new QueryProcessor(queryParameters).fetchPlaces();
	}
}