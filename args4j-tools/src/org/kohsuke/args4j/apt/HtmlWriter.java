package org.kohsuke.args4j.apt;

import org.kohsuke.args4j.Option;

import java.io.PrintWriter;
import java.io.Writer;

/**
 * Writes the option list as HTML to a {@link Writer}.
 *
 * @author Kohsuke Kawaguchi
 */
class HtmlWriter implements AnnotationVisitor {
    private final PrintWriter out;

    public HtmlWriter(Writer out) {
        this.out = new PrintWriter(out);
        this.out.println("<table class='args4j-usage'>");
    }

    public void onOption(Option a) {
        out.println("  <tr>");
        writeTag("td","args4j-option",a.name());
        writeTag("td","args4j-usage",a.usage());
        out.println("  </tr>");
    }

    private void writeTag(String tag, String cssClass, String value) {
        out.println("    <"+tag+" class='"+cssClass+"'><![CDATA["+value+"]]></"+tag+">");
    }

    public void done() {
        out.println("</table>");
        out.close();
    }
}
