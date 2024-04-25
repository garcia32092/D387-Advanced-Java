package edu.wgu.d387_sample_code.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
import java.util.ResourceBundle;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class MessageMapping {

    @RequestMapping(path = "/welcomeEn", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getWelcomeMessageEn() {
        Locale locale = Locale.US;
        return getWelcomeMessage(locale);
    }

    @RequestMapping(path = "/welcomeFr", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getWelcomeMessageFr() {
        Locale locale = Locale.CANADA_FRENCH;
        return getWelcomeMessage(locale);
    }

    @RequestMapping("/welcome")
    public ResponseEntity<String> showWelcome(@RequestParam("lang") String lang) {
        Locale locale = Locale.forLanguageTag(lang);
        return new ResponseEntity<String> (getWelcomeMessage(locale), HttpStatus.OK);
    }

    public String getWelcomeMessage(Locale locale) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("welcome", locale);
        return resourceBundle.getString("welcome");
    }
}