package com.codepath.apps.restclienttemplate.models;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Tweet {
    public String body;
    public String createdAt;
    public User user;

    public Tweet (String body, String createdAt, User user) {
        this.body = body;
        this.createdAt = createdAt;
        this.user = user;
    }

    public static Tweet fromJson(@NotNull JSONObject jsonObject) throws JSONException {
        Tweet tweet = new Tweet(jsonObject.getString("text"),
                jsonObject.getString("created_at"),
                User.fromJson(jsonObject.getJSONObject("user")));
        return tweet;
    }

    public static List<Tweet> fromJsonArray(@NotNull JSONArray jsonArray) throws JSONException {
        List<Tweet> tweets = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            tweets.add(fromJson(jsonArray.getJSONObject(i)));
        }
        return tweets;
    }
}
