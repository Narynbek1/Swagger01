package com.example.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
//Эта аннотация указывает, что класс является
// конфигурационным классом Spring. Когда Spring Boot запускается,
// он автоматически обнаруживает классы, помеченные @Configuration,
// и применяет их конфигурацию.
@EnableSwagger2
//Эта аннотация активирует поддержку Swagger в приложении.
// Когда вы помечаете ваш класс @EnableSwagger2, Spring Boot
// настраивает Swagger для генерации документации API. Обычно
// это включает в себя создание бина Docket (как вы видели в
// предыдущем вопросе) и настройку Swagger UI для визуализации документации.
public class SwaggerConfig {

    //Эта аннотация используется в Spring Framework для указания,
    // что метод, к которому она применена, создает и возвращает
    // экземпляр бина (объекта), который будет управляться контейнером Spring.
    @Bean

    //Этот метод возвращает объект Docket. В Spring Fox, который
    // является реализацией Swagger для Spring, Docket представляет
    // собой настройки Swagger для вашего API.
    public Docket api() {

        //Здесь создается новый объект Docket, и передается DocumentationType.SWAGGER_2
        // в качестве параметра. Это указывает, что вы используете Swagger 2.0 для создания
        // документации вашего API. Swagger - это инструмент для документации и тестирования веб-сервисов
        return new Docket(DocumentationType.SWAGGER_2)

                //Начинает цепочку настроек для выбора определенных элементов вашего API
                .select()

                // Определяет, какие пакеты (packages) следует
                // включить в документацию. В данном случае
                // включаются все классы из пакета "com.example.swagger"
                .apis(RequestHandlerSelectors.basePackage("com.example.swagger"))

                // Включает все пути в документацию
                .paths(PathSelectors.any())

                // Завершает цепочку настроек и создает объект Docket
                .build()

                //Устанавливает информацию о вашем API
                // используя метод apiInfo() который мы рассмотрим ниже
                .apiInfo(apiInfo());
    }

    //apiInfo(), который создает объект ApiInfo
    private ApiInfo apiInfo() {

        //Создает новый объект ApiInfoBuilder
        return new ApiInfoBuilder()

                // Устанавливает заголовок документации API (пустой в вашем случае)
                .title("")

                //Устанавливает описание API (пустое в вашем случае)
                .description("")

                //Устанавливает версию вашего API (пустая в вашем случае)
                .version("")

                // Устанавливает контактную информацию для вашего API.
                // Здесь устанавливаются email, URL и имя контактного лица.
                //.build(): Завершает цепочку настроек и создает объект ApiInfo.
                .contact(new Contact(
                        "postgres@localhost",
                        "jdbc:postgresql://localhost:5432/postgres",
                        "narynbeksuiunov9@gmail.com"))
                .build();
    }
}
