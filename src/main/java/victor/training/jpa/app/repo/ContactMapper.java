package victor.training.jpa.app.repo;

import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.descriptor.LocalResolver;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;
import victor.training.jpa.app.entity.Tag;

import java.util.Collection;
import java.util.Locale;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ContactMapper {
    private final MessageSource messageSource;

   // TODO translate all tags via messages.properties
}
