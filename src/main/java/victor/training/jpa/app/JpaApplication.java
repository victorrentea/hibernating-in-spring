package victor.training.jpa.app;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.descriptor.LocalResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import victor.training.jpa.app.common.EntityRepositoryFactoryBean;
import victor.training.jpa.app.common.GetCurrentUserUtil;

@SpringBootApplication
@EnableJpaRepositories // (repositoryFactoryBeanClass = EntityRepositoryFactoryBean.class)
@EnableJpaAuditing
@EnableTransactionManagement
@Slf4j
@EnableSwagger2
@RequiredArgsConstructor
public class JpaApplication {
	private final DummyDataCreator dummyDataCreator;
	private final PlatformTransactionManager txm;

	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		log.info("Transaction Manager: " + txm.getClass());
		System.out.println("Application started...");
		dummyDataCreator.persistDummyData();
		System.out.println(" ========= END ========== ");
	}


	@Bean
	public AuditorAware<String> auditorProvider() {
		return GetCurrentUserUtil::getCurrentUserOpt;
	}

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}
}
