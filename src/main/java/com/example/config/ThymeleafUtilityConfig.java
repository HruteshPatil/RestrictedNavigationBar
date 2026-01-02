package com.example.config;

import com.example.util.CustomFormatters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.context.IExpressionContext;
import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.dialect.IExpressionObjectDialect;
import org.thymeleaf.expression.IExpressionObjectFactory;

import java.util.Collections;
import java.util.Set;

@Configuration
public class ThymeleafUtilityConfig extends AbstractDialect implements IExpressionObjectDialect {

    @Autowired
    private CustomFormatters customFormatters;

    public ThymeleafUtilityConfig() {
        super("Custom Formatter Dialect");
    }

    @Override
    public IExpressionObjectFactory getExpressionObjectFactory() {
        return new IExpressionObjectFactory() {
            @Override
            public Set<String> getAllExpressionObjectNames() {
                // This defines the name you use in HTML (e.g., #format)
                return Collections.singleton("format");
            }

            @Override
            public Object buildObject(IExpressionContext context, String expressionObjectName) {
                if ("format".equals(expressionObjectName)) {
                    return customFormatters;
                }
                return null;
            }

            @Override
            public boolean isCacheable(String expressionObjectName) {
                return true;
            }
        };
    }
}