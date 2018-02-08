package nl.youwe.diff.config;

/*
 * This file is part of the rest diff project.
 *
 * (c) Osman Üngür <osmanungur@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.util.StopWatch;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {

    @Autowired
    private Logger log;

    @Bean
    public Docket swaggerSpringApiDocket() {
        log.info("Starting Swagger");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .enableUrlTemplating(true);

        stopWatch.stop();
        log.info("Started Swagger in {} ms", stopWatch.getTotalTimeMillis());
        return docket;
    }
}
