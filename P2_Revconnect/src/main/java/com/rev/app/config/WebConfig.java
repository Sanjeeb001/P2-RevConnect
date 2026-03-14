package com.rev.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.beans.factory.annotation.Value;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class WebConfig implements WebMvcConfigurer {

        @Value("${app.upload.dir}")
        private String uploadDir;

        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
                Path uploadPath = Paths.get(uploadDir).toAbsolutePath();
                String location = uploadPath.toUri().toString();
                if (!location.endsWith("/")) {
                        location += "/";
                }

                registry.addResourceHandler("/uploads/**")
                                .addResourceLocations(location)
                                .setCachePeriod(0);

                // Explicit handlers for subfolders to be extra safe
                registry.addResourceHandler("/uploads/profile-pictures/**")
                                .addResourceLocations(location + "profile-pictures/")
                                .setCachePeriod(0);

                registry.addResourceHandler("/uploads/post-images/**")
                                .addResourceLocations(location + "post-images/")
                                .setCachePeriod(0);
        }
}
