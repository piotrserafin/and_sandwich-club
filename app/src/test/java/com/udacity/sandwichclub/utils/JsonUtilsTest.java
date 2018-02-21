package com.udacity.sandwichclub.utils;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by pserafin on 20.02.2018.
 */
public class JsonUtilsTest {

    private static final String testJson = "{" +
            "   \"name\":{" +
            "      \"mainName\":\"Bosna\"," +
            "      \"alsoKnownAs\":[" +
            "         \"Bosner\"" +
            "      ]" +
            "   }," +
            "   \"placeOfOrigin\":\"Austria\"," +
            "   \"description\":\"Bosna" +
            "is a spicy Austrian fast food dish, said to have originated in either Salzburg or Linz." +
            "It is now popular all over western Austria and southern Bavaria.\"," +
            "   \"image\":\"https://upload.wikimedia.org/wikipedia/commons/c/ca/Bosna_mit_2_Bratw%C3%BCrsten.jpg\"," +
            "   \"ingredients\":[" +
            "      \"White bread\"," +
            "      \"Bratwurst\"," +
            "      \"Onions\"," +
            "      \"Tomato ketchup\"," +
            "      \"Mustard\"," +
            "      \"Curry powder\"" +
            "   ]" +
            "}";

    private static final String testJson2 = "{\"name\"}";

    private static final String expectedMainName = "Bosna";
    private static final List<String> expectedAka = Arrays.asList("Bosner");
    private static final String expectedPlaceOfOrigin = "Austria";
    private static final String expectedDescription =
            "Bosna is a spicy Austrian fast food dish, said to have originated in either Salzburg or Linz." +
            "It is now popular all over western Austria and southern Bavaria.";
    private static final String expectedImage = "https://upload.wikimedia.org/wikipedia/commons/c/ca/Bosna_mit_2_Bratw%C3%BCrsten.jpg";
    private static final List<String> expectedIngredients = Arrays.asList("White bread","Bratwurst","Onions","Tomato ketchup","Mustard","Curry powder");

    @Test
    public void parseSandwichJson() {

//        Sandwich sandwich = JsonUtils.parseSandwichJson(testJson2);
//
//        assertEquals(expectedMainName, sandwich.getMainName());
//        assertEquals(expectedAka, sandwich.getAlsoKnownAs());
//        assertEquals(expectedPlaceOfOrigin, sandwich.getPlaceOfOrigin());
//        assertEquals(expectedDescription, sandwich.getDescription());
//        assertEquals(expectedImage, sandwich.getImage());
//        assertEquals(expectedIngredients, sandwich.getIngredients());
    }

}