let dropdown = document.getElementById('genreid');
dropdown.length = 0;

let defaultOption = document.createElement('option');
defaultOption.text = 'Choose genre';
defaultOption.value = 'genreid';
defaultOption.title = "genreid";

dropdown.add(defaultOption);
dropdown.selectedIndex = 0;

const url = 'http://localhost:8080/genres';

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
                let option;

                console.log(data);

                for (let i = 0; i < data.length; i++) {
                    option = document.createElement('option');
                    option.text = data[i].genre;
                    dropdown.add(option);
                    // parseInt(dropdown.add(option));
                }
            });
        }
    )
    .catch(function (err) {
        console.error('Fetch Error -', err);
    });
