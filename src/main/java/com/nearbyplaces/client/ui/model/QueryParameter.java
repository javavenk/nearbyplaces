package com.nearbyplaces.client.ui.model;

public class QueryParameter {
	private EQueryParameters name;
	private String value;

	public QueryParameter(EQueryParameters name, String value) {
		super();
		this.name = name;
		this.value = value;
	}

	/**
	 * @return the name
	 */
	public EQueryParameters getName() {
		return name;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

}
