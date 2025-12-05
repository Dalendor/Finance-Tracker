package com.projecten.finance.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

import java.awt.*;
import java.net.URI;

@Configuration
public class OpenSwaggerConfig {

    @PostConstruct
    public void openSwagger() {
        try {
            Thread.sleep(2000); // 2 seconden wachten
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        String url = "http://localhost:8080/swagger-ui.html";

        try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(url));
                System.out.println("Swagger UI automatisch geopend: " + url);
            } else {
                System.out.println("Desktop niet ondersteund. Open handmatig: " + url);
            }
        } catch (Exception e) {
            System.out.println("Kon browser niet automatisch openen. Ga naar: " + url);
        }
    }
}