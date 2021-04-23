console.log("Welcome to the index page/JS")
let uri = 'http://localhost:8080/app/refresh';
let userAccounts = [];

async function readInAccounts() {
    let resp = await fetch(uri);
    userAccounts = await resp.json();
    console.log(userAccounts);

}
readInAccounts();

//For use in Javascript testing(Mock data)
function checkUsers(){
var user1 = {id:"1", name:"Maurice", color:"password"};
var user2 = {id:"2", name:"Nick", color:"password2"};
var user3 = {id:"3", name:"Burke", color:"password3"};

var users=[];
users.push(user1,user2,user3);

return users.length;
}


module.exports = {checkUsers};