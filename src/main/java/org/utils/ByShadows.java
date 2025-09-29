package org.utils;

import org.openqa.selenium.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ByShadows extends By {
    private final List<String> selectors;

    public ByShadows(String... selectors) {
        this.selectors = Arrays.asList(selectors);
    }

    public static ByShadows shadowCss(String... selectors) {
        return new ByShadows(selectors);
    }

    public List<WebElement> findElements(SearchContext context) {
        WebDriver driver = extractDriver(context);

        Object el = ((JavascriptExecutor) driver).executeScript(
                "return (function(selectors){\n" +
                        "  function queryDeep(selectors) {\n" +
                        "    let node = document;\n" +
                        "    for (let i = 0; i < selectors.length; i++) {\n" +
                        "      const sel = selectors[i];\n" +
                        "      if (!node) return null;\n" +
                        "      if (node instanceof Document || node instanceof ShadowRoot) {\n" +
                        "        node = node.querySelector(sel);\n" +
                        "      } else {\n" +
                        "        if (node.shadowRoot) node = node.shadowRoot.querySelector(sel);\n" +
                        "        else node = node.querySelector(sel);\n" +
                        "      }\n" +
                        "    }\n" +
                        "    return node;\n" +
                        "  }\n" +
                        "  return queryDeep(arguments[0]);\n" +
                        "})(arguments[0]);",
                this.selectors
        );

        if (el == null) return Collections.emptyList();
        if (el instanceof WebElement) return Collections.singletonList((WebElement) el);
        return Collections.emptyList();
    }

    private WebDriver extractDriver(SearchContext context) {
        if (context instanceof WebDriver) return (WebDriver) context;
        if (context instanceof WrapsDriver) return ((WrapsDriver) context).getWrappedDriver();
        throw new IllegalStateException("No se puede extraer WebDriver desde el context: " + context);
    }

    @Override
    public String toString() {
        return "ByShadow: " + selectors.toString();
    }
}