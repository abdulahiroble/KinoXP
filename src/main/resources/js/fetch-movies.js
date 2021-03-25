const url = 'http://localhost:8080/movies';

fetch(url)
    .then(
        function (response) {
            if (response.status !== 200) {
                console.warn('Looks like there was a problem. Status Code: ' +
                    response.status);
                return;
            }

            // Examine the text in the response  
            response.json().then(function (data) {

                console.log(data);

                var table = document.createElement("table"), row, cellA, cellB, cellC, cellD, header
                document.getElementById("demoA").appendChild(table);

                for (let key in data) {
                    // (C2) ROWS & CELLS
                    row = document.createElement("tr");
                    header = document.createElement("th");
                    cellA = document.createElement("td");
                    cellB = document.createElement("td");
                    cellC = document.createElement("td");
                    cellD = document.createElement("td");

                    // (C3) KEY & VALUE
                    cellA.innerHTML = data[key].title;
                    cellB.innerHTML = data[key].length;
                    cellC.innerHTML = data[key].age;
                    cellD.innerHTML = data[key].actor;


                    // (C4) ATTACH ROW & CELLS
                    table.appendChild(row).style.width = "500px"
                    row.appendChild(cellA).style.width = "500px"
                    row.appendChild(cellB).style.width = "500px"
                    row.appendChild(cellC).style.width = "500px"
                    row.appendChild(cellD).style.width = "500px"
                }
            });
        }
    )
    .catch(function (err) {
        console.error('Fetch Error -', err);
    });




// window.addEventListener("load", function () {
//     // (B) PARSE THE JSON STRING INTO OBJECT FIRST
//     var data = '{"Name":"John Doe","Email":"john@doe.com","Gender":"male"}';
//     data = JSON.parse(data);
//     // console.table(data);

//     // (C) GENERATE TABLE
//     // (C1) CREATE EMPTY TABLE
//     var table = document.createElement("table"), row, cellA, cellB;
//     document.getElementById("demoA").appendChild(table);
//     for (let key in data) {
//         // (C2) ROWS & CELLS
//         row = document.createElement("tr");
//         cellA = document.createElement("td");
//         cellB = document.createElement("td");

//         // (C3) KEY & VALUE
//         cellA.innerHTML = key;
//         cellB.innerHTML = data[key];

//         // (C4) ATTACH ROW & CELLS
//         table.appendChild(row);
//         row.appendChild(cellA);
//         row.appendChild(cellB);
//     }
// });

// let dropdown = document.getElementById('genreid');
// dropdown.length = 0;

// let defaultOption = document.createElement('option');
// defaultOption.text = 'Choose genre';
// defaultOption.value = 'genreid';
// defaultOption.title = "genreid";

// dropdown.add(defaultOption);
// dropdown.selectedIndex = 0;

// const url = 'http://localhost:8080/movies';

// fetch(url)
//     .then(
//         function (response) {
//             if (response.status !== 200) {
//                 console.warn('Looks like there was a problem. Status Code: ' +
//                     response.status);
//                 return;
//             }

//             // Examine the text in the response  
//             response.json().then(function (data) {
//                 let option;

//                 console.log(data);

//                 for (let i = 0; i < data.length; i++) {
//                     option = document.createElement('option');
//                     option.text = data[i].title;
//                     dropdown.add(option);
//                     // parseInt(dropdown.add(option));
//                 }
//             });
//         }
//     )
//     .catch(function (err) {
//         console.error('Fetch Error -', err);
//     });
