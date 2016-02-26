package br.com.cantinhodamarmita.converters;


import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class LocalDateConverterFactory implements AnnotationFormatterFactory<LocalDateConverter> {
    @Override
    public Set<Class<?>> getFieldTypes() {
        Set<Class<?>> setTypes = new HashSet<Class<?>>();
        setTypes.add(LocalDate.class);
        return setTypes;
    }

    @Override
    public Printer<?> getPrinter(LocalDateConverter localDateConverter, Class<?> aClass) {
        return new LocalDateFormatter() ;
    }

    @Override
    public Parser<?> getParser(LocalDateConverter localDateConverter, Class<?> aClass) {
        return new LocalDateFormatter();
    }
}
