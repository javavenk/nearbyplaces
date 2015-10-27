package com.nearbyplaces.client.ui.model;

import java.util.List;

public class Place {
	private String name;
	private String vicinity;
	private List<String> types;

	public Place(String name, String vicinity, List<String> types) {
		super();
		this.name = name;
		this.vicinity = vicinity;
		this.types = types;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the vicinity
	 */
	public String getVicinity() {
		return vicinity;
	}

	/**
	 * @return the types
	 */
	public List<String> getTypes() {
		return types;
	}

	public String getDisplayString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder
				.append(System.lineSeparator() + System.lineSeparator() + "----------------------------------------------------------------");
		stringBuilder.append(System.lineSeparator() + "Name : " + name);
		stringBuilder.append(System.lineSeparator() + "Vicinity : " + vicinity);
		stringBuilder.append(System.lineSeparator() + "Types : [");
		if (types != null && types.size() > 0) {
			stringBuilder.append(" " + types.get(0));
		}
		if (types != null && types.size() > 1) {
			for (int index = 1; index < types.size(); index++) {
				stringBuilder.append(", " + types.get(index));
			}
		}
		stringBuilder.append(" ]");
		stringBuilder.append(System.lineSeparator() + "----------------------------------------------------------------");
		return stringBuilder.toString();
	}

}
