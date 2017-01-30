package com.opengest.crm.web.utils;

public interface IAppCostants {

	/** Context path gestiti dal'applicazione */
	
	/** Modulo Utenti */
	static final String CONTEXT_PATH_INIT_LOGIN = "/initlogin";
	static final String CONTEXT_PATH_LOGIN = "/login";
	static final String CONTEXT_PATH_LOGOUT = "/logout";
	static final String CONTEXT_PATH_MENU_USERS = "/usersMenu";
	static final String CONTEXT_PATH_USERS_USERLIST = "/users/list";
	static final String CONTEXT_PATH_USERS_CREATE_INIT = "/users/createinit";
	static final String CONTEXT_PATH_USERS_CREATE = "/users/create";
	static final String CONTEXT_PATH_USERS_DELETE = "/users/delete";
	static final String CONTEXT_PATH_USERS_UPDATE_INIT = "/users/updateinit";
	static final String CONTEXT_PATH_USERS_UPDATE = "/users/update";
	static final String CONTEXT_PATH_USERS_UPDATE_FAILURE = "/WEB-INF/pages/users/user.jsp";
	static final String CONTEXT_PATH_USERS_CREATE_FAILURE = "/WEB-INF/pages/users/newuser.jsp";
	
	
	/** Modulo Prodotti */
	static final String CONTEXT_PATH_MENU_PRODUCTS = "/productsMenu";
	static final String CONTEXT_PATH_PRODUCTS_PRODUCT_LIST = "/products/list";
	static final String CONTEXT_PATH_PRODUCTS_CREATE = "/products/create";
	static final String CONTEXT_PATH_PRODUCTS_DELETE = "/products/delete";
	static final String CONTEXT_PATH_PRODUCTS_CREATE_INIT = "/products/createinit";
	static final String CONTEXT_PATH_PRODUCTS_UPDATE_INIT = "/products/updateinit";
	static final String CONTEXT_PATH_PRODUCTS_UPDATE = "/products/update";
	static final String CONTEXT_PATH_PRODUCTS_UPDATE_FAILURE = "/WEB-INF/pages/products/product.jsp";
	static final String CONTEXT_PATH_PRODUCTS_CREATE_FAILURE = "/WEB-INF/pages/products/saveProduct.jsp";
	
	/** Modulo Clienti */
	static final String CONTEXT_PATH_MENU_CUSTOMERS = "/customersMenu";
	static final String CONTEXT_PATH_CUSTOMERS_LIST = "/customers/list";
	static final String CONTEXT_PATH_CUSTOMERS_CREATE = "/customers/create";
	static final String CONTEXT_PATH_CUSTOMERS_DELETE = "/customers/delete";
	static final String CONTEXT_PATH_CUSTOMERS_CREATE_INIT = "/customers/createinit";
	static final String CONTEXT_PATH_CUSTOMERS_UPDATE_INIT = "/customers/updateinit";
	static final String CONTEXT_PATH_CUSTOMERS_UPDATE = "/customers/update";
	static final String CONTEXT_PATH_CUSTOMERS_UPDATE_FAILURE = "/WEB-INF/pages/customers/customer.jsp";
	static final String CONTEXT_PATH_CUSTOMERS_CREATE_FAILURE = "/WEB-INF/pages/customers/newCustomer.jsp";
	
	/** Modulo Ordini */
	static final String CONTEXT_PATH_MENU_ORDERS = "/ordersMenu";
	static final String CONTEXT_PATH_ORDERS_LIST = "/orders/list";
	static final String CONTEXT_PATH_ORDERS_CREATE = "/orders/create";
	static final String CONTEXT_PATH_ORDERS_DELETE = "/orders/delete";
	static final String CONTEXT_PATH_ORDERS_CREATE_INIT = "/orders/createinit";
	static final String CONTEXT_PATH_ORDERS_UPDATE_INIT = "/orders/updateinit";
	static final String CONTEXT_PATH_ORDERS_UPDATE = "/orders/update";
	static final String CONTEXT_PATH_ORDERS_UPDATE_FAILURE = "/WEB-INF/pages/orders/order.jsp";
	static final String CONTEXT_PATH_ORDERS_CREATE_FAILURE = "/WEB-INF/pages/orders/newOrder.jsp";
	
	
	
	/** Session parameters errors. */
	static final String SESSION_PARAM_LOGGED_USER 		= "loggedUser";
	static final String SESSION_PARAM_REQUEST_USER 		= "userdata";
	static final String SESSION_PARAM_REQUEST_USER_MOD 	= "userdatam";
	static final String SESSION_PARAM_REQUEST_PRODUCT  	= "product";
	static final String SESSION_PARAM_REQUEST_CUSTOMER 	= "customer";
	static final String SESSION_PARAM_REQUEST_ORDER  	= "order";
	
	/** Request parameters errors. */
	static final String REQUEST_PARAM_ERROR_MESSAGE = "errorMSG";
	
	
	/** Request parameters. */
	static final String REQUEST_PARAM_USER_LIST		 = "userList";
	static final String REQUEST_PARAM_USER_ID 		 = "userid";
	
	static final String REQUEST_PARAM_PRODUCT_ID 	 = "productid";
	static final String REQUEST_PARAM_PRODUCT_LIST 	 = "productList";
	
	static final String REQUEST_PARAM_ORDER_ID 	 	 = "orderid";
	static final String REQUEST_PARAM_ORDER_LIST 	 = "orderList";
	
	static final String REQUEST_PARAM_CUSTOMER_ID 	 = "customerid";
	static final String REQUEST_PARAM_CUSTOMER_LIST  = "customerList";

	static final String REQUEST_PARAM_USER_FORM 	 = "form";
	static final String REQUEST_PARAM_PRODUCT_FORM 	 = "form";
	static final String REQUEST_PARAM_CUSTOMER_FORM  = "form";
	static final String REQUEST_PARAM_ORDER_FORM  	 = "form";
	
}
