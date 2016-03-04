package com.kakapo.goodpic.retrofit;

/**
 * Created by mustafasevgi on 14/02/16.
 */
public class ApiProvider {
    private Api api;

    public Api getApi() {
        if (api == null) {
            api = new Api();
        }
        return api;
    }
}
