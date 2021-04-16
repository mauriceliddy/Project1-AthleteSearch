console.log("hello from javascript land")

let swapi = 'http://localhost:8080/app/refresh';
let allPeople = [];

(async () => {
    let resp = await fetch(swapi);
    allPeople = await resp.json();
    console.log(allPeople)
    // document.querySelector('#greeting').innerHTML =
    //     new PeopleComponent(allPeople.results[0]).render();
})();

console.log(allPeople.forEach.name);