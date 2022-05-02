<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
	<jsp:include page="header.jsp"/>
	<script type="text/javascript">
		window.onload = function() {
		var dps = [[], []];
		var chart = new CanvasJS.Chart("chartContainer", {
			exportEnabled: true,
			animationEnabled: true,
			title: {
				text: "Revenue"
			},
			subtitles: [{
				text: "Click Legend to Hide or Unhide Data Series"
			}],
			axisX: {
				title: "Date"
			},
			axisY: {
				title: "Revenue",
				prefix: "$"
			},
			toolTip: {
				shared: true
			},
			legend: {
				cursor: "pointer",
				verticalAlign: "top",
				itemclick: toggleDataSeries
			},
			data: [{
				type: "column",
				name: "Egg Income",
				showInLegend: true,
				yValueFormatString: "$#,##0",
				dataPoints: dps[0]
			},
			{
				type: "column",
				name: "Feed Expense",
				showInLegend: true,
				yValueFormatString: "$#,##0",
				dataPoints: dps[1]
			}]
		});
		 
		var yValue;
		var label;

		<c:forEach items="${productions}" var="production">
			yValue = parseFloat("${production.price}");
			label = "${production.date}";
			dps[parseInt("${production.itemId}")].push({
				label : label,
				y : yValue,
			});
		</c:forEach> 

		chart.render();

		function toggleDataSeries(e) {
			if (typeof (e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
				e.dataSeries.visible = false;
			} else {
				e.dataSeries.visible = true;
			}
			e.chart.render();
		}
		}
	</script>
</head>
<body>
    <jsp:include page="menu.jsp"/>
	<div class="user-wrapper">
		<div class="left">
		</div>
		<div class="middle">
			<div class="user-header">
				<h2>Production Details</h2>
			</div>
		</div>
		<div class="right">
		</div>
	</div>
	<div class="listproductioncontainer">
		<div class="content">
			<div class="left">
			</div>

			<div class="middle">
				<table>
					<tr>
						<th>Item</th>
						<th>Quantity</th>
						<th>Price</th>
						<th>Date</th>
						<th>Action</th>
					</tr>
					
					<!-- loop over and print our users -->
					<c:forEach var="temp" items="${productions}">
						<!-- construct an "update" link with id -->
						<c:url var="updateLink" value="/production/update">
							<c:param name="prodid" value="${temp.id}" />
						</c:url>

						<!-- construct an "delete" link with id -->
						<c:url var="deleteLink" value="/production/delete">
							<c:param name="prodid" value="${temp.id}" />
						</c:url>

						<tr>
							<td> ${temp.itemId} </td>
							<td> ${temp.quantity} </td>
							<td> ${temp.price} </td>
							<td> ${temp.date} </td>

							<td>
								<!-- display the update link -->
								<a href="${updateLink}">Update</a> | <a href="${deleteLink}"
								   onclick="if (!(confirm('Are you sure you want to delete this record?'))) return false">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="right">
			</div>
		</div>
		<br>
		<br>
		<div class="content">
			<div class="left">
			</div>
			<input type="button" value="Add Record" onclick="window.location.href='add'; return false;" class="addupd-button"/>
			<div class="right">
			</div>
		</div>
		<div class="content">
			<div class="left">
			</div>
			<div id="chartContainer" style="height: 370px; width: 100%;"></div>
			<div class="right">
			</div>
		</div>
	</div>
</body>
<jsp:include page="footer.jsp"/>
</html>


