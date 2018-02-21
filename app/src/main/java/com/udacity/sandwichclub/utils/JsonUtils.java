package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String sandwichJson) {
        try {
            JSONObject rootObj = new JSONObject(sandwichJson);
            JSONObject nameObj = rootObj.getJSONObject("name");

            return new Sandwich(
                    nameObj.getString("mainName"),
                    getListOfValues(nameObj.getJSONArray("alsoKnownAs")),
                    rootObj.getString("placeOfOrigin"),
                    rootObj.getString("description"),
                    rootObj.getString("image"),
                    getListOfValues(rootObj.getJSONArray("ingredients"))
            );

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static List<String> getListOfValues(JSONArray array) throws JSONException {

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < array.length(); i++) {
            list.add(array.getString(i));
        }

        return list;
    }
}
