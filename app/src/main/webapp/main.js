console.log("hello from javascript land")


let uri = 'http://localhost:8080/app/refresh';
let allPeople = [];

async function readIn() {
    let resp = await fetch(uri);
    allPeople = await resp.json();
    console.log(allPeople);
    //document.querySelector('#athtable').innerHTML = new
}
readIn();
var x="";
function update2(){
    console.log("Some shit")
   
    for (i in allPeople) {
        x+= "<h3>" + allPeople[i].name + " "+ allPeople[i].id+ "</h3>";
        console.log(x);
      }
      document.querySelector("#athtable").innerHTML = x;
}



// document.componentRegistry = {};
// document.nextId = 0;

// class Component {
//     constructor() {
//         this._id = ++document.nextId;
//         document.componentRegistry[this._id] = this;
//     }
// }

// class Athlete extends Component{
//     constructor(props){
//         super();
//         this.state = {
//             aname: props.aname,
//             pass: props.pass
//         }
//     }
// }

// function render() {
//     return `<div class="people">
//                 <h2>${this.state.aname}</h2>
//                 <h3>${this.state.pass}</h3>
//             </div>`
// }

// function update() {
//     document.querySelector('#athtable').innerHTML = document.componentRegistry[1].render()
// }

// document.querySelector('#athtable').innerHTML ="length of array: "+ allPeople.length;

