package com.mvc.ecommerce.controller.RequestPojo;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ApiResponse {

    private String message, token;
    JSONArray array = null;
    HashMap<String, String> data = null;
    JSONObject jsonobj = null;
    private List<String> errors;

    public ApiResponse(String message, List<String> errors) {
        super();
        this.message = message;
        this.errors = errors;
    }

    public ApiResponse(HashMap<String, String> data, String token) {
        this.token = token;
        this.data = data;
    }

    public ApiResponse(JSONArray array, String token) {
        this.token = token;
        this.array = array;
    }

    public ApiResponse(JSONObject jsonobj, String token ) {
        this.token = token;
        this.jsonobj = jsonobj;
    }

    public ApiResponse( String token, String message, List<String> errors) {
        this.message = message;
        this.token = token;
        this.errors = errors;
    }

    public ApiResponse( String message, String error) {
        super();
        //this.status = status;
        this.message = message;
        errors = Arrays.asList(error);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public JSONArray getArray() {
        return array;
    }

    public void setArray(JSONArray array) {
        this.array = array;
    }

    public HashMap<String, String> getData() {
        return data;
    }

    public void setData(HashMap<String, String> data) {
        this.data = data;
    }

    public JSONObject getJsonobj() {
        return jsonobj;
    }

    public void setJsonobj(JSONObject jsonobj) {
        this.jsonobj = jsonobj;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
