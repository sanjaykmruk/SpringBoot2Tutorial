package th.in.lordgift.SpringBoot2Tutorial.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import th.in.lordgift.SpringBoot2Tutorial.mode.bean.Pretty;

import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
@RequestMapping("/api")
public class ServiceController {

    @GetMapping(path = "/test")
    public String test() {
        return "success";
    }

    /**
     * Sample call service : <BR />
     * GET localhost:8080/spring/api/testQueryParam?singleParam=zzzzzzz
     */
    @GetMapping(path = "/testQueryParam", produces = TEXT_PLAIN_VALUE)
    public ResponseEntity testQueryParam(@RequestParam(value = "singleParam") String singleParam) {
        return ResponseEntity.ok(singleParam);
    }

    /**
     * Sample call service : <BR />
     * GET localhost:8080/spring/api/testQueryParams?param1=abc&param2=def
     */
    @GetMapping(path = "/testQueryParams", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity testQueryParams(@RequestParam Map<String,String> requestParams) {
        String param1 = requestParams.get("param1");
        String param2 = requestParams.get("param2");

        return ResponseEntity.ok(requestParams);
    }


    /**
     * Sample call service : <BR />
     * POST localhost:8080/spring/api/testRequestBody
     *
     */
    @PostMapping(path = "/testRequestBody",
            produces = APPLICATION_JSON_UTF8_VALUE,
            consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity testRequestBody(@RequestBody Pretty pretty) {

        pretty.setPrice(0L);

        return ResponseEntity.ok(pretty);
    }


    @GetMapping(path = "/testPathParam/{id}")
    public ResponseEntity testPathParam(@PathVariable("id") String id) {
        Pretty pretty = new Pretty("Aaaa Bbbb", "**", 5L);
        return ResponseEntity.ok(pretty);
    }





}