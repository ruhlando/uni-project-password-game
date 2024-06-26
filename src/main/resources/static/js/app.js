const client = new StompJs.Client({
    brokerURL: 'ws://localhost:8080/gs-guide-websocket',
    debug: function (str) {
        console.log(str);
    },
    reconnectDelay: 5000,
    heartbeatIncoming: 4000,
    heartbeatOutgoing: 4000,
});

client.onWebSocketError = (error) => {
    console.error('Error with websocket', error);
};

client.onStompError = (frame) => {
    console.error('Broker reported error: ' + frame.headers['message']);
    console.error('Additional details: ' + frame.body);
};


client.onConnect = (frame) => {
    document.getElementById('status').innerHTML = 'Connected';

    client.subscribe('/topic/password', (callback) => {
        document.getElementById('message').innerHTML = callback.body;
        console.log("message received")
    })
};

client.onDisconnect = (frame) => {
    document.getElementById('status').innerHTML = '';
}

function sendMessage(destination, message) {
    if (message){
        client.publish({
            destination: destination,
            body: message,
            skipContentLengthHeader: true
        });
    } else {
        throw new Error('Empty message!');
    }
}

// connects to Server when page is fully loaded by client
addEventListener('load', function (){
    client.activate();
})

// executed by <input> in index.html
function sendPassword(password){
    console.log(password);

    sendMessage(
        '/app/password',
        JSON.stringify({'password': password})
    );
}