package com.example.dialect;

import com.example.processor.HighlightAttributeProcessor;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import java.util.Set;

public class MyCustomDialect extends AbstractProcessorDialect {
    public MyCustomDialect() {
        super("My App Dialect", "myApp", 1000);
    }

    @Override
    public Set<IProcessor> getProcessors(String dialectPrefix) {
        return Set.of(new HighlightAttributeProcessor(dialectPrefix)); // Minimalist set
    }
}