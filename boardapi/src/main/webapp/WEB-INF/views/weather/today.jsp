<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <h2>${city}</h2>
    오늘의 날씨: ${weather.weather[0].description} <img src="${iconUrl}"/>
</div>
<div>
    나라: ${weather.sys.country}
    <br>
    온도: ${weather.main.temp}°
    / 체감 온도: ${weather.main.feels_like}°
    / 최저 기온: ${weather.main.temp_min}°
    / 최고 기온: ${weather.main.temp_max}°
    / 습도: ${weather.main.humidity}%
    / 풍속: ${weather.wind.speed}m/s
    /
</div>
</body>
</html>