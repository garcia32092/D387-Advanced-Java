package edu.wgu.d387_sample_code.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
import java.util.ResourceBundle;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class MessageMapping {

    TimeZoneConversion timeZoneConversion = new TimeZoneConversion();

    @RequestMapping("/welcome")
    public ResponseEntity<String> showWelcome(@RequestParam("lang") String lang) {
        Locale locale = Locale.forLanguageTag(lang);
        return new ResponseEntity<String> (getWelcomeMessage(locale), HttpStatus.OK);
    }

    public String getWelcomeMessage(Locale locale) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("welcome", locale);
        return resourceBundle.getString("welcome");
    }

    @RequestMapping(path = "/timezones")
    public String showTimes() {
        return timeZoneConversion.timeConversion();
    }
}