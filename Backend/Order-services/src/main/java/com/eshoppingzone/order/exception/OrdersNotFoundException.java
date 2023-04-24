package com.eshoppingzone.order.exception;

public class OrdersNotFoundException extends RuntimeException {

	public OrdersNotFoundException() {
		super();
	}

	public OrdersNotFoundException(String message) {
		super(message);
	}

	public OrdersNotFoundException(Throwable cause) {
		super(cause);
	}
	
}
