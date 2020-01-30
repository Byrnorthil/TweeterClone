package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;

public class User {
    public String name;
    public String screenName;
    public String profileImageUrl;

    public User (String name, String screenName, String profileImageUrl) {
        this.name = name;
        this.screenName = screenName;
        this.profileImageUrl = profileImageUrl;
    }

    public static User fromJson(JSONObject jsonObject) throws JSONException {
        User user = new User(jsonObject.getString("name"),
                jsonObject.getString("screen_name"),
                jsonObject.getString("profile_image_url_https"));
        return user;
    }
}
