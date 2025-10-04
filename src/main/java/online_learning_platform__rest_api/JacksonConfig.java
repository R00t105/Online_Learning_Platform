package online_learning_platform__rest_api;

import com.fasterxml.jackson.datatype.hibernate5.jakarta.Hibernate5JakartaModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    /**
     * لتجنب مشكلة Serialization للـ Hibernate Proxies والـ Lazy Loading.
     * لازم يتم تفعيلها عشان Jackson يقدر يتعامل مع كائنات JPA/Hibernate
     * لما بتكون محملة بشكل Lazy.
     */
    @Bean
    public Hibernate5JakartaModule hibernate5Module() {
        // الخيار الأهم هنا هو .disable(Hibernate5JakartaModule.Feature.FORCE_LAZY_LOADING)
        // وده بيمنع Jackson من محاولة تحميل الكائنات الـ Lazy Loading
        // اللي مش محملة بالفعل (زي الـ courses في الـ Instructor)
        return new Hibernate5JakartaModule()
                .disable(Hibernate5JakartaModule.Feature.FORCE_LAZY_LOADING);
    }
}
