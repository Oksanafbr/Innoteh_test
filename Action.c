Action()
{
lr_start_transaction("Common_time_scenario");
lr_start_transaction("Open_main");
	web_add_auto_header("DNT", 
		"1");

	web_add_auto_header("Upgrade-Insecure-Requests", 
		"1");



	web_reg_save_param("userSession",
		"LB=userSession\" value=\"",
		"RB=\"",
		"Ord=1",
		LAST);
		
		
		


	web_url("webtours", 
		"URL=http://localhost:1080/webtours/", 
		"TargetFrame=", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=", 
		"Snapshot=t1.inf", 
		"Mode=HTML", 
		LAST);

	web_set_sockets_option("SSL_VERSION", "AUTO");
lr_end_transaction("Open_main",LR_AUTO);



	lr_start_transaction("Login");
	
	web_reg_find("Fail=NotFound",
		"Text=Welcome, <b>{login}</b>, to the Web Tours",
		LAST);

	web_revert_auto_header("Upgrade-Insecure-Requests");

	lr_think_time(10);

	web_submit_data("login.pl",
		"Action=http://localhost:1080/cgi-bin/login.pl",
		"Method=POST",
		"TargetFrame=body",
		"RecContentType=text/html",
		"Referer=http://localhost:1080/cgi-bin/nav.pl?in=home",
		"Snapshot=t2.inf",
		"Mode=HTML",
		ITEMDATA,
		"Name=userSession", "Value={userSession}", ENDITEM,
		"Name=username", "Value={login}", ENDITEM,
		"Name=password", "Value={password}", ENDITEM,
		"Name=login.x", "Value=58", ENDITEM,
		"Name=login.y", "Value=2", ENDITEM,
		"Name=JSFormSubmit", "Value=off", ENDITEM,
		LAST);

	lr_end_transaction("Login",LR_AUTO);
	
	

	lr_start_transaction("Open_flights");
	
	web_reg_find("Fail=NotFound",
		"Text=<b>Find Flight</font></b>",
		LAST);

	web_add_auto_header("Upgrade-Insecure-Requests", 
		"1");

	lr_think_time(15);

	web_url("Search Flights Button", 
		"URL=http://localhost:1080/cgi-bin/welcome.pl?page=search", 
		"TargetFrame=body", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:1080/cgi-bin/nav.pl?page=menu&in=home", 
		"Snapshot=t3.inf", 
		"Mode=HTML", 
		LAST);

	lr_end_transaction("Open_flights",LR_AUTO);

	lr_think_time(23);
	
	

	lr_start_transaction("Find_flights");
	
	web_reg_find("Fail=NotFound",
		"Text=Flight departing from <B>{depart_country}</B> to <B>{arrive_city}</B> on <B>{departDate}</B>",
		LAST);

	web_submit_data("reservations.pl", 
		"Action=http://localhost:1080/cgi-bin/reservations.pl", 
		"Method=POST", 
		"TargetFrame=", 
		"RecContentType=text/html", 
		"Referer=http://localhost:1080/cgi-bin/reservations.pl?page=welcome", 
		"Snapshot=t4.inf", 
		"Mode=HTML", 
		ITEMDATA, 
		"Name=advanceDiscount", "Value={adv_discount}", ENDITEM, 
		"Name=depart", "Value={depart_country}", ENDITEM, 
		"Name=departDate", "Value={departDate}", ENDITEM, 
		"Name=arrive", "Value={arrive_city}", ENDITEM, 
		"Name=returnDate", "Value={return_date}", ENDITEM, 
		"Name=numPassengers", "Value={num_Pass}", ENDITEM, 
		"Name=seatPref", "Value={seat_Pref}", ENDITEM, 
		"Name=seatType", "Value={seat_type}", ENDITEM, 
		"Name=findFlights.x", "Value=59", ENDITEM, 
		"Name=findFlights.y", "Value=4", ENDITEM, 
		"Name=.cgifields", "Value=roundtrip", ENDITEM, 
		"Name=.cgifields", "Value=seatType", ENDITEM, 
		"Name=.cgifields", "Value=seatPref", ENDITEM, 
		LAST);

	lr_end_transaction("Find_flights",LR_AUTO);

	lr_think_time(15);
	
	
	

	lr_start_transaction("Check_cost");
	
	web_reg_find("Fail=NotFound",
		"Text=<b>Payment Details</font></b>",
		LAST);

	web_submit_data("reservations.pl_2", 
		"Action=http://localhost:1080/cgi-bin/reservations.pl", 
		"Method=POST", 
		"TargetFrame=", 
		"RecContentType=text/html", 
		"Referer=http://localhost:1080/cgi-bin/reservations.pl", 
		"Snapshot=t5.inf", 
		"Mode=HTML", 
		ITEMDATA, 
		"Name=outboundFlight", "Value=502;487;{departDate}", ENDITEM, 
		"Name=numPassengers", "Value={num_Pass}", ENDITEM, 
		"Name=advanceDiscount", "Value={adv_discount}", ENDITEM, 
		"Name=seatType", "Value={seat_type}", ENDITEM, 
		"Name=seatPref", "Value={seat_Pref}", ENDITEM, 
		"Name=reserveFlights.x", "Value=33", ENDITEM, 
		"Name=reserveFlights.y", "Value=10", ENDITEM, 
		LAST);

	lr_end_transaction("Check_cost",LR_AUTO);
	
	

	lr_start_transaction("Payment_details");
	
	web_reg_find("Fail=NotFound",
		"Text=<small><B>Thank you for booking through Web Tours.</B></small>",
		LAST);

	
	

	web_revert_auto_header("Upgrade-Insecure-Requests");

	lr_think_time(48);

	web_submit_data("reservations.pl_3", 
		"Action=http://localhost:1080/cgi-bin/reservations.pl", 
		"Method=POST", 
		"TargetFrame=", 
		"RecContentType=text/html", 
		"Referer=http://localhost:1080/cgi-bin/reservations.pl", 
		"Snapshot=t6.inf", 
		"Mode=HTML", 
		ITEMDATA, 
		"Name=firstName", "Value={login}", ENDITEM, 
		"Name=lastName", "Value={password}", ENDITEM, 
		"Name=address1", "Value={Street}", ENDITEM, 
		"Name=address2", "Value={City}", ENDITEM, 
		"Name=pass1", "Value={login} {password}", ENDITEM, 
		"Name=creditCard", "Value={Credit_card}", ENDITEM, 
		"Name=expDate", "Value={exp_date}", ENDITEM, 
		"Name=oldCCOption", "Value=", ENDITEM, 
		"Name=numPassengers", "Value={num_Pass}", ENDITEM, 
		"Name=seatType", "Value={seat_type}", ENDITEM, 
		"Name=seatPref", "Value={seat_Pref}", ENDITEM, 
		"Name=outboundFlight", "Value=502;487;{departDate}", ENDITEM, 
		"Name=advanceDiscount", "Value={adv_discount}", ENDITEM, 
		"Name=returnFlight", "Value=", ENDITEM, 
		"Name=JSFormSubmit", "Value=off", ENDITEM, 
		"Name=buyFlights.x", "Value=15", ENDITEM, 
		"Name=buyFlights.y", "Value=2", ENDITEM, 
		"Name=.cgifields", "Value=saveCC", ENDITEM, 
		LAST);

	lr_end_transaction("Payment_details",LR_AUTO);
	
	

	lr_start_transaction("Logout");
	
	web_reg_find("Fail=NotFound",
		"Text=If you haven't registered yet,",
		LAST);


	web_add_header("Upgrade-Insecure-Requests", 
		"1");

	lr_think_time(8);

	web_url("SignOff Button", 
		"URL=http://localhost:1080/cgi-bin/welcome.pl?signOff=1", 
		"TargetFrame=body", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:1080/cgi-bin/nav.pl?page=menu&in=flights", 
		"Snapshot=t7.inf", 
		"Mode=HTML", 
		LAST);

	lr_end_transaction("Logout",LR_AUTO);
	
	
	lr_end_transaction("Common_time_scenario",LR_AUTO);


	return 0;
}