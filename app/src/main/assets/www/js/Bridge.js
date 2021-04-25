var Bridge = {};
Bridge.login = function(state) {
	// build json string
	var message = {
	                method: "login",
	                state : state
	               }
	prompt("bridge_key", JSON.stringify(message));
}
// Call back function on success result, display a alert on screen with message
Bridge.callBack = function(result) {
	if(result.success) {
		alert("login success");
	}
}
