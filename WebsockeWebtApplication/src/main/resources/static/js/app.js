var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

/*
* connect 方法使用SockJS & stomp.js开启一个到"/gs-guide-websocket"的连接
* 此连接正是我们SockJS 服务器等待连接的地方
* 一旦连接成功，客户端订阅的"/topic/greetings"目的地，服务器将向该目的地发布问候消息
* 当该目的地收到问候语时，客户端会增加一个段落元素在DOM上来显示问候语
*
*/
function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({},function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings', function (greeting) {
            showGreeting(JSON.parse(greeting.body).content);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

/*
* sendName()方法检索用户输入名称，并使用STOMP客户端将其发送到"/app/hello"
* （GreetingController.greeting()会接受它）
*/

function sendName() {
    stompClient.send("/app/hello",{},JSON.stringify({ 'name' : $("#name").val() }));
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $("#connect").click(function () {
        connect();
    });
    $("#disconnect").click(function () {
        disconnect();
    });
    $("#send").click(function () {
        sendName();
    });
})