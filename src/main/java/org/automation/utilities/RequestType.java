package org.automation.utilities;

import org.apache.http.client.methods.*;


public enum RequestType {

    OPTIONS(new HttpOptions()), GET(new HttpGet()), HEAD(new HttpHead()), PATCH(new HttpPatch()), POST(new HttpPost()),
    PUT(new HttpDelete()), TRACE(new HttpTrace());

    private final HttpRequestBase requestMethod;

    /**
     * Create Request Type instance.
     *
     * @param requestMethod request method type
     */
    RequestType(HttpRequestBase requestMethod) {
        this.requestMethod = requestMethod;
    }

    /**
     * Get the HTTP Request Method.
     *
     * @return HTTP request method
     */
    public HttpRequestBase getRequestMethod() {
        return requestMethod;
    }

}
