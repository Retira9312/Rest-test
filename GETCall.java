package com.qa.rest.test;


import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import static com.jayway.restassured.RestAssured.get;

import com.jayway.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;

public class GetTest {

	@Test
	public void getRequestFindCapital() throws JSONException {

		// ��������� ������ get ��� ������� �� ���� ���������� ������
		Response resp = get("http://restcountries.eu/rest/v1/name/ukraine");

		JSONArray jsonResponse = new JSONArray(resp.asString());

		// ��������� ��������� capital (������� ��������)
		String capital = jsonResponse.getJSONObject(0).getString("capital");

		// ��������, ��� �������� �������� ����
		AssertJUnit.assertEquals(capital, "Kiev");
	}
}