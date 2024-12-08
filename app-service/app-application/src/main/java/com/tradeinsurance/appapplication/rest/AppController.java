
package com.tradeinsurance.appapplication.rest;

import com.tradeinsurance.appapplicationservice.dto.create.CreateAppCommand;
import com.tradeinsurance.appapplicationservice.dto.create.CreateAppResponse;
import com.tradeinsurance.appapplicationservice.ports.input.service.AppApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/")
@ComponentScan(basePackages = {"com.tradeinsurance.appapplicationservice", "com.tradeinsurance.appdomaincore"})
public class AppController {

    private Environment env;
    private final AppApplicationService appApplicationService;

    @Autowired
    public AppController(Environment env,
                         AppApplicationService appApplicationService) {
        this.env = env;
        this.appApplicationService = appApplicationService;
    }

    @GetMapping("/health_check")
    public String status() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("It's Working in App Service").append(System.lineSeparator());
        stringBuilder.append("port(local.server.port) = " + env.getProperty("local.server.port")).append(System.lineSeparator());
        stringBuilder.append("port(server.port) = " + env.getProperty("server.port")).append(System.lineSeparator());
        stringBuilder.append("token secret = " + env.getProperty("token.secret")).append(System.lineSeparator());
        stringBuilder.append("token expiration time = " + env.getProperty("token.expiration_time"));

        log.info(stringBuilder.toString());

        return stringBuilder.toString();
    }

    @PostMapping("/app_register")
    public ResponseEntity<CreateAppResponse> registerApp(@RequestBody CreateAppCommand createAppCommand) {
        log.info("Creating order for customer: {}", createAppCommand.getCustomerId());

        CreateAppResponse createAppResponse = appApplicationService.createApp(createAppCommand);

        return ResponseEntity.ok(createAppResponse);
    }


}
