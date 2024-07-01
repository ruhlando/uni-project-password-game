const client = new StompJs.Client({
    brokerURL: 'ws://localhost:8080/gs-guide-websocket',
    //debug: function (str) {console.log(str);},
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
    client.subscribe('/topic/password', (callback) => {
        console.log(callback.body);
        let json = JSON.parse(callback.body);

        for (let i in json){
            //hidden
            console.log(json[i]);
            switch (json[i].hidden) {
                case true:
                    console.log(json[i].name);
                    document.getElementById(json[i].name).classList.add("is-hidden");
                    break;
                case false:
                    document.getElementById(json[i].name).classList.remove("is-hidden");
                    break;
            }

            //value
            switch (json[i].value) {
                case true:
                    document.getElementById(json[i].name).classList.add("border-success");
                    document.getElementById(json[i].name).classList.remove("border-danger");
                    break;
                case false:
                    document.getElementById(json[i].name).classList.add("border-danger");
                    document.getElementById(json[i].name).classList.remove("border-success");
                    break;
            }
        }

    })
};

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