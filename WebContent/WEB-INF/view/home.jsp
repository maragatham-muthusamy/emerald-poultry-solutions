<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="header.jsp" />
</head>
<body>
	<jsp:include page="menu.jsp" />
	<div class="homecontainer">
		<main class="home-main-data">
			<div class="main-data-left"></div>
			<div class="main-data-right">
				<section class="section-hero">
					<div class="hero">
						<div class="hero-text-box">
							<h1 class="heading-primary">An Egg a day keeps the doctor
								Away!!</h1>
							<p class="hero-description">Egg is one of the most nutritious
								food you can buy. Eggs provide significant amounts of vitamins
								and minerals, and are also an excellent source of high-quality
								proteins.</p>

							<div class="delivered">
								<div class="delivered-imgs">
									<img
										src="${pageContext.request.contextPath}/resources/images/users/user-1.jpg"
										alt="User photo" /> <img
										src="${pageContext.request.contextPath}/resources/images/users/user-2.jpg"
										alt="Userphoto" /> <img
										src="${pageContext.request.contextPath}/resources/images/users/user-3.jpg"
										alt="User photo" /> <img
										src="${pageContext.request.contextPath}/resources/images/users/user-4.jpg"
										alt="User photo" /> <img
										src="${pageContext.request.contextPath}/resources/images/users/user-5.jpg"
										alt="User photo" /> <img
										src="${pageContext.request.contextPath}/resources/images/users/user-6.jpg"
										alt="User photo" />
								</div>
								<p class="delivered-text">
									<span>250,000+</span> delivered last year!
								</p>
							</div>
						</div>
					</div>
				</section>
			</div>
		</main>
	</div>
</body>
<jsp:include page="footer.jsp" />
</html>
