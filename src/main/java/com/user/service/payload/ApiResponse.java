package com.user.service.payload;

import org.springframework.http.HttpStatus;

public class ApiResponse {

	private String message;
	private boolean success;
	private HttpStatus status;
	
	public ApiResponse(String message, boolean success, HttpStatus status) {
		super();
		this.message = message;
		this.success = success;
		this.status = status;
	}
	
	public ApiResponse() {
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	// Builder pattern
    public static class Builder {
        private String message;
        private boolean success;
        private HttpStatus status;

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder success(boolean success) {
            this.success = success;
            return this;
        }

        public Builder status(HttpStatus status) {
            this.status = status;
            return this;
        }

        public ApiResponse build() {
            return new ApiResponse(message, success, status);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

}
