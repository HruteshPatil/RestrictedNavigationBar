package com.example.processor;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractAttributeTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

public class HighlightAttributeProcessor extends AbstractAttributeTagProcessor {
	public HighlightAttributeProcessor(final String dialectPrefix) {
		super(TemplateMode.HTML, dialectPrefix, null, false, "highlight", true, 1000, true);
	}

	@Override
	protected void doProcess(ITemplateContext context, IProcessableElementTag tag, AttributeName attrName,
			String attrValue, IElementTagStructureHandler structureHandler) {
		// Only adds the class; lightweight and fast
		structureHandler.setAttribute("class", "important-highlight");
	}
}