
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

                for (let key in data) {

                    var calendar = new FullCalendar.Calendar(calendarEl, {
                        initialView: 'dayGridMonth',
                        headerToolbar: {
                            left: 'prev,next today',
                            center: 'title',
                            right: 'dayGridMonth,timeGridWeek,timeGridDay'
                        },
                        events: [
                            {
                                title: data[key].title,
                                start: '2021-04-12T10:30:00'
                            },
                            {
                                title: data[key].title,
                                start: '2021-04-12T12:00:00'
                            },
                            {
                                title: data[key].title,
                                start: '2021-04-12T14:30:00'
                            },
                            {
                                title: data[key].title,
                                start: '2021-04-13T07:00:00'
                            }
                        ]
                    });


                }

                calendar.render();


            });
        }
    )
    .catch(function (err) {
        console.error('Fetch Error -', err);
    });





