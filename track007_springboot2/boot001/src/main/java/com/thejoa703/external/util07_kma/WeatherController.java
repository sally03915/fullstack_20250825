package com.thejoa703.external.util07_kma;

import java.net.URISyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WeatherController {

	@Autowired
	private WeatherService weatherService;

	@GetMapping("/api/weather")
	public String weather() {
		return "external/weather";
	}

	@GetMapping(value = "/api/weatherapi", produces = "application/xml;charset=UTF-8")
	@ResponseBody
	public String weatherapi() throws URISyntaxException {
		return weatherService.getWeatherResponse();
	}
}
