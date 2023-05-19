var stompClient = null



function sendMessage() {


	let jsonOb = {
		
		to: localStorage.getItem("to"),
		from:localStorage.getItem("from"),
		content: $("#message-value").val()
	}

	stompClient.send("/app/message", {}, JSON.stringify(jsonOb));

}

function connect() {

	let socket = new SockJS("/server1")

	stompClient = Stomp.over(socket)
	let to = $("#to-value").val()
	
	stompClient.connect({user: to}, function(frame) {

		console.log("Connected :12333 " + frame)

		$("#name-from").addClass('d-none')
		$("#chat-room").removeClass('d-none')


		//subscribe
		stompClient.subscribe("/user/topic/return-to", function(response) {
			console.log("Response from subs "+response.body)
			showMessage(JSON.parse(response.body));

		})
	})

}


function showMessage(message) {

	$("#message-container-table").prepend(`<tr><td><b>${message.from} :</b> ${message.content}</td></tr>`)

}

$(document).ready((e) => {


	$("#login").click(() => {
		let to = $("#to-value").val()
		localStorage.setItem("to", to)
		let from = $("#from-value").val()
		localStorage.setItem("from", from)
		$("#name-title").html(`Welcome , <b>${from} </b>`)

		connect();


	})

	$("#send-btn").click(() => {
		sendMessage()
	})

	$("#logout").click(() => {

		localStorage.removeItem("name")
		if (stompClient !== null) {
			stompClient.disconnect()

			$("#name-from").removeClass('d-none')
			$("#chat-room").addClass('d-none')
			console.log(stompClient)
		}

	})

})