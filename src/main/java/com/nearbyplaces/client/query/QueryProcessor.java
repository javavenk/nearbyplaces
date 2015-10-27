package com.nearbyplaces.client.query;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.nearbyplaces.client.query.json.POJO;
import com.nearbyplaces.client.query.json.Result;
import com.nearbyplaces.client.ui.model.Place;
import com.nearbyplaces.client.ui.model.QueryParameter;
import com.nearbyplaces.client.utils.HttpUtils;

public class QueryProcessor {

	private String encoding = "UTF-8";
	private List<QueryParameter> queryParameters;

	public QueryProcessor(List<QueryParameter> queryParameters) {
		if (System.getProperty("encoding") != null) {
			this.encoding = System.getProperty("encoding");
		}
		this.queryParameters = queryParameters;
	}

	public List<Place> fetchPlaces() {
		List<Place> places = new ArrayList<Place>();
		String queryString = null;
		try {
			queryString = makeQueryString(this.queryParameters);
			String jsonResponse = null;
			jsonResponse = HttpUtils.getJSONResponse(queryString);

			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			POJO pojo = null;
			pojo = mapper.readValue(jsonResponse, POJO.class);

			List<Result> results = pojo.getResults();
			for (Result result : results) {
				places.add(new Place(result.getName(), result.getVicinity(), result.getTypes()));
			}
		} catch (UnsupportedEncodingException e) {
			// The right behavior here is to log to a local file or show an
			// error pop-up window
			e.printStackTrace();
		} catch (JsonParseException e) {
			// The right behavior here is to log to a local file or show an
			// error pop-up window
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// The right behavior here is to log to a local file or show an
			// error pop-up window
			e.printStackTrace();
		} catch (IOException e) {
			// The right behavior here is to log to a local file or show an
			// error pop-up window
			e.printStackTrace();
		}
		return places;
	}

	private String makeQueryString(List<QueryParameter> queryParameters) throws UnsupportedEncodingException {
		StringBuilder stringBuilder = new StringBuilder();
		for (QueryParameter queryParameter : queryParameters) {
			stringBuilder.append(HttpUtils.getQueryParameter(queryParameter.getName().toString(),
					queryParameter.getValue(), encoding));
		}
		return stringBuilder.toString();
	}
}
