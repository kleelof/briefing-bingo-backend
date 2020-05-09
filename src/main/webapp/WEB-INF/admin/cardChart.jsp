<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Card Charts</title>
    <jsp:include page="header.jsp" ></jsp:include>
    
    <!--Load the AJAX API-->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">

      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {

        var days=JSON.parse(`${DTO}`)['days'];
        var dataFill = [
          ['Day', 'Issued', 'Bingos', 'Shares']
        ];

        for (var key in days ) {
          dataFill.push([
            days[key].date,
            parseInt(days[key].numberOfCardsIssued),
            parseInt(days[key].numberOfBingos),
            parseInt(days[key].numberOfShares)
          ]);
        }
        console.log(days, dataFill);
        var data = new google.visualization.arrayToDataTable(dataFill);
        

        // Set chart options
        var options = {
            title :'Cards Stats',
            vAxis: {title: 'cards'},
            yAxis: {title: 'Day'},
            seriesType: 'bars'
                       };

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>
  </head>

  <body>
    <div class="container-fluid">
      <jsp:include page="menu.jsp" ></jsp:include>
      <div id="chart_div"></div>
    </div>
  </body>
</html>