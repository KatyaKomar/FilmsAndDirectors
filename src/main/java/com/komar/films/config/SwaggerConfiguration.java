package net.wickedware.hfo.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.SpringDocUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

	static {
		SpringDocUtils.getConfig();
	}

	@Bean
	public OpenAPI customOpenAPI() {
		String securitySchemeName = "bearerAuth";
		SecurityScheme securityScheme = new SecurityScheme().name(securitySchemeName)
		                                                    .type(SecurityScheme.Type.HTTP)
		                                                    .scheme("bearer")
		                                                    .bearerFormat("JWT");
		return new OpenAPI().addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
		                    .components(new Components().addSecuritySchemes(securitySchemeName, securityScheme))
		                    .info(new Info());
	}
}
