
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


                var calendarEl = document.getElementById('calendar');

                data.map((calendar) => {

                    console.log(calendar)

                    // console.log(test.screenings.map((test) => test.screeningDate))

                    // console.log(data[key].screenings.map((date) => date.screeningDate))

                    var calendar = new FullCalendar.Calendar(calendarEl, {
                        initialView: 'dayGridMonth',
                        headerToolbar: {
                            left: 'prev,next today',
                            center: 'title',
                            right: 'dayGridMonth,timeGridWeek,timeGridDay'
                        },
                        events: [{ title: calendar.title, start: '2021-04-19' }]
                        // events: [
                        //     {
                        //         title: data[key].title,
                        //         start: '2021-04-19'
                        //         //start: data[key].screenings.map((date) => `${date.screeningDate}`)
                        //     },
                        //     {
                        //         title: "hej",
                        //         start: '2021-04-17'
                        //         // start: data[key].screenings.map((date) => date.screeningDate)
                        //     },
                        // ]
                    });




                    calendar.render();


                })



            });
        }
    )
    .catch(function (err) {
        console.error('Fetch Error -', err);
    });





